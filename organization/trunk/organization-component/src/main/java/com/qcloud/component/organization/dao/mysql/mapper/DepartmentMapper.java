package com.qcloud.component.organization.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.query.DepartmentQuery;

public interface DepartmentMapper {

	@Insert("insert into `organization_department`(`id`,`parentId`,`bsid`,`name`,`manager`,`displayName`)"
			+ " values(#{id},#{parentId},#{bsid},#{name},#{manager},#{displayName})")
	public void insert(Department department);

	@Select("select * from `organization_department` where `id`=#{id}")
	public Department get(Long id);

	@Update("update `organization_department` set `parentId`=#{parentId},`bsid`=#{bsid},`name`=#{name},`manager`=#{manager},`displayName`=#{displayName} where `id`=#{id}")
	public void update(Department department);

	@Delete("delete from `organization_department` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `organization_department` limit #{start},#{count}")
	public List<Department> list4page(Map<String,Object> param);

	@Select("select count(*) from `organization_department`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `organization_department`")
	public List<Department> listAll();
}