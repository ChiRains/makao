package com.qcloud.project.macaovehicle.web.controller.outside;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OnestopCarRecordType;
import com.qcloud.project.macaovehicle.service.OnestopCarRecordService;
import com.qcloud.project.macaovehicle.util.SignUtils;

// 盛视一站式接口
@Controller
@RequestMapping(value = OnestopController.DIR)
public class OnestopController {

    public static final String      DIR    = "/onestop";

    @Autowired
    private OnestopCarRecordService onestopCarRecordService;

    private Log                     logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/enterRecord", method = RequestMethod.POST)
    public FrontAjaxView enterRecord(String dCardid, String vCardid, String date, String gate, String sign) {

        // 要考虑网络延迟，重复推送数据的判断
        logger.info("测试访问入境.=================================================");
        logger.info("司机卡dCardid：" + dCardid);
        logger.info("车辆卡vCardid：" + vCardid);
        logger.info("时间：" + date);
        logger.info("关口：" + gate);
        if (!SignUtils.checkSign("test", sign, dCardid, vCardid, date, gate)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            logger.info("签名错误");
            return view;
        }
        FrontAjaxView view = new FrontAjaxView();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dCardid", dCardid);
        map.put("vCardid", vCardid);
        map.put("date", DateUtil.date2String(DateUtil.str2Date(date, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss"));
        OnestopCarRecord carRecord = onestopCarRecordService.getByMap(map);
        if (carRecord != null) {
            throw new MacaovehicleException("此数据已存在.");
        }
        OnestopCarRecord onestopCarRecord = new OnestopCarRecord();
        onestopCarRecord.setDCardid(dCardid);
        onestopCarRecord.setVCardid(vCardid);
        onestopCarRecord.setDate(DateUtil.str2Date(date, "yyyyMMddHHmmss"));
        onestopCarRecord.setGate(gate);
        onestopCarRecord.setType(OnestopCarRecordType.ENTER.getKey());
        onestopCarRecordService.add(onestopCarRecord);
        view.setMessage("入境通知成功.");
        logger.info("测试访问成功.sign签名" + sign);
        logger.info("入境成功.=================================================");
        return view;
    }

    @RequestMapping(value = "/outRecord", method = RequestMethod.POST)
    public FrontAjaxView outRecord(String dCardid, String vCardid, String date, String gate, String sign) {

        // 要考虑网络延迟，重复推送数据的判断
        logger.info("测试访问出境.=================================================");
        logger.info("司机卡dCardid：" + dCardid);
        logger.info("车辆卡vCardid：" + vCardid);
        logger.info("时间：" + date);
        logger.info("关口：" + gate);
        if (!SignUtils.checkSign("test", sign, dCardid, vCardid, date, gate)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            logger.info("签名错误");
            return view;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dCardid", dCardid);
        map.put("vCardid", vCardid);
        map.put("date", DateUtil.date2String(DateUtil.str2Date(date, "yyyyMMddHHmmss"), "yyyy-MM-dd HH:mm:ss"));
        OnestopCarRecord carRecord = onestopCarRecordService.getByMap(map);
        if (carRecord != null) {
            throw new MacaovehicleException("此数据已存在.");
        }
        FrontAjaxView view = new FrontAjaxView();
        OnestopCarRecord onestopCarRecord = new OnestopCarRecord();
        onestopCarRecord.setDCardid(dCardid);
        onestopCarRecord.setVCardid(vCardid);
        onestopCarRecord.setDate(DateUtil.str2Date(date, "yyyyMMddHHmmss"));
        onestopCarRecord.setGate(gate);
        onestopCarRecord.setType(OnestopCarRecordType.OUT.getKey());
        onestopCarRecordService.add(onestopCarRecord);
        view.setMessage("出境通知成功.");
        logger.info("测试访问成功.sign签名" + sign);
        logger.info("出境成功.=================================================");
        return view;
    }
}
