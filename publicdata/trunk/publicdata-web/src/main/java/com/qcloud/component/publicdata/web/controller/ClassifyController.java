package com.qcloud.component.publicdata.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.QClassify;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = ClassifyController.DIR)
public class ClassifyController {

    //
    public static final String DIR = "/classify";

    @Autowired
    private ClassifyService    classifyService;

    @Autowired
    private PublicdataClient   publicdataClient;

    @Autowired
    private FileSDKClient      fileSDKClient;

    @RequestMapping
    @NoReferer
    public FrontAjaxView listToTopAncestor(Long classifyId) {

        AssertUtil.assertNotNull(classifyId, "分类ID不能为空.");
        Classify classify = classifyService.get(classifyId);
        AssertUtil.assertNotNull(classify, "分类不存在." + classifyId);
        //
        List<Classify> allList = classifyService.listAll(classify.getType());
        List<Classify> list = new ArrayList<Classify>();
        Set<Long> idSet = new HashSet<Long>();
        Classify p = classify;
        while (true) {
            if (idSet.add(p.getId())) {
                list.add(0, p);
            } else {
                break;
            }
            for (Classify c : allList) {
                if (c.getId() == p.getParentId()) {
                    p = c;
                }
            }
        }
        List<QClassify> qList = new ArrayList<QClassify>();
        for (Classify c : list) {
            QClassify qc = new QClassify();
            qc.setId(c.getId());
            if (StringUtils.isNotEmpty(c.getImage())) {
                qc.setImage(fileSDKClient.getFileServerUrl() + c.getImage());
            } else {
                qc.setImage("");
            }
            qc.setName(c.getName());
            qc.setRemark(c.getRemark());
            qc.setEnable(c.getEnable());
            qList.add(qc);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("classifyList", qList);
        view.setMessage("获取分类成功");
        return view;
    }

    @RequestMapping
    @NoReferer
    public FrontAjaxView listTopByType(Long type) {

        List<QClassify> classifyList = publicdataClient.listTopClassify(type);
        for (QClassify qClassify : classifyList) {
            fillFileServerUrlBeforeImage(qClassify);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("classifyList", classifyList);
        view.setMessage("获取分类成功");
        return view;
    }

    @RequestMapping
    @NoReferer
    public FrontAjaxView listByParentAndType(Long parentId, Long type) {

        List<QClassify> classifyList = publicdataClient.listClassifyForTreeByParent(parentId, type);
        for (QClassify qClassify : classifyList) {
            fillFileServerUrlBeforeImage(qClassify);
        }
        Classify classify = classifyService.get(parentId);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("classifyList", classifyList);
        view.addObject("parentName", classify.getName());
        view.setMessage("获取分类成功");
        return view;
    }

    @RequestMapping
    @NoReferer
    public FrontAjaxView listByType(Long type) {

        List<QClassify> classifyList = publicdataClient.listClassifyForTree(type);
        for (QClassify qClassify : classifyList) {
            fillFileServerUrlBeforeImage(qClassify);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("classifyList", classifyList);
        view.setMessage("获取分类成功");
        return view;
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
