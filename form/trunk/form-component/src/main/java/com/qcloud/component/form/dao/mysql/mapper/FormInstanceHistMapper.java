package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;

public interface FormInstanceHistMapper {

	@Insert("insert into `form_form_instance_hist`(`id`,`formId`,`formInstanceId`,`code`,`dataId`,`editTime`,`backTime`)"
			+ " values(#{id},#{formId},#{formInstanceId},#{code},#{dataId},#{editTime},#{backTime})")
	public void insert(FormInstanceHist formInstanceHist);

	@Select("select * from `form_form_instance_hist` where `id`=#{id}")
	public FormInstanceHist get(Long id);

	@Update("update `form_form_instance_hist` set `formId`=#{formId},`formInstanceId`=#{formInstanceId},`code`=#{code},`dataId`=#{dataId},`editTime`=#{editTime},`backTime`=#{backTime} where `id`=#{id}")
	public void update(FormInstanceHist formInstanceHist);

	@Delete("delete from `form_form_instance_hist` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_form_instance_hist` limit #{start},#{count}")
	public List<FormInstanceHist> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_form_instance_hist`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_form_instance_hist`")
	public List<FormInstanceHist> listAll();
}