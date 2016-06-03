package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

public interface QuestionnaireMapper {

	@Insert("insert into `publicdata_questionnaire`(`id`,`name`,`code`)"
			+ " values(#{id},#{name},#{code})")
	public void insert(Questionnaire questionnaire);

	@Select("select * from `publicdata_questionnaire` where `id`=#{id}")
	public Questionnaire get(Long id);

	@Update("update `publicdata_questionnaire` set `name`=#{name},`code`=#{code} where `id`=#{id}")
	public void update(Questionnaire questionnaire);

	@Delete("delete from `publicdata_questionnaire` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_questionnaire` limit #{start},#{count}")
	public List<Questionnaire> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_questionnaire`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_questionnaire`")
	public List<Questionnaire> listAll();
}