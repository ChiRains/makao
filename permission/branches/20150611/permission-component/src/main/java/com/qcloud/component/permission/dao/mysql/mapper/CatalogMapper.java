package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Catalog;

public interface CatalogMapper {

	@Insert("insert into `permission_catalog`(`id`,`name`,`order`,`type`)"
			+ " values(#{id},#{name},#{order},#{type})")
	public void insert(Catalog catalog);

	@Select("select * from `permission_catalog` where `id`=#{id}")
	public Catalog get(Long id);

	@Update("update `permission_catalog` set `name`=#{name},`order`=#{order},`type`=#{type} where `id`=#{id}")
	public void update(Catalog catalog);

	@Delete("delete from `permission_catalog` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_catalog` limit #{start},#{count}")
	public List<Catalog> list4page(int start, int count);

	@Select("select count(*) from `permission_catalog`")
	public int count4page();
	
	@Select("select `id` from `permission_catalog`")
	List<Long> listKeys();
}