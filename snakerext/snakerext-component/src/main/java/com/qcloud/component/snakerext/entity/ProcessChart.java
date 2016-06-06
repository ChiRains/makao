package com.qcloud.component.snakerext.entity;

import java.util.List;

public class ProcessChart {

    private List<ProcessWorkitemChart> chart;

    private List<ProcessWorkitem>      list;

    public List<ProcessWorkitemChart> getChart() {

        return chart;
    }

    public void setChart(List<ProcessWorkitemChart> chart) {

        this.chart = chart;
    }

    public List<ProcessWorkitem> getList() {

        return list;
    }

    public void setList(List<ProcessWorkitem> list) {

        this.list = list;
    }
}
