package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

public interface CarOwnerTalentMapper {

	@Insert("insert into `macaovehicle_car_owner_talent`(`id`,`carOwnerId`,`company`,`fixedLine`,`address`,`phone`,`consignee`,`position`,`workCertificate`,`code`,`time`,`entryTime`,`contractUrl`,`insuranceFeeUrl`,`deptCertificateUrl`)"
			+ " values(#{id},#{carOwnerId},#{company},#{fixedLine},#{address},#{phone},#{consignee},#{position},#{workCertificate},#{code},#{time},#{entryTime},#{contractUrl},#{insuranceFeeUrl},#{deptCertificateUrl})")
	public void insert(CarOwnerTalent carOwnerTalent);

	@Select("select * from `macaovehicle_car_owner_talent` where `id`=#{id}")
	public CarOwnerTalent get(Long id);

	@Update("update `macaovehicle_car_owner_talent` set `carOwnerId`=#{carOwnerId},`company`=#{company},`fixedLine`=#{fixedLine},`address`=#{address},`phone`=#{phone},`consignee`=#{consignee},`position`=#{position},`workCertificate`=#{workCertificate},`code`=#{code},`time`=#{time},`entryTime`=#{entryTime},`contractUrl`=#{contractUrl},`insuranceFeeUrl`=#{insuranceFeeUrl},`deptCertificateUrl`=#{deptCertificateUrl} where `id`=#{id}")
	public void update(CarOwnerTalent carOwnerTalent);

	@Delete("delete from `macaovehicle_car_owner_talent` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_talent` limit #{start},#{count}")
	public List<CarOwnerTalent> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_talent`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_talent`")
	public List<CarOwnerTalent> listAll();
}