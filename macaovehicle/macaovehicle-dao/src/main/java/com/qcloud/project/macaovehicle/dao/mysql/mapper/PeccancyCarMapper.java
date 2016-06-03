package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;

public interface PeccancyCarMapper {

	@Insert("insert into `macaovehicle_peccancy_car`(`id`,`outsidePlate`,`temporaryPlate`,`time`,`code`,`place`,`behavior`,`isPublish`,`creatorId`,`createTime`)"
			+ " values(#{id},#{outsidePlate},#{temporaryPlate},#{time},#{code},#{place},#{behavior},#{isPublish},#{creatorId},#{createTime})")
	public void insert(PeccancyCar peccancyCar);

	@Select("select * from `macaovehicle_peccancy_car` where `id`=#{id}")
	public PeccancyCar get(Long id);

	@Update("update `macaovehicle_peccancy_car` set `outsidePlate`=#{outsidePlate},`temporaryPlate`=#{temporaryPlate},`time`=#{time},`code`=#{code},`place`=#{place},`behavior`=#{behavior},`isPublish`=#{isPublish},`creatorId`=#{creatorId},`createTime`=#{createTime} where `id`=#{id}")
	public void update(PeccancyCar peccancyCar);

	@Delete("delete from `macaovehicle_peccancy_car` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_peccancy_car` limit #{start},#{count}")
	public List<PeccancyCar> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_peccancy_car`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_peccancy_car`")
	public List<PeccancyCar> listAll();
}