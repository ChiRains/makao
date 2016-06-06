package com.qcloud.component.mvprocesstask.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.mvprocesstask.model.Tasking;

public interface TaskingMapper {

	@Insert("insert into `mvprocesstask_tasking`(`id`,`clerkId`,`creator`,`name`,`type`,`applyTime`,`receiveTime`,`formId`,`formInstanceId`,`processId`,`processInstId`,`workitemId`,`pcPageUrl`,`code`,`applyType`,`clerkType`,`clerkName`,`idCard`,`companyName`,`companyCode`,`plateNumber`,`indicatorsNo`,`indicatorsTime`,`indicatorsPeriod`,`ownerName`,`vehicleType`,`specification`,`engineNo`,`frameNumber`,`permittedWeight`,`passengers`,`brand`,`temporaryplate`,`formInstCode`,`departmentId`)"
			+ " values(#{id},#{clerkId},#{creator},#{name},#{type},#{applyTime},#{receiveTime},#{formId},#{formInstanceId},#{processId},#{processInstId},#{workitemId},#{pcPageUrl},#{code},#{applyType},#{clerkType},#{clerkName},#{idCard},#{companyName},#{companyCode},#{plateNumber},#{indicatorsNo},#{indicatorsTime},#{indicatorsPeriod},#{ownerName},#{vehicleType},#{specification},#{engineNo},#{frameNumber},#{permittedWeight},#{passengers},#{brand},#{temporaryplate},#{formInstCode},#{departmentId})")
	public void insert(Tasking tasking);

	@Select("select * from `mvprocesstask_tasking` where `id`=#{id}")
	public Tasking get(Long id);

	@Update("update `mvprocesstask_tasking` set `clerkId`=#{clerkId},`creator`=#{creator},`name`=#{name},`type`=#{type},`applyTime`=#{applyTime},`receiveTime`=#{receiveTime},`formId`=#{formId},`formInstanceId`=#{formInstanceId},`processId`=#{processId},`processInstId`=#{processInstId},`workitemId`=#{workitemId},`pcPageUrl`=#{pcPageUrl},`code`=#{code},`applyType`=#{applyType},`clerkType`=#{clerkType},`clerkName`=#{clerkName},`idCard`=#{idCard},`companyName`=#{companyName},`companyCode`=#{companyCode},`plateNumber`=#{plateNumber},`indicatorsNo`=#{indicatorsNo},`indicatorsTime`=#{indicatorsTime},`indicatorsPeriod`=#{indicatorsPeriod},`ownerName`=#{ownerName},`vehicleType`=#{vehicleType},`specification`=#{specification},`engineNo`=#{engineNo},`frameNumber`=#{frameNumber},`permittedWeight`=#{permittedWeight},`passengers`=#{passengers},`brand`=#{brand},`temporaryplate`=#{temporaryplate},`formInstCode`=#{formInstCode},`departmentId`=#{departmentId} where `id`=#{id}")
	public void update(Tasking tasking);

	@Delete("delete from `mvprocesstask_tasking` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `mvprocesstask_tasking` limit #{start},#{count}")
	public List<Tasking> list4page(Map<String,Object> param);

	@Select("select count(*) from `mvprocesstask_tasking`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `mvprocesstask_tasking`")
	public List<Tasking> listAll();
}