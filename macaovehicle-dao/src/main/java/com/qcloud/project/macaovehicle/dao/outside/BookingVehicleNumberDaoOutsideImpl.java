package com.qcloud.project.macaovehicle.dao.outside;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.dao.BookingVehicleNumberDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Repository
public class BookingVehicleNumberDaoOutsideImpl implements BookingVehicleNumberDao {

    private Log logger = LogFactory.getLog(getClass());

    @Override
    public VehicleNetResult booking(ApprovalResults approvalResults) {

        if (ApprovalCardType.CAR.getKey() == approvalResults.getType()) {
            return bookingCar(approvalResults);
        } else if (ApprovalCardType.DRIVER.getKey() == approvalResults.getType()) {
            return bookingDriver(approvalResults);
        } else {
            logger.info("预约号类型不对." + approvalResults.getAppointmentNumber());
            return null;
        }
    }

    /**
     * 备案完成，触发排期预装车卡(排期)
     * @param approvalResults
     * @return
     */
    private VehicleNetResult bookingCar(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber(), "UU6JA69691D713820", "张三", "13100000001", "MC-88-88");
        Map<String, String> map = new HashMap<String, String>();
        // 预约号
        map.put("appCode", approvalResults.getAppointmentNumber());
        // 车架号 ,车联网说 必须十七位的
        map.put("vin", "UU6JA69691D713820");
        // 车主姓名
        map.put("owner", "张三");
        // 车主手机
        map.put("tel", "13100000001");
        // 车牌号
        map.put("licenseNo", "MC-88-88");
        // 签名
        map.put("sign", sign);
        //
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/carApp/", map);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }

    /**
     * 备案完成，触发排期预装司机卡(排期)
     * @param approvalResults
     * @return
     */
    private VehicleNetResult bookingDriver(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber(), "李小小", "450881198605783654", "13100000005");
        Map<String, String> map = new HashMap<String, String>();
        // 预约号
        map.put("appCode", approvalResults.getAppointmentNumber());
        // 司机姓名
        map.put("driverName", "李小小");
        // 司机身份证号
        map.put("idNo", "450881198605783654");
        // 司机手机
        map.put("tel", "13100000005");
        // 签名
        map.put("sign", sign);
        //
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/driverApp/", map);
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }
}
