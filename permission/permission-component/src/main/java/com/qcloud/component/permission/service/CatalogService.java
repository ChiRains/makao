package com.qcloud.component.permission.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.model.Catalog;

public interface CatalogService {

	public boolean add(Catalog catalog);

	public Catalog get(Long id);

	public boolean delete(Long id);

	public boolean update(Catalog catalog);

	public Page<Catalog> page(int start, int count);

	List<Catalog> list();
}
