package com.qcloud.component.permission.vo;

import java.util.List;

import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.model.Menu;

public class CatalogVO {

	private Catalog catalog;

	private List<Menu> menuList;

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
