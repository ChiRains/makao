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
import com.qcloud.project.macaovehicle.web.handler.TaskingCustomsHandler;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.web.vo.TaskingCustomsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCustomsVO;

@Component
public class TaskingCustomsHandlerImpl implements TaskingCustomsHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private VehicleGetter      vehicleGetter;

    @Override
    public List<TaskingCustomsVO> toVOList(List<TaskingCustoms> list) {

        List<TaskingCustomsVO> voList = new ArrayList<TaskingCustomsVO>();
        for (TaskingCustoms taskingCustoms : list) {
            voList.add(toVO(taskingCustoms));
        }
        return voList;
    }

    @Override
    public TaskingCustomsVO toVO(TaskingCustoms taskingCustoms) {

        String json = Json.toJson(taskingCustoms);
        TaskingCustomsVO vo = Json.toObject(json, TaskingCustomsVO.class, true);
        QClerk clerk = organizationClient.getClerk(taskingCustoms.getClerkId());
        vo.setClerkName(clerk.getName());
        QClerk creatorClerk = organizationClient.getClerk(taskingCustoms.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(taskingCustoms.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(taskingCustoms.getApplyTime(), "yyyy-MM-dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(taskingCustoms.getReceiveTime(), "yyyy-MM-dd HH:mm"));
//         vo.setFormInstCode(formClient.getFormInstCode(taskingCustoms.getFormInstanceId()));
        //
        vo.setIndicatorsTimeStr(taskingCustoms.getIndicatorsTime() != null ? DateUtil.date2String(taskingCustoms.getIndicatorsTime(), "yyyy-MM-dd") : null);
        vo.setIndicatorsPeriodStr(taskingCustoms.getIndicatorsPeriod() != null ? DateUtil.date2String(taskingCustoms.getIndicatorsPeriod(), "yyyy-MM-dd") : null);
        Date validDate = vehicleGetter.getValidDate(taskingCustoms.getPlateNumber());
        vo.setValidDateStr(validDate != null ? DateUtil.date2String(validDate) : "--");
        return vo;
    }

    @Override
    public List<AdminTaskingCustomsVO> toVOList4Admin(List<TaskingCustoms> list) {

        List<AdminTaskingCustomsVO> voList = new ArrayList<AdminTaskingCustomsVO>();
        for (TaskingCustoms adminTaskingCustoms : list) {
            voList.add(toVO4Admin(adminTaskingCustoms));
        }
        return voList;
    }

    @Override
    public AdminTaskingCustomsVO toVO4Admin(TaskingCustoms taskingCustoms) {

        String json = Json.toJson(taskingCustoms);
        return Json.toObject(json, AdminTaskingCustomsVO.class, true);
    }

    @Override
    public TaskingCustoms toEntity(Tasking tasking) {

        String json = Json.toJson(tasking);
        return Json.toObject(json, TaskingCustoms.class, true);
    }
}
