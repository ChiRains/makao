package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ExpressDistrictDao;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;

@Repository
public class ExpressDistrictDaoCacheImpl implements ExpressDistrictDao {
	
	@Autowired
	private ExpressDistrictDao expressDistrictDaoMysqlImpl;
	
	@Autowired
	private ExpressDistrictDao expressDistrictDaoRedisImpl;

	@Override
	public boolean add(ExpressDistrict expressDistrict) {
		return expressDistrictDaoMysqlImpl.add(expressDistrict);
	}

	@Override
	public ExpressDistrict get(Long id) {
		return CacheLoader.get(expressDistrictDaoRedisImpl, expressDistrictDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return expressDistrictDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ExpressDistrict expressDistrict){
		return expressDistrictDaoMysqlImpl.update(expressDistrict);
	}
	
	@Override
	public List<ExpressDistrict> list(List<Long> idList) {
		return CacheLoader.list(expressDistrictDaoRedisImpl, expressDistrictDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ExpressDistrict> map(Set<Long> idSet){
		return CacheLoader.map(expressDistrictDaoRedisImpl, expressDistrictDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ExpressDistrict> page(int start, int count){
		return expressDistrictDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int count){
		return expressDistrictDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ExpressDistrict> listAll(){
		return expressDistrictDaoMysqlImpl.listAll();
	}

    @Override
    public List<ExpressDistrict> listByExpressId(Long expressId) {
        return expressDistrictDaoMysqlImpl.listByExpressId(expressId);
    }
}

