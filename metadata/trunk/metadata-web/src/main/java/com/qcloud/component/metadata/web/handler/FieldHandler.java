package com.qcloud.component.metadata.web.handler;

import java.util.List;

import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.web.vo.FieldVO;
import com.qcloud.component.metadata.web.vo.admin.AdminFieldVO;

public interface FieldHandler {

	List<FieldVO> toVOList(List<Field> list);

	FieldVO toVO(Field field);

	List<AdminFieldVO> toVOList4Admin(List<Field> list);

	AdminFieldVO toVO4Admin(Field field);
}
