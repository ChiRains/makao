package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

public interface OnestopCarRecordMapper {

	@Insert("insert into `macaovehicle_onestop_car_record`(`id`,`dCardid`,`vCardid`,`date`,`gate`,`type`)"
			+ " values(#{id},#{dCardid},#{vCardid},#{date},#{gate},#{type})")
	public void insert(OnestopCarRecord onestopCarRecord);

	@Select("select * from `macaovehicle_onestop_car_record` where `id`=#{id}")
	public OnestopCarRecord get(Long id);

	@Update("update `macaovehicle_onestop_car_record` set `dCardid`=#{dCardid},`vCardid`=#{vCardid},`date`=#{date},`gate`=#{gate},`type`=#{type} where `id`=#{id}")
	public void update(OnestopCarRecord onestopCarRecord);

	@Delete("delete from `macaovehicle_onestop_car_record` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_onestop_car_record` limit #{start},#{count}")
	public List<OnestopCarRecord> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_onestop_car_record`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_onestop_car_record`")
	public List<OnestopCarRecord> listAll();
}