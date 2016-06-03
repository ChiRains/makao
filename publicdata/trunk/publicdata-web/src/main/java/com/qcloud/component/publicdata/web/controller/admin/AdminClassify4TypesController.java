package com.qcloud.component.publicdata.web.controller.admin;

import com.qcloud.component.publicdata.ClassifyType;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.QClassify;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.component.publicdata.util.Common;
import com.qcloud.component.publicdata.web.handler.ClassifyHandler;
import com.qcloud.component.publicdata.web.handler.ClassifyTypeHandler;
import com.qcloud.component.publicdata.web.vo.admin.AdminClassifyVO;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/" + AdminClassify4TypesController.DIR)
public class AdminClassify4TypesController {

    public static final String DIR = "admin/classify4Types";

    @Autowired
    private ClassifyService    classifyService;

    @Autowired
    private ClassifyHandler    classifyHandler;

    @Autowired
    private PublicdataClient   publicdataClient;

    @RequestMapping
    @NoReferer
    public ModelAndView list(HttpServletRequest request, Integer pageNum, ClassifyQuery query, String beanId) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        ClassifyTypeHandler typeHandler = (ClassifyTypeHandler) PiratesBeanFactoryAware.getBeanFactory().getBean(beanId);
        AssertUtil.assertNotNull(typeHandler, "分类类别列表业务实现不能为空.");
        IntKeyValue[] kv = typeHandler.listType(request);
        AssertUtil.assertNotNull(kv, "业务分类类别数组不能为空.");
        List<KeyValueVO> typeList = publicdataClient.exchageObj(kv, query.getType(), "selected");
        AssertUtil.assertNotEmpty(typeList, "业务分类类别列表不能为空.");
        if (query.getType() <= 0) {
            query.setType(kv[0].getKey());
        }
        Page<Classify> page = classifyService.page(query, start, PAGE_SIZE);
        List<AdminClassifyVO> list = classifyHandler.toVOList4Admin(page.getData(), query.getType());
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-Classify4Types-list", DIR + "/list?type=" + query.getType() + "&name=" + StringUtil.nullToEmpty(query.getName()) + "&beanId=" + beanId, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        pagingView.addObject("beanId", beanId);
        pagingView.addObject("typeList", typeList);
        return pagingView;
    }

    @RequestMapping
    @NoReferer
    public ModelAndView listForMerchant(HttpServletRequest request, String beanId) {

        ClassifyTypeHandler typeHandler = (ClassifyTypeHandler) PiratesBeanFactoryAware.getBeanFactory().getBean(beanId);
        AssertUtil.assertNotNull(typeHandler, "分类类别列表业务实现不能为空.");
        long type = typeHandler.listType(request)[0].getKey();
        AssertUtil.assertTrue(type > 0, "业务分类类别不能为空.");
        // List<Classify> classifies = classifyService.listAll(type);
        // List<AdminClassifyVO> list = classifyHandler.toVOList4Admin(classifies, type);
        List<QClassify> classifyList = publicdataClient.listClassifyForTree(type);
        ModelAndView modelAndView = new ModelAndView("/admin/publicdata-Classify4Types-tree-list");
        // modelAndView.addObject("result", Common.listToTree(list, "id", "parentId", "children", -1));
        modelAndView.addObject("beanId", beanId);
        modelAndView.addObject("type", type);
        modelAndView.addObject("qclassify", classifyList);
        return modelAndView;
    }

    @RequestMapping
    public ModelAndView toAdd(long type, String beanId) {

        ModelAndView model = new ModelAndView("/admin/publicdata-Classify4Types-add");
        model.addObject("type", type);
        List<Classify> list = classifyService.listAll(type);
        List<AdminClassifyVO> voList = classifyHandler.toVOList4Admin(list, null, type);
        model.addObject("classifyList", voList);
        model.addObject("beanId", beanId);
        String fileSize=publicdataClient.getImageInformationByCode("shangpinfenlei");
        model.addObject("fileSize",fileSize);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Classify classify, String beanId) {

        classifyService.add(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        // aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType() + "&beanId=" + beanId);
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id, String beanId) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        AdminClassifyVO adminClassifyVO = classifyHandler.toVO4Admin(classify);
        ModelAndView model = new ModelAndView("/admin/publicdata-Classify4Types-edit");
        model.addObject("classify", adminClassifyVO);
        List<Classify> list = classifyService.listAll(classify.getType());
        List<AdminClassifyVO> voList = classifyHandler.toVOList4Admin(list, classify, classify.getType());
        model.addObject("classifyList", voList);
        ClassifyType classifyType = null;
        for (ClassifyType t : ClassifyType.values()) {
            if (t.getKey() == classify.getType()) {
                classifyType = t;
                break;
            }
        }
        if (classifyType != null) {
            model.addObject("typeStr", classifyType.getValue());
        }
        model.addObject("beanId", beanId);
        String fileSize=publicdataClient.getImageInformationByCode("shangpinfenlei");
        model.addObject("fileSize",fileSize);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Classify classify, String beanId) {

        classifyService.update(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        // aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType() + "&beanId=" + beanId);
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id, String beanId) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        classifyService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType() + "&beanId=" + beanId);
        return aceAjaxView;
    }
}
