package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.PeccancyCarDao;
import com.qcloud.project.macaovehicle.model.PeccancyCar;
import com.qcloud.project.macaovehicle.model.query.PeccancyCarQuery;

@Repository
public class PeccancyCarDaoCacheImpl implements PeccancyCarDao {
	
	@Autowired
	private PeccancyCarDao peccancyCarDaoMysqlImpl;
	
	@Autowired
	private PeccancyCarDao peccancyCarDaoRedisImpl;

	@Override
	public boolean add(PeccancyCar peccancyCar) {
		return peccancyCarDaoMysqlImpl.add(peccancyCar);
	}

	@Override
	public PeccancyCar get(Long id) {
		return peccancyCarDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return peccancyCarDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(PeccancyCar peccancyCar){
		return peccancyCarDaoMysqlImpl.update(peccancyCar);
	}
	
	@Override
	public List<PeccancyCar> list(List<Long> idList) {
		return CacheLoader.list(peccancyCarDaoRedisImpl, peccancyCarDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, PeccancyCar> map(Set<Long> idSet){
		return CacheLoader.map(peccancyCarDaoRedisImpl, peccancyCarDaoMysqlImpl, idSet);
	}

	@Override
	public Page<PeccancyCar> page(int start, int count){
		return peccancyCarDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<PeccancyCar> page(PeccancyCarQuery query, int start, int count){
		return peccancyCarDaoMysqlImpl.page(query, start, count);
	}
	
	public List<PeccancyCar> listAll(){
		return peccancyCarDaoMysqlImpl.listAll();
	}
}

