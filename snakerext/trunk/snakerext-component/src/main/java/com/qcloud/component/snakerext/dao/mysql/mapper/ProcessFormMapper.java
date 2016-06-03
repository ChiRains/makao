package com.qcloud.component.snakerext.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;

public interface ProcessFormMapper {

	@Insert("insert into `snakerext_process_form`(`id`,`processId`,`mainFormId`)"
			+ " values(#{id},#{processId},#{mainFormId})")
	public void insert(ProcessForm processForm);

	@Select("select * from `snakerext_process_form` where `id`=#{id}")
	public ProcessForm get(Long id);

	@Update("update `snakerext_process_form` set `processId`=#{processId},`mainFormId`=#{mainFormId} where `id`=#{id}")
	public void update(ProcessForm processForm);

	@Delete("delete from `snakerext_process_form` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `snakerext_process_form` limit #{start},#{count}")
	public List<ProcessForm> list4page(Map<String,Object> param);

	@Select("select count(*) from `snakerext_process_form`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `snakerext_process_form`")
	public List<ProcessForm> listAll();
}