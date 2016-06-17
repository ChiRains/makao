package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;

public interface DvrDetailMapper {

	@Insert("insert into `macaovehicle_dvr_detail`(`id`,`areaId`,`username`,`password`,`name`,`ip`,`port`,`vendor`,`direction`,`operator`,`lastModifiedTime`,`status`)"
			+ " values(#{id},#{areaId},#{username},#{password},#{name},#{ip},#{port},#{vendor},#{direction},#{operator},#{lastModifiedTime},#{status})")
	public void insert(DvrDetail dvrDetail);

	@Select("select * from `macaovehicle_dvr_detail` where `id`=#{id}")
	public DvrDetail get(Long id);

	@Update("update `macaovehicle_dvr_detail` set `areaId`=#{areaId},`username`=#{username},`password`=#{password},`name`=#{name},`ip`=#{ip},`port`=#{port},`vendor`=#{vendor},`direction`=#{direction},`operator`=#{operator},`lastModifiedTime`=#{lastModifiedTime},`status`=#{status} where `id`=#{id}")
	public void update(DvrDetail dvrDetail);

	@Delete("delete from `macaovehicle_dvr_detail` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_dvr_detail` limit #{start},#{count}")
	public List<DvrDetail> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_dvr_detail`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_dvr_detail`")
	public List<DvrDetail> listAll();
}