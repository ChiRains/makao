package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

public interface ApprovalResultsMapper {

	@Insert("insert into `macaovehicle_approval_results`(`id`,`formInstanceId`,`appointmentNumber`,`cardNumber`,`type`,`state`,`time`,`vehicleId`,`driverId`,`formInstCode`)"
			+ " values(#{id},#{formInstanceId},#{appointmentNumber},#{cardNumber},#{type},#{state},#{time},#{vehicleId},#{driverId},#{formInstCode})")
	public void insert(ApprovalResults approvalResults);

	@Select("select * from `macaovehicle_approval_results` where `id`=#{id}")
	public ApprovalResults get(Long id);

	@Update("update `macaovehicle_approval_results` set `formInstanceId`=#{formInstanceId},`appointmentNumber`=#{appointmentNumber},`cardNumber`=#{cardNumber},`type`=#{type},`state`=#{state},`time`=#{time} ,`vehicleId`=#{vehicleId} ,`driverId`=#{driverId},`formInstCode`=#{formInstCode}  where `id`=#{id}")
	public void update(ApprovalResults approvalResults);

	@Delete("delete from `macaovehicle_approval_results` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_approval_results` limit #{start},#{count}")
	public List<ApprovalResults> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_approval_results`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_approval_results`")
	public List<ApprovalResults> listAll();
}