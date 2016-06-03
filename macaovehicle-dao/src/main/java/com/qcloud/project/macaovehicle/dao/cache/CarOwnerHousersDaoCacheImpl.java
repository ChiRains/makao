package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerHousersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerHousersQuery;

@Repository
public class CarOwnerHousersDaoCacheImpl implements CarOwnerHousersDao {
	
	@Autowired
	private CarOwnerHousersDao carOwnerHousersDaoMysqlImpl;
	
	@Autowired
	private CarOwnerHousersDao carOwnerHousersDaoRedisImpl;

	@Override
	public boolean add(CarOwnerHousers carOwnerHousers) {
		return carOwnerHousersDaoMysqlImpl.add(carOwnerHousers);
	}

	@Override
	public CarOwnerHousers get(Long id) {
		return  carOwnerHousersDaoMysqlImpl.get( id);
	}

	@Override
	public boolean delete(Long id){
		return carOwnerHousersDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CarOwnerHousers carOwnerHousers){
		return carOwnerHousersDaoMysqlImpl.update(carOwnerHousers);
	}
	
	@Override
	public List<CarOwnerHousers> list(List<Long> idList) {
		return CacheLoader.list(carOwnerHousersDaoRedisImpl, carOwnerHousersDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CarOwnerHousers> map(Set<Long> idSet){
		return CacheLoader.map(carOwnerHousersDaoRedisImpl, carOwnerHousersDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CarOwnerHousers> page(int start, int count){
		return carOwnerHousersDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CarOwnerHousers> page(CarOwnerHousersQuery query, int start, int count){
		return carOwnerHousersDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CarOwnerHousers> listAll(){
		return carOwnerHousersDaoMysqlImpl.listAll();
	}

    @Override
    public CarOwnerHousers getByCarOwner(Long userId) {

        return carOwnerHousersDaoMysqlImpl.getByCarOwner(userId);
    }
}

