package com.qcloud.component.mvprocesstask.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import jodd.util.StringUtil;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.web.handler.TaskedGetter;
import com.qcloud.component.mvprocesstask.web.handler.TaskedHandler;
import com.qcloud.component.mvprocesstask.web.vo.TaskedVO;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskedVO;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;

@Component
public class TaskedHandlerImpl implements TaskedHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private TaskedGetter       taskedGetter;

    @Override
    public List<TaskedVO> toVOList(List<Tasked> list) {

        List<TaskedVO> voList = new ArrayList<TaskedVO>();
        for (Tasked tasked : list) {
            voList.add(toVO(tasked));
        }
        return voList;
    }

    @Override
    public TaskedVO toVO(Tasked tasked) {

        String json = Json.toJson(tasked);
        TaskedVO vo = Json.toObject(json, TaskedVO.class, true);
        QClerk dealClerk = organizationClient.getClerk(tasked.getClerkId());
        vo.setClerkName(dealClerk.getName());
        QClerk creatorClerk = organizationClient.getClerk(tasked.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(tasked.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(tasked.getApplyTime(), "yyyy-MM-dd HH:mm:ss"));
        vo.setReceiveTimeStr(DateUtil.date2String(tasked.getReceiveTime(), "yyyy-MM-dd HH:mm:ss"));
        vo.setDealTimeStr(DateUtil.date2String(tasked.getDealTime(), "yyyy-MM-dd HH:mm:ss"));
        // vo.setFormInstCode(formClient.getFormInstCode(tasked.getFormInstanceId()));
        //
        vo.setIndicatorsTimeStr(tasked.getIndicatorsTime() != null ? DateUtil.date2String(tasked.getIndicatorsTime(), "yyyy-MM-dd HH:mm:ss") : null);
        vo.setIndicatorsPeriodStr(tasked.getIndicatorsPeriod() != null ? DateUtil.date2String(tasked.getIndicatorsPeriod(), "yyyy-MM-dd HH:mm:ss") : null);
        QClerk operatorClerk = organizationClient.getClerk(tasked.getOperatorClerkId());
        vo.setOperator(operatorClerk.getName());
        vo.setRecordTime(DateUtil.date2String(tasked.getRecordTime(), "yyyy-MM-dd HH:mm:ss"));
        vo.setBorderStatus(taskedGetter.getBorderStatus(tasked.getFormInstanceId()));
        vo.setCiqStatus(taskedGetter.getCiqStatus(tasked.getFormInstanceId()));
        vo.setCustomsStatus(taskedGetter.getCustomsStatus(tasked.getFormInstanceId()));
        if (StringUtil.isEmpty(vo.getOwnerName())) {
            vo.setOwnerName("--");
        }
        return vo;
    }

    @Override
    public List<AdminTaskedVO> toVOList4Admin(List<Tasked> list) {

        List<AdminTaskedVO> voList = new ArrayList<AdminTaskedVO>();
        for (Tasked adminTasked : list) {
            voList.add(toVO4Admin(adminTasked));
        }
        return voList;
    }

    @Override
    public AdminTaskedVO toVO4Admin(Tasked tasked) {

        String json = Json.toJson(tasked);
        return Json.toObject(json, AdminTaskedVO.class, true);
    }
}
