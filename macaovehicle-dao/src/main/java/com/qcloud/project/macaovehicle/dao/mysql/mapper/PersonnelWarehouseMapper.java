package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.PersonnelWarehouse;
import com.qcloud.project.macaovehicle.model.query.PersonnelWarehouseQuery;

public interface PersonnelWarehouseMapper {

	@Insert("insert into `macaovehicle_personnel_warehouse`(`id`,`name`,`mobile`,`sex`,`address`,`email`,`idcardNumber`,`residence`,`time`,`type`,`departmentId`)"
			+ " values(#{id},#{name},#{mobile},#{sex},#{address},#{email},#{idcardNumber},#{residence},#{time},#{type},#{departmentId})")
	public void insert(PersonnelWarehouse personnelWarehouse);

	@Select("select * from `macaovehicle_personnel_warehouse` where `id`=#{id}")
	public PersonnelWarehouse get(Long id);

	@Update("update `macaovehicle_personnel_warehouse` set `name`=#{name},`mobile`=#{mobile},`sex`=#{sex},`address`=#{address},`email`=#{email},`idcardNumber`=#{idcardNumber},`residence`=#{residence},`time`=#{time},`type`=#{type},`departmentId`=#{departmentId} where `id`=#{id}")
	public void update(PersonnelWarehouse personnelWarehouse);

	@Delete("delete from `macaovehicle_personnel_warehouse` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_personnel_warehouse` limit #{start},#{count}")
	public List<PersonnelWarehouse> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_personnel_warehouse`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_personnel_warehouse`")
	public List<PersonnelWarehouse> listAll();
}