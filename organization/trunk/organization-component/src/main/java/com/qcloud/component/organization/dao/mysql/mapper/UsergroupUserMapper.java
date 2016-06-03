package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;

public interface UsergroupUserMapper {

	@Insert("insert into `organization_usergroup_user`(`id`,`groupId`,`userId`)"
			+ " values(#{id},#{groupId},#{userId})")
	public void insert(UsergroupUser usergroupUser);

	@Select("select * from `organization_usergroup_user` where `id`=#{id}")
	public UsergroupUser get(Long id);

	@Update("update `organization_usergroup_user` set `groupId`=#{groupId},`userId`=#{userId} where `id`=#{id}")
	public void update(UsergroupUser usergroupUser);

	@Delete("delete from `organization_usergroup_user` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_usergroup_user` limit #{start},#{count}")
	public List<UsergroupUser> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_usergroup_user`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_usergroup_user`")
	public List<UsergroupUser> listAll();
}