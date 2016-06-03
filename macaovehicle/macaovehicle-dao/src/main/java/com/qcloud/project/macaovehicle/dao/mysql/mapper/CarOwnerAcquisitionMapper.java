package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

public interface CarOwnerAcquisitionMapper {

	@Insert("insert into `macaovehicle_car_owner_acquisition`(`id`,`carOwnerId`,`application`,`deadline`,`buyTime`,`contractUrl`)"
			+ " values(#{id},#{carOwnerId},#{application},#{deadline},#{buyTime},#{contractUrl})")
	public void insert(CarOwnerAcquisition carOwnerAcquisition);

	@Select("select * from `macaovehicle_car_owner_acquisition` where `id`=#{id}")
	public CarOwnerAcquisition get(Long id);

	@Update("update `macaovehicle_car_owner_acquisition` set `carOwnerId`=#{carOwnerId},`application`=#{application},`deadline`=#{deadline},`buyTime`=#{buyTime},`contractUrl`=#{contractUrl} where `id`=#{id}")
	public void update(CarOwnerAcquisition carOwnerAcquisition);

	@Delete("delete from `macaovehicle_car_owner_acquisition` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_owner_acquisition` limit #{start},#{count}")
	public List<CarOwnerAcquisition> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_owner_acquisition`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_owner_acquisition`")
	public List<CarOwnerAcquisition> listAll();
}