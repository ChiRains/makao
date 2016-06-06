package com.qcloud.component.form.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;

public interface ElementFieldMappingMapper {

	@Insert("insert into `form_element_field_mapping`(`id`,`elementId`,`fieldId`)"
			+ " values(#{id},#{elementId},#{fieldId})")
	public void insert(ElementFieldMapping elementFieldMapping);

	@Select("select * from `form_element_field_mapping` where `id`=#{id}")
	public ElementFieldMapping get(Long id);

	@Update("update `form_element_field_mapping` set `elementId`=#{elementId},`fieldId`=#{fieldId} where `id`=#{id}")
	public void update(ElementFieldMapping elementFieldMapping);

	@Delete("delete from `form_element_field_mapping` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `form_element_field_mapping` limit #{start},#{count}")
	public List<ElementFieldMapping> list4page(Map<String,Object> param);

	@Select("select count(*) from `form_element_field_mapping`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `form_element_field_mapping`")
	public List<ElementFieldMapping> listAll();
}