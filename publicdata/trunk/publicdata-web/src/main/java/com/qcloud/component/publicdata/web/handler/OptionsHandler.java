package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.web.vo.OptionsVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminOptionsVO;

public interface OptionsHandler {

	List<OptionsVO> toVOList(List<Options> list);

	OptionsVO toVO(Options options);

	List<AdminOptionsVO> toVOList4Admin(List<Options> list);

	AdminOptionsVO toVO4Admin(Options options);
}
