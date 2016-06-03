package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.publicdata.web.handler.ExpressHandler;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.web.vo.ExpressVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressVO;

@Component
public class ExpressHandlerImpl implements ExpressHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<ExpressVO> toVOList(List<Express> list) {

        List<ExpressVO> voList = new ArrayList<ExpressVO>();
        for (Express express : list) {
            voList.add(toVO(express));
        }
        return voList;
    }

    @Override
    public ExpressVO toVO(Express express) {

        String json = Json.toJson(express);
        return Json.toObject(json, ExpressVO.class, true);
    }

    @Override
    public List<AdminExpressVO> toVOList4Admin(List<Express> list) {

        List<AdminExpressVO> voList = new ArrayList<AdminExpressVO>();
        for (Express adminExpress : list) {
            voList.add(toVO4Admin(adminExpress));
        }
        return voList;
    }

    @Override
    public AdminExpressVO toVO4Admin(Express express) {

        String json = Json.toJson(express);
        AdminExpressVO vo = Json.toObject(json, AdminExpressVO.class, true);
        vo.setLogoUid(fileSDKClient.urlToUid(vo.getLogo()));
        return vo;
    }
}
