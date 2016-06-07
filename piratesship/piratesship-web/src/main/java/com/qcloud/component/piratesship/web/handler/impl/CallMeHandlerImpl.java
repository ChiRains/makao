package com.qcloud.component.piratesship.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.web.handler.CallMeHandler;
import com.qcloud.component.piratesship.web.vo.admin.AdminCallMeVO;
import com.qcloud.pirates.core.json.Json;

@Component
public class CallMeHandlerImpl implements CallMeHandler {

    @Override
    public List<AdminCallMeVO> toVOList4Admin(List<CallMe> list) {

        List<AdminCallMeVO> voList = new ArrayList<AdminCallMeVO>();
        for (CallMe adminCallMe : list) {
            voList.add(toVO4Admin(adminCallMe));
        }
        return voList;
    }

    @Override
    public AdminCallMeVO toVO4Admin(CallMe callMe) {

        String json = Json.toJson(callMe);
        return Json.toObject(json, AdminCallMeVO.class, true);
    }
}
