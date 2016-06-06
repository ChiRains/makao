package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;

public interface PostMapper {

	@Insert("insert into `organization_post`(`id`,`name`)"
			+ " values(#{id},#{name})")
	public void insert(Post post);

	@Select("select * from `organization_post` where `id`=#{id}")
	public Post get(Long id);

	@Update("update `organization_post` set `name`=#{name} where `id`=#{id}")
	public void update(Post post);

	@Delete("delete from `organization_post` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_post` limit #{start},#{count}")
	public List<Post> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_post`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_post`")
	public List<Post> listAll();
}