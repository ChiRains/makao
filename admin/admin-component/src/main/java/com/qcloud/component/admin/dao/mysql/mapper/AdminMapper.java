package com.qcloud.component.admin.dao.mysql.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.admin.model.Admin;

public interface AdminMapper {

	@Insert("insert into pirates_admin(id,account,name,password,`enable`) values(#{id},#{account},#{name},#{password},#{enable})")
	public void insert(Admin bean);

	@Select("select * from pirates_admin where id = #{id}")
	public Admin get(long id);

	@Select("select * from pirates_admin where account = #{account}")
	public Admin getByAccount(String account);

	@Update("update pirates_admin set name = #{name},password=#{password},`enable`=#{enable} where id = #{id}")
	public void update(Admin bean);

	@Delete("delete from pirates_admin where id = #{id}")
	public void delete(long id);

	@Select("select * from pirates_admin limit #{start},#{count}")
	public List<Admin> list4page(int start, int count);

	@Select("select count(*) from pirates_admin")
	public int count4page();
}
