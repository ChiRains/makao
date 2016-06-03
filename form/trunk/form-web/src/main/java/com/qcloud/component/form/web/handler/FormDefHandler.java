package com.qcloud.component.form.web.handler;

import java.util.List;

import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.web.vo.FormDefVO;
import com.qcloud.component.form.web.vo.admin.AdminFormDefVO;

public interface FormDefHandler {

	List<FormDefVO> toVOList(List<FormDef> list);

	FormDefVO toVO(FormDef formDef);

	List<AdminFormDefVO> toVOList4Admin(List<FormDef> list);

	AdminFormDefVO toVO4Admin(FormDef formDef);
}
