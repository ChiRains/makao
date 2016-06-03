package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

public interface CarOwnerWorkersMapper {

	@Insert("insert into `macaovehicle_car_owner_workers`(`id`,`carOwnerId`,`company`,`fixedLine`,`address`,`phone`,`consignee`,`position`,`workCertificate`,`code`,`time`,`entryTime`,`contractUrl`,`insuranceFeeUrl`)"
			+ " values(#{id},#{carOwnerId},#{company},#{fixedLine},#{address},#{phone},#{consignee},#{position},#{workCertificate},#{code},#{time},#{entryTime},#{contractUrl},#{insuranceFeeUrl})")
	public void insert(CarOwnerWorkers carOwnerWorkers);

	@Select("select * from `macaovehicle_car_owner_workers` where `id`=#{id}")
	public CarOwnerWorkers get(Long id);

	@Update("update `macaovehicle_car_owner_workers` set `carOwnerId`=#{carOwnerId},`company`=#{company},`fixedLine`=#{fixedLine},`address`=#{address},`phone`=#{phone},`consignee`=#{consignee},`position`=#{position},`workCertificate`=#{workCertificate},`code`=#{code},`time`=#{time},`entryTime`=#{entryTime},`contractUrl`=#{contractUrl},`insuranceFeeUrl`=#{insuranceFeeUrl} where `id`=#{id}")
	public void update(CarOwnerWorkers carOwnerWorkers);

	@Delete("delete from `macaovehicle_car_owner_workers` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_workers` limit #{start},#{count}")
	public List<CarOwnerWorkers> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_workers`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_workers`")
	public List<CarOwnerWorkers> listAll();
}