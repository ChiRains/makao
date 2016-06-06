package com.qcloud.component.publicservice.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicservice.model.MessageType;
import com.qcloud.component.publicservice.model.query.MessageTypeQuery;

public interface MessageTypeMapper {

	@Insert("insert into `publicservice_message_type`(`id`,`code`,`name`,`tableNumber`,`storageTime`,`classify`)"
			+ " values(#{id},#{code},#{name},#{tableNumber},#{storageTime},#{classify})")
	public void insert(MessageType messageType);

	@Select("select * from `publicservice_message_type` where `id`=#{id}")
	public MessageType get(Long id);

	@Update("update `publicservice_message_type` set `code`=#{code},`name`=#{name},`tableNumber`=#{tableNumber},`storageTime`=#{storageTime},`classify`=#{classify} where `id`=#{id}")
	public void update(MessageType messageType);

	@Delete("delete from `publicservice_message_type` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicservice_message_type` limit #{start},#{count}")
	public List<MessageType> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicservice_message_type`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicservice_message_type`")
	public List<MessageType> listAll();
}