package com.qcloud.component.file.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;

public interface FileInformationMapper {

	@Insert("insert into `file_file_information`(`id`,`code`,`url`,`time`,`remark`)"
			+ " values(#{id},#{code},#{url},#{time},#{remark})")
	public void insert(FileInformation fileInformation);

	@Select("select * from `file_file_information` where `id`=#{id}")
	public FileInformation get(Long id);

	@Update("update `file_file_information` set `code`=#{code},`url`=#{url},`time`=#{time} ,`remark`=#{remark} where `id`=#{id}")
	public void update(FileInformation fileInformation);

	@Delete("delete from `file_file_information` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `file_file_information` limit #{start},#{count}")
	public List<FileInformation> list4page(Map<String,Object> param);

	@Select("select count(*) from `file_file_information`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `file_file_information`")
	public List<FileInformation> listAll();
}