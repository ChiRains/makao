package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;

public interface QuestionMapper {

	@Insert("insert into `publicdata_question`(`id`,`questionnaireId`,`name`,`serialNumber`,`sort`,`type`)"
			+ " values(#{id},#{questionnaireId},#{name},#{serialNumber},#{sort},#{type})")
	public void insert(Question question);

	@Select("select * from `publicdata_question` where `id`=#{id}")
	public Question get(Long id);

	@Update("update `publicdata_question` set `questionnaireId`=#{questionnaireId},`name`=#{name},`serialNumber`=#{serialNumber},`sort`=#{sort},`type`=#{type} where `id`=#{id}")
	public void update(Question question);

	@Delete("delete from `publicdata_question` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_question` limit #{start},#{count}")
	public List<Question> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_question`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_question`")
	public List<Question> listAll();
}