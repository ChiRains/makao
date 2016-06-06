package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

public interface FormInstanceCodeNumberMapper {

	@Insert("insert into `form_form_instance_code_number`(`id`,`code`,`number`)"
			+ " values(#{id},#{code},#{number})")
	public void insert(FormInstanceCodeNumber formInstanceCodeNumber);

	@Select("select * from `form_form_instance_code_number` where `id`=#{id}")
	public FormInstanceCodeNumber get(Long id);

	@Update("update `form_form_instance_code_number` set `code`=#{code},`number`=#{number} where `id`=#{id}")
	public void update(FormInstanceCodeNumber formInstanceCodeNumber);

	@Delete("delete from `form_form_instance_code_number` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_form_instance_code_number` limit #{start},#{count}")
	public List<FormInstanceCodeNumber> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_form_instance_code_number`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_form_instance_code_number`")
	public List<FormInstanceCodeNumber> listAll();
}