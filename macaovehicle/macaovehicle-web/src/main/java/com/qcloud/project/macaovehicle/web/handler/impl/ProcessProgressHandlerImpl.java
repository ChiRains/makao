package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.key.TypeEnum.ProcessStateType;
import com.qcloud.component.mvprocesstask.service.TaskedService;
import com.qcloud.component.mvprocesstask.service.TaskingService;
import com.qcloud.component.mvprocesstask.web.handler.VehicleGetter;
import com.qcloud.component.template.core.util.string.StringUtils;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.ProcessProgressHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerTalentVO;
import com.qcloud.project.macaovehicle.web.vo.IllegalCarRecordVO;
import com.qcloud.project.macaovehicle.web.vo.ProcessProgressItemVO;
import com.qcloud.project.macaovehicle.web.vo.ProcessProgressVO;

@Component
public class ProcessProgressHandlerImpl implements ProcessProgressHandler {

    @Autowired
    private VehicleService       vehicleService;

    @Autowired
    private DriverService        driverService;

    @Autowired
    private DriverVehicleService driverVehicleService;

    @Autowired
    private CarOwnerService      carOwnerService;

    @Autowired
    private TaskingService       taskingService;

    @Autowired
    private TaskedService        taskedService;

    @Autowired
    private FormClient           formClient;

    @Autowired
    private VehicleGetter        vehicleGetter;

    @Override
    public List<ProcessProgressVO> toVOList(List<ProcessProgress> list) {

        List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
        for (ProcessProgress processProgress : list) {
            voList.add(toVO(processProgress));
        }
        return voList;
    }

    @Override
    public ProcessProgressVO toVO(ProcessProgress processProgress) {

        String json = Json.toJson(processProgress);
        ProcessProgressVO vo = Json.toObject(json, ProcessProgressVO.class, true);
        Map<String, Object> returnMap = new HashMap<String, Object>();
        List<DriverVehicle> driverVehicleList = driverVehicleService.getListByFormInstCode(processProgress.getFormInstCode());
        String vehicleInfo = "";
        String driverInfo = "";
        String ownName = "";
        for (DriverVehicle driverVehicle : driverVehicleList) {
            Vehicle vehicle = vehicleService.get(driverVehicle.getVehicleId());
            if (StringUtils.isEmpty(ownName)) {
                ownName = vehicle.getOwnerName();
            }
            AssertUtil.assertNotNull(vehicle, "车辆不存在." + vehicle.getId());
            Driver driver = driverService.get(driverVehicle.getDriverId());
            AssertUtil.assertNotNull(driver, "司机不存在." + driver.getId());
            vehicleInfo = vehicle.getPlateNumber() + "," + vehicle.getColor() + "," + vehicle.getBrand() + "," + vehicle.getSpecification();
            driverInfo = driverInfo + driver.getDriverName() + ",";
        }
        if (!StringUtils.isEmpty(driverInfo)) {
            driverInfo = driverInfo.substring(0, driverInfo.length() - 1);
        }
        // CarOwner carOwner = carOwnerService.get(processProgress.getCarOwnerId());
        returnMap.put("ownerName", ownName);
        returnMap.put("vehicleInfo", vehicleInfo);
        returnMap.put("driverInfo", driverInfo);
        vo.setReturnMap(returnMap);
        return vo;
    }

    // @Override
    // public List<ProcessProgressVO> toVOList(List<ProcessProgress> list) {
    //
    // Map<String, List<ProcessProgress>> map = new HashMap<String, List<ProcessProgress>>();
    // for (ProcessProgress processProgress : list) {
    // List<ProcessProgress> il = map.get(processProgress.getFormInstCode());
    // if (il == null) {
    // il = new ArrayList<ProcessProgress>();
    // map.put(processProgress.getFormInstCode(), il);
    // }
    // il.add(processProgress);
    // }
    // List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
    // for (String str : map.keySet()) {
    // List<ProcessProgress> il = map.get(str);
    // voList.add(toVO(il));
    // }
    // return voList;
    // }
    //
    // public ProcessProgressVO toVO(List<ProcessProgress> list) {
    //
    // Collections.sort(list, new Comparator<ProcessProgress>() {
    //
    // @Override
    // public int compare(ProcessProgress o1, ProcessProgress o2) {
    //
    // return DateUtil.str2Date(o1.getDateStr()).before(DateUtil.str2Date(o2.getDateStr())) ? 1 : -1;
    // }
    // });
    // ProcessProgressVO processProgressVO = new ProcessProgressVO();
    // List<ProcessProgressItemVO> itemList = new ArrayList<ProcessProgressItemVO>();
    // int index = 1;
    // for (ProcessProgress processProgress : list) {
    // processProgressVO.setFormInstCode(processProgress.getFormInstCode());
    // ProcessProgressItemVO processProgressItemVO = new ProcessProgressItemVO();
    // processProgressItemVO.setOrderNO(index++);
    // processProgressItemVO.setActivity(processProgress.getActivity());
    // processProgressItemVO.setDateStr(processProgress.getDateStr());
    // processProgressItemVO.setFormInstCode(processProgress.getFormInstCode());
    // processProgressItemVO.setDateStr(processProgress.getDateStr());
    // itemList.add(processProgressItemVO);
    // }
    // return processProgressVO;
    // }
    @Override
    public List<ProcessProgressVO> toApproveInfo(List<ProcessProgress> list) {

        List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
        for (ProcessProgress processProgress : list) {
            String json = Json.toJson(processProgress);
            ProcessProgressVO vo = Json.toObject(json, ProcessProgressVO.class, true);
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Tasking tasking = taskingService.getByFormInstanceId(processProgress.getFormInstanceId());
            if (tasking == null) {
                List<Tasked> taskeds = taskedService.listTaskedByFormInstanceId(processProgress.getFormInstanceId());
                if (taskeds.size() > 0) {
                    Tasked tasked = taskeds.get(0);
                    returnMap.put("formInstanceId", tasked.getFormInstanceId());
                    returnMap.put("formInstCode", tasked.getFormInstCode());
                    returnMap.put("frameNumber", tasked.getFrameNumber());
                    returnMap.put("ownerName", tasked.getOwnerName());
                    returnMap.put("plateNumber", tasked.getPlateNumber());
                    returnMap.put("vehicleType", tasked.getVehicleType());
                    returnMap.put("brand", tasked.getBrand());
                    returnMap.put("specification", tasked.getSpecification());
                    returnMap.put("engineNo", tasked.getEngineNo());
                    returnMap.put("frameNumber", tasked.getFrameNumber());
                    returnMap.put("permittedWeight", tasked.getPermittedWeight());
                    returnMap.put("passengers", tasked.getPassengers());
                }
            } else {
                returnMap.put("formInstanceId", tasking.getFormInstanceId());
                returnMap.put("formInstCode", formClient.getFormInstCode(tasking.getFormInstanceId()));
                returnMap.put("frameNumber", tasking.getFrameNumber());
                returnMap.put("ownerName", tasking.getOwnerName());
                returnMap.put("plateNumber", tasking.getPlateNumber());
                returnMap.put("vehicleType", tasking.getVehicleType());
                returnMap.put("brand", tasking.getBrand());
                returnMap.put("specification", tasking.getSpecification());
                returnMap.put("engineNo", tasking.getEngineNo());
                returnMap.put("frameNumber", tasking.getFrameNumber());
                returnMap.put("permittedWeight", tasking.getPermittedWeight());
                returnMap.put("passengers", tasking.getPassengers());
            }
            vo.setReturnMap(returnMap);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<ProcessProgressVO> toPilotInfo(List<ProcessProgress> list) {

        List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
        for (ProcessProgress processProgress : list) {
            String json = Json.toJson(processProgress);
            ProcessProgressVO vo = Json.toObject(json, ProcessProgressVO.class, true);
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Tasking tasking = taskingService.getByFormInstanceId(processProgress.getFormInstanceId());
            if (tasking == null) {
                List<Tasked> taskeds = taskedService.listTaskedByFormInstanceId(processProgress.getFormInstanceId());
                if (taskeds.size() > 0) {
                    Tasked tasked = taskeds.get(0);
                    returnMap.put("formInstanceId", tasked.getFormInstanceId());
                    returnMap.put("formInstCode", tasked.getFormInstCode());
                    returnMap.put("plateNumber", tasked.getPlateNumber());
                    returnMap.put("frameNumber", tasked.getFrameNumber());
                    //
                    returnMap.put("temporaryplate", tasked.getTemporaryplate());
                    returnMap.put("ownerName", tasked.getOwnerName());
                    Date validDate = vehicleGetter.getValidDate(tasked.getPlateNumber());
                    returnMap.put("validDateStr", validDate != null ? DateUtil.date2String(validDate) : "");
                }
            } else {
                returnMap.put("formInstanceId", tasking.getFormInstanceId());
                returnMap.put("formInstCode", formClient.getFormInstCode(tasking.getFormInstanceId()));
                returnMap.put("frameNumber", tasking.getFrameNumber());
                //
                returnMap.put("plateNumber", tasking.getPlateNumber());
                returnMap.put("temporaryplate", tasking.getTemporaryplate());
                returnMap.put("ownerName", tasking.getOwnerName());
                Date validDate = vehicleGetter.getValidDate(tasking.getPlateNumber());
                returnMap.put("validDateStr", validDate != null ? DateUtil.date2String(validDate) : "");
            }
            vo.setReturnMap(returnMap);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public List<ProcessProgressVO> toRenewalInfo(List<ProcessProgress> list) {

        List<ProcessProgressVO> voList = new ArrayList<ProcessProgressVO>();
        for (ProcessProgress processProgress : list) {
            String json = Json.toJson(processProgress);
            ProcessProgressVO vo = Json.toObject(json, ProcessProgressVO.class, true);
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Tasking tasking = taskingService.getByFormInstanceId(processProgress.getFormInstanceId());
            if (tasking == null) {
                List<Tasked> taskeds = taskedService.listTaskedByFormInstanceId(processProgress.getFormInstanceId());
                if (taskeds.size() > 0) {
                    Tasked tasked = taskeds.get(0);
                    returnMap.put("formInstanceId", tasked.getFormInstanceId());
                    returnMap.put("formInstCode", tasked.getFormInstCode());
                    returnMap.put("brand", tasked.getBrand());
                    returnMap.put("ownerName", tasked.getOwnerName());
                    returnMap.put("plateNumber", tasked.getPlateNumber());
                    returnMap.put("vehicleType", tasked.getVehicleType());
                    returnMap.put("specification", tasked.getSpecification());
                    returnMap.put("engineNo", tasked.getEngineNo());
                    returnMap.put("frameNumber", tasked.getFrameNumber());
                    returnMap.put("permittedWeight", tasked.getPermittedWeight());
                    returnMap.put("passengers", tasked.getPassengers());
                }
            } else {
                returnMap.put("formInstanceId", tasking.getFormInstanceId());
                returnMap.put("formInstCode", formClient.getFormInstCode(tasking.getFormInstanceId()));
                returnMap.put("brand", tasking.getBrand());
                returnMap.put("ownerName", tasking.getOwnerName());
                returnMap.put("plateNumber", tasking.getPlateNumber());
                returnMap.put("vehicleType", tasking.getVehicleType());
                returnMap.put("specification", tasking.getSpecification());
                returnMap.put("engineNo", tasking.getEngineNo());
                returnMap.put("frameNumber", tasking.getFrameNumber());
                returnMap.put("permittedWeight", tasking.getPermittedWeight());
                returnMap.put("passengers", tasking.getPassengers());
            }
            vo.setReturnMap(returnMap);
            voList.add(vo);
        }
        return voList;
    }
}
