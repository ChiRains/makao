package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

public interface CarOwnerIndicatorsMapper {

	@Insert("insert into `macaovehicle_car_owner_indicators`(`id`,`vehicleId`,`indicatorsNo`,`userName`,`validityPeriod`)"
			+ " values(#{id},#{vehicleId},#{indicatorsNo},#{userName},#{validityPeriod})")
	public void insert(CarOwnerIndicators carOwnerIndicators);

	@Select("select * from `macaovehicle_car_owner_indicators` where `id`=#{id}")
	public CarOwnerIndicators get(Long id);

	@Update("update `macaovehicle_car_owner_indicators` set `vehicleId`=#{vehicleId},`indicatorsNo`=#{indicatorsNo},`userName`=#{userName},`validityPeriod`=#{validityPeriod} where `id`=#{id}")
	public void update(CarOwnerIndicators carOwnerIndicators);

	@Delete("delete from `macaovehicle_car_owner_indicators` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_indicators` limit #{start},#{count}")
	public List<CarOwnerIndicators> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_indicators`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_indicators`")
	public List<CarOwnerIndicators> listAll();
}