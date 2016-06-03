package com.qcloud.component.account.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;

public interface EntryCertificateMapper {

	@Insert("insert into `account_entry_certificate`(`id`,`account`,`group`,`code`,`password`,`name`,`registTime`,`state`,`frozenTime`)"
			+ " values(#{id},#{account},#{group},#{code},#{password},#{name},#{registTime},#{state},#{frozenTime})")
	public void insert(EntryCertificate entryCertificate);

	@Select("select * from `account_entry_certificate` where `id`=#{id}")
	public EntryCertificate get(Long id);

	@Update("update `account_entry_certificate` set `account`=#{account},`group`=#{group},`code`=#{code},`password`=#{password},`name`=#{name},`registTime`=#{registTime},`state`=#{state},`frozenTime`=#{frozenTime} where `id`=#{id}")
	public void update(EntryCertificate entryCertificate);

	@Delete("delete from `account_entry_certificate` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `account_entry_certificate` limit #{start},#{count}")
	public List<EntryCertificate> list4page(Map<String,Object> param);

	@Select("select count(*) from `account_entry_certificate`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `account_entry_certificate`")
	public List<EntryCertificate> listAll();
}