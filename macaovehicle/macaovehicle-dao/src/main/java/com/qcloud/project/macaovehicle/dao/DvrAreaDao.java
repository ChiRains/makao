package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;
		
public interface DvrAreaDao extends ISimpleDao<DvrArea, Long> {

	public boolean add(DvrArea dvrArea);	
	
	public DvrArea get(Long id);

	public boolean delete(Long id);
	
	public boolean update(DvrArea dvrArea);
	
	public List<DvrArea> list(List<Long> idList);
	
	public Map<Long, DvrArea> map(Set<Long> idSet);
	
	public Page<DvrArea> page(DvrAreaQuery query, int start, int size);

	public List<DvrArea> listAll();
	
	
}
