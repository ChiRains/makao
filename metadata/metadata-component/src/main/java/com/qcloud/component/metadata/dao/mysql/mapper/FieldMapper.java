package com.qcloud.component.metadata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.query.FieldQuery;

public interface FieldMapper {

	@Insert("insert into `metadata_field`(`id`,`tableId`,`label`,`name`,`type`,`length`,`precision`,`remark`)"
			+ " values(#{id},#{tableId},#{label},#{name},#{type},#{length},#{precision},#{remark})")
	public void insert(Field field);

	@Select("select * from `metadata_field` where `id`=#{id}")
	public Field get(Long id);

	@Update("update `metadata_field` set `tableId`=#{tableId},`label`=#{label},`name`=#{name},`type`=#{type},`length`=#{length},`precision`=#{precision},`remark`=#{remark} where `id`=#{id}")
	public void update(Field field);

	@Delete("delete from `metadata_field` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `metadata_field` limit #{start},#{count}")
	public List<Field> list4page(Map<String,Object> param);

	@Select("select count(*) from `metadata_field`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `metadata_field`")
	public List<Field> listAll();
}