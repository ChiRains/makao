package com.qcloud.project.macaovehicle.web.event;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;

@Component
public class ProcessProgressEvent implements FormEvent {

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    private ISnakerClient          snakerClient;

    @Autowired
    private ProcessProgressService processProgressService;

    @Autowired
    private DriverVehicleService   driverVehicleService;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("代码进来了...............**************************");
        String formInstCode = context.getFormInstCode();
        logger.info("formInstCode*****  " + formInstCode);
        Task task = snakerClient.query().getTask(context.getWorkitemId());
        AssertUtil.assertNotNull(task, "流程任务不存在" + context.getWorkitemId());
        String activity = task.getDisplayName();
        boolean pass = context.isPass("qc_notion_cmcpre", "qc_notion_cmc", "qc_notion_police", "qc_notion_carInspection");
        String dateStr = (String) context.getParameter("applyTime");
        Task st = snakerClient.query().getTask(context.getWorkitemId());
        AssertUtil.assertNotNull(st, "流程任务不存在." + context.getWorkitemId());
        Order order = snakerClient.query().getOrder(st.getOrderId());
        AssertUtil.assertNotNull(order, "流程实例不存在." + st.getOrderId());
        logger.info(formInstCode + " " + order.getCreator() + " " + activity + " " + pass + " " + dateStr);
        // 更新流程状态
        Integer progressState = (Integer) context.getParameter("progressState");
        Integer progressType = (Integer) context.getParameter("progressType");
        if (!StringUtils.isEmpty(progressState)) {
            // 添加车辆驾驶员关系
            Long carOwnerId = (Long) context.getParameter("carOwnerId");
            if (progressState == ProgressState.SHENGQIN.getKey()) {
                String vehicleId = (String) context.getParameter("vehicle");
                Object driversObj = context.getParameter("drivers");
                if (driversObj == null) {
                    return;
                }
                if (!StringUtils.isEmpty(driversObj.toString())) {
                    String[] strs = driversObj.toString().split(",");
                    Date curDate = new Date();
                    for (int index = 0; index < strs.length; index++) {
                        String str = strs[index];
                        DriverVehicle driverVehicle = new DriverVehicle();
                        driverVehicle.setFormInstCode(formInstCode);
                        driverVehicle.setVehicleId(Long.valueOf(vehicleId));
                        driverVehicle.setDriverId(Long.valueOf(str));
                        driverVehicle.setCreateDate(curDate);
                        driverVehicle.setCarOwnerId(carOwnerId);
                        driverVehicle.setFormInstanceId(context.getFormInstId());
                        driverVehicle.setType(progressType);
                        Object temporaryplate = context.getParameter("vehicle[0].temporaryplate");
                        Object indicators = context.getParameter("vehicle[0].indicators");
                        Object indicatorsTime = context.getParameter("vehicle[0].indicatorsTime");
                        // 针对添加驾驶员这一个情况
                        if (temporaryplate != null) {
                            driverVehicle.setTemporaryPlate((String) temporaryplate);
                        }
                        if (indicators != null) {
                            driverVehicle.setIndicatorsNo((String) indicators);
                        }
                        if (indicatorsTime != null) {
                            driverVehicle.setIndicatorsTime(DateUtil.str2Date((String) indicatorsTime));
                        }
                        driverVehicleService.add(driverVehicle);
                    }
                }
            }
            ProcessProgress processProgress = processProgressService.getMaxByFormInstCode(formInstCode);
            int newState = progressState;
            int oldState = processProgress != null ? processProgress.getProgressState() : 0;
            // TODO 限制规则后面加
            // if (checkState(oldState, newState)) {
            if (processProgress != null) {
                String notionReason = "";
                if (!pass) {
                    String[] strs = new String[] { "qc_notion_cmcpre", "qc_notion_cmc", "qc_notion_police", "qc_notion_carInspection", "qc_notion_policepilot", "qc_notion_xqpolicepilot", "qc_notion_gwhyjb", "qc_notion_jjyjzb"};
                    for (String str : strs) {
                        if (context.getParameter(str + "[0].content") != null) {
                            notionReason = (String) context.getParameter(str + "[0].content");
                        }
                    }
                }
                MessageEntity messageEntity = new MessageEntity();
                messageEntity.setNotionReason(notionReason);
                processProgressService.changeState(context.getFormInstId(), pass ? ApplyType.PASS.getKey() : ApplyType.REJECT.getKey(), newState, Long.valueOf(order.getCreator()), messageEntity);
            } else {
                processProgress = new ProcessProgress();
                processProgress.setActivity(activity);
                processProgress.setCarOwnerId(carOwnerId);
                processProgress.setDateStr(dateStr);
                processProgress.setFormInstCode(formInstCode);
                processProgress.setState(pass ? ApplyType.PASS.getKey() : ApplyType.REJECT.getKey());
                processProgress.setProgressState(newState);
                processProgress.setType(progressType);
                processProgress.setFormInstanceId(context.getFormInstId());
                processProgress.setVehicleId(Long.valueOf((String) context.getParameter("vehicle")));
                processProgressService.add(processProgress);
            }
            // }
        }
    }

    private boolean checkState(int oldState, int newState) {

        boolean isOK = false;
        for (ProgressState progressState : ProgressState.values()) {
            if (progressState.getKey() == newState && oldState + 1 == newState) {
                isOK = true;
            }
        }
        return isOK;
    }
}
