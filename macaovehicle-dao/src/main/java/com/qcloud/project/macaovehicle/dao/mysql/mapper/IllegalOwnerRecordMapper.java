package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;

public interface IllegalOwnerRecordMapper {

	@Insert("insert into `macaovehicle_illegal_owner_record`(`id`,`certificates`,`certificatesNo`,`name`,`desc`,`departmentId`,`createTime`,`clerkId`)"
			+ " values(#{id},#{certificates},#{certificatesNo},#{name},#{desc},#{departmentId},#{createTime},#{clerkId})")
	public void insert(IllegalOwnerRecord illegalOwnerRecord);

	@Select("select * from `macaovehicle_illegal_owner_record` where `id`=#{id}")
	public IllegalOwnerRecord get(Long id);

	@Update("update `macaovehicle_illegal_owner_record` set `certificates`=#{certificates},`certificatesNo`=#{certificatesNo},`name`=#{name},`desc`=#{desc},`departmentId`=#{departmentId},`createTime`=#{createTime},`clerkId`=#{clerkId} where `id`=#{id}")
	public void update(IllegalOwnerRecord illegalOwnerRecord);

	@Delete("delete from `macaovehicle_illegal_owner_record` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_illegal_owner_record` limit #{start},#{count}")
	public List<IllegalOwnerRecord> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_illegal_owner_record`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_illegal_owner_record`")
	public List<IllegalOwnerRecord> listAll();
}