package com.qcloud.project.macaovehicle.web.controller.outside;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.util.SignUtils;

// 提供给物联网的接口
@Controller
@RequestMapping(value = AppointmentController.DIR)
public class AppointmentController {

    public static final String     DIR    = "/appointment";

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    private ApprovalResultsService approvalResultsService;

    @Autowired
    private ProcessProgressService processProgressService;

    @Autowired
    private TaskingBorderService   taskingBorderService;

    /**
     * 排期完成之后预约装车卡
     * @param appCode
     * @param toFixAt
     * @param toFixDate
     * @param sign
     * @return
     */
    @RequestMapping(value = "/notityCarReservation", method = RequestMethod.POST)
    public FrontAjaxView notityCarReservation(String appCode, String toFixAt, String toFixDate, String sign) {

        logger.info("装卡预约通知开始（车卡）.=================================================");
        logger.info("预约号:" + appCode);
        logger.info("装卡地点:" + toFixAt);
        logger.info("装卡时间:" + toFixDate);
        if (!SignUtils.checkSign("test", sign, appCode, toFixAt, toFixDate)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        Date date = DateUtil.str2Date(toFixDate, "yyyyMMddHHMMSS");
        logger.info("时间:" + DateUtil.date2String(date, DateUtil.FORMAT_STRING));
        ApprovalResults approvalResults = approvalResultsService.getResultByAppointmentNumber(appCode);
        AssertUtil.assertNotNull(approvalResults, "预约号对应记录不存在");
        AssertUtil.assertTrue(approvalResults.getType() == ApprovalCardType.CAR.getKey(), "通知必须是车卡" + appCode);
        AssertUtil.assertTrue(approvalResults.getState() == ApprovalResultState.APPOINTMENT.getKey(), "预约号对应记录状态不正确");
        approvalResults.setState(ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey());
        // TODO 结果表需要添加两个字段,安装时间 安装地点
        approvalResultsService.update(approvalResults);
        // 状态修改
        if (approvalResultsService.checkAllReceive(approvalResults.getFormInstanceId(), ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS)) {
            List<Long> formInstanceIds = new ArrayList<Long>();
            TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(approvalResults.getFormInstanceId());
            if (!formInstanceIds.contains(approvalResults.getFormInstanceId())) {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setTime(DateUtil.date2String(date, DateUtil.FORMAT_STRING));
                messageEntity.setAddress(toFixAt);
                processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.TZZK.getKey(), taskingBorder.getCreator(), messageEntity);
                formInstanceIds.add(approvalResults.getFormInstanceId());
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知预装车卡成功.");
        logger.info("装卡预约通知结束（车卡）.=================================================");
        return view;
    }

    /**
     * 排期完成之后预约装司机卡
     * @param appCode
     * @param toFixAt
     * @param toFixDate
     * @param sign
     * @return
     */
    @RequestMapping(value = "/notityDriverReservation", method = RequestMethod.POST)
    public FrontAjaxView notityDriverReservation(String appCode, String toFixAt, String toFixDate, String sign) {

        logger.info("装卡预约通知开始（司机卡）.=================================================");
        logger.info("预约号:" + appCode);
        logger.info("装卡地点:" + toFixAt);
        logger.info("装卡时间:" + toFixDate);
        if (!SignUtils.checkSign("test", sign, appCode, toFixAt, toFixDate)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        Date date = DateUtil.str2Date(toFixDate, "yyyyMMddHHMMSS");
        logger.info("时间:" + DateUtil.date2String(date, DateUtil.FORMAT_STRING));
        ApprovalResults approvalResults = approvalResultsService.getResultByAppointmentNumber(appCode);
        AssertUtil.assertNotNull(approvalResults, "预约号对应记录不存在");
        AssertUtil.assertTrue(approvalResults.getType() == ApprovalCardType.DRIVER.getKey(), "通知必须是司机卡" + appCode);
        AssertUtil.assertTrue(approvalResults.getState() == ApprovalResultState.APPOINTMENT.getKey(), "预约号对应记录状态不正确");
        approvalResults.setState(ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey());
        // TODO 结果表需要添加两个字段,安装时间 安装地点
        approvalResultsService.update(approvalResults);
        // 状态修改
        if (approvalResultsService.checkAllReceive(approvalResults.getFormInstanceId(), ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS)) {
            List<Long> formInstanceIds = new ArrayList<Long>();
            TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(approvalResults.getFormInstanceId());
            if (!formInstanceIds.contains(approvalResults.getFormInstanceId())) {
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setTime(DateUtil.date2String(date, DateUtil.FORMAT_STRING));
                messageEntity.setAddress(toFixAt);
                processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.TZZK.getKey(), taskingBorder.getCreator(), messageEntity);
                formInstanceIds.add(approvalResults.getFormInstanceId());
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知预装司机卡成功.");
        logger.info("装卡预约通知结束（司机卡）.=================================================");
        return view;
    }

    // @RequestMapping(value = "/notityCarFirstInstallation/{appointmentNumber}/{carId}/{date}", method = RequestMethod.POST)
    // public FrontAjaxView notityCarFirstInstallation(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("cardId") String carId, @PathVariable("date") String date) {
    //
    // logger.info("装卡初装成功通知开始（车卡）.=================================================");
    // logger.info("预约号:" + appointmentNumber);
    // logger.info("卡号:" + carId);
    // logger.info("装卡时间:" + date);
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("通知初装车卡成功.");
    // logger.info("装卡初装成功通知结束（车卡）.=================================================");
    // return view;
    // }
    //
    // @RequestMapping(value = "/notityDriverFirstInstallation/{appointmentNumber}/{carId}/{date}", method = RequestMethod.POST)
    // public FrontAjaxView notityDriverFirstInstallation(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("carId") String carId, @PathVariable("date") String date) {
    //
    // logger.info("装卡初装成功通知开始（司机卡）.=================================================");
    // logger.info("预约号:" + appointmentNumber);
    // logger.info("卡号:" + carId);
    // logger.info("装卡时间:" + date);
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("通知初装司机卡成功.");
    // logger.info("装卡初装成功通知结束（司机卡）.=================================================");
    // return view;
    // }
    /**
     * 装卡完成后通知初装车卡
     * @param appointmentNumber
     * @param carId
     * @param date
     * @param sign
     * @return
     */
    @RequestMapping(value = "/notityCarInstallation/{appointmentNumber}/{carId}/{date}/{sign}", method = RequestMethod.POST)
    public FrontAjaxView notityCarInstallation(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("carId") String carId, @PathVariable("date") String date, @PathVariable("sign") String sign) {

        logger.info("装卡初装成功通知开始（车卡）.=================================================");
        logger.info("预约号:" + appointmentNumber);
        logger.info("卡号:" + carId);
        logger.info("装卡时间:" + date);
        if (!SignUtils.checkSign("test", sign, appointmentNumber, carId, date)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        Date d = DateUtil.str2Date(date, "yyyyMMddHHMMSS");
        logger.info("时间:" + DateUtil.date2String(d, DateUtil.FORMAT_STRING));
        ApprovalResults approvalResults = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        AssertUtil.assertNotNull(approvalResults, "预约号对应记录不存在");
        AssertUtil.assertTrue(approvalResults.getType() == ApprovalCardType.CAR.getKey(), "通知必须是车卡" + appointmentNumber);
        AssertUtil.assertTrue(approvalResults.getState() == ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey(), "预约号对应记录状态不正确");
        approvalResults.setState(ApprovalResultState.SET_CARD_SUCCESS.getKey());
        // TODO 结果表需要添加两个字段,最终安装成功的卡号，时间
        approvalResultsService.update(approvalResults);
        // 状态修改
        if (approvalResultsService.checkAllReceive(approvalResults.getFormInstanceId(), ApprovalResultState.SET_CARD_SUCCESS)) {
            processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.WANCHENG.getKey());
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知装卡成功.");
        logger.info("装卡初装成功通知结束（车卡）.=================================================");
        return view;
    }

    /**
     * 装卡完成后通知初司机卡
     * @param appointmentNumber
     * @param carId
     * @param date
     * @param sign
     * @return
     */
    @RequestMapping(value = "/notityDriverInstallation/{appointmentNumber}/{carId}/{date}/{sign}", method = RequestMethod.POST)
    public FrontAjaxView notityDriverInstallation(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("carId") String carId, @PathVariable("date") String date, @PathVariable("sign") String sign) {

        logger.info("装卡成功通知开始（司机卡）.=================================================");
        logger.info("预约号:" + appointmentNumber);
        logger.info("卡号:" + carId);
        logger.info("装卡时间:" + date);
        if (!SignUtils.checkSign("test", sign, appointmentNumber, carId, date)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        Date d = DateUtil.str2Date(date, "yyyyMMddHHMMSS");
        logger.info("时间:" + DateUtil.date2String(d, DateUtil.FORMAT_STRING));
        ApprovalResults approvalResults = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        AssertUtil.assertNotNull(approvalResults, "预约号对应记录不存在");
        AssertUtil.assertTrue(approvalResults.getType() == ApprovalCardType.DRIVER.getKey(), "通知必须是司机卡" + appointmentNumber);
        AssertUtil.assertTrue(approvalResults.getState() == ApprovalResultState.APPOINTMENT_SET_CARD_SUCCESS.getKey(), "预约号对应记录状态不正确");
        approvalResults.setState(ApprovalResultState.SET_CARD_SUCCESS.getKey());
        // TODO 结果表需要添加两个字段,最终安装成功的卡号，时间
        approvalResultsService.update(approvalResults);
        // 状态修改
        if (approvalResultsService.checkAllReceive(approvalResults.getFormInstanceId(), ApprovalResultState.SET_CARD_SUCCESS)) {
            processProgressService.changeState(approvalResults.getFormInstanceId(), ApplyType.PASS.getKey(), ProgressState.WANCHENG.getKey());
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("通知装卡成功.");
        logger.info("装卡成功通知结束（司机卡）.=================================================");
        return view;
    }
}
