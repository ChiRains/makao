package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.FormClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.ApprovalVehicleThirdPartyService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Controller
@RequestMapping(value = DemoController.DIR)
public class DemoController {

    public static final String               DIR    = "/demo";

    @Autowired
    private ApprovalVehicleThirdPartyService approvalVehicleThirdPartyService;

    @Autowired
    private FileSDKClient                    fileSDKClient;

    @Autowired
    TaskingBorderService                     taskingBorderService;

    @Autowired
    TaskingCiqService                        taskingCiqService;

    @Autowired
    TaskingCustomsService                    taskingCustomsService;

    @Autowired
    private FormClient                       formClient;

    private Log                              logger = LogFactory.getLog(getClass());

    @Autowired
    private ApprovalResultsService           approvalResultsService;

    @Autowired
    private ProcessProgressService           processProgressService;

    @Autowired
    private UniqueCodeGenerator              uniqueCodeGenerator;

    /**
     * 收到车卡id，司机id
     * @return
     */
    @RequestMapping
    public FrontAjaxView carId() {

        List<TaskingCiq> ciqList = taskingCiqService.listAllByState(StatusType.DISABLE.getKey());
        for (TaskingCiq taskingCiq : ciqList) {
            taskingCiq.setStatus(StatusType.NOTDO.getKey());
            taskingCiqService.update(taskingCiq);
        }
        //
        List<TaskingCustoms> customsList = taskingCustomsService.listAllByState(StatusType.DISABLE.getKey());
        for (TaskingCustoms taskingCustoms : customsList) {
            taskingCustoms.setStatus(StatusType.NOTDO.getKey());
            taskingCustomsService.update(taskingCustoms);
        }
        //
        // List<TaskingBorder> taskingBorderList = taskingBorderService.listAllByState(StatusType.DISABLE.getKey());
        // for (TaskingBorder taskingBorder : taskingBorderList) {
        // taskingBorder.setStatus(StatusType.NOTDO.getKey());
        // taskingBorderService.update(taskingBorder);
        // }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("推送成功");
        return view;
    }

    /**
     * 备案结果(国检)
     * @return
     */
    @RequestMapping
    public FrontAjaxView ciqBeian() {

        List<TaskingCiq> ciqlist = taskingCiqService.listAllByState(StatusType.PASSED.getKey());
        for (TaskingCiq taskingCiq : ciqlist) {
            taskingCiq.setCiqStatus(StatusType.PASSED.getKey());
            taskingCiqService.update(taskingCiq);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("推送成功");
        return view;
    }

    /**
     * 备案结果(海关)
     * @return
     */
    @RequestMapping
    public FrontAjaxView customsBeian() {

        List<TaskingCustoms> customslist = taskingCustomsService.listAllByState(StatusType.PASSED.getKey());
        for (TaskingCustoms taskingCustoms : customslist) {
            taskingCustoms.setCustomsStatus(StatusType.PASSED.getKey());
            taskingCustomsService.update(taskingCustoms);
        }
        //
        // List<TaskingBorder> borderList = taskingBorderService.listAllByState(StatusType.DISABLE.getKey());
        // for (TaskingBorder taskingBorder : borderList) {
        // taskingBorder.setCustomsStatus(StatusType.PASSED.getKey());
        // taskingBorder.setCiqStatus(StatusType.PASSED.getKey());
        // taskingBorder.setBorderStatus(StatusType.PASSED.getKey());
        // taskingBorderService.update(taskingBorder);
        // }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("推送成功");
        return view;
    }

    /**
     * 排期完成之后预约装司机卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView notityCarReservation() {

        // 状态修改
        List<ApprovalResults> approvalResultsList = approvalResultsService.listByState(ApprovalResultState.RECORD_SUCCESS.getKey());
        List<Long> formInstanceIds = new ArrayList<Long>();
        for (ApprovalResults approvalResults : approvalResultsList) {
            TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(approvalResults.getFormInstanceId());
            if (!formInstanceIds.contains(approvalResults.getFormInstanceId())) {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setNotionReason("");
                processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.TZZK.getKey(), taskingBorder.getCreator(), messageEntity);
                formInstanceIds.add(approvalResults.getFormInstanceId());
            }
            approvalResults.setState(ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey());
            approvalResultsService.update(approvalResults);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知预装车卡成功.");
        logger.info("装卡预约通知结束（车卡）.=================================================");
        return view;
    }

    /**
     * 装卡完成后通知初装车卡
     * @return
     */
    @RequestMapping
    public FrontAjaxView notityCarInstallation() {

        // 状态修改
        List<ApprovalResults> approvalResultsList = approvalResultsService.listByState(ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey());
        for (ApprovalResults approvalResults : approvalResultsList) {
            processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.WANCHENG.getKey());
            approvalResults.setState(ApprovalResultState.SET_CARD_SUCCESS.getKey());
            approvalResultsService.update(approvalResults);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知预装车卡成功.");
        logger.info("装卡预约通知结束（车卡）.=================================================");
        return view;
    }

    public FrontAjaxView enterRecord(String dCardid, String vCardid, String date, String gate, String sign) {

        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知预装车卡成功.");
        logger.info("装卡预约通知结束（车卡）.=================================================");
        return view;
    }

    /** ============================================分隔线=======================================================   */
    @RequestMapping
    public FrontAjaxView postOnekDataEnter() {

        FrontAjaxView view = new FrontAjaxView();
        for(int i = 0; i < 1000; i++) {
            uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            Map<String, String> map = new HashMap<String, String>();
            String dCardid = uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            String vCardid = uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            String dateStr = DateUtil.date2String(new Date(), "yyyyMMddHHmmss");
            map.put("dCardid", dCardid);
            map.put("vCardid", vCardid);
            map.put("date", dateStr);
            map.put("gate", "hengqin");
            map.put("sign", SignUtils.sign("test", dCardid, vCardid, dateStr, "hengqin"));
            System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/onestop/enterRecord", map));
        }
        view.setMessage("推送一千条数据成功.");
        return view;
    }
    
    @RequestMapping
    public FrontAjaxView postOnekDataOut() {

        FrontAjaxView view = new FrontAjaxView();
        for(int i = 0; i < 1000; i++) {
            uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            Map<String, String> map = new HashMap<String, String>();
            String dCardid = uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            String vCardid = uniqueCodeGenerator.generate("pirates-form-indicators-code", new HashMap<String, String>());
            String dateStr = DateUtil.date2String(new Date(), "yyyyMMddHHmmss");
            map.put("dCardid", dCardid);
            map.put("vCardid", vCardid);
            map.put("date", dateStr);
            map.put("gate", "hengqin");
            map.put("sign", SignUtils.sign("test", dCardid, vCardid, dateStr, "hengqin"));
            System.out.println(HttpUtils.doPost("http://127.0.0.1:8081/onestop/outRecord", map));
        }
        view.setMessage("推送一千条数据成功.");
        return view;
    }
}
