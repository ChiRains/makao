package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarCardDao;
import com.qcloud.project.macaovehicle.model.CarCard;
import com.qcloud.project.macaovehicle.model.query.CarCardQuery;

@Repository
public class CarCardDaoCacheImpl implements CarCardDao {
	
	@Autowired
	private CarCardDao carCardDaoMysqlImpl;
	
	@Autowired
	private CarCardDao carCardDaoRedisImpl;

	@Override
	public boolean add(CarCard carCard) {
		return carCardDaoMysqlImpl.add(carCard);
	}

	@Override
	public CarCard get(Long id) {
		return carCardDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return carCardDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CarCard carCard){
		return carCardDaoMysqlImpl.update(carCard);
	}
	
	@Override
	public List<CarCard> list(List<Long> idList) {
		return CacheLoader.list(carCardDaoRedisImpl, carCardDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CarCard> map(Set<Long> idSet){
		return CacheLoader.map(carCardDaoRedisImpl, carCardDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CarCard> page(int start, int count){
		return carCardDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CarCard> page(CarCardQuery query, int start, int count){
		return carCardDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CarCard> listAll(){
		return carCardDaoMysqlImpl.listAll();
	}
}

