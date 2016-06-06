package com.qcloud.component.publicservice.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;

public interface CommonQuestionMapper {

	@Insert("insert into `publicservice_common_question`(`id`,`title`,`answer`,`sort`,`time`)"
			+ " values(#{id},#{title},#{answer},#{sort},#{time})")
	public void insert(CommonQuestion commonQuestion);

	@Select("select * from `publicservice_common_question` where `id`=#{id}")
	public CommonQuestion get(Long id);

	@Update("update `publicservice_common_question` set `title`=#{title},`answer`=#{answer},`sort`=#{sort},`time`=#{time} where `id`=#{id}")
	public void update(CommonQuestion commonQuestion);

	@Delete("delete from `publicservice_common_question` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicservice_common_question` order by sort limit #{start},#{count}")
	public List<CommonQuestion> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicservice_common_question`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicservice_common_question` order by sort")
	public List<CommonQuestion> listAll();
}