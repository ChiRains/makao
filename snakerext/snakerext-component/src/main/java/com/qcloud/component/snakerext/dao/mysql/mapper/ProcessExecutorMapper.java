package com.qcloud.component.snakerext.dao.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.snakerext.model.ProcessExecutor;
public interface ProcessExecutorMapper {
    @Insert("insert into `snakerext_process_executor`(`id`,`processId`,`taskName`,`type`,`memberId`)" + " values(#{id},#{processId},#{taskName},#{type},#{memberId})")
    public void insert(ProcessExecutor processExecutor);

    @Select("select * from `snakerext_process_executor` where `id`=#{id}")
    public ProcessExecutor get(Long id);

    @Update("update `snakerext_process_executor` set `processId`=#{processId},`taskName`=#{taskName},`type`=#{type},`memberId`=#{memberId} where `id`=#{id}")
    public void update(ProcessExecutor processExecutor);

    @Delete("delete from `snakerext_process_executor` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `snakerext_process_executor` limit #{start},#{count}")
    public List<ProcessExecutor> list4page(Map<String, Object> param);

    @Select("select count(*) from `snakerext_process_executor`")
    public int count4page(Map<String, Object> param);

    @Select("select * from `snakerext_process_executor`")
    public List<ProcessExecutor> listAll();
}