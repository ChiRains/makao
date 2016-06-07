package com.qcloud.component.piratesship.web.handler;

import java.util.List;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.web.vo.admin.AdminCallMeVO;

public interface CallMeHandler {

    List<AdminCallMeVO> toVOList4Admin(List<CallMe> list);

    AdminCallMeVO toVO4Admin(CallMe callMe);
}
