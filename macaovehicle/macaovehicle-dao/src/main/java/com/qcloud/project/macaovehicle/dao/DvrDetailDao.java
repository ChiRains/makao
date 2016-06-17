package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;
		
public interface DvrDetailDao extends ISimpleDao<DvrDetail, Long> {

	public boolean add(DvrDetail dvrDetail);	
	
	public DvrDetail get(Long id);

	public boolean delete(Long id);
	
	public boolean update(DvrDetail dvrDetail);
	
	public List<DvrDetail> list(List<Long> idList);
	
	public Map<Long, DvrDetail> map(Set<Long> idSet);
	
	public Page<DvrDetail> page(DvrDetailQuery query, int start, int size);

	public List<DvrDetail> listAll();
	
	public List<DvrDetail> getByArea(long id);
}
