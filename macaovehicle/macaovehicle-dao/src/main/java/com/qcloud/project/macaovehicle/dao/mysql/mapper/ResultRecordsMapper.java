package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.ResultRecords;
import com.qcloud.project.macaovehicle.model.query.ResultRecordsQuery;

public interface ResultRecordsMapper {

	@Insert("insert into `macaovehicle_result_records`(`id`,`resultsId`,`state`,`newState`,`time`)"
			+ " values(#{id},#{resultsId},#{state},#{newState},#{time})")
	public void insert(ResultRecords resultRecords);

	@Select("select * from `macaovehicle_result_records` where `macaovehicle_result_records`=#{macaovehicle_result_records}")
	public ResultRecords get(Integer macaovehicleResultRecordsId);

	@Update("update `macaovehicle_result_records` set `id`=#{id},`resultsId`=#{resultsId},`state`=#{state},`newState`=#{newState},`time`=#{time} where `macaovehicle_result_records`=#{macaovehicle_result_records}")
	public void update(ResultRecords resultRecords);

	@Delete("delete from `macaovehicle_result_records` where `macaovehicle_result_records`=#{macaovehicle_result_records}")
	public void delete(Integer macaovehicleResultRecordsId);

	@Select("select * from `macaovehicle_result_records` limit #{start},#{count}")
	public List<ResultRecords> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_result_records`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_result_records`")
	public List<ResultRecords> listAll();
}