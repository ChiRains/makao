package com.qcloud.component.snakerext.dao.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
public interface ProcessExecutorInterfaceMapper {
    @Insert("insert into `snakerext_process_executor_interface`(`id`,`name`,`method`)" + " values(#{id},#{name},#{method})")
    public void insert(ProcessExecutorInterface processExecutorInterface);

    @Select("select * from `snakerext_process_executor_interface` where `id`=#{id}")
    public ProcessExecutorInterface get(Long id);

    @Update("update `snakerext_process_executor_interface` set `name`=#{name},`method`=#{method} where `id`=#{id}")
    public void update(ProcessExecutorInterface processExecutorInterface);

    @Delete("delete from `snakerext_process_executor_interface` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `snakerext_process_executor_interface` limit #{start},#{count}")
    public List<ProcessExecutorInterface> list4page(Map<String, Object> param);

    @Select("select count(*) from `snakerext_process_executor_interface`")
    public int count4page(Map<String, Object> param);

    @Select("select * from `snakerext_process_executor_interface`")
    public List<ProcessExecutorInterface> listAll();
}