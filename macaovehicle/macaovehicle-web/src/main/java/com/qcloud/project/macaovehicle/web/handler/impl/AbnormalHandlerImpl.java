package com.qcloud.project.macaovehicle.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QMainFormData;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.web.handler.AbnormalHandler;
import com.qcloud.project.macaovehicle.web.vo.AbnormalVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminAbnormalVO;

@Component
public class AbnormalHandlerImpl implements AbnormalHandler {

    @Autowired
    private FormClient             formClient;

    @Autowired
    private ApprovalResultsService approvalResultsService;

    @Autowired
    private FileSDKClient          fileSDKClient;
    
    @Value("${macaovehicle.networking.imageServerUrl}")
    private   String imageServerUrl ;

    @Override
    public List<AbnormalVO> toVOList(List<Abnormal> list) {

        List<AbnormalVO> voList = new ArrayList<AbnormalVO>();
        for (Abnormal abnormal : list) {
            voList.add(toVO(abnormal));
        }
        return voList;
    }

    @Override
    public AbnormalVO toVO(Abnormal abnormal) {

        String json = Json.toJson(abnormal);
        AbnormalVO vo = Json.toObject(json, AbnormalVO.class, true);
//        ApprovalResults results = approvalResultsService.getResultByCardNumber(vo.getCarCardId(), ApprovalCardType.CAR.getKey());
//        QMainFormData mainFormData = formClient.get(results.getFormInstanceId());
//        Map<String, Object> formMap = mainFormData.toMap();
//        Integer inner_number = (Integer) formMap.get("vehicle.qc_inner_number");
//        for (int i = 0; i < inner_number; i++) {
//            vo.setColor((String) formMap.get("vehicle[" + i + "].color"));
//            vo.setModels((String) formMap.get("vehicle[" + i + "].models"));
//        }
        if (vo.getEventType().equals("1")) {
            vo.setEventTypeStr("越界预警");
        }
        if (vo.getEventType().equals("2")) {
            vo.setEventTypeStr("越界告警");
        }
//        vo.setPicture(imageServerUrl+vo.getPicture());
        if(StringUtils.isNotEmpty(vo.getPictureUrl())){
            vo.setPictureUrl(vo.getPictureUrl());
        }
        return vo;
    }

    @Override
    public List<AdminAbnormalVO> toVOList4Admin(List<Abnormal> list) {

        List<AdminAbnormalVO> voList = new ArrayList<AdminAbnormalVO>();
        for (Abnormal adminAbnormal : list) {
            voList.add(toVO4Admin(adminAbnormal));
        }
        return voList;
    }

    @Override
    public AdminAbnormalVO toVO4Admin(Abnormal abnormal) {

        String json = Json.toJson(abnormal);
        return Json.toObject(json, AdminAbnormalVO.class, true);
    }
}
