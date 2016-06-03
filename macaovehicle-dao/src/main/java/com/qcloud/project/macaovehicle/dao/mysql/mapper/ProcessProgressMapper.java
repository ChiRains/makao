package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.project.macaovehicle.model.ProcessProgress;

public interface ProcessProgressMapper {

    @Insert("insert into `macaovehicle_process_progress`(`id`,`formInstCode`,`carOwnerId`,`activity`,`state`,`dateStr`,`progressState`,`type`,`formInstanceId`)" 
    + " values(#{id},#{formInstCode},#{carOwnerId},#{activity},#{state},#{dateStr},#{progressState},#{type},#{formInstanceId})")
    public void insert(ProcessProgress processProgress);

    @Select("select * from `macaovehicle_process_progress` where `id`=#{id}")
    public ProcessProgress get(Long id);

    @Update("update `macaovehicle_process_progress` set `formInstCode`=#{formInstCode},`carOwnerId`=#{carOwnerId},`activity`=#{activity},`state`=#{state},`dateStr`=#{dateStr},`progressState`=#{progressState},`type`=#{type},`formInstanceId`=#{formInstanceId} where `id`=#{id}")
    public void update(ProcessProgress processProgress);

    @Delete("delete from `macaovehicle_process_progress` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `macaovehicle_process_progress` limit #{start},#{count}")
    public List<ProcessProgress> list4page(Map<String, Object> param);

    @Select("select count(*) from `macaovehicle_process_progress`")
    public int count4page(Map<String, Object> param);

    @Select("select * from `macaovehicle_process_progress`")
    public List<ProcessProgress> listAll();
}