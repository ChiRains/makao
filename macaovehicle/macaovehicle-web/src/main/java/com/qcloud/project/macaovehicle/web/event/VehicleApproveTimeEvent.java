package com.qcloud.project.macaovehicle.web.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.DateUtil;

@Component
public class VehicleApproveTimeEvent implements FormEvent {

    private Log   logger = LogFactory.getLog(getClass());

    @Autowired
    ISnakerClient snakerClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        Order order = snakerClient.query().getOrder(context.getProcessInstId());
        if (order == null) {
            context.addReturnResult("applyTime", DateUtil.date2String(context.getSystemUnifiedDate()));
        }
    }
}
