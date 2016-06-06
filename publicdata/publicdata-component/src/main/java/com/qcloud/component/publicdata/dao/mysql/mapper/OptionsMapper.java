package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;

public interface OptionsMapper {

	@Insert("insert into `publicdata_options`(`id`,`questionId`,`questionnaireId`,`serialNumber`,`content`)"
			+ " values(#{id},#{questionId},#{questionnaireId},#{serialNumber},#{content})")
	public void insert(Options options);

	@Select("select * from `publicdata_options` where `id`=#{id}")
	public Options get(Long id);

	@Update("update `publicdata_options` set `questionId`=#{questionId},`questionnaireId`=#{questionnaireId},`serialNumber`=#{serialNumber},`content`=#{content} where `id`=#{id}")
	public void update(Options options);

	@Delete("delete from `publicdata_options` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_options` limit #{start},#{count}")
	public List<Options> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_options`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_options`")
	public List<Options> listAll();
}