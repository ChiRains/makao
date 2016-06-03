package com.qcloud.component.publicdata.web.controller.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicdata.ClassifyType;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.Classify;
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
@RequestMapping(value = "/" + AdminClassifyController.DIR)
public class AdminClassifyController {
    public static final String DIR = "admin/classify";
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
        //把枚举转换成数组在页面显示,query.getType()用来跟枚举的值对比
        List<KeyValueVO> typeList = publicdataClient.exchageObj(ClassifyType.values(), query.getType(), "selected");
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-Classify-list", DIR + "/list?type=" + query.getType() + "&name=" + StringUtil.nullToEmpty(query.getName()), pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        pagingView.addObject("typeList", typeList);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd(long type) {
        ModelAndView model = new ModelAndView("/admin/publicdata-Classify-add");
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
        classifyService.add(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        AdminClassifyVO adminClassifyVO = classifyHandler.toVO4Admin(classify);
        ModelAndView model = new ModelAndView("/admin/publicdata-Classify-edit");
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
        
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Classify classify) {
        classifyService.update(classify);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        Classify classify = classifyService.get(id);
        classifyService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list?type=" + classify.getType());
        return aceAjaxView;
    }
}
