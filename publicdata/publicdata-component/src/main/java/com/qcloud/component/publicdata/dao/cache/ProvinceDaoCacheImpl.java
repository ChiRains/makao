package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ProvinceDao;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;

@Repository
public class ProvinceDaoCacheImpl implements ProvinceDao {
	
	@Autowired
	private ProvinceDao provinceDaoMysqlImpl;
	
//	@Autowired
//	private ProvinceDao provinceDaoRedisImpl;

	@Override
	public boolean add(Province province) {
		return provinceDaoMysqlImpl.add(province);
	}

	@Override
	public Province get(Long id) {
	    return provinceDaoMysqlImpl.get(id);
//		return CacheLoader.get(provinceDaoRedisImpl, provinceDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return provinceDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Province province){
		return provinceDaoMysqlImpl.update(province);
	}
	
	@Override
	public List<Province> list(List<Long> idList) {
	    return CacheLoader.list(provinceDaoMysqlImpl, idList);
//		return CacheLoader.list(provinceDaoRedisImpl, provinceDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Province> map(Set<Long> idSet){
	    return CacheLoader.map(provinceDaoMysqlImpl, idSet);
//		return CacheLoader.map(provinceDaoRedisImpl, provinceDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Province> page(int start, int count){
		return provinceDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Province> page(ProvinceQuery query, int start, int count){
		return provinceDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Province> listAll(){
		return provinceDaoMysqlImpl.listAll();
	}

    @Override
    public Province getByName(String name) {       
        return provinceDaoMysqlImpl.getByName(name);
    }
}

