package com.qcloud.component.metadata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.metadata.web.handler.TableHandler;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.web.vo.TableVO;
import com.qcloud.component.metadata.web.vo.admin.AdminTableVO;

@Component
public class TableHandlerImpl implements TableHandler {

	@Override
	public List<TableVO> toVOList(List<Table> list){
		List<TableVO> voList = new ArrayList<TableVO>();
		for (Table table : list) {
			voList.add(toVO(table));
		}
		return voList;
	}

	@Override
	public TableVO toVO(Table table){
		String json = Json.toJson(table);
		return Json.toObject(json, TableVO.class, true);

	}

	@Override
	public List<AdminTableVO> toVOList4Admin(List<Table> list){
		List<AdminTableVO> voList = new ArrayList<AdminTableVO>();
		for (Table adminTable : list) {
			voList.add(toVO4Admin(adminTable));
		}
		return voList;
	}

	@Override
	public AdminTableVO toVO4Admin(Table table){
		String json = Json.toJson(table);
		return Json.toObject(json, AdminTableVO.class, true);
	}
}
