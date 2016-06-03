package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.FormInstance;
import com.qcloud.component.form.model.query.FormInstanceQuery;

public interface FormInstanceMapper {

	@Insert("insert into `form_form_instance`(`id`,`formId`,`dataId`,`code`,`editTime`)"
			+ " values(#{id},#{formId},#{dataId},#{code},#{editTime})")
	public void insert(FormInstance formInstance);

	@Select("select * from `form_form_instance` where `id`=#{id}")
	public FormInstance get(Long id);

	@Update("update `form_form_instance` set `formId`=#{formId},`dataId`=#{dataId},`code`=#{code},`editTime`=#{editTime} where `id`=#{id}")
	public void update(FormInstance formInstance);

	@Delete("delete from `form_form_instance` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_form_instance` limit #{start},#{count}")
	public List<FormInstance> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_form_instance`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_form_instance`")
	public List<FormInstance> listAll();
}