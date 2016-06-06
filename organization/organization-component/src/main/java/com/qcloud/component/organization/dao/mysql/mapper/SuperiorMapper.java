package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.Superior;
import com.qcloud.component.organization.model.query.SuperiorQuery;

public interface SuperiorMapper {

	@Insert("insert into `organization_superior`(`id`,`clerkId`,`leaderId`)"
			+ " values(#{id},#{clerkId},#{leaderId})")
	public void insert(Superior superior);

	@Select("select * from `organization_superior` where `id`=#{id}")
	public Superior get(Long id);

	@Update("update `organization_superior` set `clerkId`=#{clerkId},`leaderId`=#{leaderId} where `id`=#{id}")
	public void update(Superior superior);

	@Delete("delete from `organization_superior` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_superior` limit #{start},#{count}")
	public List<Superior> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_superior`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_superior`")
	public List<Superior> listAll();
}