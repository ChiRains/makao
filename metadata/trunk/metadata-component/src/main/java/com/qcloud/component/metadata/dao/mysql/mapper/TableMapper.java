package com.qcloud.component.metadata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;

public interface TableMapper {

	@Insert("insert into `metadata_table`(`id`,`label`,`name`,`remark`)"
			+ " values(#{id},#{label},#{name},#{remark})")
	public void insert(Table table);

	@Select("select * from `metadata_table` where `id`=#{id}")
	public Table get(Long id);

	@Update("update `metadata_table` set `label`=#{label},`name`=#{name},`remark`=#{remark} where `id`=#{id}")
	public void update(Table table);

	@Delete("delete from `metadata_table` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `metadata_table` limit #{start},#{count}")
	public List<Table> list4page(Map<String,Object> param);

	@Select("select count(*) from `metadata_table`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `metadata_table`")
	public List<Table> listAll();
}