package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.permission.model.Permission;

public interface PermissionMapper {

    @Insert("insert into `permission_permission`(`id`,`name`,`type`,`targetId`)" + " values(#{id},#{name},#{type},#{targetId})")
    public void insert(Permission permission);

    @Select("select * from `permission_permission` where `id`=#{id}")
    public Permission get(Long id);

    @Update("update `permission_permission` set `name`=#{name},`type`=#{type},`targetId`=#{targetId} where `id`=#{id}")
    public void update(Permission permission);

    @Delete("delete from `permission_permission` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `permission_permission` limit #{start},#{count}")
    public List<Permission> list4page(int start, int count);

    @Select("select count(*) from `permission_permission`")
    public int count4page();

    @Select("select * from `permission_permission` where `targetId`=#{menuId}  and `type`=1 ")
    public Permission getByMenu(Long menuId);

    @Select("select * from `permission_permission` where `targetId`=#{targetId}  and `type`=#{type} ")
    public Permission getByTargetId(int type, Long targetId);
}