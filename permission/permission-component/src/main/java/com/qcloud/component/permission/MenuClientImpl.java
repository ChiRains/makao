package com.qcloud.component.permission;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.key.TypeEnum.PermissionType;
import com.qcloud.component.permission.service.AuthenticationService;
import com.qcloud.component.permission.service.CatalogService;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.component.permission.vo.CatalogVO;

@Service
public class MenuClientImpl implements MenuClient {

    @Autowired
    private CatalogService        catalogService;

    @Autowired
    private MenuService           menuService;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public List<CatalogVO> list(String[] accounts) {

        if (accounts == null || accounts.length == 0) {
            return new ArrayList<CatalogVO>(0);
        }
        List<Menu> pms = new ArrayList<Menu>();
        for (String str : accounts) {
            List<Menu> list = listMenu(str);
            if (CollectionUtils.isNotEmpty(list)) {
                pms.addAll(list);
            }
        }
        List<Catalog> list = catalogService.list();
        List<CatalogVO> result = new ArrayList<CatalogVO>();
        if (list == null) {
            return result;
        }
        for (Catalog catalog : list) {
            List<Menu> menuList = menuService.list(catalog.getId());
            List<Menu> umList = filter(menuList, pms);
            if (CollectionUtils.isEmpty(umList)) {
                continue;
            }
            CatalogVO vo = new CatalogVO();
            vo.setCatalog(catalog);
            vo.setMenuList(umList);
            result.add(vo);
        }
        return result;
    }

    private List<Menu> filter(List<Menu> menuList, List<Menu> pms) {

        List<Menu> result = new ArrayList<Menu>(menuList.size());
        for (Menu menu : menuList) {
            for (Menu pm : pms) {
                if (pm != null && menu.getId() == pm.getId()) {
                    result.add(menu);
                    break;
                }
            }
        }
        return result;
    }

    private List<Menu> listMenu(String account) {

        List<Permission> permissionList = authenticationService.listPermissions(account);
        if (CollectionUtils.isNotEmpty(permissionList)) {
            List<Long> menuKeyList = new ArrayList<Long>();
            List<Long> resourcesKeyList = new ArrayList<Long>();
            for (Permission permission : permissionList) {
                if (PermissionType.P1.getKey() == permission.getType()) {
                    menuKeyList.add(permission.getTargetId());
                } else if (PermissionType.P2.getKey() == permission.getType()) {
                    resourcesKeyList.add(permission.getTargetId());
                }
            }
            List<Menu> menuList = menuService.list(menuKeyList);
            return menuList;
        }
        return new ArrayList<Menu>(0);
    }

    @Override
    public List<Catalog> listCatalogs() {

        return catalogService.list();
    }
}
