package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Role;

public interface RoleMapper {

	@Insert("insert into `permission_role`(`id`,`name`,`desc`,`parentGrantRoleId`)"
			+ " values(#{id},#{name},#{desc},#{parentGrantRoleId})")
	public void insert(Role role);

	@Select("select * from `permission_role` where `id`=#{id}")
	public Role get(Long id);

	@Update("update `permission_role` set `name`=#{name},`desc`=#{desc},`parentGrantRoleId`=#{parentGrantRoleId} where `id`=#{id}")
	public void update(Role role);

	@Delete("delete from `permission_role` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_role` limit #{start},#{count}")
	public List<Role> list4page(int start, int count);

	@Select("select * from `permission_role`")
	public List<Role> list();

	@Select("select count(*) from `permission_role`")
	public int count4page();
}