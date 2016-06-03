package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

public interface CarOwnerPurchaseMapper {

	@Insert("insert into `macaovehicle_car_owner_purchase`(`id`,`carOwnerId`,`company`,`code`,`operate`,`scale`,`represent`,`phone`,`address`,`time`,`license`,`tax`,`letter`,`operatingPeriod`,`organs`,`contacts`,`paymentUrl`,`commitmentUrl`,`representID`,`positiveUrl`,`oppositeUrl`)"
			+ " values(#{id},#{carOwnerId},#{company},#{code},#{operate},#{scale},#{represent},#{phone},#{address},#{time},#{license},#{tax},#{letter},#{operatingPeriod},#{organs},#{contacts},#{paymentUrl},#{commitmentUrl},#{representID},#{positiveUrl},#{oppositeUrl})")
	public void insert(CarOwnerPurchase carOwnerPurchase);

	@Select("select * from `macaovehicle_car_owner_purchase` where `id`=#{id}")
	public CarOwnerPurchase get(Long id);

	@Update("update `macaovehicle_car_owner_purchase` set `carOwnerId`=#{carOwnerId},`company`=#{company},`code`=#{code},`operate`=#{operate},`scale`=#{scale},`represent`=#{represent},`phone`=#{phone},`address`=#{address},`time`=#{time},`license`=#{license},`tax`=#{tax},`letter`=#{letter},`operatingPeriod`=#{operatingPeriod},`organs`=#{organs},`contacts`=#{contacts},`paymentUrl`=#{paymentUrl},`commitmentUrl`=#{commitmentUrl},`representID`=#{representID},`positiveUrl`=#{positiveUrl},`oppositeUrl`=#{oppositeUrl} where `id`=#{id}")
	public void update(CarOwnerPurchase carOwnerPurchase);

	@Delete("delete from `macaovehicle_car_owner_purchase` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_purchase` limit #{start},#{count}")
	public List<CarOwnerPurchase> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_purchase`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_purchase`")
	public List<CarOwnerPurchase> listAll();
}