package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

public interface ProfilesSuccessMapper {

	@Insert("insert into `macaovehicle_profiles_success`(`id`,`formInstanceId`,`carOwnerId`,`vehicleId`,`driverId`,`createDate`,`vEnable`,`dEnable`,`plateNumber`,`driverName`,`driverIdCard`,`models`,`idcardNumber`,`licenseNumber`,`sex`,`nation`)"
			+ " values(#{id},#{formInstanceId},#{carOwnerId},#{vehicleId},#{driverId},#{createDate},#{vEnable},#{dEnable},#{plateNumber},#{driverName},#{driverIdCard},#{models},#{idcardNumber},#{licenseNumber},#{sex},#{nation})")
	public void insert(ProfilesSuccess profilesSuccess);

	@Select("select * from `macaovehicle_profiles_success` where `id`=#{id}")
	public ProfilesSuccess get(Long id);

	@Update("update `macaovehicle_profiles_success` set `formInstanceId`=#{formInstanceId},`carOwnerId`=#{carOwnerId},`vehicleId`=#{vehicleId},`driverId`=#{driverId},`createDate`=#{createDate},`vEnable`=#{vEnable},`dEnable`=#{dEnable},`plateNumber`=#{plateNumber},`driverName`=#{driverName},`driverIdCard`=#{driverIdCard},`models`=#{models},`idcardNumber`=#{idcardNumber},`licenseNumber`=#{licenseNumber},`sex`=#{sex},`nation`=#{nation} where `id`=#{id}")
	public void update(ProfilesSuccess profilesSuccess);

	@Delete("delete from `macaovehicle_profiles_success` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_profiles_success` limit #{start},#{count}")
	public List<ProfilesSuccess> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_profiles_success`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_profiles_success`")
	public List<ProfilesSuccess> listAll();
}