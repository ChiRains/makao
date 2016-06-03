package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.query.DataDictionaryQuery;

public interface DataDictionaryMapper {

	@Insert("insert into `publicdata_data_dictionary`(`id`,`type`,`key`,`value`,`displayName`)"
			+ " values(#{id},#{type},#{key},#{value},#{displayName})")
	public void insert(DataDictionary dataDictionary);

	@Select("select * from `publicdata_data_dictionary` where `id`=#{id}")
	public DataDictionary get(Long id);

	@Update("update `publicdata_data_dictionary` set `type`=#{type},`key`=#{key},`value`=#{value},`displayName`=#{displayName} where `id`=#{id}")
	public void update(DataDictionary dataDictionary);

	@Delete("delete from `publicdata_data_dictionary` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_data_dictionary` limit #{start},#{count}")
	public List<DataDictionary> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_data_dictionary`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_data_dictionary` where `type`=#{type}")
	public List<DataDictionary> listAll();
}