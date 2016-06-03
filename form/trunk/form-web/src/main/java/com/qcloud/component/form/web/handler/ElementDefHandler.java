package com.qcloud.component.form.web.handler;

import java.util.List;

import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.web.vo.ElementDefVO;
import com.qcloud.component.form.web.vo.admin.AdminElementDefVO;

public interface ElementDefHandler {

	List<ElementDefVO> toVOList(List<ElementDef> list);

	ElementDefVO toVO(ElementDef elementDef);

	List<AdminElementDefVO> toVOList4Admin(List<ElementDef> list);

	AdminElementDefVO toVO4Admin(ElementDef elementDef);
}
