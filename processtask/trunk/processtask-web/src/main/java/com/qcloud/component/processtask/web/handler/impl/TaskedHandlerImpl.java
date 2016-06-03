package com.qcloud.component.processtask.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QMainForm;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.QDepartment;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.key.TypeEnum.ProcessStateType;
import com.qcloud.component.processtask.model.key.TypeEnum.TaskStartStateType;
import com.qcloud.component.processtask.web.handler.TaskedHandler;
import com.qcloud.component.processtask.web.vo.AppTaskedVO;
import com.qcloud.component.processtask.web.vo.TaskedVO;
import com.qcloud.component.processtask.web.vo.admin.AdminTaskedVO;
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
    private FileSDKClient      fileSDKClient;

    @Autowired
    private FormClient         formClient;

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
        vo.setApplyTimeStr(DateUtil.date2String(tasked.getApplyTime(), "yyyy/MM/dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(tasked.getReceiveTime(), "yyyy/MM/dd HH:mm"));
        vo.setDealTimeStr(DateUtil.date2String(tasked.getDealTime(), "yyyy/MM/dd HH:mm"));
        //vo.setApply(tasked.getStart() == TaskStartStateType.START.getKey());
        vo.setApply(false);
        vo.setProcessState(tasked.getProcessState());
        // 从xml取
        QMainForm form=formClient.getForm(tasked.getFormId());
        vo.setPcPageUrl(form.getPcTaskedViewUrl());
        vo.setMobilePageUrl(form.getMobileTaskedViewUrl());
        vo.setFormCode(form.getCode());
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

    @Override
    public List<AppTaskedVO> toVOList4App(List<Tasked> list) {

        List<AppTaskedVO> voList = new ArrayList<AppTaskedVO>();
        for (Tasked tasked : list) {
            voList.add(toVO4App(tasked));
        }
        return voList;
    }

    @Override
    public AppTaskedVO toVO4App(Tasked tasked) {

        String json = Json.toJson(tasked);
        AppTaskedVO vo = Json.toObject(json, AppTaskedVO.class, true);
        QClerk creatorClerk = organizationClient.getClerk(tasked.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(tasked.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(tasked.getApplyTime(), "yyyy-MM-dd HH:mm"));
        String processStateStr = "";
        if (ProcessStateType.DOING.getKey() == tasked.getProcessState()) {
            processStateStr = "申请中";
        } else if (ProcessStateType.PASS.getKey() == tasked.getProcessState()) {
            processStateStr = "已通过";
        } else if (ProcessStateType.REFUSE.getKey() == tasked.getProcessState()) {
            processStateStr = "已拒绝";
        }
        vo.setProcessStateStr(processStateStr);
        if (StringUtils.isNotEmpty(creatorClerk.getHeadImage())) {
            vo.setImage(fileSDKClient.getFileServerUrl() + creatorClerk.getHeadImage());
        } else {
            vo.setImage("");
        }
        vo.setApply(tasked.getStart() == TaskStartStateType.START.getKey());
        vo.setMobilePageUrl(formClient.getMobileDomain() + formClient.getForm(tasked.getFormId()).getMobileTaskedViewUrl());
        return vo;
    }
}
