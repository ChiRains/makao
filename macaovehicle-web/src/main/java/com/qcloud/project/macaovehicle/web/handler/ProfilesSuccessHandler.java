package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.web.vo.DriverVehicleVO;
import com.qcloud.project.macaovehicle.web.vo.ProfilesSuccessVO;

public interface ProfilesSuccessHandler {

    List<ProfilesSuccessVO> toVOList(List<ProfilesSuccess> list);

    ProfilesSuccessVO toVO(ProfilesSuccess profilesSuccess);

    List<ProfilesSuccessVO> toVehicleVOList(List<ProfilesSuccess> list);

    List<ProfilesSuccessVO> toDriverVOList(List<ProfilesSuccess> list);
}
