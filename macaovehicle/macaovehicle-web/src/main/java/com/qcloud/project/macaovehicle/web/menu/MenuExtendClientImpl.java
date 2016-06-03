package com.qcloud.project.macaovehicle.web.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.qcloud.component.admin.web.menu.MenuExtendClient;
import com.qcloud.component.permission.vo.CatalogVO;

@Component
public class MenuExtendClientImpl implements MenuExtendClient {

	@Override
	public List<CatalogVO> list() {
		List<CatalogVO> list = new ArrayList<CatalogVO>();
		
		return list;
	}
}
