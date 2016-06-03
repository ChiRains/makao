package com.qcloud.component.permission.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.CatalogDao;
import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.service.CatalogService;
import com.qcloud.pirates.data.Page;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	@Autowired
	private AutoIdGenerator autoIdGenerator;

	private String key = "permission_catalog";

	@Override
	public boolean add(Catalog catalog) {
		long id = autoIdGenerator.get(key);
		catalog.setId(id);
		return catalogDao.add(catalog);
	}

	@Override
	public Catalog get(Long id) {
		return catalogDao.get(id);
	}

	@Override
	public boolean delete(Long id) {
		return catalogDao.delete(id);
	}

	@Override
	public boolean update(Catalog catalog) {
		return catalogDao.update(catalog);
	}

	@Override
	public Page<Catalog> page(int start, int count) {
		return catalogDao.page(start, count);
	}

	@Override
	public List<Catalog> list() {
		return catalogDao.list();
	}
}
