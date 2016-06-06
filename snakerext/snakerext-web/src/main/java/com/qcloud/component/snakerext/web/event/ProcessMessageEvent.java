package com.qcloud.component.snakerext.web.event;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.EventContext;
import com.qcloud.component.form.FormEvent;
import com.qcloud.component.organization.ClerkMessageType;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;

@Component
public class ProcessMessageEvent implements FormEvent {

    private Log                logger = LogFactory.getLog(getClass());

    @Autowired
    ISnakerClient              snakerClient;

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public void doEvent(FormEventType type, EventContext context) {

        logger.info("代码进来了...............**************************");
        QClerk clerk = organizationClient.getClerk(context.getClerkId());
        Task st = snakerClient.query().getTask(context.getWorkitemId());
        AssertUtil.assertNotNull(st, "流程任务不存在." + context.getWorkitemId());
        Order order = snakerClient.query().getOrder(st.getOrderId());
        AssertUtil.assertNotNull(order, "流程实例不存在." + st.getOrderId());
        organizationClient.sendMsg(Long.valueOf(order.getCreator()), ClerkMessageType.INSIDE_LETTER, "申请消息", "您的申请流程[" + context.getFormInstCode() + "]已处理！处理环节:" + st.getDisplayName() + " 处理人:" + clerk.getName() + " 处理时间:" + DateUtil.date2String(new Date()));
    }
}
