package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.PostRole;
import com.qcloud.component.organization.model.query.PostRoleQuery;

public interface PostRoleMapper {

	@Insert("insert into `organization_post_role`(`id`,`roleId`,`postId`)"
			+ " values(#{id},#{roleId},#{postId})")
	public void insert(PostRole postRole);

	@Select("select * from `organization_post_role` where `id`=#{id}")
	public PostRole get(Long id);

	@Update("update `organization_post_role` set `roleId`=#{roleId},`postId`=#{postId} where `id`=#{id}")
	public void update(PostRole postRole);

	@Delete("delete from `organization_post_role` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_post_role` limit #{start},#{count}")
	public List<PostRole> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_post_role`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_post_role`")
	public List<PostRole> listAll();
}