package com.qcloud.component.publicservice.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

public interface LoginLogMapper {

	@Insert("insert into `publicservice_login_log`(`id`,`consumerId`,`consumerType`,`time`,`ip`,`operate`)"
			+ " values(#{id},#{consumerId},#{consumerType},#{time},#{ip},#{operate})")
	public void insert(LoginLog loginLog);

	@Select("select * from `publicservice_login_log` where `id`=#{id}")
	public LoginLog get(Long id);

	@Update("update `publicservice_login_log` set `consumerId`=#{consumerId},`consumerType`=#{consumerType},`time`=#{time},`ip`=#{ip},`operate`=#{operate} where `id`=#{id}")
	public void update(LoginLog loginLog);

	@Delete("delete from `publicservice_login_log` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicservice_login_log` limit #{start},#{count}")
	public List<LoginLog> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicservice_login_log`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicservice_login_log`")
	public List<LoginLog> listAll();
}