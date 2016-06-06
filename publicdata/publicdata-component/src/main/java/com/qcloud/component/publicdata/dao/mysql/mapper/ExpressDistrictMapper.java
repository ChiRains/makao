package com.qcloud.component.publicdata.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;

public interface ExpressDistrictMapper {

	@Insert("insert into `publicdata_express_district`(`id`,`expressId`,`firstPrice`,`continuedPrice`,`province`,`city`,`district`)"
			+ " values(#{id},#{expressId},#{firstPrice},#{continuedPrice},#{province},#{city},#{district})")
	public void insert(ExpressDistrict expressDistrict);

	@Select("select * from `publicdata_express_district` where `id`=#{id}")
	public ExpressDistrict get(Long id);

	@Update("update `publicdata_express_district` set `expressId`=#{expressId},`firstPrice`=#{firstPrice},`continuedPrice`=#{continuedPrice},`province`=#{province},`city`=#{city},`district`=#{district} where `id`=#{id}")
	public void update(ExpressDistrict expressDistrict);

	@Delete("delete from `publicdata_express_district` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `publicdata_express_district` limit #{start},#{count}")
	public List<ExpressDistrict> list4page(Map<String,Object> param);

	@Select("select count(*) from `publicdata_express_district`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `publicdata_express_district`")
	public List<ExpressDistrict> listAll();
	@Select("select * from `publicdata_express_district` where `expressId`=#{expressId}")
	public List<ExpressDistrict> listByExpressId(Long id);
}