package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;

public interface InstanceMessageMapper {

	@Insert("insert into `macaovehicle_instance_message`(`id`,`formInstanceId`,`messageClerkId`,`clerkId`,`createTime`)"
			+ " values(#{id},#{formInstanceId},#{messageClerkId},#{clerkId},#{createTime})")
	public void insert(InstanceMessage instanceMessage);

	@Select("select * from `macaovehicle_instance_message` where `id`=#{id}")
	public InstanceMessage get(Long id);

	@Update("update `macaovehicle_instance_message` set `formInstanceId`=#{formInstanceId},`messageClerkId`=#{messageClerkId},`clerkId`=#{clerkId},`createTime`=#{createTime} where `id`=#{id}")
	public void update(InstanceMessage instanceMessage);

	@Delete("delete from `macaovehicle_instance_message` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_instance_message` limit #{start},#{count}")
	public List<InstanceMessage> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_instance_message`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_instance_message`")
	public List<InstanceMessage> listAll();
}