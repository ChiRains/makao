package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.web.handler.VehicleGetter;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.web.handler.TaskingCiqHandler;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.web.vo.TaskingCiqVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCiqVO;

@Component
public class TaskingCiqHandlerImpl implements TaskingCiqHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private VehicleGetter      vehicleGetter;

    @Override
    public List<TaskingCiqVO> toVOList(List<TaskingCiq> list) {

        List<TaskingCiqVO> voList = new ArrayList<TaskingCiqVO>();
        for (TaskingCiq taskingCiq : list) {
            voList.add(toVO(taskingCiq));
        }
        return voList;
    }

    @Override
    public TaskingCiqVO toVO(TaskingCiq taskingCiq) {

        String json = Json.toJson(taskingCiq);
        TaskingCiqVO vo = Json.toObject(json, TaskingCiqVO.class, true);
        QClerk clerk = organizationClient.getClerk(taskingCiq.getClerkId());
        vo.setClerkName(clerk.getName());
        QClerk creatorClerk = organizationClient.getClerk(taskingCiq.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(taskingCiq.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(taskingCiq.getApplyTime(), "yyyy-MM-dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(taskingCiq.getReceiveTime(), "yyyy-MM-dd HH:mm"));
        // vo.setFormInstCode(formClient.getFormInstCode(taskingCiq.getFormInstanceId()));
        //
        vo.setIndicatorsTimeStr(taskingCiq.getIndicatorsTime() != null ? DateUtil.date2String(taskingCiq.getIndicatorsTime(), "yyyy-MM-dd") : null);
        vo.setIndicatorsPeriodStr(taskingCiq.getIndicatorsPeriod() != null ? DateUtil.date2String(taskingCiq.getIndicatorsPeriod(), "yyyy-MM-dd") : null);
        Date validDate = vehicleGetter.getValidDate(taskingCiq.getPlateNumber());
        vo.setValidDateStr(validDate != null ? DateUtil.date2String(validDate) : "--");
        return vo;
    }

    @Override
    public List<AdminTaskingCiqVO> toVOList4Admin(List<TaskingCiq> list) {

        List<AdminTaskingCiqVO> voList = new ArrayList<AdminTaskingCiqVO>();
        for (TaskingCiq adminTaskingCiq : list) {
            voList.add(toVO4Admin(adminTaskingCiq));
        }
        return voList;
    }

    @Override
    public AdminTaskingCiqVO toVO4Admin(TaskingCiq taskingCiq) {

        String json = Json.toJson(taskingCiq);
        return Json.toObject(json, AdminTaskingCiqVO.class, true);
    }

    @Override
    public TaskingCiq toEntity(Tasking tasking) {

        String json = Json.toJson(tasking);
        return Json.toObject(json, TaskingCiq.class, true);
    }
}
