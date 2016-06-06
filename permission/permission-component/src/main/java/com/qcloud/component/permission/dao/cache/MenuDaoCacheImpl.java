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
import com.qcloud.component.permission.dao.MenuDao;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.query.MenuQuery;

@Repository
public class MenuDaoCacheImpl implements MenuDao {

	@Autowired
	private MenuDao menuDaoMysqlImpl;

	@Autowired
	private MenuDao menuDaoMomeryImpl;

	@Override
	public boolean add(Menu menu) {
		return menuDaoMysqlImpl.add(menu);
	}

	@Override
	public Menu get(Long id) {
		return CacheLoader.get(menuDaoMomeryImpl, menuDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id) {
		return menuDaoMysqlImpl.delete(id);
	}

	@Override
	public boolean update(Menu menu) {
		return menuDaoMysqlImpl.update(menu);
	}

	@Override
	public List<Menu> list(List<Long> idList) {
		return CacheLoader.list(menuDaoMomeryImpl, menuDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Menu> map(Set<Long> idSet) {
		return CacheLoader.map(menuDaoMomeryImpl, menuDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Menu> page(int start, int count) {
		return menuDaoMysqlImpl.page(start, count);
	}

	@Override
	public List<Menu> list() {
		List<Long> keys = menuDaoMomeryImpl.listKeys();
		if (keys == null) {
			keys = menuDaoMysqlImpl.listKeys();
			if (keys != null) {
				menuDaoMomeryImpl.addKeys(keys);
			}
		}
		List<Menu> list = new ArrayList<Menu>();
		if (keys != null) {
			for (Long key : keys) {
				list.add(get(key));
			}
		}
		return list;
	}

	@Override
	public List<Menu> list(long catalogId) {
		List<Long> keys = menuDaoMomeryImpl.listKeysByCatalog(catalogId);
		if (keys == null) {
			keys = menuDaoMysqlImpl.listKeysByCatalog(catalogId);
			if (keys != null) {
				menuDaoMomeryImpl.addKeys(catalogId, keys);
			}
		}
		List<Menu> list = new ArrayList<Menu>();
		if (keys != null) {
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
	public List<Long> listKeysByCatalog(long catalogId) {
		throw new NotImplementedException();
	}

	@Override
	public void addKeys(List<Long> keys) {
		throw new NotImplementedException();
	}

	@Override
	public void addKeys(long catalogId, List<Long> keys) {
		throw new NotImplementedException();
	}

    @Override
    public Page<Menu> page(MenuQuery query, int start, int count) {
        return menuDaoMysqlImpl.page(query,start, count);
    }
}
