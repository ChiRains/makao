package com.qcloud.component.permission.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.permission.model.Resources;
		
public interface ResourcesDao extends ISimpleDao<Resources, Long> {

	public boolean add(Resources resources);	
	
	public Resources get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Resources resources);
	
	public List<Resources> list(List<Long> idList);
	
	public Map<Long, Resources> map(Set<Long> idSet);
	
	public Page<Resources> page(int start, int size);

}
