package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.Usergroup;
import com.qcloud.component.organization.model.query.UsergroupQuery;

public interface UsergroupMapper {

	@Insert("insert into `organization_usergroup`(`id`,`name`)"
			+ " values(#{id},#{name})")
	public void insert(Usergroup usergroup);

	@Select("select * from `organization_usergroup` where `id`=#{id}")
	public Usergroup get(Long id);

	@Update("update `organization_usergroup` set `name`=#{name} where `id`=#{id}")
	public void update(Usergroup usergroup);

	@Delete("delete from `organization_usergroup` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_usergroup` limit #{start},#{count}")
	public List<Usergroup> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_usergroup`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_usergroup`")
	public List<Usergroup> listAll();
}