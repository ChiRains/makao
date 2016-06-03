package com.qcloud.component.publicdata.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicdata.ClassifyType;
import com.qcloud.component.publicdata.EnableType;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.key.TypeEnum;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.component.publicdata.web.handler.ClassifyHandler;
import com.qcloud.component.publicdata.web.vo.admin.AdminClassifyVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminClassify4TypeController.DIR)
public class AdminClassify4TypeController {

    //
    public static final String DIR = "admin/classify4Type";

    @Autowired
    private ClassifyService    classifyService;

    @Autowired
    private ClassifyHandler    classifyHandler;

    @Autowired
    private PublicdataClient   publicdataClient;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ClassifyQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Classify> page = classifyService.page(query, start, PAGE_SIZE);
        List<AdminClassifyVO> list = classifyHandler.toVOList4Admin(page.getData(), query.getType());
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-Classify4Type-list", DIR + "/list?type=" + query.getType() + "&name=" + StringUtil.nullToEmpty(query.getName()), pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd(long type) {

        ModelAndView model = new ModelAndView("/admin/publicdata-Classify4Type-add");
        ClassifyType classifyType = null;
        for (ClassifyType t : ClassifyType.values()) {
            if (t.getKey() == type) {
                classifyType = t;
                break;
            }
        }
        if (classifyType == null) {
            List<KeyValueVO> typeList = publicdataClient.exchageObj(ClassifyType.values(), type, "selected");
            model.addObject("typeList", typeList);
            model.addObject("type", 0);
        } else {
            model.addObject("typeStr", classifyType.getValue());
            model.addObject("type", type);
            String fileSize = publicdataClient.getImageInformationByCode(TypeEnum.PictureType.get(classifyType.getKey()));
            model.addObject("fileSize", fileSize);
        }
        List<Classify> list = classifyService.listAll(type);
        List<AdminClassifyVO> voList = classifyHandler.toVOList4Admin(list, null, type);
        model.addObject("classifyList", voList);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Classify classify) {

        ClassifyType classifyType = null;
        for (ClassifyType t : ClassifyType.values()) {
            if (t.getKey() == classify.getType()) {
                classifyType = t;
                break;
            }
        }
        AssertUtil.assertNotNull(classifyType, "分类未指定:" + classify.getType());
        System.out.println(classify.getImage());
        classifyService.add(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        // aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        AdminClassifyVO adminClassifyVO = classifyHandler.toVO4Admin(classify);
        ModelAndView model = new ModelAndView("/admin/publicdata-Classify4Type-edit");
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
            String fileSize = publicdataClient.getImageInformationByCode(TypeEnum.PictureType.get(classifyType.getKey()));
            model.addObject("fileSize", fileSize);
        }
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Classify classify) {

        classifyService.update(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        // aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        AssertUtil.assertNotNull(classify, "指定分类不存在" + id);
        classifyService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView upward(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        classifyService.sort(id, TypeEnum.SortType.UPWARD.getKey());
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView down(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        classifyService.sort(id, TypeEnum.SortType.DOWN.getKey());
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView top(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        classifyService.sort(id, TypeEnum.SortType.TOP.getKey());
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView enable(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        classifyService.enable(id, EnableType.ENABLE.getKey());
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView disable(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        classifyService.enable(id, EnableType.DISABLE.getKey());
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }

    // 未完成
    @RequestMapping
    public AceAjaxView withoutDelete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        AceAjaxView aceAjaxView = new AceAjaxView();
        // 获取商品列表
        classifyService.withoutDelete(id);
        aceAjaxView.setMessage("修改成功");
        return aceAjaxView;
    }
}
