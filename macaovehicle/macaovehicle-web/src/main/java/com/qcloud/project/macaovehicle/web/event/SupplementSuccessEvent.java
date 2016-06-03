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
import com.qcloud.component.snakerext.ExecutorVariableCalculator;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;

@Component
public class SupplementSuccessEvent implements FormEvent, ExecutorVariableCalculator {

    private Log            logger = LogFactory.getLog(getClass());

    @Autowired
    ApprovalResultsService approvalResultsService;

    @Autowired
    FormClient             formClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("申请成功.");
        // TODO 这里要判断最后一步,并且是结束的
        Boolean end = (Boolean) context.getParameter("Process-End-Activity");
        if (end != null && end) {
            boolean pass = context.isPass("qc_notion_xqpolicepilot");
            logger.info("审批结果." + pass);
            if (!pass) {
                return;
            }
            logger.info("审批通过,生成预约号.");
        }
        logger.info(type);
        logger.info(context.getParameterMap());
    }

    @Override
    public Map<String, Object> calculate(Map<String, Object> map) {

        return null;
    }
}
