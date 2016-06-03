package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.ClerkPost;
import com.qcloud.component.organization.model.query.ClerkPostQuery;

public interface ClerkPostMapper {

	@Insert("insert into `organization_clerk_post`(`id`,`clerkId`,`postId`)"
			+ " values(#{id},#{clerkId},#{postId})")
	public void insert(ClerkPost clerkPost);

	@Select("select * from `organization_clerk_post` where `id`=#{id}")
	public ClerkPost get(Long id);

	@Update("update `organization_clerk_post` set `clerkId`=#{clerkId},`postId`=#{postId} where `id`=#{id}")
	public void update(ClerkPost clerkPost);

	@Delete("delete from `organization_clerk_post` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_clerk_post` limit #{start},#{count}")
	public List<ClerkPost> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_clerk_post`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_clerk_post`")
	public List<ClerkPost> listAll();
	
	@Select("select * from `organization_clerk_post` where `postId`=#{postId}")
    public List<ClerkPost> listByPost(Long postId);
}