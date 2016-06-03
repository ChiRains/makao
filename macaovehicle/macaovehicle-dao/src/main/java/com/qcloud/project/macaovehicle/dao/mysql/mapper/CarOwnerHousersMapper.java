package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;

public interface CarOwnerHousersMapper {

	@Insert("insert into `macaovehicle_car_owner_housers`(`id`,`carOwnerId`,`property`,`application`,`situation`,`code`,`time`,`located`,`structure`,`floor`,`buildArea`,`totalArea`,`licenseNo`,`licenseUrl`,`method`)"
			+ " values(#{id},#{carOwnerId},#{property},#{application},#{situation},#{code},#{time},#{located},#{structure},#{floor},#{buildArea},#{totalArea},#{licenseNo},#{licenseUrl},#{method})")
	public void insert(CarOwnerHousers carOwnerHousers);

	@Select("select * from `macaovehicle_car_owner_housers` where `id`=#{id}")
	public CarOwnerHousers get(Long id);

	@Update("update `macaovehicle_car_owner_housers` set `carOwnerId`=#{carOwnerId},`property`=#{property},`application`=#{application},`situation`=#{situation},`code`=#{code},`time`=#{time},`located`=#{located},`structure`=#{structure},`floor`=#{floor},`buildArea`=#{buildArea},`totalArea`=#{totalArea},`licenseNo`=#{licenseNo},`licenseUrl`=#{licenseUrl},`method`=#{method} where `id`=#{id}")
	public void update(CarOwnerHousers carOwnerHousers);

	@Delete("delete from `macaovehicle_car_owner_housers` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_housers` limit #{start},#{count}")
	public List<CarOwnerHousers> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_housers`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_housers`")
	public List<CarOwnerHousers> listAll();
}