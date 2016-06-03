package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

public interface VehicleMapper {

	@Insert("insert into `macaovehicle_vehicle`(`id`,`carOwnerId`,`plateNumber`,`licenseNumber`,`licenseImage`,`brand`,`specification`,`models`,`authority`,`buyTime`,`ownerName`,`ownerPhone`,`ownerAddress`,`engineNumber`,`frameNumber`,`steeringWheel`,`startTime`,`weight`,`length`,`height`,`width`,`color`,`type`,`capacity`,`seat`,`backupWheel`,`faceWheel`,`backWheel`,`registTime`,`faceImage`,`leftfaceImage`,`rightfaceImage`,`leftbackImage`,`rightbackImage`,`area`,`engineNo`,`permittedWeight`,`passengers`,`effectiveDates`,`endDates`,`insuranceUrl`,`state`,`ric`,`approveTime`,`temporaryplate`,`ricState`,`temState`,`indicators`,`indicatorsTime`,`temporaryplated`)"
			+ " values(#{id},#{carOwnerId},#{plateNumber},#{licenseNumber},#{licenseImage},#{brand},#{specification},#{models},#{authority},#{buyTime},#{ownerName},#{ownerPhone},#{ownerAddress},#{engineNumber},#{frameNumber},#{steeringWheel},#{startTime},#{weight},#{length},#{height},#{width},#{color},#{type},#{capacity},#{seat},#{backupWheel},#{faceWheel},#{backWheel},#{registTime},#{faceImage},#{leftfaceImage},#{rightfaceImage},#{leftbackImage},#{rightbackImage},#{area},#{engineNo},#{permittedWeight},#{passengers},#{effectiveDates},#{endDates},#{insuranceUrl},#{state},#{ric},#{approveTime},#{temporaryplate},#{ricState},#{temState},#{indicators},#{indicatorsTime},#{temporaryplated})")
	public void insert(Vehicle vehicle);

	@Select("select * from `macaovehicle_vehicle` where `id`=#{id}")
	public Vehicle get(Long id);

	@Update("update `macaovehicle_vehicle` set `carOwnerId`=#{carOwnerId},`plateNumber`=#{plateNumber},`licenseNumber`=#{licenseNumber},`licenseImage`=#{licenseImage},`brand`=#{brand},`specification`=#{specification},`models`=#{models},`authority`=#{authority},`buyTime`=#{buyTime},`ownerName`=#{ownerName},`ownerPhone`=#{ownerPhone},`ownerAddress`=#{ownerAddress},`engineNumber`=#{engineNumber},`frameNumber`=#{frameNumber},`steeringWheel`=#{steeringWheel},`startTime`=#{startTime},`weight`=#{weight},`length`=#{length},`height`=#{height},`width`=#{width},`color`=#{color},`type`=#{type},`capacity`=#{capacity},`seat`=#{seat},`backupWheel`=#{backupWheel},`faceWheel`=#{faceWheel},`backWheel`=#{backWheel},`registTime`=#{registTime},`faceImage`=#{faceImage},`leftfaceImage`=#{leftfaceImage},`rightfaceImage`=#{rightfaceImage},`leftbackImage`=#{leftbackImage},`rightbackImage`=#{rightbackImage},`area`=#{area},`engineNo`=#{engineNo},`permittedWeight`=#{permittedWeight},`passengers`=#{passengers},`effectiveDates`=#{effectiveDates},`endDates`=#{endDates},`insuranceUrl`=#{insuranceUrl},`state`=#{state},`ric`=#{ric},`approveTime`=#{approveTime},`temporaryplate`=#{temporaryplate},`ricState`=#{ricState},`temState`=#{temState},`indicators`=#{indicators},`indicatorsTime`=#{indicatorsTime},`temporaryplated`=#{temporaryplated} where `id`=#{id}")
	public void update(Vehicle vehicle);

	@Delete("delete from `macaovehicle_vehicle` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_vehicle` limit #{start},#{count}")
	public List<Vehicle> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_vehicle`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_vehicle`")
	public List<Vehicle> listAll();
}