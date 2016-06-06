package com.qcloud.component.account.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;

public interface CertificateTypeMapper {

	@Insert("insert into `account_certificate_type`(`id`,`code`,`name`)"
			+ " values(#{id},#{code},#{name})")
	public void insert(CertificateType certificateType);

	@Select("select * from `account_certificate_type` where `id`=#{id}")
	public CertificateType get(Long id);

	@Update("update `account_certificate_type` set `code`=#{code},`name`=#{name} where `id`=#{id}")
	public void update(CertificateType certificateType);

	@Delete("delete from `account_certificate_type` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `account_certificate_type` limit #{start},#{count}")
	public List<CertificateType> list4page(Map<String,Object> param);

	@Select("select count(*) from `account_certificate_type`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `account_certificate_type`")
	public List<CertificateType> listAll();
}