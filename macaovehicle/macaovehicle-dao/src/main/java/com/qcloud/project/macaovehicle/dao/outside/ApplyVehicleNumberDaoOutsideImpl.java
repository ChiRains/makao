package com.qcloud.project.macaovehicle.dao.outside;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.dao.ApplyVehicleNumberDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Repository
public class ApplyVehicleNumberDaoOutsideImpl implements ApplyVehicleNumberDao {

    private Log logger = LogFactory.getLog(getClass());

    @Override
    public VehicleNetResult applyVehicleNumber(ApprovalResults approvalResults) {

        if (ApprovalCardType.CAR.getKey() == approvalResults.getType()) {
            return applyCarNumber(approvalResults);
        } else if (ApprovalCardType.DRIVER.getKey() == approvalResults.getType()) {
            return applyDriverNumber(approvalResults);
        } else {
            logger.info("预约号类型不对." + approvalResults.getAppointmentNumber());
            return null;
        }
    }

    /**
     * 申请车辆卡ID
     * @param approvalResults
     * @return
     */
    private VehicleNetResult applyCarNumber(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber());
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/carIdApp/" + approvalResults.getAppointmentNumber() + "/" + sign, new HashMap<String, String>());
        System.out.println(str);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }

    /**
     * 申请驾驶员ID
     * @param approvalResults
     * @return
     */
    private VehicleNetResult applyDriverNumber(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber());
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/driverIdApp/" + approvalResults.getAppointmentNumber() + "/" + sign, new HashMap<String, String>());
        System.out.println(str);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }
}
