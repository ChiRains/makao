package com.qcloud.project.macaovehicle.dao;

import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;

/**
 * 交通物联网对外访问接口
 */
public interface AppointmentDao {

    /**
     * 产生车辆卡ID和驾驶员ID
     * @param approvalResults
     * @return
     */
    VehicleNetResult product(ApprovalResults approvalResults);

    /**
     * 确定排期时间
     * @param approvalResults
     * @return
     */
    VehicleNetResult comfirmTime(ApprovalResults approvalResults);
}
