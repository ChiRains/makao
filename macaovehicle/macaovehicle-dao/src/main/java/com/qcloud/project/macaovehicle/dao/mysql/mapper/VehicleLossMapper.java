package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

public interface VehicleLossMapper {

	@Insert("insert into `macaovehicle_vehicle_loss`(`id`,`formInstCode`,`carOwnerId`,`vehicleId`,`oldRic`,`newRic`,`lossTime`,`recordTime`,`type`,`plateNumber`)"
			+ " values(#{id},#{formInstCode},#{carOwnerId},#{vehicleId},#{oldRic},#{newRic},#{lossTime},#{recordTime},#{type},#{plateNumber})")
	public void insert(VehicleLoss vehicleLoss);

	@Select("select * from `macaovehicle_vehicle_loss` where `id`=#{id}")
	public VehicleLoss get(Long id);

	@Update("update `macaovehicle_vehicle_loss` set `formInstCode`=#{formInstCode},`carOwnerId`=#{carOwnerId},`vehicleId`=#{vehicleId},`oldRic`=#{oldRic},`newRic`=#{newRic},`lossTime`=#{lossTime},`recordTime`=#{recordTime},`type`=#{type},`plateNumber`=#{plateNumber} where `id`=#{id}")
	public void update(VehicleLoss vehicleLoss);

	@Delete("delete from `macaovehicle_vehicle_loss` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_vehicle_loss` limit #{start},#{count}")
	public List<VehicleLoss> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_vehicle_loss`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_vehicle_loss`")
	public List<VehicleLoss> listAll();
}