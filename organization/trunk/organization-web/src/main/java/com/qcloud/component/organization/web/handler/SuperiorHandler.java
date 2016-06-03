package com.qcloud.component.organization.web.handler;

import java.util.List;

import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.web.vo.SuperiorVO;
import com.qcloud.component.organization.web.vo.admin.AdminSuperiorVO;

public interface SuperiorHandler {

	List<SuperiorVO> toVOList(List<Superior> list);

	SuperiorVO toVO(Superior superior);

	List<AdminSuperiorVO> toVOList4Admin(List<Superior> list);

	AdminSuperiorVO toVO4Admin(Superior superior);
}
