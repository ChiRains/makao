package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;

public interface NeighbourhoodMapper {

	@Insert("insert into `publicdata_neighbourhood`(`id`,`name`,`province`,`city`,`district`,`longitude`,`latitude`)"
			+ " values(#{id},#{name},#{province},#{city},#{district},#{longitude},#{latitude})")
	public void insert(Neighbourhood neighbourhood);

	@Select("select * from `publicdata_neighbourhood` where `id`=#{id}")
	public Neighbourhood get(Long id);

	@Update("update `publicdata_neighbourhood` set `name`=#{name},`province`=#{province},`city`=#{city},`district`=#{district},`longitude`=#{longitude},`latitude`=#{latitude} where `id`=#{id}")
	public void update(Neighbourhood neighbourhood);

	@Delete("delete from `publicdata_neighbourhood` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_neighbourhood` limit #{start},#{count}")
	public List<Neighbourhood> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_neighbourhood`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_neighbourhood`")
	public List<Neighbourhood> listAll();
}