package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;

public interface ClassifyMapper {

	@Insert("insert into `publicdata_classify`(`id`,`parentId`,`name`,`bsid`,`type`,`image`,`remark`,`enable`,`sort`)"
			+ " values(#{id},#{parentId},#{name},#{bsid},#{type},#{image},#{remark},#{enable},#{sort})")
	public void insert(Classify classify);

	@Select("select * from `publicdata_classify` where `id`=#{id}")
	public Classify get(Long id);

	@Update("update `publicdata_classify` set `parentId`=#{parentId},`name`=#{name},`bsid`=#{bsid},`image`=#{image},`remark`=#{remark},`enable`=#{enable},`sort`=#{sort}  where `id`=#{id}")
	public void update(Classify classify);

	@Delete("delete from `publicdata_classify` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_classify` order by sort limit #{start},#{count}")
	public List<Classify> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_classify`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_classify` where `type`=#{type} order by sort")
	public List<Classify> listAll(int type);
	
	@Update("update `publicdata_classify` set `sort`=#{sort}  where `id`=#{id}")
	public int sort(Map<String,Object> param);
	
	@Update("update `publicdata_classify` set `enable`=#{enable}  where `id`=#{id}")
    public int enable (Map<String,Object> param);
}