package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.web.page.PPage;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OnestopCarRecordType;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.OnestopCarRecordService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.OnestopCarRecordHandler;

/**
 * 车辆入境记录
 */
@Controller
@RequestMapping(value = OnestopCarRecordController.DIR)
public class OnestopCarRecordController {

    public static final String      DIR = "/onestopCarRecord";

    @Autowired
    private OnestopCarRecordService onestopCarRecordService;

    @Autowired
    private OnestopCarRecordHandler onestopCarRecordHandler;

    @Autowired
    private DriverVehicleService    driverVehicleService;

    @Autowired
    private ClerkHelper             clerkHelper;

    @Autowired
    private CarOwnerService         carOwnerService;

    @Autowired
    private VehicleService          vehicleService;

    /**
     * 审批端-入境车辆列表
     */
    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request, OnestopCarRecordQuery query, Long formInstanceId) {

        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertTrue(carOwner == null, "门户网用户无访问权限.");
        AssertUtil.greatZero(formInstanceId, "流程实例id不能为空.");
        List<DriverVehicle> driverVehicles = driverVehicleService.getListByFormInstanceId(formInstanceId);
        // 车卡id
        query.setvCardid(driverVehicles.get(0).getRic());
        query.setOrderBy("date DESC");
        Page<OnestopCarRecord> enterPage = onestopCarRecordService.page(query, 0, Integer.MAX_VALUE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        //
        List<Date> enterList = new ArrayList<Date>();
        List<Date> outList = new ArrayList<Date>();
        for (OnestopCarRecord onestopCarRecord : enterPage.getData()) {
            if (onestopCarRecord.getType() == OnestopCarRecordType.ENTER.getKey()) {
                enterList.add(onestopCarRecord.getDate());
            } else if (onestopCarRecord.getType() == OnestopCarRecordType.OUT.getKey()) {
                outList.add(onestopCarRecord.getDate());
            }
        }
        for (int i = 0; i < enterList.size(); i++) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            Date enterTime = enterList.get(i);
            Date outTime = outList.size() > i ? outList.get(i) : null;
            returnMap.put("enterTime", DateUtil.date2String(enterTime));
            returnMap.put("outTime", outTime != null ? DateUtil.date2String(outTime) : "");
            returnMap.put("stayHour", (outTime.getTime() - enterTime.getTime()) / 1000 / 3600);
            mapList.add(returnMap);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("mapList", mapList);
        return view;
    }

    /**
     * 门户网-入境车辆列表
     */
    @RequestMapping
    public FrontAjaxView listEntry(HttpServletRequest request, OnestopCarRecordQuery query, PPage pPage) {

        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertNotNull(carOwner, "用户信息不完整." + clerk.getId());
        // 车卡id
        List<Vehicle> vehicles = vehicleService.listByCarOwner(carOwner.getId());
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Vehicle vehicle : vehicles) {
            query.setvCardid(vehicle.getRic());
            query.setOrderBy("date DESC");
            Page<OnestopCarRecord> enterPage = onestopCarRecordService.page(query, 0, Integer.MAX_VALUE);
            //
            List<Date> enterList = new ArrayList<Date>();
            List<Date> outList = new ArrayList<Date>();
            for (OnestopCarRecord onestopCarRecord : enterPage.getData()) {
                if (onestopCarRecord.getType() == OnestopCarRecordType.ENTER.getKey()) {
                    enterList.add(onestopCarRecord.getDate());
                } else if (onestopCarRecord.getType() == OnestopCarRecordType.OUT.getKey()) {
                    outList.add(onestopCarRecord.getDate());
                }
            }
            for (int i = 0; i < enterList.size(); i++) {
                Map<String, Object> returnMap = new HashMap<String, Object>();
                Date enterTime = enterList.get(i);
                Date outTime = outList.size() > i ? outList.get(i) : null;
                returnMap.put("plateNumber", vehicle.getPlateNumber());
                returnMap.put("temporaryplate", vehicle.getTemporaryplate());
                returnMap.put("enterGate", "横琴");
                returnMap.put("enterTime", DateUtil.date2String(enterTime));
                returnMap.put("outGate", "横琴");
                returnMap.put("outTime", outTime != null ? DateUtil.date2String(outTime) : "");
                returnMap.put("stayHour", (outTime.getTime() - enterTime.getTime()) / 1000 / 3600);
                mapList.add(returnMap);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("returnMap", mapList);
        return view;
    }

    /**
     * 审批端入出境数量
     * @param request
     * @param query
     * @param pPage
     * @return
     */
    @RequestMapping
    public FrontAjaxView countAll(HttpServletRequest request, OnestopCarRecordQuery query, PPage pPage) {

        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertTrue(carOwner == null, "门户网用户无访问权限.");
        query.setType(OnestopCarRecordType.ENTER.getKey());
        int enterCount = onestopCarRecordService.getCountByMap(query);
        query.setType(OnestopCarRecordType.OUT.getKey());
        int outCount = onestopCarRecordService.getCountByMap(query);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("enterCount", enterCount);
        view.addObject("outCount", outCount);
        return view;
    }

    /**
     * 出入境实时数据监测
     * @param request
     * @param query
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontAjaxView realList(HttpServletRequest request, OnestopCarRecordQuery query, Integer pageSize) {

        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertTrue(carOwner == null, "门户网用户无访问权限.");
        pageSize = pageSize <= 0 ? 10 : pageSize;
        query.setOrderBy("date DESC");
        query.setType(OnestopCarRecordType.ENTER.getKey());
        Page<OnestopCarRecord> enterPage = onestopCarRecordService.page(query, 0, pageSize);
        query.setType(OnestopCarRecordType.OUT.getKey());
        Page<OnestopCarRecord> outPage = onestopCarRecordService.page(query, 0, pageSize);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("enterList", onestopCarRecordHandler.toVOList(enterPage.getData()));
        view.addObject("outList", onestopCarRecordHandler.toVOList(outPage.getData()));
        return view;
    }

    /**
     * 审批端-车辆入境记录
     */
    @RequestMapping
    public FrontPagingView listRecord(HttpServletRequest request, OnestopCarRecordQuery query, PPage pPage) {

        Clerk clerk = clerkHelper.getClerk(request);
        CarOwner carOwner = carOwnerService.getByClerk(clerk.getId());
        AssertUtil.assertTrue(carOwner == null, "门户网用户无访问权限.");
        query.setGroupByStr("vCardid,date");
        query.setType(OnestopCarRecordType.ENTER.getKey());
        // 入境的数据
        query.setOrderBy("date DESC");
        Page<OnestopCarRecord> enterPage = onestopCarRecordService.page(query, pPage.getPageStart(), pPage.getPageSize());
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        //
        List<OnestopCarRecord> enterList = new ArrayList<OnestopCarRecord>();
        List<OnestopCarRecord> outList = new ArrayList<OnestopCarRecord>();
        for (OnestopCarRecord onestopCarRecord : enterPage.getData()) {
            query.setvCardid(onestopCarRecord.getVCardid());
            query.setType(OnestopCarRecordType.OUT.getKey());
            query.setOrderBy("date");
            Page<OnestopCarRecord> page = onestopCarRecordService.page(query, 0, Integer.MAX_VALUE);
            enterList.add(onestopCarRecord);
            // 提取出境时间, 最接近入境时间的数据
            for (OnestopCarRecord onestop : page.getData()) {
                if (onestop.getDate().after(onestopCarRecord.getDate())) {
                    outList.add(onestop);
                    break;
                }
            }
        }
        //
        for (int i = 0; i < enterList.size(); i++) {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            OnestopCarRecord enterCarRecord = enterList.get(i);
            OnestopCarRecord outCarRecord = outList.size() > i ? outList.get(i) : null;
            Date enterTime = enterCarRecord.getDate();
            Date outTime = outCarRecord != null ? outCarRecord.getDate() : null;
            Vehicle vehicle = vehicleService.getByRic(enterCarRecord.getVCardid());
            returnMap.put("plateNumber", vehicle != null ? vehicle.getPlateNumber() : "-");
            returnMap.put("temporaryplate", vehicle != null ? vehicle.getTemporaryplate() : "-");
            returnMap.put("color", vehicle != null ? vehicle.getColor() : "-");
            // returnMap.put("type", enterCarRecord.getType());
            //
            // returnMap.put("date", enterCarRecord.getDate());
            // returnMap.put("gate", enterCarRecord.getGate());
            returnMap.put("enterTime", enterTime != null ? DateUtil.date2String(enterTime) : "-");
            returnMap.put("outTime", outTime != null ? DateUtil.date2String(outTime) : "-");
            returnMap.put("stayHour", outTime != null ? (outTime.getTime() - enterTime.getTime()) / 1000 / 3600 : "-");
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pPage.getPageNum(), pPage.getPageSize(), enterPage.getCount());
        view.addObject("mapList", mapList);
        return view;
    }
}
