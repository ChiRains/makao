package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

public interface TaskingBorderMapper {

	@Insert("insert into `macaovehicle_tasking_border`(`id`,`taskingId`,`clerkId`,`creator`,`name`,`type`,`applyTime`,`receiveTime`,`dealTime`,`formId`,`formInstanceId`,`formInstanceHistId`,`processId`,`processInstId`,`workitemId`,`pcPageUrl`,`code`,`applyType`,`clerkType`,`clerkName`,`idCard`,`companyName`,`companyCode`,`plateNumber`,`indicatorsNo`,`indicatorsTime`,`indicatorsPeriod`,`ownerName`,`vehicleType`,`specification`,`engineNo`,`frameNumber`,`permittedWeight`,`passengers`,`brand`,`fplateNumber`,`status`,`operatorClerkId`,`recordTime`,`temporaryplate`,`borderStatus`,`ciqStatus`,`customsStatus`,`reason`,`formInstCode`)"
			+ " values(#{id},#{taskingId},#{clerkId},#{creator},#{name},#{type},#{applyTime},#{receiveTime},#{dealTime},#{formId},#{formInstanceId},#{formInstanceHistId},#{processId},#{processInstId},#{workitemId},#{pcPageUrl},#{code},#{applyType},#{clerkType},#{clerkName},#{idCard},#{companyName},#{companyCode},#{plateNumber},#{indicatorsNo},#{indicatorsTime},#{indicatorsPeriod},#{ownerName},#{vehicleType},#{specification},#{engineNo},#{frameNumber},#{permittedWeight},#{passengers},#{brand},#{fplateNumber},#{status},#{operatorClerkId},#{recordTime},#{temporaryplate},#{borderStatus},#{ciqStatus},#{customsStatus},#{reason},#{formInstCode})")
	public void insert(TaskingBorder taskingBorder);

	@Select("select * from `macaovehicle_tasking_border` where `id`=#{id}")
	public TaskingBorder get(Long id);

	@Update("update `macaovehicle_tasking_border` set `taskingId`=#{taskingId},`clerkId`=#{clerkId},`creator`=#{creator},`name`=#{name},`type`=#{type},`applyTime`=#{applyTime},`receiveTime`=#{receiveTime},`dealTime`=#{dealTime},`formId`=#{formId},`formInstanceId`=#{formInstanceId},`formInstanceHistId`=#{formInstanceHistId},`processId`=#{processId},`processInstId`=#{processInstId},`workitemId`=#{workitemId},`pcPageUrl`=#{pcPageUrl},`code`=#{code},`applyType`=#{applyType},`clerkType`=#{clerkType},`clerkName`=#{clerkName},`idCard`=#{idCard},`companyName`=#{companyName},`companyCode`=#{companyCode},`plateNumber`=#{plateNumber},`indicatorsNo`=#{indicatorsNo},`indicatorsTime`=#{indicatorsTime},`indicatorsPeriod`=#{indicatorsPeriod},`ownerName`=#{ownerName},`vehicleType`=#{vehicleType},`specification`=#{specification},`engineNo`=#{engineNo},`frameNumber`=#{frameNumber},`permittedWeight`=#{permittedWeight},`passengers`=#{passengers},`brand`=#{brand},`fplateNumber`=#{fplateNumber},`status`=#{status},`operatorClerkId`=#{operatorClerkId},`recordTime`=#{recordTime},`temporaryplate`=#{temporaryplate},`borderStatus`=#{borderStatus},`ciqStatus`=#{ciqStatus},`customsStatus`=#{customsStatus},`reason`=#{reason},`formInstCode`=#{formInstCode} where `id`=#{id}")
	public void update(TaskingBorder taskingBorder);

	@Delete("delete from `macaovehicle_tasking_border` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_tasking_border` limit #{start},#{count}")
	public List<TaskingBorder> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_tasking_border`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_tasking_border`")
	public List<TaskingBorder> listAll();
}