package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerEnterprisersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

@Repository
public class CarOwnerEnterprisersDaoCacheImpl implements CarOwnerEnterprisersDao {
	
	@Autowired
	private CarOwnerEnterprisersDao carOwnerEnterprisersDaoMysqlImpl;
	
	@Autowired
	private CarOwnerEnterprisersDao carOwnerEnterprisersDaoRedisImpl;

	@Override
	public boolean add(CarOwnerEnterprisers carOwnerEnterprisers) {
		return carOwnerEnterprisersDaoMysqlImpl.add(carOwnerEnterprisers);
	}

	@Override
	public CarOwnerEnterprisers get(Long id) {
		return carOwnerEnterprisersDaoMysqlImpl.get( id);
	}

	@Override
	public boolean delete(Long id){
		return carOwnerEnterprisersDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CarOwnerEnterprisers carOwnerEnterprisers){
		return carOwnerEnterprisersDaoMysqlImpl.update(carOwnerEnterprisers);
	}
	
	@Override
	public List<CarOwnerEnterprisers> list(List<Long> idList) {
		return CacheLoader.list(carOwnerEnterprisersDaoRedisImpl, carOwnerEnterprisersDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CarOwnerEnterprisers> map(Set<Long> idSet){
		return CacheLoader.map(carOwnerEnterprisersDaoRedisImpl, carOwnerEnterprisersDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CarOwnerEnterprisers> page(int start, int count){
		return carOwnerEnterprisersDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int count){
		return carOwnerEnterprisersDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CarOwnerEnterprisers> listAll(){
		return carOwnerEnterprisersDaoMysqlImpl.listAll();
	}

    @Override
    public CarOwnerEnterprisers getByCarOwner(Long carOwnerId) {

        return carOwnerEnterprisersDaoMysqlImpl.getByCarOwner(carOwnerId);
    }
}

