package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;

public interface ImageInformationMapper {

	@Insert("insert into `publicdata_image_information`(`id`,`name`,`size`,`remark`,`code`)"
			+ " values(#{id},#{name},#{size},#{remark},#{code})")
	public void insert(ImageInformation imageInformation);

	@Select("select * from `publicdata_image_information` where `id`=#{id}")
	public ImageInformation get(Long id);

	@Update("update `publicdata_image_information` set `name`=#{name},`size`=#{size},`remark`=#{remark},`code`=#{code}  where `id`=#{id}")
	public void update(ImageInformation imageInformation);

	@Delete("delete from `publicdata_image_information` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_image_information` limit #{start},#{count}")
	public List<ImageInformation> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_image_information`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_image_information`")
	public List<ImageInformation> listAll();
}