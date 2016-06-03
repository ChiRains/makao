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
import com.qcloud.project.macaovehicle.web.handler.TaskingBorderHandler;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.web.vo.TaskingBorderVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingBorderVO;

@Component
public class TaskingBorderHandlerImpl implements TaskingBorderHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private VehicleGetter      vehicleGetter;

    @Override
    public List<TaskingBorderVO> toVOList(List<TaskingBorder> list) {

        List<TaskingBorderVO> voList = new ArrayList<TaskingBorderVO>();
        for (TaskingBorder taskingBorder : list) {
            voList.add(toVO(taskingBorder));
        }
        return voList;
    }

    @Override
    public TaskingBorderVO toVO(TaskingBorder taskingBorder) {

        String json = Json.toJson(taskingBorder);
        TaskingBorderVO vo = Json.toObject(json, TaskingBorderVO.class, true);
        QClerk clerk = organizationClient.getClerk(taskingBorder.getClerkId());
        vo.setClerkName(clerk.getName());
        QClerk creatorClerk = organizationClient.getClerk(taskingBorder.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(taskingBorder.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(taskingBorder.getApplyTime(), "yyyy-MM-dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(taskingBorder.getReceiveTime(), "yyyy-MM-dd HH:mm"));
        // vo.setFormInstCode(formClient.getFormInstCode(taskingBorder.getFormInstanceId()));
        //
        vo.setIndicatorsTimeStr(taskingBorder.getIndicatorsTime() != null ? DateUtil.date2String(taskingBorder.getIndicatorsTime(), "yyyy-MM-dd") : null);
        vo.setIndicatorsPeriodStr(taskingBorder.getIndicatorsPeriod() != null ? DateUtil.date2String(taskingBorder.getIndicatorsPeriod(), "yyyy-MM-dd") : null);
        Date validDate = vehicleGetter.getValidDate(taskingBorder.getPlateNumber());
        vo.setValidDateStr(validDate != null ? DateUtil.date2String(validDate) : "--");
        return vo;
    }

    @Override
    public List<AdminTaskingBorderVO> toVOList4Admin(List<TaskingBorder> list) {

        List<AdminTaskingBorderVO> voList = new ArrayList<AdminTaskingBorderVO>();
        for (TaskingBorder adminTaskingBorder : list) {
            voList.add(toVO4Admin(adminTaskingBorder));
        }
        return voList;
    }

    @Override
    public AdminTaskingBorderVO toVO4Admin(TaskingBorder taskingBorder) {

        String json = Json.toJson(taskingBorder);
        return Json.toObject(json, AdminTaskingBorderVO.class, true);
    }

    @Override
    public TaskingBorder toEntity(Tasking tasking) {

        String json = Json.toJson(tasking);
        return Json.toObject(json, TaskingBorder.class, true);
    }
}
