package com.qcloud.component.processtask.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.model.query.TaskedQuery;

public interface TaskedMapper {

	@Insert("insert into `processtask_tasked`(`id`,`taskingId`,`clerkId`,`creator`,`name`,`type`,`applyTime`,`receiveTime`,`dealTime`,`formId`,`formInstanceId`,`formInstanceHistId`,`processId`,`processInstId`,`workitemId`,`pcPageUrl`,`mobilePageUrl`,`creatorName`,`departmantName`,`processName`,`processState`,start,taskState)"
			+ " values(#{id},#{taskingId},#{clerkId},#{creator},#{name},#{type},#{applyTime},#{receiveTime},#{dealTime},#{formId},#{formInstanceId},#{formInstanceHistId},#{processId},#{processInstId},#{workitemId},#{pcPageUrl},#{mobilePageUrl},#{creatorName},#{departmantName},#{processName},#{processState},#{start},#{taskState})")
	public void insert(Tasked tasked);

	@Select("select * from `processtask_tasked` where `id`=#{id}")
	public Tasked get(Long id);

	@Update("update `processtask_tasked` set `taskingId`=#{taskingId},`clerkId`=#{clerkId},`creator`=#{creator},`name`=#{name},`type`=#{type},`applyTime`=#{applyTime},`receiveTime`=#{receiveTime},`dealTime`=#{dealTime},`formId`=#{formId},`formInstanceId`=#{formInstanceId},`formInstanceHistId`=#{formInstanceHistId},`processId`=#{processId},`processInstId`=#{processInstId},`workitemId`=#{workitemId},`pcPageUrl`=#{pcPageUrl},`mobilePageUrl`=#{mobilePageUrl},`creatorName`=#{creatorName},`departmantName`=#{departmantName},`processName`=#{processName},`processState`=#{processState},`start`=#{start},`taskState`=#{taskState} where `id`=#{id}")
	public void update(Tasked tasked);

	@Delete("delete from `processtask_tasked` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `processtask_tasked` limit #{start},#{count}")
	public List<Tasked> list4page(Map<String,Object> param);

	@Select("select count(*) from `processtask_tasked`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `processtask_tasked`")
	public List<Tasked> listAll();
}