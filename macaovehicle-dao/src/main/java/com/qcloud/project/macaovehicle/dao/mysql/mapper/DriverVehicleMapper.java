package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;

public interface DriverVehicleMapper {

	@Insert("insert into `macaovehicle_driver_vehicle`(`id`,`formInstCode`,`vehicleId`,`driverId`,`ric`,`driverIc`,`isPrimary`,`carOwnerId`,`createDate`,`modifier`,`modifyDate`,`state`,`type`,`formInstanceId`,`temporaryPlate`,`indicatorsNo`,`indicatorsTime`)"
			+ " values(#{id},#{formInstCode},#{vehicleId},#{driverId},#{ric},#{driverIc},#{isPrimary},#{carOwnerId},#{createDate},#{modifier},#{modifyDate},#{state},#{type},#{formInstanceId},#{temporaryPlate},#{indicatorsNo},#{indicatorsTime})")
	public void insert(DriverVehicle driverVehicle);

	@Select("select * from `macaovehicle_driver_vehicle` where `id`=#{id}")
	public DriverVehicle get(Long id);

	@Update("update `macaovehicle_driver_vehicle` set `formInstCode`=#{formInstCode},`vehicleId`=#{vehicleId},`driverId`=#{driverId},`ric`=#{ric},`driverIc`=#{driverIc},`isPrimary`=#{isPrimary},`carOwnerId`=#{carOwnerId},`createDate`=#{createDate},`modifier`=#{modifier},`modifyDate`=#{modifyDate},`state`=#{state},`type`=#{type},`formInstanceId`=#{formInstanceId},`temporaryPlate`=#{temporaryPlate},`indicatorsNo`=#{indicatorsNo},`indicatorsTime`=#{indicatorsTime} where `id`=#{id}")
	public void update(DriverVehicle driverVehicle);

	@Delete("delete from `macaovehicle_driver_vehicle` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_driver_vehicle` limit #{start},#{count}")
	public List<DriverVehicle> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_driver_vehicle`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_driver_vehicle`")
	public List<DriverVehicle> listAll();
}