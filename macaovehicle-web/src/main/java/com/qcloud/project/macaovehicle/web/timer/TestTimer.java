package com.qcloud.project.macaovehicle.web.timer;

import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.pirates.core.env.ProjectInfo;
import com.qcloud.pirates.core.timer.AbstractTimer;
import com.qcloud.pirates.core.timer.OncePeriod;
import com.qcloud.pirates.core.timer.Period;
import com.qcloud.pirates.core.timer.SecondPeriod;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;

@Component
public class TestTimer extends AbstractTimer {

    @Autowired
    ApprovalResultsService      approvalResultsService;

    @Autowired
    private UniqueCodeGenerator uniqueCodeGenerator;

    @Override
    public boolean isEnabled() {

        return true;
    }

    @Override
    public Period getPeriod() {

        // return ProjectInfo.isDev() ? new SecondPeriod(10) : new SecondPeriod(300);
        return ProjectInfo.isDev() ? new OncePeriod() : new SecondPeriod(300);
    }

    @Override
    public void start() {

//        for (int i = 0; i < 2; i++) {
//            logger.info("插一些测试数据" + DateUtil.date2String(new Date()));
//            ApprovalResults approvalResults1 = new ApprovalResults();
//            String appointmentNumber1 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
//            appointmentNumber1 += StringUtils.leftPad(String.valueOf(1), 2, "0");
//            approvalResults1.setAppointmentNumber(appointmentNumber1);
//            approvalResults1.setTime(new Date());
//            approvalResults1.setType(i % 2 == 1 ? 1 : 2);
//            approvalResultsService.add(approvalResults1);
//        }
        //
        // ApprovalResults approvalResults2 = new ApprovalResults();
        // String appointmentNumber2 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
        // appointmentNumber2 += StringUtils.leftPad(String.valueOf(1), 2, "0");
        // approvalResults2.setAppointmentNumber(appointmentNumber2);
        // approvalResults2.setTime(new Date());
        // approvalResults2.setType(2);
        // approvalResultsService.add(approvalResults2);
        // //
        // ApprovalResults approvalResults3 = new ApprovalResults();
        // String appointmentNumber3 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
        // appointmentNumber3 += StringUtils.leftPad(String.valueOf(1), 2, "0");
        // approvalResults3.setAppointmentNumber(appointmentNumber3);
        // approvalResults3.setTime(new Date());
        // approvalResults3.setType(1);
        // approvalResultsService.add(approvalResults3);
        // approvalResults3.setState(ApprovalResultState.TAKE_CARD.getKey());
        // approvalResults3.setCardNumber("粤CZS527");
        // approvalResultsService.update(approvalResults3);
        // //
        // ApprovalResults approvalResults4 = new ApprovalResults();
        // String appointmentNumber4 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
        // appointmentNumber4 += StringUtils.leftPad(String.valueOf(1), 2, "0");
        // approvalResults4.setAppointmentNumber(appointmentNumber4);
        // approvalResults4.setTime(new Date());
        // approvalResults4.setType(2);
        // approvalResultsService.add(approvalResults4);
        // approvalResults4.setState(ApprovalResultState.RECORD_SUCCESS.getKey());
        // approvalResults4.setCardNumber("粤CZS527");
        // approvalResultsService.update(approvalResults4);
        // //
        // ApprovalResults approvalResults5 = new ApprovalResults();
        // String appointmentNumber5 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
        // appointmentNumber5 += StringUtils.leftPad(String.valueOf(1), 2, "0");
        // approvalResults5.setAppointmentNumber(appointmentNumber5);
        // approvalResults5.setTime(new Date());
        // approvalResults5.setType(2);
        // approvalResultsService.add(approvalResults5);
        // approvalResults5.setState(ApprovalResultState.RECORD_FAILED.getKey());
        // approvalResults5.setCardNumber("粤CZS527");
        // approvalResultsService.update(approvalResults5);
        // //
        // ApprovalResults approvalResults6 = new ApprovalResults();
        // String appointmentNumber6 = uniqueCodeGenerator.generate("pirates-form-inst-code", new HashMap<String, String>());
        // appointmentNumber6 += StringUtils.leftPad(String.valueOf(1), 2, "0");
        // approvalResults6.setAppointmentNumber(appointmentNumber6);
        // approvalResults6.setTime(new Date());
        // approvalResults6.setType(2);
        // approvalResultsService.add(approvalResults6);
        //
        logger.info("插一些测试数据 end" + DateUtil.date2String(new Date()));
    }
}
