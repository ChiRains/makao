package com.qcloud.component.permission.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.ResourcesDao;
import com.qcloud.component.permission.model.Resources;

@Repository
public class ResourcesDaoCacheImpl implements ResourcesDao {
	
	@Autowired
	private ResourcesDao resourcesDaoMysqlImpl;
	
	@Autowired
	private ResourcesDao resourcesDaoRedisImpl;

	@Override
	public boolean add(Resources resources) {
		return resourcesDaoMysqlImpl.add(resources);
	}

	@Override
	public Resources get(Long id) {
		return CacheLoader.get(resourcesDaoRedisImpl, resourcesDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return resourcesDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Resources resources){
		return resourcesDaoMysqlImpl.update(resources);
	}
	
	@Override
	public List<Resources> list(List<Long> idList) {
		return CacheLoader.list(resourcesDaoRedisImpl, resourcesDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Resources> map(Set<Long> idSet){
		return CacheLoader.map(resourcesDaoRedisImpl, resourcesDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Resources> page(int start, int count){
		return resourcesDaoMysqlImpl.page(start, count);
	}
}

