package com.qcloud.project.macaovehicle.dao.mysql.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;

public interface CarCardMapper {

	@Insert("insert into `macaovehicle_car_card`(`id`)"
			+ " values(#{id})")
	public void insert(CarCard carCard);

	@Select("select * from `macaovehicle_car_card` where `id`=#{id}")
	public CarCard get(Long id);

	@Update("update `macaovehicle_car_card` set  where `id`=#{id}")
	public void update(CarCard carCard);

	@Delete("delete from `macaovehicle_car_card` where `id`=#{id}")
	public void delete(Long id);

	@Select("select * from `macaovehicle_car_card` limit #{start},#{count}")
	public List<CarCard> list4page(Map<String,Object> param);

	@Select("select count(*) from `macaovehicle_car_card`")
	public int count4page(Map<String,Object> param);
	
	@Select("select * from `macaovehicle_car_card`")
	public List<CarCard> listAll();
}