package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.IllegalCarRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalCarRecordQuery;

public interface IllegalCarRecordMapper {

	@Insert("insert into `macaovehicle_illegal_car_record`(`id`,`plateNumber`,`tplateNumber`,`departmentId`,`createTime`,`clerkId`,`desc`)"
			+ " values(#{id},#{plateNumber},#{tplateNumber},#{departmentId},#{createTime},#{clerkId},#{desc})")
	public void insert(IllegalCarRecord illegalCarRecord);

	@Select("select * from `macaovehicle_illegal_car_record` where `id`=#{id}")
	public IllegalCarRecord get(Long id);

	@Update("update `macaovehicle_illegal_car_record` set `plateNumber`=#{plateNumber},`tplateNumber`=#{tplateNumber},`departmentId`=#{departmentId},`createTime`=#{createTime},`clerkId`=#{clerkId},`desc`=#{desc} where `id`=#{id}")
	public void update(IllegalCarRecord illegalCarRecord);

	@Delete("delete from `macaovehicle_illegal_car_record` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_illegal_car_record` limit #{start},#{count}")
	public List<IllegalCarRecord> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_illegal_car_record`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_illegal_car_record`")
	public List<IllegalCarRecord> listAll();
}