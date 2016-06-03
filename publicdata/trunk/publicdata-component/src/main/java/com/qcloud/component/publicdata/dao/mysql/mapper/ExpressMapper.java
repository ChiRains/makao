package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

public interface ExpressMapper {

	@Insert("insert into `publicdata_express`(`id`,`name`,`code`,`desc`,`logo`,`sort`,`firstWeight`,`firstPrice`,`continuedWeight`,`continuedPrice`,`enable`)"
			+ " values(#{id},#{name},#{code},#{desc},#{logo},#{sort},#{firstWeight},#{firstPrice},#{continuedWeight},#{continuedPrice},#{enable})")
	public void insert(Express express);

	@Select("select * from `publicdata_express` where `id`=#{id}")
	public Express get(Long id);

	@Update("update `publicdata_express` set `name`=#{name},`code`=#{code},`desc`=#{desc},`logo`=#{logo},`sort`=#{sort},`firstWeight`=#{firstWeight},`firstPrice`=#{firstPrice},`continuedWeight`=#{continuedWeight},`continuedPrice`=#{continuedPrice},`enable`=#{enable} where `id`=#{id}")
	public void update(Express express);

	@Delete("delete from `publicdata_express` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_express` limit #{start},#{count}")
	public List<Express> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_express`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_express`")
	public List<Express> listAll();
}