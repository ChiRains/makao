package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.web.vo.PersonnelWarehouseVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminPersonnelWarehouseVO;

public interface PersonnelWarehouseHandler {

	List<PersonnelWarehouseVO> toVOList(List<PersonnelWarehouse> list);

	PersonnelWarehouseVO toVO(PersonnelWarehouse personnelWarehouse);

	List<AdminPersonnelWarehouseVO> toVOList4Admin(List<PersonnelWarehouse> list);

	AdminPersonnelWarehouseVO toVO4Admin(PersonnelWarehouse personnelWarehouse);
}
