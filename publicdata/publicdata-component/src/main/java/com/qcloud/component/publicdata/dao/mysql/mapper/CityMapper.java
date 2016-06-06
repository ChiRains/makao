package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;

public interface CityMapper {

	@Insert("insert into `publicdata_city`(`id`,`provinceId`,`name`)"
			+ " values(#{id},#{provinceId},#{name})")
	public void insert(City city);

	@Select("select * from `publicdata_city` where `id`=#{id}")
	public City get(Long id);

	@Update("update `publicdata_city` set `provinceId`=#{provinceId},`name`=#{name} where `id`=#{id}")
	public void update(City city);

	@Delete("delete from `publicdata_city` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_city` limit #{start},#{count}")
	public List<City> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_city`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_city`")
	public List<City> listAll();
}