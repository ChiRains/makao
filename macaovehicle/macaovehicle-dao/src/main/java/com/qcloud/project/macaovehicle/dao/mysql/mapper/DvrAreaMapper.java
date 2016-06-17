package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;

public interface DvrAreaMapper {

	@Insert("insert into `macaovehicle_dvr_area`(`id`,`name`,`status`)"
			+ " values(#{id},#{name},#{status})")
	public void insert(DvrArea dvrArea);

	@Select("select * from `macaovehicle_dvr_area` where `id`=#{id}")
	public DvrArea get(Long id);

	@Update("update `macaovehicle_dvr_area` set `name`=#{name},`status`=#{status} where `id`=#{id}")
	public void update(DvrArea dvrArea);

	@Delete("delete from `macaovehicle_dvr_area` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_dvr_area` limit #{start},#{count}")
	public List<DvrArea> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_dvr_area`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_dvr_area`")
	public List<DvrArea> listAll();
}