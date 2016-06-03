package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.DistrictDao;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;

@Repository
public class DistrictDaoCacheImpl implements DistrictDao {
	
	@Autowired
	private DistrictDao districtDaoMysqlImpl;
	
//	@Autowired
//	private DistrictDao districtDaoRedisImpl;

	@Override
	public boolean add(District district) {
		return districtDaoMysqlImpl.add(district);
	}

	@Override
	public District get(Long id) {
	    return districtDaoMysqlImpl.get(id);
//		return CacheLoader.get(districtDaoRedisImpl, districtDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return districtDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(District district){
		return districtDaoMysqlImpl.update(district);
	}
	
	@Override
	public List<District> list(List<Long> idList) {	    
	    return CacheLoader.list(districtDaoMysqlImpl, idList);
//		return CacheLoader.list(districtDaoRedisImpl, districtDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, District> map(Set<Long> idSet){
	    return CacheLoader.map(districtDaoMysqlImpl, idSet);
//		return CacheLoader.map(districtDaoRedisImpl, districtDaoMysqlImpl, idSet);
	}

	@Override
	public Page<District> page(int start, int count){
		return districtDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<District> page(DistrictQuery query, int start, int count){
		return districtDaoMysqlImpl.page(query, start, count);
	}
	
	public List<District> listAll(){
		return districtDaoMysqlImpl.listAll();
	}

    @Override
    public District getByName(String name) {
        return districtDaoMysqlImpl.getByName(name);
    }

    @Override
    public List<District> listByCity(long cityId) {        
        return districtDaoMysqlImpl.listByCity(cityId);
    }
}

