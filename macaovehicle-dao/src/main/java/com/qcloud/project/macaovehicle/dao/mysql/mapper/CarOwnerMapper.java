package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;

public interface CarOwnerMapper {

	@Insert("insert into `macaovehicle_car_owner`(`id`,`userId`,`idcardNumber`,`address`,`residence`,`idcardBack`,`idcardFace`,`birthday`,`type`,`clerkType`,`mobile`,`email`,`name`,`certificateType`,`certificateNo`,`certificateDate`,`certificateUrl`,`sex`,`idCardValidTime`)"
			+ " values(#{id},#{userId},#{idcardNumber},#{address},#{residence},#{idcardBack},#{idcardFace},#{birthday},#{type},#{clerkType},#{mobile},#{email},#{name},#{certificateType},#{certificateNo},#{certificateDate},#{certificateUrl},#{sex},#{idCardValidTime})")
	public void insert(CarOwner carOwner);

	@Select("select * from `macaovehicle_car_owner` where `id`=#{id}")
	public CarOwner get(Long id);

	@Update("update `macaovehicle_car_owner` set `userId`=#{userId},`idcardNumber`=#{idcardNumber},`address`=#{address},`residence`=#{residence},`idcardBack`=#{idcardBack},`idcardFace`=#{idcardFace},`birthday`=#{birthday},`type`=#{type},`clerkType`=#{clerkType},`mobile`=#{mobile},`email`=#{email},`name`=#{name},`certificateType`=#{certificateType},`certificateNo`=#{certificateNo},`certificateDate`=#{certificateDate},`certificateUrl`=#{certificateUrl},`sex`=#{sex},`idCardValidTime`=#{idCardValidTime} where `id`=#{id}")
	public void update(CarOwner carOwner);

	@Delete("delete from `macaovehicle_car_owner` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner` limit #{start},#{count}")
	public List<CarOwner> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner`")
	public List<CarOwner> listAll();
}