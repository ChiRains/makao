package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.NeighbourhoodDao;
import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.model.query.NeighbourhoodQuery;

@Repository
public class NeighbourhoodDaoCacheImpl implements NeighbourhoodDao {
	
	@Autowired
	private NeighbourhoodDao neighbourhoodDaoMysqlImpl;
	
	/*@Autowired
	private NeighbourhoodDao neighbourhoodDaoRedisImpl;*/

	@Override
	public boolean add(Neighbourhood neighbourhood) {
		return neighbourhoodDaoMysqlImpl.add(neighbourhood);
	}

	@Override
	public Neighbourhood get(Long id) {
		return neighbourhoodDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return neighbourhoodDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Neighbourhood neighbourhood){
		return neighbourhoodDaoMysqlImpl.update(neighbourhood);
	}
	
	@Override
	public List<Neighbourhood> list(List<Long> idList) {
		return CacheLoader.list( neighbourhoodDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Neighbourhood> map(Set<Long> idSet){
		return CacheLoader.map(neighbourhoodDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Neighbourhood> page(int start, int count){
		return neighbourhoodDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Neighbourhood> page(NeighbourhoodQuery query, int start, int count){
		return neighbourhoodDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Neighbourhood> listAll(){
		return neighbourhoodDaoMysqlImpl.listAll();
	}
}

