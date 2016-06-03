package com.qcloud.component.mvprocesstask.web.handler.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jodd.util.StringUtil;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.web.handler.TaskingHandler;
import com.qcloud.component.mvprocesstask.web.handler.VehicleGetter;
import com.qcloud.component.mvprocesstask.web.vo.TaskingVO;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskingVO;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.DateUtil;

@Component
public class TaskingHandlerImpl implements TaskingHandler {

    @Autowired
    private OrganizationClient organizationClient;

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private FormClient         formClient;

    @Autowired
    private VehicleGetter      vehicleGetter;

    @Override
    public List<TaskingVO> toVOList(List<Tasking> list) {

        List<TaskingVO> voList = new ArrayList<TaskingVO>();
        for (Tasking tasking : list) {
            voList.add(toVO(tasking));
        }
        return voList;
    }

    @Override
    public TaskingVO toVO(Tasking tasking) {

        String json = Json.toJson(tasking);
        TaskingVO vo = Json.toObject(json, TaskingVO.class, true);
        QClerk clerk = organizationClient.getClerk(tasking.getClerkId());
        vo.setClerkName(clerk.getName());
        QClerk creatorClerk = organizationClient.getClerk(tasking.getCreator());
        vo.setCreatorName(StringUtils.isEmpty(creatorClerk.getName()) ? "--" : creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(tasking.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(tasking.getApplyTime(), "yyyy-MM-dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(tasking.getReceiveTime(), "yyyy-MM-dd HH:mm"));
        // vo.setFormInstCode(formClient.getFormInstCode(tasking.getFormInstanceId()));
        //
        vo.setIndicatorsTimeStr(tasking.getIndicatorsTime() != null ? DateUtil.date2String(tasking.getIndicatorsTime(), "yyyy-MM-dd") : null);
        vo.setIndicatorsPeriodStr(tasking.getIndicatorsPeriod() != null ? DateUtil.date2String(tasking.getIndicatorsPeriod(), "yyyy-MM-dd") : null);
        Date validDate = vehicleGetter.getValidDate(tasking.getPlateNumber());
        vo.setValidDateStr(validDate != null ? DateUtil.date2String(validDate) : "");
        if (StringUtil.isEmpty(vo.getOwnerName())) {
            vo.setOwnerName("--");
        }
        return vo;
    }

    @Override
    public List<AdminTaskingVO> toVOList4Admin(List<Tasking> list) {

        List<AdminTaskingVO> voList = new ArrayList<AdminTaskingVO>();
        for (Tasking adminTasking : list) {
            voList.add(toVO4Admin(adminTasking));
        }
        return voList;
    }

    @Override
    public AdminTaskingVO toVO4Admin(Tasking tasking) {

        String json = Json.toJson(tasking);
        return Json.toObject(json, AdminTaskingVO.class, true);
    }
}
