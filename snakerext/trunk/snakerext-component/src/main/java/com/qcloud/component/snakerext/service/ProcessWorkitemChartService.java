package com.qcloud.component.snakerext.service;

import com.qcloud.component.snakerext.entity.ProcessChart;

public interface ProcessWorkitemChartService {

    ProcessChart calculateChart(String processInstId);
}
