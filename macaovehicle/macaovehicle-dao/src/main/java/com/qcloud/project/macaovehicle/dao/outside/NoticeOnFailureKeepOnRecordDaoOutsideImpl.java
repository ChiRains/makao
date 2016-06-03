package com.qcloud.project.macaovehicle.dao.outside;

import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.EncryptUtil;
import com.qcloud.pirates.util.HttpUtils;
import com.qcloud.project.macaovehicle.dao.NoticeOnFailureKeepOnRecordDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.VehicleNetResult;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Repository
public class NoticeOnFailureKeepOnRecordDaoOutsideImpl implements NoticeOnFailureKeepOnRecordDao {

    private Log logger = LogFactory.getLog(getClass());

    @Override
    public VehicleNetResult noticeOnFailureKeepOnRecord(ApprovalResults approvalResults) {

        if (ApprovalCardType.CAR.getKey() == approvalResults.getType()) {
            return noticeCarOnFailureKeepOnRecord(approvalResults);
        } else if (ApprovalCardType.DRIVER.getKey() == approvalResults.getType()) {
            return noticeDriverOnFailureKeepOnRecord(approvalResults);
        } else {
            logger.info("预约号类型不对." + approvalResults.getAppointmentNumber());
            return null;
        }
    }

    private VehicleNetResult noticeCarOnFailureKeepOnRecord(ApprovalResults approvalResults) {

        String sign = SignUtils.sign("test", approvalResults.getAppointmentNumber());
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/carRecordResultFail/" + approvalResults.getAppointmentNumber() + "/" + sign, new HashMap<String, String>());
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }

    private VehicleNetResult noticeDriverOnFailureKeepOnRecord(ApprovalResults approvalResults) {

        String sign = EncryptUtil.md5("/" + approvalResults.getAppointmentNumber() + "/test");
        String str = HttpUtils.doPost("http://19.52.64.29:8080/iimgmt-webapp/ws/card/driverRecordResultFail/" + approvalResults.getAppointmentNumber() + "/" + sign, new HashMap<String, String>());
        VehicleNetResult vo = Json.toObject(str, VehicleNetResult.class, true);
        return vo;
    }
}
