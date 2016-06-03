package com.qcloud.component.form.web.handler;

import java.util.List;

import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.web.vo.FormTableMappingVO;
import com.qcloud.component.form.web.vo.admin.AdminFormTableMappingVO;

public interface FormTableMappingHandler {

	List<FormTableMappingVO> toVOList(List<FormTableMapping> list);

	FormTableMappingVO toVO(FormTableMapping formTableMapping);

	List<AdminFormTableMappingVO> toVOList4Admin(List<FormTableMapping> list);

	AdminFormTableMappingVO toVO4Admin(FormTableMapping formTableMapping);
}
