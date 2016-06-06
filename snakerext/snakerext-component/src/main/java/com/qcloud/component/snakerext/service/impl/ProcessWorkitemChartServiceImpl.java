package com.qcloud.component.snakerext.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.ProcesstaskClient;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.entity.ProcessChart;
import com.qcloud.component.snakerext.entity.ProcessWorkitem;
import com.qcloud.component.snakerext.entity.ProcessWorkitemChart;
import com.qcloud.component.snakerext.service.ProcessWorkitemChartService;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class ProcessWorkitemChartServiceImpl implements ProcessWorkitemChartService {

    @Autowired
    ISnakerClient      snakerClient;

    @Autowired
    ProcesstaskClient  processtaskClient;

    @Autowired
    OrganizationClient organizationClient;

    @Override
    public ProcessChart calculateChart(String processInstId) {

        QueryFilter filter = new QueryFilter();
        filter.setOrderId(processInstId);
        String applyWorkitemId = "";
        List<String> workitemIdList = new ArrayList<String>();
        List<HistoryTask> taskedList = snakerClient.query().getHistoryTasks(filter);
        List<Task> taskList = snakerClient.query().getActiveTasks(filter);
        Map<String, String> idNameMapping = new HashMap<String, String>();
        for (HistoryTask historyTask : taskedList) {
            workitemIdList.add(historyTask.getId());
            idNameMapping.put(historyTask.getId(), historyTask.getDisplayName());
            if ("start".equals(historyTask.getParentTaskId())) {
                applyWorkitemId = historyTask.getId();
            }
        }
        if (StringUtils.isEmpty(applyWorkitemId)) {
            for (Task task : taskList) {
                workitemIdList.add(task.getId());
                idNameMapping.put(task.getId(), task.getDisplayName());
                if ("start".equals(task.getParentTaskId())) {
                    applyWorkitemId = task.getId();
                }
            }
        }
        AssertUtil.assertNotEmpty(applyWorkitemId, "找不到第一步流程活动任务.");
        List<ProcessWorkitem> workitemList = new ArrayList<ProcessWorkitem>();
        for (String str : workitemIdList) {
            QTask task = processtaskClient.getTaskByWorkitem(str);
            AssertUtil.assertNotNull(task, "流程任务对应待办任务不存在." + str);
            int state = 1;
            if (task.isTasking()) {
                state = 1;
            } else {
                if (task.isPass()) {
                    state = 2;
                } else {
                    state = 3;
                }
            }
            Long clerkId = task.getClerk();
            QClerk clerk = organizationClient.getClerk(clerkId);
            AssertUtil.assertNotNull(clerk, "审批人不存在." + clerkId);
            ProcessWorkitem processWorkitem = new ProcessWorkitem();
            processWorkitem.setClerkName(clerk.getName());
            processWorkitem.setName(idNameMapping.get(str));
            processWorkitem.setState(state);
            processWorkitem.setTime(StringUtil.nullToEmpty(DateUtil.date2String(task.getDoneTime())));
            processWorkitem.setWorkitem(str);
            workitemList.add(processWorkitem);
        }
        ProcessChart processChart = new ProcessChart();
        processChart.setList(workitemList);
        //
        List<ProcessWorkitemChart> chart = new ArrayList<ProcessWorkitemChart>();
        LinkedList<String> chain = new LinkedList<String>();
        chain.add(applyWorkitemId);
        while (!chain.isEmpty()) {
            String current = chain.removeFirst();
            for (HistoryTask historyTask : taskedList) {
                if (historyTask.getParentTaskId().equals(current)) {
                    chain.add(historyTask.getId());
                    //
                    ProcessWorkitemChart processWorkitemChart = new ProcessWorkitemChart();
                    processWorkitemChart.setSourceWorkitemId(current);
                    processWorkitemChart.setTargetWorkitemId(historyTask.getId());
                    chart.add(processWorkitemChart);
                }
            }
            for (Task task : taskList) {
                if (task.getParentTaskId().equals(current)) {
                    chain.add(task.getId());
                    //
                    ProcessWorkitemChart processWorkitemChart = new ProcessWorkitemChart();
                    processWorkitemChart.setSourceWorkitemId(current);
                    processWorkitemChart.setTargetWorkitemId(task.getId());
                    chart.add(processWorkitemChart);
                }
            }
        }
        processChart.setChart(chart);
        return processChart;
    }
}
