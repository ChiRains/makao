package com.qcloud.project.macaovehicle.web.timer;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.env.ProjectInfo;
import com.qcloud.pirates.core.timer.AbstractTimer;
import com.qcloud.pirates.core.timer.Period;
import com.qcloud.pirates.core.timer.SecondPeriod;
import com.qcloud.project.macaovehicle.service.AbnormalService;

@Component
public class ApprovalResutlTimer extends AbstractTimer {

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    private AbnormalService        abnormalService;

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public Period getPeriod() {

         return ProjectInfo.isDev() ? new SecondPeriod(5) : new SecondPeriod(5);
    }

    @Override
    public void start() {

        // String picStrs[]={"/file/get.do?uid=EB1DD5D8901F4152AC82991E9C6658D7.jpg","/file/get.do?uid=3CC16508DECE425C80D85AEF79479BED.jpg",
        // "/file/get.do?uid=5F4419DCFFB94E308E3F3C4B76A43680.jpg","/file/get.do?uid=EB1DD5D8901F4152AC82991E9C6658D7.jpg",
        // "/file/get.do?uid=AA624B51D8494F858A365755F83BA989.jpg"};
        // logger.info("添加异常记录开始 ...");
        // // int day=(int)new Date().getTime()%365;
        // int day=0;
        // Date today=DateUtil.addDate(new Date(), -day);
        // Abnormal abnormal = new Abnormal();
        // abnormal.setMonitorId("1001");
        // abnormal.setMonitorName("第一检测");
        // abnormal.setHappenedTime(DateUtil.date2String(today));
        // abnormal.setCarCardId("10001");
        // abnormal.setDriverCardId("90003");
        // abnormal.setRfPlate(StringUtil.uuid().substring(0,5));
        // abnormal.setOcrPlate(abnormal.getRfPlate());
        // abnormal.setEventType("1");
        // int index=(int)new Date().getTime()%5;
        // abnormal.setPicture(picStrs[index]);
        // abnormal.setAlarmNum(1);
        // abnormalService.add(abnormal);
        // logger.info("添加异常记录结束 ...");
        // logger.info("添加通关记录开始 ...");
        // ClearanceRecord record=new ClearanceRecord();
        // record.setCarCardNumber("10001");
        // record.setDriverCardNumber("90001");
        // record.setTime(DateUtil.date2String(today));
        // record.setChannel("第"+new Date().getTime()%3+1+"通道");
        // record.setType((int)new Date().getTime()%2+1);
        // clearanceRecordService.add(record);
        // logger.info("添加通关记录结束 ...");
    }
}
