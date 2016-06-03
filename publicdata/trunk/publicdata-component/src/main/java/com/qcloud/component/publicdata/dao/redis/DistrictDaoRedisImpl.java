package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicdata.dao.DistrictDao;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
import com.qcloud.pirates.data.Page;

@Repository
public class DistrictDaoRedisImpl implements DistrictDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(District district) {			
		throw new NotImplementedException();
	}

	@Override
	public District get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(District district){
		throw new NotImplementedException();
	}
	
	@Override
	public List<District> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, District> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<District> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<District> page(DistrictQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<District> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public District getByName(String name) {
        throw new NotImplementedException();
    }

    @Override
    public List<District> listByCity(long cityId) {
        throw new NotImplementedException();
    }
}

