package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;

public interface HistoryRecordsMapper {

	@Insert("insert into `macaovehicle_history_records`(`id`,`carOwnerId`,`updateParam`,`updateParamStr`,`oldValue`,`newValue`,`updateTime`,`clerkId`,`type`)"
			+ " values(#{id},#{carOwnerId},#{updateParam},#{updateParamStr},#{oldValue},#{newValue},#{updateTime},#{clerkId},#{type})")
	public void insert(HistoryRecords historyRecords);

	@Select("select * from `macaovehicle_history_records` where `id`=#{id}")
	public HistoryRecords get(Long id);

	@Update("update `macaovehicle_history_records` set `carOwnerId`=#{carOwnerId},`updateParam`=#{updateParam},`updateParamStr`=#{updateParamStr},`oldValue`=#{oldValue},`newValue`=#{newValue},`updateTime`=#{updateTime},`clerkId`=#{clerkId},`type`=#{type} where `id`=#{id}")
	public void update(HistoryRecords historyRecords);

	@Delete("delete from `macaovehicle_history_records` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_history_records` limit #{start},#{count}")
	public List<HistoryRecords> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_history_records`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_history_records`")
	public List<HistoryRecords> listAll();
}