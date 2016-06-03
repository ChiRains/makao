package com.qcloud.component.snaker.web.controller;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snaker.web.handler.ProcessHandler;
import com.qcloud.component.snaker.web.vo.admin.ProcessVO;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = ProcessController.DIR)
public class ProcessController {

    public static final String DIR = "/process";

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private ProcessHandler     processHandler;

    @RequestMapping
    @NoReferer
    public FrontAjaxView list(String type) {

        Page<Process> page = new Page<Process>();
        QueryFilter filter = new QueryFilter();
        if (StringUtils.isNotEmpty(type)) {
            filter.setProcessType(type);
        }
        List<Process> list = snakerClient.process().getProcesss(page, filter);
        List<ProcessVO> voList = processHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("processList", voList);
        return view;
    }
}
