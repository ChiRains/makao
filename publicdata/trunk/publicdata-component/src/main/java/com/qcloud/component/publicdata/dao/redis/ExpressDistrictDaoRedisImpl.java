package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.ExpressDistrictDao;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;

@Repository
public class ExpressDistrictDaoRedisImpl implements ExpressDistrictDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(ExpressDistrict expressDistrict) {			
		throw new NotImplementedException();
	}

	@Override
	public ExpressDistrict get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(ExpressDistrict expressDistrict){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ExpressDistrict> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ExpressDistrict> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ExpressDistrict> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<ExpressDistrict> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public List<ExpressDistrict> listByExpressId(Long expressId) {
        throw new NotImplementedException();
    }
}

