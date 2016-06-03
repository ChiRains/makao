package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Organization;

public interface OrganizationMapper {

	@Insert("insert into `permission_organization`(`id`,`name`,`parentId`)"
			+ " values(#{id},#{name},#{parentId})")
	public void insert(Organization organization);

	@Select("select * from `permission_organization` where `id`=#{id}")
	public Organization get(Long id);

	@Update("update `permission_organization` set `name`=#{name},`parentId`=#{parentId} where `id`=#{id}")
	public void update(Organization organization);

	@Delete("delete from `permission_organization` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_organization` limit #{start},#{count}")
	public List<Organization> list4page(int start, int count);

	@Select("select count(*) from `permission_organization`")
	public int count4page();
}