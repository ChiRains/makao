package com.qcloud.component.form.dao.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qcloud.component.form.model.FormTableMapping;
import com.qcloud.component.form.model.query.FormTableMappingQuery;
public interface FormTableMappingMapper {
    @Insert("insert into `form_form_table_mapping`(`id`,`mainFormId`,`tableId`)" + " values(#{id},#{mainFormId},#{tableId})")
    public void insert(FormTableMapping formTableMapping);

    @Select("select * from `form_form_table_mapping` where `id`=#{id}")
    public FormTableMapping get(Long id);

    @Update("update `form_form_table_mapping` set `mainFormId`=#{mainFormId},`tableId`=#{tableId} where `id`=#{id}")
    public void update(FormTableMapping formTableMapping);

    @Delete("delete from `form_form_table_mapping` where `id`=#{id}")
    public void delete(Long id);

    @Select("select * from `form_form_table_mapping` limit #{start},#{count}")
    public List<FormTableMapping> list4page(Map<String, Object> param);

    @Select("select count(*) from `form_form_table_mapping`")
    public int count4page(Map<String, Object> param);

    @Select("select * from `form_form_table_mapping`")
    public List<FormTableMapping> listAll();
}