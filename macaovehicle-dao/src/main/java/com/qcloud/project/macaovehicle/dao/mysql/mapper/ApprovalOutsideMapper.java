package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;

public interface ApprovalOutsideMapper {

	@Insert("insert into `macaovehicle_approval_outside`(`id`,`code`,`ric`,`driverIc`,`xml`,`type`,`subType`,`recordTime`)"
			+ " values(#{id},#{code},#{ric},#{driverIc},#{xml},#{type},#{subType},#{recordTime})")
	public void insert(ApprovalOutside approvalOutside);

	@Select("select * from `macaovehicle_approval_outside` where `id`=#{id}")
	public ApprovalOutside get(Long id);

	@Update("update `macaovehicle_approval_outside` set `code`=#{code},`ric`=#{ric},`driverIc`=#{driverIc},`xml`=#{xml},`type`=#{type},`subType`=#{subType},`recordTime`=#{recordTime} where `id`=#{id}")
	public void update(ApprovalOutside approvalOutside);

	@Delete("delete from `macaovehicle_approval_outside` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_approval_outside` limit #{start},#{count}")
	public List<ApprovalOutside> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_approval_outside`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_approval_outside`")
	public List<ApprovalOutside> listAll();
}