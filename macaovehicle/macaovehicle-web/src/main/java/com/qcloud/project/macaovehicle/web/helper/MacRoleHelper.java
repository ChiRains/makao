package com.qcloud.project.macaovehicle.web.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.common.ClerkConstant;
import com.qcloud.component.permission.PermissionClient;
import com.qcloud.component.permission.QPermission;
import com.qcloud.component.permission.QRole;
import com.qcloud.component.permission.model.RolePermission;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.QClassify;
import com.qcloud.component.publicdata.model.Classify;

@Component
public class MacRoleHelper {

    @Autowired
    private PermissionClient permissionClient;

    @Autowired
    private FileSDKClient    fileSDKClient;

    @Autowired
    private PublicdataClient publicdataClient;

    /**
     * 菜单分类，根据角色id
     * @param roleId
     * @return
     */
    public List<QClassify> listClassify(long roleId) {

        // 分类资源
        List<Classify> classifys = new ArrayList<Classify>();
        QRole qRole = permissionClient.getRole(roleId);
        List<RolePermission> rolePermissions = qRole.getRolePermissions();
        // 权限permissionId
        for (RolePermission rolePermission : rolePermissions) {
            long permissionId = rolePermission.getPermissionId();
            QPermission qPermission = permissionClient.getPermission(permissionId);
            Classify classify = publicdataClient.getClassify(qPermission.getTargetId());
            classifys.add(classify);
        }
        List<QClassify> classifyList = publicdataClient.listClassifyForTree(classifys);
        for (QClassify qClassify : classifyList) {
            fillFileServerUrlBeforeImage(qClassify);
        }
        return classifyList;
    }

    /**
     * 菜单分类，根据账号
     * @param account
     * @return
     */
    public List<QClassify> listClassify(String account) {

        String accountCode = ClerkConstant.CLERKPREFIXCODE + account;
        // 角色
        List<QRole> qRoles = permissionClient.listRoleByAccount(accountCode);
        // 分类资源
        List<Classify> classifys = new ArrayList<Classify>();
        if (qRoles.size() > 0) {
            List<RolePermission> rolePermissions = qRoles.get(0).getRolePermissions();
            // 权限permissionId
            for (RolePermission rolePermission : rolePermissions) {
                long permissionId = rolePermission.getPermissionId();
                QPermission qPermission = permissionClient.getPermission(permissionId);
                Classify classify = publicdataClient.getClassify(qPermission.getTargetId());
                classifys.add(classify);
            }
        }
        Collections.sort(classifys, new Comparator<Classify>() {

            public int compare(Classify arg0, Classify arg1) {

                return arg0.getSort() - arg1.getSort();
            }
        });
        List<QClassify> classifyList = publicdataClient.listClassifyForTree(classifys);
        for (QClassify qClassify : classifyList) {
            fillFileServerUrlBeforeImage(qClassify);
        }
        return classifyList;
    }

    private void fillFileServerUrlBeforeImage(QClassify qClassify) {

        if (StringUtils.isNotEmpty(qClassify.getImage())) {
            qClassify.setImage(fileSDKClient.getFileServerUrl() + qClassify.getImage());
        } else {
            qClassify.setImage("");
        }
        List<QClassify> children = qClassify.getChildrenList();
        for (QClassify c : children) {
            fillFileServerUrlBeforeImage(c);
        }
    }
}
