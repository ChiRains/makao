package com.qcloud.component.piratesship.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

public interface CallMeMapper {

	@Insert("insert into `piratesship_call_me`(`id`,`project`,`fromSeaman`,`toSeaman`,`receiveSeaman`,`subject`,`state`,`callDate`,`updateDate`)"
			+ " values(#{id},#{project},#{fromSeaman},#{toSeaman},#{receiveSeaman},#{subject},#{state},#{callDate},#{updateDate})")
	public void insert(CallMe callMe);

	@Select("select * from `piratesship_call_me` where `id`=#{id}")
	public CallMe get(Long id);

	@Update("update `piratesship_call_me` set `project`=#{project},`fromSeaman`=#{fromSeaman},`toSeaman`=#{toSeaman},`receiveSeaman`=#{receiveSeaman},`subject`=#{subject},`state`=#{state},`callDate`=#{callDate},`updateDate`=#{updateDate} where `id`=#{id}")
	public void update(CallMe callMe);

	@Delete("delete from `piratesship_call_me` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `piratesship_call_me` limit #{start},#{count}")
	public List<CallMe> list4page(Map<String,Object> param);

	@Select("select count(*) from `piratesship_call_me`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `piratesship_call_me`")
	public List<CallMe> listAll();
}