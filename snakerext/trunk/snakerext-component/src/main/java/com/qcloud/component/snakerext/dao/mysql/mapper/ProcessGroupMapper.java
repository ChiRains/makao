package com.qcloud.component.snakerext.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;

public interface ProcessGroupMapper {

	@Insert("insert into `snaker_ext_process_group`(`id`,`name`,`remark`)"
			+ " values(#{id},#{name},#{remark})")
	public void insert(ProcessGroup processGroup);

	@Select("select * from `snaker_ext_process_group` where `id`=#{id}")
	public ProcessGroup get(Long id);

	@Update("update `snaker_ext_process_group` set `name`=#{name},`remark`=#{remark} where `id`=#{id}")
	public void update(ProcessGroup processGroup);

	@Delete("delete from `snaker_ext_process_group` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `snaker_ext_process_group` limit #{start},#{count}")
	public List<ProcessGroup> list4page(Map<String,Object> param);

	@Select("select count(*) from `snaker_ext_process_group`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `snaker_ext_process_group`")
	public List<ProcessGroup> listAll();
}