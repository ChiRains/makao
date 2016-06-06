package com.qcloud.component.publicservice.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.service.CommonQuestionService;
import com.qcloud.component.publicservice.web.handler.CommonQuestionHandler;
import com.qcloud.component.publicservice.web.vo.CommonQuestionVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = CommonQuestionController.DIR)
public class CommonQuestionController {

    public static final String    DIR = "/commonQuestion";

    @Autowired
    private CommonQuestionService commonQuestionService;

    @Autowired
    private CommonQuestionHandler commonQuestionHandler;

    @RequestMapping
    @NoReferer
    public FrontAjaxView listCommonQuestion(PPage page) {

        Page<CommonQuestion> pageInfo = commonQuestionService.page(page.getPageStart(), page.getPageSize());
        List<CommonQuestion> list = pageInfo.getData();
        List<CommonQuestionVO> voList = commonQuestionHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("list", voList);
        return view;
    }

    @RequestMapping
    @NoReferer
    public ModelAndView getCommonQuestion(Long id) {

        CommonQuestion item = commonQuestionService.get(id);
        CommonQuestionVO voItem = commonQuestionHandler.toVO(item);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", voItem);
        return view;
    }
}
