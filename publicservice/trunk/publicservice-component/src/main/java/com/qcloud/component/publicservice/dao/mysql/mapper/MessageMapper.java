package com.qcloud.component.publicservice.dao.mysql.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.publicservice.model.Message;

public interface MessageMapper {

	@Insert("insert into `${table_name}`(`id`,`typeId`,`receiver`,`title`,`content`,`time`,`state`,`classify`)"
			+ " values(#{id},#{typeId},#{receiver},#{title},#{content},#{time},#{state},#{classify})")
	public void insert(Message message);

	@Select("select * from `${table_name}` where `id`=#{id}")
	public Message get(Long id);

	@Update("update `${table_name}` set `typeId`=#{typeId},`receiver`=#{receiver},`title`=#{title},`content`=#{content},`time`=#{time},`state`=#{state},`classify`=#{classify} where `id`=#{id}")
	public void update(Message message);

	@Delete("delete from `${table_name}` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `${table_name}` limit #{start},#{count}")
	public List<Message> list4page(Map<String,Object> param);

	@Select("select count(*) from `${table_name}`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `${table_name}`")
	public List<Message> listAll();
}