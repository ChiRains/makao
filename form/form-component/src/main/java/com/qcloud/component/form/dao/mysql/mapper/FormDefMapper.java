package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.form.model.query.FormDefQuery;

public interface FormDefMapper {

	@Insert("insert into `form_form_def`(`id`,`mainFormId`,`name`,`code`,`remark`,`pcPageUrl`,`mobilePageUrl`)"
			+ " values(#{id},#{mainFormId},#{name},#{code},#{remark},#{pcPageUrl},#{mobilePageUrl})")
	public void insert(FormDef formDef);

	@Select("select * from `form_form_def` where `id`=#{id}")
	public FormDef get(Long id);

	@Update("update `form_form_def` set `mainFormId`=#{mainFormId},`name`=#{name},`code`=#{code},`remark`=#{remark},`pcPageUrl`=#{pcPageUrl},`mobilePageUrl`=#{mobilePageUrl} where `id`=#{id}")
	public void update(FormDef formDef);

	@Delete("delete from `form_form_def` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_form_def` limit #{start},#{count}")
	public List<FormDef> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_form_def`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_form_def`")
	public List<FormDef> listAll();
}