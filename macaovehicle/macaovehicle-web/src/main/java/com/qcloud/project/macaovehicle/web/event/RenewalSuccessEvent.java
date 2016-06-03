package com.qcloud.project.macaovehicle.web.event;

import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.form.QMainFormData;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;

@Component
public class RenewalSuccessEvent implements FormEvent {

    private Log            logger = LogFactory.getLog(getClass());

    @Autowired
    ApprovalResultsService approvalResultsService;

    @Autowired
    FormClient             formClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("申请成功.");
        String code = context.getFormInstCode();
        QMainFormData mainFormData = formClient.get(context.getFormInstId());
        Map<String, Object> map = mainFormData.toMap();
        // TODO 这里要判断最后一步,并且是结束的
        Boolean end = (Boolean) context.getParameter("Process-End-Activity");
        if (end != null && end) {
            boolean pass = context.isPass("qc_notion_gwhyjb", "qc_notion_jjyjzb");
            logger.info("审批结果." + pass);
            if (!pass) {
                return;
            }
            logger.info("审批通过,生成预约号.");
            int number = 1;
            Integer driverNumber = (Integer) map.get("driver.qc_inner_number");
            for (int index = 0; index < driverNumber; index++) {
                ApprovalResults approvalResults = new ApprovalResults();
                approvalResults.setAppointmentNumber(code.substring(0, code.length() - 1) + StringUtils.leftPad(String.valueOf(number), 2, "0"));
                approvalResults.setCardNumber("");
                approvalResults.setFormInstanceId(context.getFormInstId());
                approvalResults.setFormInstCode(code);
                approvalResults.setType(ApprovalCardType.DRIVER.getKey());
                Long id = (Long) map.get("driver[" + index + "].driverId");
                approvalResults.setDriverId(id);
                approvalResultsService.add(approvalResults);
                number++;
            }
        }
        logger.info(type);
        logger.info(context.getParameterMap());
    }
}
