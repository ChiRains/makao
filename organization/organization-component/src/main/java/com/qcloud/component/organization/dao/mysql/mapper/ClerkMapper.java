package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

public interface ClerkMapper {

	@Insert("insert into `organization_clerk`(`id`,`name`,`mobile`,`jobEmail`,`idCard`,`sex`,`headImage`,`enable`,`accountGroup`,`inside`)"
			+ " values(#{id},#{name},#{mobile},#{jobEmail},#{idCard},#{sex},#{headImage},#{enable},#{accountGroup},#{inside})")
	public void insert(Clerk clerk);

	@Select("select * from `organization_clerk` where `id`=#{id}")
	public Clerk get(Long id);

	@Update("update `organization_clerk` set `name`=#{name},`mobile`=#{mobile},`jobEmail`=#{jobEmail},`idCard`=#{idCard},`sex`=#{sex},`headImage`=#{headImage},`enable`=#{enable},`accountGroup`=#{accountGroup},`inside`=#{inside} where `id`=#{id}")
	public void update(Clerk clerk);

	@Delete("delete from `organization_clerk` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_clerk` limit #{start},#{count}")
	public List<Clerk> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_clerk`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_clerk`")
	public List<Clerk> listAll();
}