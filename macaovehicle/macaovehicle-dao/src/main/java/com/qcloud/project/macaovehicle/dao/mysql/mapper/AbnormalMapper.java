package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;

public interface AbnormalMapper {

	@Insert("insert into `macaovehicle_abnormal`(`id`,`monitorId`,`monitorName`,`happenedTime`,`carCardId`,`driverCardId`,`rfPlate`,`ocrPlate`,`eventType`,`picture`,`alarmNum`,`pictureUrl`)"
			+ " values(#{id},#{monitorId},#{monitorName},#{happenedTime},#{carCardId},#{driverCardId},#{rfPlate},#{ocrPlate},#{eventType},#{picture},#{alarmNum},#{pictureUrl})")
	public void insert(Abnormal abnormal);

	@Select("select * from `macaovehicle_abnormal` where `macaovehicle_abnormal`=#{macaovehicle_abnormal}")
	public Abnormal get(Integer macaovehicleAbnormalId);

	@Update("update `macaovehicle_abnormal` set `id`=#{id},`monitorId`=#{monitorId},`monitorName`=#{monitorName},`happenedTime`=#{happenedTime},`carCardId`=#{carCardId},`driverCardId`=#{driverCardId},`rfPlate`=#{rfPlate},`ocrPlate`=#{ocrPlate},`eventType`=#{eventType},`picture`=#{picture},`alarmNum`=#{alarmNum},`pictureUrl`=#{pictureUrl} where `macaovehicle_abnormal`=#{macaovehicle_abnormal}")
	public void update(Abnormal abnormal);

	@Delete("delete from `macaovehicle_abnormal` where `macaovehicle_abnormal`=#{macaovehicle_abnormal}")
	public void delete(Integer macaovehicleAbnormalId);

	@Select("select * from `macaovehicle_abnormal` limit #{start},#{count}")
	public List<Abnormal> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_abnormal`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_abnormal`")
	public List<Abnormal> listAll();
}