package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.DepartmentRole;
import com.qcloud.project.macaovehicle.model.query.DepartmentRoleQuery;

public interface DepartmentRoleMapper {

	@Insert("insert into `macaovehicle_department_role`(`id`,`roleId`,`departmentId`,`desc`,`status`,`creator`,`createDate`)"
			+ " values(#{id},#{roleId},#{departmentId},#{desc},#{status},#{creator},#{createDate})")
	public void insert(DepartmentRole departmentRole);

	@Select("select * from `macaovehicle_department_role` where `id`=#{id}")
	public DepartmentRole get(Long id);

	@Update("update `macaovehicle_department_role` set `roleId`=#{roleId},`departmentId`=#{departmentId},`desc`=#{desc},`status`=#{status},`creator`=#{creator},`createDate`=#{createDate} where `id`=#{id}")
	public void update(DepartmentRole departmentRole);

	@Delete("delete from `macaovehicle_department_role` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_department_role` limit #{start},#{count}")
	public List<DepartmentRole> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_department_role`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_department_role`")
	public List<DepartmentRole> listAll();
}