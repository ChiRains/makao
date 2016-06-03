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
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.key.TypeEnum.TaskStartStateType;
import com.qcloud.component.processtask.web.handler.TaskingHandler;
import com.qcloud.component.processtask.web.vo.AppTaskingVO;
import com.qcloud.component.processtask.web.vo.TaskingVO;
import com.qcloud.component.processtask.web.vo.admin.AdminTaskingVO;
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
    private FileSDKClient      fileSDKClient;

    @Autowired
    private FormClient         formClient;

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
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(tasking.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(tasking.getApplyTime(), "yyyy/MM/dd HH:mm"));
        vo.setReceiveTimeStr(DateUtil.date2String(tasking.getReceiveTime(), "yyyy/MM/dd HH:mm"));
        vo.setApply(tasking.getStart() == TaskStartStateType.START.getKey());
        // 从配置文件取
        QMainForm form=formClient.getForm(tasking.getFormId());
        vo.setPcPageUrl(form.getPcTaskingViewUrl());
        vo.setFormCode(form.getCode());
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

    @Override
    public List<AppTaskingVO> toVOList4App(List<Tasking> list) {

        List<AppTaskingVO> voList = new ArrayList<AppTaskingVO>();
        for (Tasking tasking : list) {
            voList.add(toVO4App(tasking));
        }
        return voList;
    }

    @Override
    public AppTaskingVO toVO4App(Tasking tasking) {

        String json = Json.toJson(tasking);
        AppTaskingVO vo = Json.toObject(json, AppTaskingVO.class, true);
        QClerk creatorClerk = organizationClient.getClerk(tasking.getCreator());
        vo.setCreatorName(creatorClerk.getName());
        Long departmentId = creatorClerk.getDepartmentId();
        QDepartment department = organizationClient.getDepartment(departmentId);
        vo.setDepartmentName(department.getName());
        Process process = snakerClient.process().getProcessById(tasking.getProcessId());
        vo.setProcessName(process.getDisplayName());
        vo.setApplyTimeStr(DateUtil.date2String(tasking.getApplyTime(), "yyyy-MM-dd HH:mm"));
        if (StringUtils.isNotEmpty(creatorClerk.getHeadImage())) {
            vo.setImage(fileSDKClient.getFileServerUrl() + creatorClerk.getHeadImage());
        } else {
            vo.setImage("");
        }
        vo.setApply(tasking.getStart() == TaskStartStateType.START.getKey());
        vo.setMobilePageUrl(formClient.getMobileDomain() + formClient.getForm(tasking.getFormId()).getMobileTaskingViewUrl());
        return vo;
    }
}
