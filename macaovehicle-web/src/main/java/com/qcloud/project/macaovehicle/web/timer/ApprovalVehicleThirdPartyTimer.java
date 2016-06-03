package com.qcloud.project.macaovehicle.web.timer;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.env.ProjectInfo;
import com.qcloud.pirates.core.timer.AbstractTimer;
import com.qcloud.pirates.core.timer.Period;
import com.qcloud.pirates.core.timer.SecondPeriod;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.service.ApprovalVehicleThirdPartyService;

@Component
public class ApprovalVehicleThirdPartyTimer extends AbstractTimer {

    @Autowired
    ApprovalVehicleThirdPartyService approvalVehicleThirdPartyService;

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public Period getPeriod() {

        return ProjectInfo.isDev() ? new SecondPeriod(3600) : new SecondPeriod(3600);
        // return ProjectInfo.isDev() ? new OncePeriod() : new SecondPeriod(300);
    }

    @Override
    public void start() {

//        logger.info("审批定时器开始,当前系统时间" + DateUtil.date2String(new Date()));
        // 申请卡号
//        approvalVehicleThirdPartyService.applyForCardNumber();
        // 备案
//        approvalVehicleThirdPartyService.keepOnRecord();
        // 备案成功预约
//        approvalVehicleThirdPartyService.bookingOnSuccessKeepOnRecord();
//         备案失败通知销卡
//        approvalVehicleThirdPartyService.noticeOnFailureKeepOnRecord();
//        logger.info("审批定时器结束,当前系统时间" + DateUtil.date2String(new Date()));
    }
}
