package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Menu;

public interface MenuDao extends ISimpleDao<Menu, Long> {

	public boolean add(Menu menu);

	public Menu get(Long id);

	public boolean delete(Long id);

	public boolean update(Menu menu);

	public List<Menu> list(List<Long> idList);

	public Map<Long, Menu> map(Set<Long> idSet);

	public Page<Menu> page(int start, int size);

	List<Menu> list();

	List<Menu> list(long catalogId);

	List<Long> listKeys();

	List<Long> listKeysByCatalog(long catalogId);

	void addKeys(List<Long> keys);

	void addKeys(long catalogId, List<Long> keys);
}
