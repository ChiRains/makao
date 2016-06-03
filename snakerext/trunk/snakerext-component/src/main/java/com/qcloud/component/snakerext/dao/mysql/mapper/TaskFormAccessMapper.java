package com.qcloud.component.snakerext.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;

public interface TaskFormAccessMapper {

	@Insert("insert into `snakerext_task_form_access`(`id`,`processId`,`taskName`,`formId`,`elementId`,`formType`,`status`)"
			+ " values(#{id},#{processId},#{taskName},#{formId},#{elementId},#{formType},#{status})")
	public void insert(TaskFormAccess taskFormAccess);

	@Select("select * from `snakerext_task_form_access` where `id`=#{id}")
	public TaskFormAccess get(Long id);

	@Update("update `snakerext_task_form_access` set `processId`=#{processId},`taskName`=#{taskName},`formId`=#{formId},`elementId`=#{elementId},`formType`=#{formType},`status`=#{status} where `id`=#{id}")
	public void update(TaskFormAccess taskFormAccess);

	@Delete("delete from `snakerext_task_form_access` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `snakerext_task_form_access` limit #{start},#{count}")
	public List<TaskFormAccess> list4page(Map<String,Object> param);

	@Select("select count(*) from `snakerext_task_form_access`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `snakerext_task_form_access`")
	public List<TaskFormAccess> listAll();
}