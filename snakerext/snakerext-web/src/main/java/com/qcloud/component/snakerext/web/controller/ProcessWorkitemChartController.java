package com.qcloud.component.snakerext.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.snakerext.entity.ProcessChart;
import com.qcloud.component.snakerext.entity.ProcessWorkitem;
import com.qcloud.component.snakerext.entity.ProcessWorkitemChart;
import com.qcloud.component.snakerext.service.ProcessWorkitemChartService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = ProcessWorkitemChartController.DIR)
public class ProcessWorkitemChartController {

    public static final String          DIR = "/processWorkitemChart";

    @Autowired
    private ProcessWorkitemChartService processWorkitemChartService;

    @RequestMapping
    public FrontAjaxView calculateChart(String processInstId) {

        AssertUtil.assertNotEmpty(processInstId, "流程实例不能为空." + processInstId);
        ProcessChart processChart = processWorkitemChartService.calculateChart(processInstId);
        List<ProcessWorkitemChart> chain = processChart.getChart();
        List<ProcessWorkitem> list = processChart.getList();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("chain", chain);
        view.addObject("list", list);
        view.setMessage("获取工作流流转记录成功.");
        return view;
    }
}
