package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QFormInstance;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.web.handler.TaskingCiqHandler;
import com.qcloud.project.macaovehicle.web.vo.TaskingCiqVO;

@Controller
@RequestMapping(value = TaskingCiqController.DIR)
public class TaskingCiqController {

    public static final String     DIR = "/taskingCiq";

    @Autowired
    private TaskingCiqService      taskingCiqService;

    @Autowired
    private TaskingCiqHandler      taskingCiqHandler;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private FormClient             formClient;

    @Autowired
    private OrganizationClient     organizationClient;

    @Autowired
    private ProcessProgressService processProgressService;

    /** 
     *  未处理
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView list(TaskingCiqQuery query, Integer pageNum, Integer pageSize, String type) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingCiq> page = taskingCiqService.page(query, start, PAGE_SIZE);
        List<TaskingCiqVO> volist = taskingCiqHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("list", volist);
        return view;
    }

    /**
     *  已处理
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listed(TaskingCiqQuery query, Integer pageNum, Integer pageSize, String type) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        query.setStatusIgnore(StatusType.NOTDO.getKey());
        query.setType(type);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingCiq> page = taskingCiqService.page(query, start, PAGE_SIZE);
        List<TaskingCiqVO> volist = taskingCiqHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("list", volist);
        return view;
    }

    /**
     * 确定备案
     * @param request
     * @param formInstCode
     * @param state
     * @return
     */
    @RequestMapping
    public AceAjaxView doTasking(HttpServletRequest request, String formInstCode, int state, String reason) {

        if (StatusType.PASSED.getKey() != state && StatusType.REJECT.getKey() != state) {
            throw new MacaovehicleException("类型state非法." + state);
        }
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        QClerk clerk = clerkHelper.getClerkModel(request);
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingCiq taskingCiq = taskingCiqService.getByFormInstanceId(qFormInstance.getId());
        taskingCiq.setStatus(state);
        if (state == StatusType.REJECT.getKey()) {
            AssertUtil.assertNotNull(reason, "拒绝原因不能为空.");
            taskingCiq.setReason(reason);
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setNotionReason(reason);
            processProgressService.changeState(qFormInstance.getId(), ApplyType.REJECT.getKey(), ProgressState.BEIAN.getKey(), taskingCiq.getCreator(), messageEntity);
        }
        taskingCiq.setRecordTime(new Date());
        taskingCiq.setOperatorClerkId(clerk.getId());
        // taskingCiq.setCiqStatus(state);
        taskingCiqService.update(taskingCiq);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("状态处理成功.");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView get(String formInstCode) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingCiq taskingCiq = taskingCiqService.getByFormInstanceId(qFormInstance.getId());
        Map<String, Object> taskingCiqMap = new HashMap<String, Object>();
        taskingCiqMap.put("status", taskingCiq.getStatus());
        taskingCiqMap.put("ciqStatus", taskingCiq.getCiqStatus());
        taskingCiqMap.put("recordTime", DateUtil.date2String(taskingCiq.getRecordTime()));
        taskingCiqMap.put("operator", organizationClient.getClerk(taskingCiq.getOperatorClerkId()).getName());
        taskingCiqMap.put("reason", taskingCiq.getReason());
        aceAjaxView.addObject("taskingCiq", taskingCiqMap);
        aceAjaxView.setMessage("状态查看成功.");
        return aceAjaxView;
    }
}
