package com.qcloud.component.mvprocesstask.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;

public interface TaskedMapper {

	@Insert("insert into `mvprocesstask_tasked`(`id`,`taskingId`,`clerkId`,`creator`,`name`,`type`,`applyTime`,`receiveTime`,`dealTime`,`formId`,`formInstanceId`,`formInstanceHistId`,`processId`,`processInstId`,`workitemId`,`pcPageUrl`,`code`,`applyType`,`clerkType`,`clerkName`,`idCard`,`companyName`,`companyCode`,`plateNumber`,`indicatorsNo`,`indicatorsTime`,`indicatorsPeriod`,`ownerName`,`vehicleType`,`specification`,`engineNo`,`frameNumber`,`permittedWeight`,`passengers`,`brand`,`status`,`operatorClerkId`,`recordTime`,`temporaryplate`,`formInstCode`,`departmentId`)"
			+ " values(#{id},#{taskingId},#{clerkId},#{creator},#{name},#{type},#{applyTime},#{receiveTime},#{dealTime},#{formId},#{formInstanceId},#{formInstanceHistId},#{processId},#{processInstId},#{workitemId},#{pcPageUrl},#{code},#{applyType},#{clerkType},#{clerkName},#{idCard},#{companyName},#{companyCode},#{plateNumber},#{indicatorsNo},#{indicatorsTime},#{indicatorsPeriod},#{ownerName},#{vehicleType},#{specification},#{engineNo},#{frameNumber},#{permittedWeight},#{passengers},#{brand},#{status},#{operatorClerkId},#{recordTime},#{temporaryplate},#{formInstCode},#{departmentId})")
	public void insert(Tasked tasked);

	@Select("select * from `mvprocesstask_tasked` where `id`=#{id}")
	public Tasked get(Long id);

	@Update("update `mvprocesstask_tasked` set `taskingId`=#{taskingId},`clerkId`=#{clerkId},`creator`=#{creator},`name`=#{name},`type`=#{type},`applyTime`=#{applyTime},`receiveTime`=#{receiveTime},`dealTime`=#{dealTime},`formId`=#{formId},`formInstanceId`=#{formInstanceId},`formInstanceHistId`=#{formInstanceHistId},`processId`=#{processId},`processInstId`=#{processInstId},`workitemId`=#{workitemId},`pcPageUrl`=#{pcPageUrl},`code`=#{code},`applyType`=#{applyType},`clerkType`=#{clerkType},`clerkName`=#{clerkName},`idCard`=#{idCard},`companyName`=#{companyName},`companyCode`=#{companyCode},`plateNumber`=#{plateNumber},`indicatorsNo`=#{indicatorsNo},`indicatorsTime`=#{indicatorsTime},`indicatorsPeriod`=#{indicatorsPeriod},`ownerName`=#{ownerName},`vehicleType`=#{vehicleType},`specification`=#{specification},`engineNo`=#{engineNo},`frameNumber`=#{frameNumber},`permittedWeight`=#{permittedWeight},`passengers`=#{passengers},`brand`=#{brand},`status`=#{status},`operatorClerkId`=#{operatorClerkId},`recordTime`=#{recordTime},`temporaryplate`=#{temporaryplate},`formInstCode`=#{formInstCode},`departmentId`=#{departmentId} where `id`=#{id}")
	public void update(Tasked tasked);

	@Delete("delete from `mvprocesstask_tasked` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `mvprocesstask_tasked` limit #{start},#{count}")
	public List<Tasked> list4page(Map<String,Object> param);

	@Select("select count(*) from `mvprocesstask_tasked`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `mvprocesstask_tasked`")
	public List<Tasked> listAll();
}