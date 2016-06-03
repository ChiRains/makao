package com.qcloud.component.permission.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.MenuDao;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.pirates.data.Page;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private AutoIdGenerator autoIdGenerator;

	private String key = "permission_menu";

	@Override
	public boolean add(Menu menu) {
		long id = autoIdGenerator.get(key);
		menu.setId(id);
		return menuDao.add(menu);
	}

	@Override
	public Menu get(Long id) {
		return menuDao.get(id);
	}

	@Override
	public boolean delete(Long id) {
		return menuDao.delete(id);
	}

	@Override
	public boolean update(Menu menu) {
		return menuDao.update(menu);
	}

	@Override
	public Page<Menu> page(int start, int count) {
		return menuDao.page(start, count);
	}

	@Override
	public List<Menu> list() {
		List<Menu> menuList = menuDao.list();
		Collections.sort(menuList, new MenuComparator());
		return menuList;
	}

	@Override
	public List<Menu> list(long catalogId) {
		List<Menu> menuList = menuDao.list(catalogId);
		Collections.sort(menuList, new MenuComparator());
		return menuList;
	}

	class MenuComparator implements Comparator<Menu> {
		@Override
		public int compare(Menu o1, Menu o2) {
			return o1.getOrder() - o2.getOrder();
		}
	}

	@Override
	public List<Menu> list(List<Long> idList) {
		return menuDao.list(idList);
	}
}
