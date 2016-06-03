package com.qcloud.project.macaovehicle.web.controller.outside;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.service.AbnormalService;
import com.qcloud.project.macaovehicle.util.HttpUtils;
import com.qcloud.project.macaovehicle.util.SignUtils;

@Controller
@RequestMapping(value = AbnormalRecordController.DIR)
public class AbnormalRecordController {

    public static final String DIR    = "/abnormalRecord";

    Log                        logger = LogFactory.getLog(getClass());

    @Autowired
    private AbnormalService    abnormalService;

    @Autowired
    private FileSDKClient      fileSDKClient;

    @RequestMapping(value = "/add/{monitorId}/{monitorName}/{happenedTime}/{carCardId}/{driverCardId}/{rfPlate}/{ocrPlate}/{eventType}/{picture}/{sign}", method = RequestMethod.POST)
    public FrontAjaxView add(@PathVariable("monitorId") String monitorId, @PathVariable("monitorName") String monitorName, @PathVariable("happenedTime") String happenedTime, @PathVariable("carCardId") String carCardId, @PathVariable("driverCardId") String driverCardId, @PathVariable("rfPlate") String rfPlate, @PathVariable("ocrPlate") String ocrPlate, @PathVariable("eventType") String eventType, @PathVariable("picture") String picture, @PathVariable("sign") String sign) {

        logger.info("=========添加异常记录开始=========");
        logger.info("监控点id" + monitorId);
        logger.info("监控点名称" + monitorName);
        logger.info("时间" + happenedTime);
        logger.info("车卡" + carCardId);
        logger.info("司机卡" + driverCardId);
        logger.info("射频车牌号" + rfPlate);
        logger.info("视频车牌号" + ocrPlate);
        logger.info("时间类型" + eventType);
        logger.info("图片" + picture);
        logger.info("=========添加异常记录结束=========");
        if (!SignUtils.checkSign("test", sign, monitorId, monitorName, happenedTime, carCardId, driverCardId, rfPlate, ocrPlate, eventType, picture)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误！");
            logger.info("签名错误！");
            return view;
        }
        Abnormal abnormal = new Abnormal();
        abnormal.setMonitorId(monitorId);
        abnormal.setMonitorName(monitorName);
        abnormal.setHappenedTime(DateUtil.date2String(DateUtil.str2Date(happenedTime, "yyyyMMddHHmmss")));
        abnormal.setCarCardId(carCardId);
        abnormal.setDriverCardId(driverCardId);
        abnormal.setOcrPlate(ocrPlate);
        abnormal.setRfPlate(rfPlate);
        //
        try {
            String url = "http://19.52.68.140:8181/eeMonitor/resources/plateImages/" + picture;
            QFile qFile = HttpUtils.getHttpQFile(picture, url);
            abnormal.setPictureUrl(fileSDKClient.saveToUrl(qFile));
        } catch (Exception e) {
            logger.info("图片url:" + picture);
            logger.info("上次图片失败!", e);
        }
        //
        abnormal.setPicture(picture);
        abnormal.setEventType(eventType);
        abnormalService.add(abnormal);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加异常记录成功");
        return view;
    }
}
