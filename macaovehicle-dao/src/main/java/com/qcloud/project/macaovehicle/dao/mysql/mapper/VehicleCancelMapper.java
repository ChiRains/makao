package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

public interface VehicleCancelMapper {

	@Insert("insert into `macaovehicle_vehicle_cancel`(`id`,`formInstCode`,`carOwnerId`,`vehicleId`,`ric`,`plateNumber`,`temporaryplate`,`recordTime`,`state`)"
			+ " values(#{id},#{formInstCode},#{carOwnerId},#{vehicleId},#{ric},#{plateNumber},#{temporaryplate},#{recordTime},#{state})")
	public void insert(VehicleCancel vehicleCancel);

	@Select("select * from `macaovehicle_vehicle_cancel` where `id`=#{id}")
	public VehicleCancel get(Long id);

	@Update("update `macaovehicle_vehicle_cancel` set `formInstCode`=#{formInstCode},`carOwnerId`=#{carOwnerId},`vehicleId`=#{vehicleId},`ric`=#{ric},`plateNumber`=#{plateNumber},`temporaryplate`=#{temporaryplate},`recordTime`=#{recordTime},`state`=#{state} where `id`=#{id}")
	public void update(VehicleCancel vehicleCancel);

	@Delete("delete from `macaovehicle_vehicle_cancel` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_vehicle_cancel` limit #{start},#{count}")
	public List<VehicleCancel> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_vehicle_cancel`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_vehicle_cancel`")
	public List<VehicleCancel> listAll();
}