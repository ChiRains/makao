package com.qcloud.component.permission.dao.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.component.permission.dao.CatalogDao;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.pirates.data.Page;

@Repository
public class CatalogDaoMomeryImpl implements CatalogDao {

	private Map<Long, Catalog> map = new HashMap<Long, Catalog>();

	private List<Long> keys = null;

	@Override
	public boolean add(Catalog bean) {
		map.put(bean.getId(), bean);
		return true;
	}

	@Override
	public Catalog get(Long key) {
		return map.get(key);
	}

	@Override
	public List<Catalog> list() {
		throw new NotImplementedException();
	}

	@Override
	public List<Long> listKeys() {
		return keys;
	}

	@Override
	public void addKeys(List<Long> keys) {
		this.keys = keys;
	}

	@Override
	public boolean delete(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public boolean update(Catalog catalog) {
		throw new NotImplementedException();
	}

	@Override
	public List<Catalog> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Catalog> map(Set<Long> idSet) {
		throw new NotImplementedException();
	}

	@Override
	public Page<Catalog> page(int start, int size) {
		throw new NotImplementedException();
	}
}
