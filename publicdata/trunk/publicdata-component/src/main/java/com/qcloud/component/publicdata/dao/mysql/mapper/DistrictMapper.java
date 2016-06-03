package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;

public interface DistrictMapper {

	@Insert("insert into `publicdata_district`(`id`,`provinceId`,`cityId`,`name`)"
			+ " values(#{id},#{provinceId},#{cityId},#{name})")
	public void insert(District district);

	@Select("select * from `publicdata_district` where `id`=#{id}")
	public District get(Long id);

	@Update("update `publicdata_district` set `provinceId`=#{provinceId},`cityId`=#{cityId},`name`=#{name} where `id`=#{id}")
	public void update(District district);

	@Delete("delete from `publicdata_district` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_district` limit #{start},#{count}")
	public List<District> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_district`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_district`")
	public List<District> listAll();
}