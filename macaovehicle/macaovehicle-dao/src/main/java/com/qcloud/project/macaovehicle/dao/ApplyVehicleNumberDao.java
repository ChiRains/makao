package com.qcloud.project.macaovehicle.dao;

import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;

public interface ApplyVehicleNumberDao {

    VehicleNetResult applyVehicleNumber(ApprovalResults approvalResults);
}
