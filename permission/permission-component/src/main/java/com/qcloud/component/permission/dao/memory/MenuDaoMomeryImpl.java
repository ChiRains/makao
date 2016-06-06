package com.qcloud.component.permission.dao.memory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.component.permission.dao.MenuDao;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.query.MenuQuery;
import com.qcloud.pirates.data.Page;

@Repository
public class MenuDaoMomeryImpl implements MenuDao {

	private Map<Long, Menu> map = new HashMap<Long, Menu>();

	private Map<Long, List<Long>> keysMap = new HashMap<Long, List<Long>>();

	@Override
	public boolean add(Menu bean) {
		map.put(bean.getId(), bean);
		return true;
	}

	@Override
	public Menu get(Long key) {
		return map.get(key);
	}

	@Override
	public List<Menu> list() {
		throw new NotImplementedException();
	}

	@Override
	public List<Menu> list(long catalogId) {
		throw new NotImplementedException();
	}

	@Override
	public List<Long> listKeys() {
		return keysMap.get(-1l);
	}

	@Override
	public List<Long> listKeysByCatalog(long catalogId) {
		return keysMap.get(catalogId);
	}

	@Override
	public void addKeys(List<Long> keys) {
		keysMap.put(-1L, keys);
	}

	@Override
	public void addKeys(long catalogId, List<Long> keys) {
		keysMap.put(catalogId, keys);
	}

	@Override
	public boolean delete(Long id) {
		throw new NotImplementedException();
	}

	@Override
	public boolean update(Menu menu) {
		throw new NotImplementedException();
	}

	@Override
	public List<Menu> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Menu> map(Set<Long> idSet) {
		Map<Long, Menu> resultMap = new HashMap<Long, Menu>();
		for (Long key : idSet) {
			resultMap.put(key, map.get(key));
		}
		return resultMap;
	}

	@Override
	public Page<Menu> page(int start, int size) {
		throw new NotImplementedException();
	}

    @Override
    public Page<Menu> page(MenuQuery query, int start, int size) {
        throw new NotImplementedException();
    }
}
