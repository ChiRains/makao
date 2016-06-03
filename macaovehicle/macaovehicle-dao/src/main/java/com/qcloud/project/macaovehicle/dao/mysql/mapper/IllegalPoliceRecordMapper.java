package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.IllegalPoliceRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalPoliceRecordQuery;

public interface IllegalPoliceRecordMapper {

	@Insert("insert into `macaovehicle_illegal_police_record`(`id`,`plateNumber`,`tplateNumber`,`violationTime`,`violationCode`,`violationAddress`,`violationDesc`,`departmentId`,`createTime`,`clerkId`,`carOwnerId`)"
			+ " values(#{id},#{plateNumber},#{tplateNumber},#{violationTime},#{violationCode},#{violationAddress},#{violationDesc},#{departmentId},#{createTime},#{clerkId},#{carOwnerId})")
	public void insert(IllegalPoliceRecord illegalPoliceRecord);

	@Select("select * from `macaovehicle_illegal_police_record` where `id`=#{id}")
	public IllegalPoliceRecord get(Long id);

	@Update("update `macaovehicle_illegal_police_record` set `plateNumber`=#{plateNumber},`tplateNumber`=#{tplateNumber},`violationTime`=#{violationTime},`violationCode`=#{violationCode},`violationAddress`=#{violationAddress},`violationDesc`=#{violationDesc},`departmentId`=#{departmentId},`createTime`=#{createTime},`clerkId`=#{clerkId},`carOwnerId`=#{carOwnerId} where `id`=#{id}")
	public void update(IllegalPoliceRecord illegalPoliceRecord);

	@Delete("delete from `macaovehicle_illegal_police_record` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_illegal_police_record` limit #{start},#{count}")
	public List<IllegalPoliceRecord> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_illegal_police_record`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_illegal_police_record`")
	public List<IllegalPoliceRecord> listAll();
}