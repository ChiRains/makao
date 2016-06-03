package com.qcloud.component.permission.dao.cache;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.dao.CatalogDao;
import com.qcloud.component.permission.model.Catalog;

@Repository
public class CatalogDaoCacheImpl implements CatalogDao {
	
	@Autowired
	private CatalogDao catalogDaoMysqlImpl;
	
	@Autowired
	private CatalogDao catalogDaoMomeryImpl;

	@Override
	public boolean add(Catalog catalog) {
		return catalogDaoMysqlImpl.add(catalog);
	}

	@Override
	public Catalog get(Long id) {
		return CacheLoader.get(catalogDaoMomeryImpl, catalogDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return catalogDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Catalog catalog){
		return catalogDaoMysqlImpl.update(catalog);
	}
	
	@Override
	public List<Catalog> list(List<Long> idList) {
		return CacheLoader.list(catalogDaoMomeryImpl, catalogDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Catalog> map(Set<Long> idSet){
		return CacheLoader.map(catalogDaoMomeryImpl, catalogDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Catalog> page(int start, int count){
		return catalogDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public List<Catalog> list() {
		List<Long> keys = catalogDaoMomeryImpl.listKeys();
		if (keys == null) {
			keys = catalogDaoMysqlImpl.listKeys();
			if(keys != null){
				catalogDaoMomeryImpl.addKeys(keys);
			}
		}
		List<Catalog> list = new ArrayList<Catalog>();
		if(keys != null){
			for (Long key : keys) {
				list.add(get(key));
			}
		}
		return list;
	}

	@Override
	public List<Long> listKeys() {
		throw new NotImplementedException();
	}

	@Override
	public void addKeys(List<Long> keys) {
		throw new NotImplementedException();
	}
}

