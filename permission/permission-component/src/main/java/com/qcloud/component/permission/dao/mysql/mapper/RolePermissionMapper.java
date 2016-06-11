package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.permission.model.RolePermission;

public interface RolePermissionMapper {

    @Insert("insert into `permission_role_permission`(`id`,`permissionId`,`roleId`)" + " values(#{id},#{permissionId},#{roleId})")
    public void insert(RolePermission rolePermission);

    @Select("select * from `permission_role_permission` where `id`=#{id}")
    public RolePermission get(Long id);

    @Update("update `permission_role_permission` set `permissionId`=#{permissionId},`roleId`=#{roleId} where `id`=#{id}")
    public void update(RolePermission rolePermission);

    @Delete("delete from `permission_role_permission` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `permission_role_permission` limit #{start},#{count}")
    public List<RolePermission> list4page(int start, int count);

    @Select("select count(*) from `permission_role_permission`")
    public int count4page();

    @Select("select * from `permission_role_permission` where `roleId`=#{roleId}")
    public List<RolePermission> listByRole(Long id);

    @Delete("delete from `permission_role_permission` where `permissionId`=#{permissionId} and `roleId`=#{roleId}")
    public void myDelete(Long permissionId, Long roleId);
}