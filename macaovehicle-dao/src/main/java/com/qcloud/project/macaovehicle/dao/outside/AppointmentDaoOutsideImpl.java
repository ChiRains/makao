package com.qcloud.project.macaovehicle.dao.outside;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.dao.AppointmentDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Component
public class AppointmentDaoOutsideImpl implements AppointmentDao {

    //TODO
    @Override
    public VehicleNetResult product(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber(), "13100000001", "粤CZS527");
        Map<String, String> map = new HashMap<String, String>();
        // 预约号
        map.put("appCode", approvalResults.getAppointmentNumber());
        // 车牌号
        map.put("licenseNo", "粤CZS527");
        // 签名
        map.put("sign", sign);
        //
        String str = HttpUtils.doPost("http://19.52.64.29:8081/iimgmt-webapp/ws/card/carApp/", map);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }

    //TODO
    @Override
    public VehicleNetResult comfirmTime(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber(), "13100000001", "粤CZS527");
        Map<String, String> map = new HashMap<String, String>();
        // 预约号
        map.put("appCode", approvalResults.getAppointmentNumber());
        // 车牌号
        map.put("licenseNo", "粤CZS527");
        // 签名
        map.put("sign", sign);
        //
        String str = HttpUtils.doPost("http://19.52.64.29:8081/iimgmt-webapp/ws/card/carApp/", map);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }
}
