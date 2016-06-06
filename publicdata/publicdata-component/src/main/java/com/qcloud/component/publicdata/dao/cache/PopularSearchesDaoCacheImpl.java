package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.PopularSearchesDao;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

@Repository
public class PopularSearchesDaoCacheImpl implements PopularSearchesDao {
	
	@Autowired
	private PopularSearchesDao popularSearchesDaoMysqlImpl;
	
//	@Autowired
//	private PopularSearchesDao popularSearchesDaoRedisImpl;

	@Override
	public boolean add(PopularSearches popularSearches) {
		return popularSearchesDaoMysqlImpl.add(popularSearches);
	}

	@Override
	public PopularSearches get(Long id) {
		return popularSearchesDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return popularSearchesDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(PopularSearches popularSearches){
		return popularSearchesDaoMysqlImpl.update(popularSearches);
	}
	
	@Override
	public List<PopularSearches> list(List<Long> idList) {
		return CacheLoader.list(popularSearchesDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, PopularSearches> map(Set<Long> idSet){
		return CacheLoader.map(popularSearchesDaoMysqlImpl, idSet);
	}

	@Override
	public Page<PopularSearches> page(int start, int count){
		return popularSearchesDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<PopularSearches> page(PopularSearchesQuery query, int start, int count){
		return popularSearchesDaoMysqlImpl.page(query, start, count);
	}
	
	public List<PopularSearches> listAll(){
		return popularSearchesDaoMysqlImpl.listAll();
	}

    @Override
    public List<PopularSearches> listTop(int type, int number) {
        return popularSearchesDaoMysqlImpl.listTop(type, number);
    }

    @Override
    public PopularSearches get(int type, String keywords) {
        return popularSearchesDaoMysqlImpl.get(type, keywords);
    }
}

