package com.qcloud.component.permission.dao.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.query.MenuQuery;

public interface MenuMapper {

	@Insert("insert into `permission_menu`(`id`,`name`,`code`,`order`,`url`,`catalogId`)"
			+ " values(#{id},#{name},#{code},#{order},#{url},#{catalogId})")
	public void insert(Menu menu);

	@Select("select * from `permission_menu` where `id`=#{id}")
	public Menu get(Long id);

	@Update("update `permission_menu` set `name`=#{name},`code`=#{code},`order`=#{order},`url`=#{url},`catalogId`=#{catalogId} where `id`=#{id}")
	public void update(Menu menu);

	@Delete("delete from `permission_menu` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `permission_menu` limit #{start},#{count}")
	public List<Menu> list4page(int start, int count);

	@Select("select count(*) from `permission_menu`")
	public int count4page();
	
	@Select("select `id` from `permission_menu`")
	List<Long> listKeys();

	@Select("select `id` from `permission_menu` where `catalogId` = #{catalogId}")
	List<Long> listKeysByCatalog(Long catalogId);
	
	@Select("select * from `permission_menu` where 1=1 and `catalogId`=#{catalogId} limit #{start},#{count}")
    public List<Menu> list4Query(MenuQuery query,int start, int count);

    @Select("select count(*) from `permission_menu` where 1=1 and `catalogId`=#{catalogId} " )
    public int count4Query(MenuQuery query);
}