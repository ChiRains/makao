package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.component.publicdata.util.ClassifyUtils;
import com.qcloud.component.publicdata.web.handler.ClassifyHandler;
import com.qcloud.component.publicdata.web.vo.ClassifyVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminClassifyVO;
import com.qcloud.pirates.core.json.Json;

@Component
public class ClassifyHandlerImpl implements ClassifyHandler {

    @Autowired
    private FileSDKClient   fileSDKClient;

    @Autowired
    private ClassifyService classifyService;

    @Override
    public List<ClassifyVO> toVOList(List<Classify> list) {

        List<ClassifyVO> voList = new ArrayList<ClassifyVO>();
        for (Classify classify : list) {
            voList.add(toVO(classify));
        }
        return voList;
    }

    @Override
    public ClassifyVO toVO(Classify classify) {

        String json = Json.toJson(classify);
        return Json.toObject(json, ClassifyVO.class, true);
    }

    @Override
    public List<AdminClassifyVO> toVOList4Admin(List<Classify> list, long type) {

        List<Classify> allList = classifyService.listAll(type);
        List<Classify> result = sort(list, list);
        List<AdminClassifyVO> voList = new ArrayList<AdminClassifyVO>();
        for (Classify adminClassify : result) {
            AdminClassifyVO vo = toVO4Admin(allList, adminClassify);
            String path = ClassifyUtils.calculationPath(allList, adminClassify);
            vo.setPath(path);
            voList.add(vo);
        }
        // 排序
        return voList;
    }

    @Override
    public AdminClassifyVO toVO4Admin(Classify classify) {

        List<Classify> allList = classifyService.listAll(classify.getType());
        return toVO4Admin(allList, classify);
    }

    private AdminClassifyVO toVO4Admin(List<Classify> list, Classify classify) {

        String json = Json.toJson(classify);
        AdminClassifyVO vo = Json.toObject(json, AdminClassifyVO.class, true);
        vo.setImageUid(fileSDKClient.urlToUid(classify.getImage()));
        vo.setImage(fileSDKClient.getFileServerUrl() + vo.getImage());
        return vo;
    }

    private List<Classify> sort(List<Classify> allList, List<Classify> list) {

        LinkedList<Classify> next = new LinkedList<Classify>();
        for (Classify classify : list) {
            if (ClassifyUtils.getParent(allList, classify.getParentId()) == null) {
                next.add(classify);
            }
        }
        List<Classify> result = new ArrayList<Classify>();
        while (!next.isEmpty()) {
            Classify c = next.removeFirst();
            result.add(c);
            LinkedList<Classify> children = new LinkedList<Classify>();
            for (Classify classify : list) {
                if (classify.getParentId() == c.getId()) {
                    children.addFirst(classify);
                }
            }
            for (Classify classify : children) {
                next.addFirst(classify);
            }
        }
        return result;
    }

    @Override
    public List<AdminClassifyVO> toVOList4Admin(List<Classify> list, Classify c, long type) {

        List<Classify> allList = classifyService.listAll(type);
        // 过滤掉当前以及其下级
        List<Classify> filterList = new ArrayList<Classify>();
        for (Classify classify : list) {
            boolean result = isParent(allList, classify, c == null ? -1 : c.getId());
            if (!result) {
                filterList.add(classify);
            }
        }
        // 排序
        List<Classify> result = sort(allList, filterList);
        List<AdminClassifyVO> voList = new ArrayList<AdminClassifyVO>();
        for (Classify adminClassify : result) {
            AdminClassifyVO vo = toVO4Admin(allList, adminClassify);
            String path = ClassifyUtils.calculationPath(allList, adminClassify);
            vo.setPath(path);
            vo.setSelected(c != null && c.getParentId() == vo.getId() ? "selected" : "");
            voList.add(vo);
        }
        return voList;
    }

    private boolean isParent(List<Classify> allList, Classify classify, long parentId) {

        List<Classify> list = ClassifyUtils.getParentList(allList, classify.getId());
        for (Classify c : list) {
            if (c.getId() == parentId) {
                return true;
            }
        }
        return false;
    }
}
