package com.qcloud.project.macaovehicle.web.controller.outside;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Controller
@RequestMapping(value = CardController.DIR)
public class CardController {

    public static final String     DIR    = "/card";

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    private ApprovalResultsService approvalResultsService;

    @Autowired
    private TaskingBorderService   taskingBorderService;

    @Autowired
    private TaskingCiqService      taskingCiqService;

    @Autowired
    private TaskingCustomsService  taskingCustomsService;

    @Autowired
    private TaskedService          taskedService;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    /**
     *  收到司机卡id
     * @param appointmentNumber
     * @param cardNumber
     * @param sign
     * @return
     */
    @RequestMapping(value = "/sendDriverCard/{appointmentNumber}/{cardNumber}/{sign}", method = RequestMethod.POST)
    public FrontAjaxView sendDriverCard(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("cardNumber") String cardNumber, @PathVariable("sign") String sign) {

        logger.info("预约号 " + appointmentNumber);
        logger.info("卡号 " + cardNumber);
        logger.info("签名 " + sign);
        if (!SignUtils.checkSign("test", sign, appointmentNumber, cardNumber)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        logger.info("车联网回调发卡开始 ================");
        ApprovalResults results = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        AssertUtil.assertNotNull(results, "预约号对应记录不存在");
        AssertUtil.assertTrue(results.getState() == ApprovalResultState.APPLY_FOR_CARDNUMBER.getKey(), "预约号对应记录状态不正确");
        results.setCardNumber(cardNumber);
        results.setState(ApprovalResultState.TAKE_CARD.getKey());
        approvalResultsService.update(results);
        // 判断有没有收到卡id
        long formInstanceId = results.getFormInstanceId();
        if (approvalResultsService.checkAllReceive(formInstanceId, ApprovalResultState.TAKE_CARD)) {
            // 边检
            taskingBorderService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 国检
            taskingCiqService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 海关
            taskingCustomsService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 添加司机卡id,根据并发量，加个jj锁
            List<DriverVehicle> list = driverVehicleService.getListByFormInstanceId(formInstanceId);
            for (DriverVehicle driverVehicle : list) {
                driverVehicle.setDriverIc(cardNumber);
                driverVehicleService.update(driverVehicle);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("收到司机卡id成功");
        return view;
    }

    /**
     *  收到车卡id
     * @param appointmentNumber
     * @param cardNumber
     * @param sign
     * @return
     */
    @RequestMapping(value = "/sendCarCard/{appointmentNumber}/{cardNumber}/{sign}", method = RequestMethod.POST)
    public FrontAjaxView sendCarCard(@PathVariable("appointmentNumber") String appointmentNumber, @PathVariable("cardNumber") String cardNumber, @PathVariable("sign") String sign) {

        logger.info("预约号 " + appointmentNumber);
        logger.info("卡号 " + cardNumber);
        logger.info("签名 " + sign);
        if (!SignUtils.checkSign("test", sign, appointmentNumber, cardNumber)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            return view;
        }
        logger.info("车联网回调发卡开始 ================");
        ApprovalResults results = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        AssertUtil.assertNotNull(results, "预约号对应记录不存在");
        AssertUtil.assertTrue(results.getState() == ApprovalResultState.APPLY_FOR_CARDNUMBER.getKey(), "预约号对应记录状态不正确");
        results.setCardNumber(cardNumber);
        results.setState(ApprovalResultState.TAKE_CARD.getKey());
        approvalResultsService.update(results);
        // 判断有没有收到卡id
        long formInstanceId = results.getFormInstanceId();
        // 状态修改
        if (approvalResultsService.checkAllReceive(formInstanceId, ApprovalResultState.TAKE_CARD)) {
            // 边检
            taskingBorderService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 国检
            taskingCiqService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 海关
            taskingCustomsService.changeStatus(formInstanceId, StatusType.NOTDO);
            // 添加司机卡id,根据并发量，加个jj锁
            List<DriverVehicle> list = driverVehicleService.getListByFormInstanceId(formInstanceId);
            for (DriverVehicle driverVehicle : list) {
                driverVehicle.setRic(cardNumber);
                driverVehicleService.update(driverVehicle);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("收到车卡id成功.");
        return view;
    }
}
