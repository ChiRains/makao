package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.template.core.util.string.StringUtils;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.ProfilesSuccessHandler;
import com.qcloud.project.macaovehicle.common.Constant;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
import com.qcloud.project.macaovehicle.web.vo.ProfilesSuccessVO;

@Component
public class ProfilesSuccessHandlerImpl implements ProfilesSuccessHandler {

    @Autowired
    private VehicleService         vehicleService;

    @Autowired
    private DriverService          driverService;

    @Autowired
    private ProfilesSuccessService profilesSuccessService;

    @Override
    public List<ProfilesSuccessVO> toVOList(List<ProfilesSuccess> list) {

        List<ProfilesSuccessVO> voList = new ArrayList<ProfilesSuccessVO>();
        for (ProfilesSuccess profilesSuccess : list) {
            voList.add(toVO(profilesSuccess));
        }
        return voList;
    }

    @Override
    public ProfilesSuccessVO toVO(ProfilesSuccess profilesSuccess) {

        String json = Json.toJson(profilesSuccess);
        return Json.toObject(json, ProfilesSuccessVO.class, true);
    }

    @Override
    public List<ProfilesSuccessVO> toVehicleVOList(List<ProfilesSuccess> list) {

        List<ProfilesSuccessVO> voList = new ArrayList<ProfilesSuccessVO>();
        if (list == null) return new ArrayList<ProfilesSuccessVO>();
        for (ProfilesSuccess p : list) {
            String json = Json.toJson(p);
            ProfilesSuccessVO vo = Json.toObject(json, ProfilesSuccessVO.class, true);
            Long vehicleId = p.getVehicleId();
            ProfilesSuccessQuery query = new ProfilesSuccessQuery();
            query.setVehicleId(vehicleId);
            query.setGroupByStr("driverId");
            query.setvEnable(EnableType.ENABLE.getKey());
            // 驾驶员
            List<ProfilesSuccess> profilesSuccesses = profilesSuccessService.listByQuery(query);
            String vehicleInfo = "";
            String driverInfo = "";
            String ownName = "";
            String validDateStr = null;
            int dayCount = 0;
            Vehicle vehicle = vehicleService.get(p.getVehicleId());
            for (ProfilesSuccess profilesSuccess : profilesSuccesses) {
                Driver driver = driverService.get(profilesSuccess.getDriverId());
                AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicle.getId());
                AssertUtil.assertNotNull(driver, "司机不存在." + driver.getId());
                vehicleInfo = vehicle.getPlateNumber() + "," + vehicle.getColor() + "," + vehicle.getBrand() + "," + vehicle.getSpecification();
                driverInfo = driver.getDriverName() + ",";
                if (StringUtils.isEmpty(ownName)) {
                    ownName = vehicle.getOwnerName();
                }
                // 180天时效
                if (validDateStr == null) {
                    AssertUtil.assertNotNull(vehicle.getApproveTime(), "入境通过时间不能为空.");
                    Date validDate = DateUtils.addDays(vehicle.getApproveTime(), Constant.VEHICLE_VALID_TIME);
                    validDateStr = DateUtil.date2String(validDate, "yyyy-MM-dd");
                    dayCount = DateUtil.getDayCount(validDate, new Date());
                }
            }
            if (driverInfo.length() > 0) {
                driverInfo = driverInfo.substring(0, driverInfo.length() - 1);
            }
            Map<String, Object> returnMap = new HashMap<String, Object>();
            returnMap.put("vehicleInfo", vehicleInfo);
            returnMap.put("ownName", ownName);
            returnMap.put("validDateStr", validDateStr);
            returnMap.put("dayCount", dayCount);
            returnMap.put("driverInfo", driverInfo);
            returnMap.put("type", 1);
            returnMap.put("vehicleId", list.get(0).getVehicleId());
            vo.setReturnMap(returnMap);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<ProfilesSuccessVO> toDriverVOList(List<ProfilesSuccess> list) {

        List<ProfilesSuccessVO> voList = new ArrayList<ProfilesSuccessVO>();
        for (ProfilesSuccess profilesSuccess : list) {
            String json = Json.toJson(profilesSuccess);
            ProfilesSuccessVO vo = Json.toObject(json, ProfilesSuccessVO.class, true);
            Driver driver = driverService.get(profilesSuccess.getDriverId());
            Map<String, Object> returnMap = new HashMap<String, Object>();
            returnMap.put("driverName", driver.getDriverName());
            returnMap.put("sex", driver.getSex());
            returnMap.put("licenseNumber", driver.getLicenseNumber());
            returnMap.put("driverPhone", driver.getDriverPhone());
            vo.setReturnMap(returnMap);
            voList.add(vo);
        }
        return voList;
    }
}
