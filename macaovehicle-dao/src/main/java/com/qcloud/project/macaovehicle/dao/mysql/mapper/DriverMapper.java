package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

public interface DriverMapper {

	@Insert("insert into `macaovehicle_driver`(`id`,`carOwnerId`,`licenseNumber`,`licenseStartTime`,`licenseImage`,`driverName`,`seconddrivername`,`driverPhone`,`driverIdCard`,`driverAddress`,`idcardValidTime`,`licenseValidTime`,`quasi`,`idcardFace`,`idcardBack`,`certificateType`,`certificateNo`,`certificateDate`,`certificateUrl`,`inchImage`,`birthday`,`secondbirthday`,`sex`,`nation`,`endorsementType`,`endorsementOrgCode`,`endorsementValidtime`,`endorsementStay`,`gotoCountry`,`comefromCountry`,`nationCode`,`endorsementCode`,`healthCard`,`healthCardImg`,`driverworkplace`,`driverIc`,`driverIcState`,`updateTime`)"
			+ " values(#{id},#{carOwnerId},#{licenseNumber},#{licenseStartTime},#{licenseImage},#{driverName},#{seconddrivername},#{driverPhone},#{driverIdCard},#{driverAddress},#{idcardValidTime},#{licenseValidTime},#{quasi},#{idcardFace},#{idcardBack},#{certificateType},#{certificateNo},#{certificateDate},#{certificateUrl},#{inchImage},#{birthday},#{secondbirthday},#{sex},#{nation},#{endorsementType},#{endorsementOrgCode},#{endorsementValidtime},#{endorsementStay},#{gotoCountry},#{comefromCountry},#{nationCode},#{endorsementCode},#{healthCard},#{healthCardImg},#{driverworkplace},#{driverIc},#{driverIcState},#{updateTime})")
	public void insert(Driver driver);

	@Select("select * from `macaovehicle_driver` where `id`=#{id}")
	public Driver get(Long id);

	@Update("update `macaovehicle_driver` set `carOwnerId`=#{carOwnerId},`licenseNumber`=#{licenseNumber},`licenseStartTime`=#{licenseStartTime},`licenseImage`=#{licenseImage},`driverName`=#{driverName},`seconddrivername`=#{seconddrivername},`driverPhone`=#{driverPhone},`driverIdCard`=#{driverIdCard},`driverAddress`=#{driverAddress},`idcardValidTime`=#{idcardValidTime},`licenseValidTime`=#{licenseValidTime},`quasi`=#{quasi},`idcardFace`=#{idcardFace},`idcardBack`=#{idcardBack},`certificateType`=#{certificateType},`certificateNo`=#{certificateNo},`certificateDate`=#{certificateDate},`certificateUrl`=#{certificateUrl},`inchImage`=#{inchImage},`birthday`=#{birthday},`secondbirthday`=#{secondbirthday},`sex`=#{sex},`nation`=#{nation},`endorsementType`=#{endorsementType},`endorsementOrgCode`=#{endorsementOrgCode},`endorsementValidtime`=#{endorsementValidtime},`endorsementStay`=#{endorsementStay},`gotoCountry`=#{gotoCountry},`comefromCountry`=#{comefromCountry},`nationCode`=#{nationCode},`endorsementCode`=#{endorsementCode},`healthCard`=#{healthCard},`healthCardImg`=#{healthCardImg},`driverworkplace`=#{driverworkplace},`driverIc`=#{driverIc},`driverIcState`=#{driverIcState},`updateTime`=#{updateTime} where `id`=#{id}")
	public void update(Driver driver);

	@Delete("delete from `macaovehicle_driver` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_driver` limit #{start},#{count}")
	public List<Driver> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_driver`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_driver`")
	public List<Driver> listAll();
}