package com.qcloud.component.permission.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.model.Menu;

public interface MenuService {

	public boolean add(Menu menu);

	public Menu get(Long id);

	public boolean delete(Long id);

	public boolean update(Menu menu);

	public Page<Menu> page(int start, int count);

	List<Menu> list();

	List<Menu> list(long catalogId);

	List<Menu> list(List<Long> idList);
}
