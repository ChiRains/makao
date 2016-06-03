package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.CityDao;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;

@Repository
public class CityDaoCacheImpl implements CityDao {
	
	@Autowired
	private CityDao cityDaoMysqlImpl;
	
//	@Autowired
//	private CityDao cityDaoRedisImpl;

	@Override
	public boolean add(City city) {
		return cityDaoMysqlImpl.add(city);
	}

	@Override
	public City get(Long id) {
	    return cityDaoMysqlImpl.get(id);
//		return CacheLoader.get(cityDaoRedisImpl, cityDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return cityDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(City city){
		return cityDaoMysqlImpl.update(city);
	}
	
	@Override
	public List<City> list(List<Long> idList) {
	    return CacheLoader.list(cityDaoMysqlImpl, idList);
//		return CacheLoader.list(cityDaoRedisImpl, cityDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, City> map(Set<Long> idSet){
	    return CacheLoader.map(cityDaoMysqlImpl, idSet);
//		return CacheLoader.map(cityDaoRedisImpl, cityDaoMysqlImpl, idSet);
	}

	@Override
	public Page<City> page(int start, int count){
		return cityDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<City> page(CityQuery query, int start, int count){
		return cityDaoMysqlImpl.page(query, start, count);
	}
	
	public List<City> listAll(){
		return cityDaoMysqlImpl.listAll();
	}

    @Override
    public City getByName(String name) {       
        return cityDaoMysqlImpl.getByName(name);
    }

    @Override
    public List<City> listByProvince(long provinceId) {        
        return cityDaoMysqlImpl.listByProvince(provinceId);
    }
}

