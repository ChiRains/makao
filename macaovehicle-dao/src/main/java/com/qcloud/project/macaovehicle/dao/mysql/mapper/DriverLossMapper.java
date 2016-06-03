package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

public interface DriverLossMapper {

	@Insert("insert into `macaovehicle_driver_loss`(`id`,`formInstCode`,`carOwnerId`,`driverId`,`oldDriverIc`,`newDriverIc`,`lossTime`,`recordTime`,`type`)"
			+ " values(#{id},#{formInstCode},#{carOwnerId},#{driverId},#{oldDriverIc},#{newDriverIc},#{lossTime},#{recordTime},#{type})")
	public void insert(DriverLoss driverLoss);

	@Select("select * from `macaovehicle_driver_loss` where `id`=#{id}")
	public DriverLoss get(Long id);

	@Update("update `macaovehicle_driver_loss` set `formInstCode`=#{formInstCode},`carOwnerId`=#{carOwnerId},`driverId`=#{driverId},`oldDriverIc`=#{oldDriverIc},`newDriverIc`=#{newDriverIc},`lossTime`=#{lossTime},`recordTime`=#{recordTime},`type`=#{type} where `id`=#{id}")
	public void update(DriverLoss driverLoss);

	@Delete("delete from `macaovehicle_driver_loss` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_driver_loss` limit #{start},#{count}")
	public List<DriverLoss> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_driver_loss`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_driver_loss`")
	public List<DriverLoss> listAll();
}