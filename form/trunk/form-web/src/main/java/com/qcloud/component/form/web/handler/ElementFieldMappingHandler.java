package com.qcloud.component.form.web.handler;

import java.util.List;

import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.web.vo.ElementFieldMappingVO;
import com.qcloud.component.form.web.vo.admin.AdminElementFieldMappingVO;

public interface ElementFieldMappingHandler {

	List<ElementFieldMappingVO> toVOList(List<ElementFieldMapping> list);

	ElementFieldMappingVO toVO(ElementFieldMapping elementFieldMapping);

	List<AdminElementFieldMappingVO> toVOList4Admin(List<ElementFieldMapping> list);

	AdminElementFieldMappingVO toVO4Admin(ElementFieldMapping elementFieldMapping);
}
