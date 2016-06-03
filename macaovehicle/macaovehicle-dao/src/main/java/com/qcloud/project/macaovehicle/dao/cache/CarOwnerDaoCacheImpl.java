package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;

@Repository
public class CarOwnerDaoCacheImpl implements CarOwnerDao {
	
	@Autowired
	private CarOwnerDao carOwnerDaoMysqlImpl;
	
	@Autowired
	private CarOwnerDao carOwnerDaoRedisImpl;

	@Override
	public boolean add(CarOwner carOwner) {
		return carOwnerDaoMysqlImpl.add(carOwner);
	}

	@Override
	public CarOwner get(Long id) {

		//return CacheLoader.get(carOwnerDaoRedisImpl, carOwnerDaoMysqlImpl, id);
	    return carOwnerDaoMysqlImpl.get(id);


	}

	@Override
	public boolean delete(Long id){
		return carOwnerDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CarOwner carOwner){
		return carOwnerDaoMysqlImpl.update(carOwner);
	}
	
	@Override
	public List<CarOwner> list(List<Long> idList) {
		return CacheLoader.list(carOwnerDaoRedisImpl, carOwnerDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CarOwner> map(Set<Long> idSet){
		return CacheLoader.map(carOwnerDaoRedisImpl, carOwnerDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CarOwner> page(int start, int count){
		return carOwnerDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CarOwner> page(CarOwnerQuery query, int start, int count){
		return carOwnerDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CarOwner> listAll(){
		return carOwnerDaoMysqlImpl.listAll();
	}

    @Override
    public CarOwner getByClerk(Long userId) {

        return carOwnerDaoMysqlImpl.getByClerk(userId);
    }

    @Override
    public CarOwner getByIdcardNumber(String idcardNumber) {

        return carOwnerDaoMysqlImpl.getByIdcardNumber(idcardNumber);
    }
}

