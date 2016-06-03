package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerWorkersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

@Repository
public class CarOwnerWorkersDaoCacheImpl implements CarOwnerWorkersDao {
	
	@Autowired
	private CarOwnerWorkersDao carOwnerWorkersDaoMysqlImpl;
	
	@Autowired
	private CarOwnerWorkersDao carOwnerWorkersDaoRedisImpl;

	@Override
	public boolean add(CarOwnerWorkers carOwnerWorkers) {
		return carOwnerWorkersDaoMysqlImpl.add(carOwnerWorkers);
	}

	@Override
	public CarOwnerWorkers get(Long id) {
		return  carOwnerWorkersDaoMysqlImpl.get( id);
	}

	@Override
	public boolean delete(Long id){
		return carOwnerWorkersDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CarOwnerWorkers carOwnerWorkers){
		return carOwnerWorkersDaoMysqlImpl.update(carOwnerWorkers);
	}
	
	@Override
	public List<CarOwnerWorkers> list(List<Long> idList) {
		return CacheLoader.list(carOwnerWorkersDaoRedisImpl, carOwnerWorkersDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CarOwnerWorkers> map(Set<Long> idSet){
		return CacheLoader.map(carOwnerWorkersDaoRedisImpl, carOwnerWorkersDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CarOwnerWorkers> page(int start, int count){
		return carOwnerWorkersDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int count){
		return carOwnerWorkersDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CarOwnerWorkers> listAll(){
		return carOwnerWorkersDaoMysqlImpl.listAll();
	}

    @Override
    public CarOwnerWorkers getByCarOwner(Long carOwnerId) {

        return carOwnerWorkersDaoMysqlImpl.getByCarOwner(carOwnerId);
    }
}

