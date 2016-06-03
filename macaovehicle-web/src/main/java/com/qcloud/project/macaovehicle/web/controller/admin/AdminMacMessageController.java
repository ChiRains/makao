package com.qcloud.project.macaovehicle.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.parameter.model.Param;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.web.handler.DriverHandler;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDriverVO;

@Controller
@RequestMapping(value = "/" + AdminMacMessageController.DIR)
public class AdminMacMessageController {

    public static final String DIR = "admin/macMessage";

    @Autowired
    private ParameterClient    parameterClient;

//    @RequestMapping
//    @NoReferer
//    public ModelAndView list(Integer pageNum, DriverQuery query) {

//        final int PAGE_SIZE = 10;
//        pageNum = RequestUtil.getPageid(pageNum);
//        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
//        parameterClient.get("");
//        AcePagingView pagingView = new AcePagingView("/admin/macaovehicle-Driver-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
//        pagingView.addObject("result", list);
//        return pagingView;
//    }
}
