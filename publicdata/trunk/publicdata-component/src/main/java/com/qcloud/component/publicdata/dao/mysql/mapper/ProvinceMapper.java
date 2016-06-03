package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;

public interface ProvinceMapper {

	@Insert("insert into `publicdata_province`(`id`,`name`)"
			+ " values(#{id},#{name})")
	public void insert(Province province);

	@Select("select * from `publicdata_province` where `id`=#{id}")
	public Province get(Long id);

	@Update("update `publicdata_province` set `name`=#{name} where `id`=#{id}")
	public void update(Province province);

	@Delete("delete from `publicdata_province` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_province` limit #{start},#{count}")
	public List<Province> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_province`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_province`")
	public List<Province> listAll();
}