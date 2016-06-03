package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Resources;

public interface ResourcesMapper {

	@Insert("insert into `permission_resources`(`id`,`name`,`code`,`uri`)"
			+ " values(#{id},#{name},#{code},#{uri})")
	public void insert(Resources resources);

	@Select("select * from `permission_resources` where `id`=#{id}")
	public Resources get(Long id);

	@Update("update `permission_resources` set `name`=#{name},`code`=#{code},`uri`=#{uri} where `id`=#{id}")
	public void update(Resources resources);

	@Delete("delete from `permission_resources` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_resources` limit #{start},#{count}")
	public List<Resources> list4page(int start, int count);

	@Select("select count(*) from `permission_resources`")
	public int count4page();
}