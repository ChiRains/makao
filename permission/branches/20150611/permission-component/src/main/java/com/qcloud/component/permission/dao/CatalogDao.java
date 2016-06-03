package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Catalog;

public interface CatalogDao extends ISimpleDao<Catalog, Long> {

	public boolean add(Catalog catalog);

	public Catalog get(Long id);

	public boolean delete(Long id);

	public boolean update(Catalog catalog);

	public List<Catalog> list(List<Long> idList);

	public Map<Long, Catalog> map(Set<Long> idSet);

	public Page<Catalog> page(int start, int size);

	List<Catalog> list();

	List<Long> listKeys();

	void addKeys(List<Long> keys);
}
