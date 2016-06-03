package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.query.ElementDefQuery;

public interface ElementDefMapper {

	@Insert("insert into `form_element_def`(`id`,`formId`,`name`,`code`,`type`)"
			+ " values(#{id},#{formId},#{name},#{code},#{type})")
	public void insert(ElementDef elementDef);

	@Select("select * from `form_element_def` where `id`=#{id}")
	public ElementDef get(Long id);

	@Update("update `form_element_def` set `formId`=#{formId},`name`=#{name},`code`=#{code},`type`=#{type} where `id`=#{id}")
	public void update(ElementDef elementDef);

	@Delete("delete from `form_element_def` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_element_def` limit #{start},#{count}")
	public List<ElementDef> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_element_def`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_element_def`")
	public List<ElementDef> listAll();
}