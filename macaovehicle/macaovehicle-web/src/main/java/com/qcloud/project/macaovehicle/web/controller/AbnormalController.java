package com.qcloud.project.macaovehicle.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.DayStatistic;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.MonthStatistic;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.YearStatistic;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;
import com.qcloud.project.macaovehicle.service.AbnormalService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.handler.AbnormalHandler;
import com.qcloud.project.macaovehicle.web.vo.AbnormalVO;
import com.qcloud.project.macaovehicle.web.vo.StatisticRecordVO;

@Controller
@RequestMapping(value = AbnormalController.DIR)
public class AbnormalController {

    public static final String   DIR            = "/abnormal";

    @Autowired
    private AbnormalService      abnormalService;

    @Autowired
    private AbnormalHandler      abnormalHandler;

    @Autowired
    private VehicleService       vehicleService;

    @Autowired
    private DriverService        driverService;

    @Autowired
    private DriverVehicleService driverVehicleService;

    @Value("${pirates.macaovehicle.networking.imageServerUrl}")
    private static final String  imageServerUrl = "";

    // @RequestMapping
    // public FrontPagingView list(AbnormalQuery query, Integer pageNum, Integer
    // pageSize) {
    //
    // final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
    // pageNum = RequestUtil.getPageid(pageNum);
    // int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
    // List<Abnormal> list = abnormalService.list(query, start, PAGE_SIZE);
    // int total = abnormalService.count(query);
    // List<AbnormalVO> volist = abnormalHandler.toVOList(list);
    // FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, total);
    // view.addObject("result", volist);
    // return view;
    // }
    @RequestMapping
    public FrontPagingView list(AbnormalQuery query, Integer pageNum, Integer pageSize, Long formInstanceId) {

        AssertUtil.greatZero(formInstanceId, "流程实例id不能为空.");
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        //
        List<DriverVehicle> driverVehicles = driverVehicleService.getListByFormInstanceId(formInstanceId);
        //
        query.setCarCardId(driverVehicles.get(0).getRic());
        Page<Abnormal> page = abnormalService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        for (Abnormal abnormal : page.getData()) {
            List<DriverVehicle> dvs = driverVehicleService.getListByDriverIc(abnormal.getDriverCardId(), ProgressType.APPLY);
            if (dvs == null) continue;
            Driver d = driverService.get(dvs.get(0).getDriverId());
            returnMap.put("monitorName", abnormal.getMonitorName());
            returnMap.put("happenedTime", abnormal.getHappenedTime());
            returnMap.put("driverName", d.getDriverName());
            returnMap.put("licenseNumber", d.getLicenseNumber());
            returnMap.put("driverIdCard", d.getDriverIdCard());
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }

    @RequestMapping
    public FrontAjaxView imitate(int type) {

        String picStrs[] = { "" + "/file/get.do?uid=65B4DF5A75B245B59B7818DA3FCBCFD2.png", "/file/get.do?uid=9DBD535002484A3E87CBCCE9E9BD1F6B.png", "/file/get.do?uid=036F9F8762D949119623CC3B0F27C66C.png", "/file/get.do?uid=EBB74D347DD044D9A9C6CEFE19C096CC.png", "/file/get.do?uid=903D686962A44C2F80E28B8F21027C89.png"};
        String carCardNumber[] = { "10001", "10002", "10003", "10004", "10005"};
        String driverCardNumber[] = { "90003", "90004", "90005", "90006", "90007"};
        int index = Math.abs(new Random().nextInt() * 100000 % 5);
        Abnormal abnormal = new Abnormal();
        abnormal.setMonitorId("1001");
        abnormal.setMonitorName("第" + index + "检测");
        abnormal.setHappenedTime(DateUtil.date2String(new Date()));
        abnormal.setRfPlate(StringUtil.uuid().substring(0, 5));
        abnormal.setOcrPlate(abnormal.getRfPlate());
        abnormal.setEventType(String.valueOf(type));
        index = Math.abs(new Random().nextInt() * 100000 % 5);
        abnormal.setPicture(picStrs[index]);
        index = Math.abs(new Random().nextInt() * 100000 % 5);
        abnormal.setCarCardId(carCardNumber[index]);
        index = Math.abs(new Random().nextInt() * 100000 % 5);
        abnormal.setDriverCardId(driverCardNumber[index]);
        abnormal.setAlarmNum(1);
        abnormalService.add(abnormal);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("推送成功");
        return view;
    }

    // 判断是否有车通关
    @RequestMapping
    public FrontAjaxView ifReal() {

        List<Abnormal> list = abnormalService.list(new AbnormalQuery(), 0, 10);
        int ifReal = 0;
        String type = "0";
        Date today = new Date();
        for (Abnormal abnormal : list) {
            Date d1 = DateUtil.str2Date(abnormal.getHappenedTime());
            long diff = (today.getTime() - d1.getTime()) / 1000;
            if (diff <= 3) {
                ifReal = 1;
                type = abnormal.getEventType();
                break;
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("ifReal", ifReal);
        view.addObject("type", Long.parseLong(type));
        return view;
    }

    @RequestMapping
    public FrontAjaxView realTime() {

        AbnormalQuery query = new AbnormalQuery();
        List<Abnormal> list = abnormalService.list(query, 0, 1);
        List<AbnormalVO> volist = abnormalHandler.toVOList(list);
        FrontAjaxView view = new FrontAjaxView();
        if (list.size() > 0) {
            view.addObject("result", volist.get(0));
        }
        return view;
    }

    // 当天流量
    @RequestMapping
    public FrontAjaxView statisticToday() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String str = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + " ";
        String startTime = str + "00:00:00";
        String endTime = str + "23:59:59";
        List<Abnormal> list = abnormalService.statisticRecord(2, startTime, endTime);
        int peccancy = list.size();
        list = abnormalService.statisticRecord(1, startTime, endTime);
        int cross = list.size();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("peccancy", peccancy);// 违章
        view.addObject("cross", cross);// 越界
        return view;
    }

    // 出境统计
    @RequestMapping
    public FrontAjaxView statisticRecord(Integer statisType) {

        List<StatisticRecordVO> voList = new ArrayList<StatisticRecordVO>();
        if (statisType == 1) {// 日表 ：24小时
            voList = statisticByDay(1);
        } else if (statisType == 2) {// 周 表：7天
            voList = statisticByWeek(1);
        } else if (statisType == 3) {// 月表 ：30天
            voList = statisticByMonth(1);
        } else if (statisType == 4) { // 年表 ：12个月
            voList = statisticByYear(1);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", voList);
        return view;
    }

    // 入境统计
    @RequestMapping
    public FrontAjaxView statisticInRecord(Integer statisType) {

        List<StatisticRecordVO> voList = new ArrayList<StatisticRecordVO>();
        if (statisType == 1) {// 日表 ：24小时
            voList = statisticByDay(2);
        } else if (statisType == 2) {// 周 表：7天
            voList = statisticByWeek(2);
        } else if (statisType == 3) {// 月表 ：30天
            voList = statisticByMonth(2);
        } else if (statisType == 4) { // 年表 ：12个月
            voList = statisticByYear(2);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", voList);
        return view;
    }

    // 统计
    public List<StatisticRecordVO> statisticByDay(int type) {

        List<StatisticRecordVO> list = new ArrayList<StatisticRecordVO>();
        //
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String str = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + " ";
        //
        DayStatistic statistic[] = DayStatistic.values();
        for (DayStatistic dayStatistic : statistic) {
            StatisticRecordVO vo = new StatisticRecordVO();
            String temp[] = dayStatistic.getName().split(",");
            String startTime = str + temp[0];
            String endTime = str + temp[1];
            vo.setName(String.valueOf(dayStatistic.getKey()));
            vo.setNumber(abnormalService.statisticRecord(type, startTime, endTime).size());
            list.add(vo);
        }
        return list;
    }

    public List<StatisticRecordVO> statisticByWeek(int type) {

        List<StatisticRecordVO> list = new ArrayList<StatisticRecordVO>();
        //
        Calendar calendar = Calendar.getInstance();
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        int remain = 7 - w;
        for (int i = w; i > 0; i--) {
            StatisticRecordVO vo = new StatisticRecordVO();
            Date temp = DateUtil.addDate(new Date(), -i);
            String tempStr = DateUtil.date2String(temp, "yyyy-MM-dd");
            String startTime = tempStr + " 00:00:00";
            String endTime = tempStr + " 23:59:59";
            if (w - i == 0) {
                vo.setName(String.valueOf(7));
            } else {
                vo.setName(String.valueOf(w - i));
            }
            vo.setNumber(abnormalService.statisticRecord(type, startTime, endTime).size());
            list.add(vo);
        }
        for (int i = 0; i < remain; i++) {
            StatisticRecordVO vo = new StatisticRecordVO();
            Date temp = DateUtil.addDate(new Date(), +i);
            String tempStr = DateUtil.date2String(temp, "yyyy-MM-dd");
            String startTime = tempStr + " 00:00:00";
            String endTime = tempStr + " 23:59:59";
            vo.setName(String.valueOf(w + i));
            vo.setNumber(abnormalService.statisticRecord(type, startTime, endTime).size());
            list.add(vo);
        }
        Collections.sort(list, new Comparator<StatisticRecordVO>() {

            @Override
            public int compare(StatisticRecordVO vo1, StatisticRecordVO vo2) {

                return vo1.getName().compareTo(vo2.getName());
            }
        });
        return list;
    }

    public List<StatisticRecordVO> statisticByMonth(int type) {

        List<StatisticRecordVO> list = new ArrayList<StatisticRecordVO>();
        //
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        String str = year + "-" + String.format("%02d", month) + "-";
        //
        MonthStatistic statistic[] = MonthStatistic.values();
        for (MonthStatistic dayStatistic : statistic) {
            StatisticRecordVO vo = new StatisticRecordVO();
            String temp[] = dayStatistic.getName().split(",");
            String startTime = str + temp[0];
            String endTime = str + temp[1];
            vo.setName(String.valueOf(dayStatistic.getKey()));
            vo.setNumber(abnormalService.statisticRecord(type, startTime, endTime).size());
            list.add(vo);
        }
        return list;
    }

    public List<StatisticRecordVO> statisticByYear(int type) {

        List<StatisticRecordVO> list = new ArrayList<StatisticRecordVO>();
        //
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        String str = year + "-";
        //
        YearStatistic statistic[] = YearStatistic.values();
        for (YearStatistic dayStatistic : statistic) {
            StatisticRecordVO vo = new StatisticRecordVO();
            String temp[] = dayStatistic.getName().split(",");
            String startTime = str + temp[0];
            String endTime = str + temp[1];
            vo.setName(String.valueOf(dayStatistic.getKey()));
            vo.setNumber(abnormalService.statisticRecord(type, startTime, endTime).size());
            list.add(vo);
        }
        return list;
    }

    /**
     * @date 2016-04-11
     * @author Kuina.黄嘉明
     * @descrition 出入境检测->越界记录(审批端)
     */
    @RequestMapping
    public FrontPagingView crossBorderRecord(AbnormalQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Abnormal> page = abnormalService.page(query, start, PAGE_SIZE);
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> returnMap = new LinkedHashMap<String, Object>();
        for (Abnormal abnormal : page.getData()) {
            Vehicle vehicle = vehicleService.getByPlateNumber(abnormal.getOcrPlate());
            returnMap.put("monitorId", abnormal.getMonitorId());// 越界关口
            returnMap.put("eventType", abnormal.getEventType());// 越界行为
            returnMap.put("ocrPlate", abnormal.getOcrPlate());// 境外车牌号码(abnormal的ocrPlate就是vehicle的plateNumber)
            returnMap.put("temporaryplate", vehicle != null ? vehicle.getTemporaryplate() : "-");// 临时号牌
            returnMap.put("color", vehicle != null ? vehicle.getColor() : "-");// 车辆颜色
            returnMap.put("HappenedTime", abnormal.getHappenedTime());// 越界时间
            mapList.add(returnMap);
        }
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", mapList);
        return view;
    }

    /**
     * @date 2016-04-11
     * @author Kuina.黄嘉明
     * @descrition 出入境检测->越界监测--实时告警(审批端)
     */
    @RequestMapping
    public FrontPagingView realTimeWarning(AbnormalQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Abnormal> page = abnormalService.page(query, start, PAGE_SIZE);
        List<AbnormalVO> voList = abnormalHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", voList);
        return view;
    }

    /**
     * @date 2016-04-11
     * @author Kuina.黄嘉明
     * @descrition 出入境检测->今日越界车辆(审批端)
     */
    @RequestMapping
    public FrontAjaxView crossBorderToday() {

        int count = abnormalService.countToday();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("result", count);
        return view;
    }

    @RequestMapping
    public FrontPagingView list4Deal(AbnormalQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Abnormal> page = abnormalService.page(query, start, PAGE_SIZE);
        List<AbnormalVO> voList = abnormalHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.addObject("result", voList);
        return view;
    }
    
    /**
     * @date 2016-06-20
     * @author Kuina.黄嘉明
     * @descrition “我的工作台”右侧面板-系统消息
     */
    @RequestMapping
    public FrontAjaxView sysMessage() {
    	List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
    	List<Abnormal> list = abnormalService.listAll();
    	for(Abnormal abnormal : list) {
    		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    		resultMap.put("rfPlate",abnormal.getRfPlate());//射频车牌号
    		resultMap.put("ocrPlate",abnormal.getOcrPlate());//视频车牌号
    		resultMap.put("monitorName", abnormal.getMonitorName());//监控点名称
    		resultMap.put("evenTpye", abnormal.getEventType()==String.valueOf(1)?"越界预警":"越界告警");//1、"越界预警"；2、"越界告警"
    		resultMap.put("happenTime", abnormal.getHappenedTime());
    		resultList.add(resultMap);
    	}
    	FrontAjaxView view = new FrontAjaxView();
    	view.addObject("sysMessage", resultList);
    	return view;
    }
}
