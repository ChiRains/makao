package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Account;

public interface AccountMapper {

	@Insert("insert into `permission_account`(`id`,`name`,`code`,`enable`,`orgId`)"
			+ " values(#{id},#{name},#{code},#{enable},#{orgId})")
	public void insert(Account account);

	@Select("select * from `permission_account` where `id`=#{id}")
	public Account get(Long id);

	@Update("update `permission_account` set `name`=#{name},`code`=#{code},`enable`=#{enable},`orgId`=#{orgId} where `id`=#{id}")
	public void update(Account account);

	@Delete("delete from `permission_account` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_account` limit #{start},#{count}")
	public List<Account> list4page(int start, int count);

	@Select("select count(*) from `permission_account`")
	public int count4page(int start, int count);

	@Select("select * from `permission_account` where `code` not in (${exCode}) limit #{start},#{count}")
	public List<Account> list4expage(String exCode, int start, int count);

	@Select("select count(*) from `permission_account` where `code` not in (${exCode})")
	public int count4expage(String exCode, int start, int count);

	@Select("select * from `permission_account` where `code`=#{code}")
	public Account getByCode(String code);

}