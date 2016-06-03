package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

public interface DriverCancelMapper {

	@Insert("insert into `macaovehicle_driver_cancel`(`id`,`formInstCode`,`carOwnerId`,`vehicleId`,`driverId`,`driverName`,`certificateType`,`certificateNo`,`plateNumber`,`temporaryplate`,`recordTime`,`driverIc`,`state`)"
			+ " values(#{id},#{formInstCode},#{carOwnerId},#{vehicleId},#{driverId},#{driverName},#{certificateType},#{certificateNo},#{plateNumber},#{temporaryplate},#{recordTime},#{driverIc},#{state})")
	public void insert(DriverCancel driverCancel);

	@Select("select * from `macaovehicle_driver_cancel` where `id`=#{id}")
	public DriverCancel get(Long id);

	@Update("update `macaovehicle_driver_cancel` set `formInstCode`=#{formInstCode},`carOwnerId`=#{carOwnerId},`vehicleId`=#{vehicleId},`driverId`=#{driverId},`driverName`=#{driverName},`certificateType`=#{certificateType},`certificateNo`=#{certificateNo},`plateNumber`=#{plateNumber},`temporaryplate`=#{temporaryplate},`recordTime`=#{recordTime},`driverIc`=#{driverIc},`state`=#{state} where `id`=#{id}")
	public void update(DriverCancel driverCancel);

	@Delete("delete from `macaovehicle_driver_cancel` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_driver_cancel` limit #{start},#{count}")
	public List<DriverCancel> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_driver_cancel`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_driver_cancel`")
	public List<DriverCancel> listAll();
}