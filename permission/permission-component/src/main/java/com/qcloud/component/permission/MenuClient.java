package com.qcloud.component.permission;

import java.util.List;

import com.qcloud.component.permission.model.Catalog;
import com.qcloud.component.permission.vo.CatalogVO;

public interface MenuClient {

	List<CatalogVO> list(String[] accounts);

	List<Catalog> listCatalogs();
}
