package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.DepartmentClerk;
import com.qcloud.component.organization.model.query.DepartmentClerkQuery;

public interface DepartmentClerkMapper {

	@Insert("insert into `organization_department_clerk`(`id`,`departmentId`,`clerkId`,`type`)"
			+ " values(#{id},#{departmentId},#{clerkId},#{type})")
	public void insert(DepartmentClerk departmentClerk);

	@Select("select * from `organization_department_clerk` where `id`=#{id}")
	public DepartmentClerk get(Long id);

	@Update("update `organization_department_clerk` set `departmentId`=#{departmentId},`clerkId`=#{clerkId},`type`=#{type} where `id`=#{id}")
	public void update(DepartmentClerk departmentClerk);

	@Delete("delete from `organization_department_clerk` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_department_clerk` limit #{start},#{count}")
	public List<DepartmentClerk> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_department_clerk`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_department_clerk`")
	public List<DepartmentClerk> listAll();
}