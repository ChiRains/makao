package com.qcloud.component.processtask.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.model.query.TaskingQuery;

public interface TaskingMapper {

	@Insert("insert into `processtask_tasking`(`id`,`clerkId`,`creator`,`name`,`type`,`applyTime`,`receiveTime`,`formId`,`formInstanceId`,`processId`,`processInstId`,`workitemId`,`pcPageUrl`,`mobilePageUrl`,`creatorName`,`departmantName`,`processName`,start)"
			+ " values(#{id},#{clerkId},#{creator},#{name},#{type},#{applyTime},#{receiveTime},#{formId},#{formInstanceId},#{processId},#{processInstId},#{workitemId},#{pcPageUrl},#{mobilePageUrl},#{creatorName},#{departmantName},#{processName},#{start})")
	public void insert(Tasking tasking);

	@Select("select * from `processtask_tasking` where `id`=#{id}")
	public Tasking get(Long id);

	@Update("update `processtask_tasking` set `clerkId`=#{clerkId},`creator`=#{creator},`name`=#{name},`type`=#{type},`applyTime`=#{applyTime},`receiveTime`=#{receiveTime},`formId`=#{formId},`formInstanceId`=#{formInstanceId},`processId`=#{processId},`processInstId`=#{processInstId},`workitemId`=#{workitemId},`pcPageUrl`=#{pcPageUrl},`mobilePageUrl`=#{mobilePageUrl},`creatorName`=#{creatorName},`departmantName`=#{departmantName},`processName`=#{processName},`start`=#{start} where `id`=#{id}")
	public void update(Tasking tasking);

	@Delete("delete from `processtask_tasking` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `processtask_tasking` limit #{start},#{count}")
	public List<Tasking> list4page(Map<String,Object> param);

	@Select("select count(*) from `processtask_tasking`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `processtask_tasking`")
	public List<Tasking> listAll();
}