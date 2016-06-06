package com.qcloud.component.metadata.web.handler;

import java.util.List;

import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.web.vo.TableVO;
import com.qcloud.component.metadata.web.vo.admin.AdminTableVO;

public interface TableHandler {

	List<TableVO> toVOList(List<Table> list);

	TableVO toVO(Table table);

	List<AdminTableVO> toVOList4Admin(List<Table> list);

	AdminTableVO toVO4Admin(Table table);
}
