package com.qcloud.component.snakerext.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;

public interface ProcessGroupClerkMapper {

	@Insert("insert into `snaker_ext_process_group_clerk`(`id`,`clerkId`,`groupId`)"
			+ " values(#{id},#{clerkId},#{groupId})")
	public void insert(ProcessGroupClerk processGroupClerk);

	@Select("select * from `snaker_ext_process_group_clerk` where `id`=#{id}")
	public ProcessGroupClerk get(Long id);

	@Update("update `snaker_ext_process_group_clerk` set `clerkId`=#{clerkId},`groupId`=#{groupId} where `id`=#{id}")
	public void update(ProcessGroupClerk processGroupClerk);

	@Delete("delete from `snaker_ext_process_group_clerk` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `snaker_ext_process_group_clerk` limit #{start},#{count}")
	public List<ProcessGroupClerk> list4page(Map<String,Object> param);

	@Select("select count(*) from `snaker_ext_process_group_clerk`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `snaker_ext_process_group_clerk`")
	public List<ProcessGroupClerk> listAll();
}