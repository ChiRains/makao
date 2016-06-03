package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

public interface PopularSearchesMapper {

	@Insert("insert into `publicdata_popular_searches`(`id`,`keywords`,`times`,`type`,`sort`)"
			+ " values(#{id},#{keywords},#{times},#{type},#{sort})")
	public void insert(PopularSearches popularSearches);

	@Select("select * from `publicdata_popular_searches` where `id`=#{id}")
	public PopularSearches get(Long id);

	@Update("update `publicdata_popular_searches` set `keywords`=#{keywords},`times`=#{times},`type`=#{type},`sort`=#{sort} where `id`=#{id}")
	public void update(PopularSearches popularSearches);

	@Delete("delete from `publicdata_popular_searches` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_popular_searches` limit #{start},#{count}")
	public List<PopularSearches> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_popular_searches`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_popular_searches`")
	public List<PopularSearches> listAll();
}