package com.qcloud.project.macaovehicle.service;

public interface ApprovalVehicleThirdPartyService {

    // 申请卡号
    boolean applyForCardNumber();

    // 发送备案
    boolean keepOnRecord();

    // 成功的预约
    boolean bookingOnSuccessKeepOnRecord();

    // 成功的预约
    boolean noticeOnFailureKeepOnRecord();
}
