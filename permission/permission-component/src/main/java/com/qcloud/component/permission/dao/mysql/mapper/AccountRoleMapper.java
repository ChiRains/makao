package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.permission.model.AccountRole;

public interface AccountRoleMapper {

    @Insert("insert into `permission_account_role`(`id`,`accountId`,`roleId`)" + " values(#{id},#{accountId},#{roleId})")
    public void insert(AccountRole accountRole);

    @Select("select * from `permission_account_role` where `id`=#{id}")
    public AccountRole get(Long id);

    @Select("select * from `permission_account_role` where `accountId`=#{accountId} and `roleId`=#{roleId}")
    public AccountRole getByAccountAndRole(Long accountId, Long roleId);

    @Update("update `permission_account_role` set `accountId`=#{accountId},`roleId`=#{roleId} where `id`=#{id}")
    public void update(AccountRole accountRole);

    @Delete("delete from `permission_account_role` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `permission_account_role` limit #{start},#{count}")
    public List<AccountRole> list4page(int start, int count);

    @Select("select count(*) from `permission_account_role`")
    public int count4page();

    @Select("select * from `permission_account_role` where `accountId`=#{accountId}")
    public List<AccountRole> listByAccount(Long accountId);

    @Delete("delete from `permission_account_role` where `accountId`=#{accountId}")
    public void unbindAccountGrant(Long accountId);
}