package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

public interface HistoryUserRecordsMapper {

	@Insert("insert into `macaovehicle_history_user_records`(`id`,`formInstCode`,`vehicleId`,`type`,`applyTime`,`finishTime`)"
			+ " values(#{id},#{formInstCode},#{vehicleId},#{type},#{applyTime},#{finishTime})")
	public void insert(HistoryUserRecords historyUserRecords);

	@Select("select * from `macaovehicle_history_user_records` where `id`=#{id}")
	public HistoryUserRecords get(Long id);

	@Update("update `macaovehicle_history_user_records` set `formInstCode`=#{formInstCode},`vehicleId`=#{vehicleId},`type`=#{type},`applyTime`=#{applyTime},`finishTime`=#{finishTime} where `id`=#{id}")
	public void update(HistoryUserRecords historyUserRecords);

	@Delete("delete from `macaovehicle_history_user_records` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_history_user_records` limit #{start},#{count}")
	public List<HistoryUserRecords> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_history_user_records`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_history_user_records`")
	public List<HistoryUserRecords> listAll();
}