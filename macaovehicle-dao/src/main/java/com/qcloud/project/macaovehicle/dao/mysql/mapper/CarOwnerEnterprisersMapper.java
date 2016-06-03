package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

public interface CarOwnerEnterprisersMapper {

	@Insert("insert into `macaovehicle_car_owner_enterprisers`(`id`,`carOwnerId`,`company`,`code`,`operate`,`scale`,`represent`,`phone`,`address`,`time`,`license`,`tax`,`letter`,`operatingPeriod`,`organs`,`contacts`,`paymentUrl`,`commitmentUrl`,`representID`,`positiveUrl`,`oppositeUrl`)"
			+ " values(#{id},#{carOwnerId},#{company},#{code},#{operate},#{scale},#{represent},#{phone},#{address},#{time},#{license},#{tax},#{letter},#{operatingPeriod},#{organs},#{contacts},#{paymentUrl},#{commitmentUrl},#{representID},#{positiveUrl},#{oppositeUrl})")
	public void insert(CarOwnerEnterprisers carOwnerEnterprisers);

	@Select("select * from `macaovehicle_car_owner_enterprisers` where `id`=#{id}")
	public CarOwnerEnterprisers get(Long id);

	@Update("update `macaovehicle_car_owner_enterprisers` set `carOwnerId`=#{carOwnerId},`company`=#{company},`code`=#{code},`operate`=#{operate},`scale`=#{scale},`represent`=#{represent},`phone`=#{phone},`address`=#{address},`time`=#{time},`license`=#{license},`tax`=#{tax},`letter`=#{letter},`operatingPeriod`=#{operatingPeriod},`organs`=#{organs},`contacts`=#{contacts},`paymentUrl`=#{paymentUrl},`commitmentUrl`=#{commitmentUrl},`representID`=#{representID},`positiveUrl`=#{positiveUrl},`oppositeUrl`=#{oppositeUrl} where `id`=#{id}")
	public void update(CarOwnerEnterprisers carOwnerEnterprisers);

	@Delete("delete from `macaovehicle_car_owner_enterprisers` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_enterprisers` limit #{start},#{count}")
	public List<CarOwnerEnterprisers> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_enterprisers`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_enterprisers`")
	public List<CarOwnerEnterprisers> listAll();
}