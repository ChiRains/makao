package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.query.ExpressQuery;
		
public interface ExpressDao extends ISimpleDao<Express, Long> {

	public boolean add(Express express);	
	
	public Express get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Express express);
	
	public List<Express> list(List<Long> idList);
	
	public Map<Long, Express> map(Set<Long> idSet);
	
	public Page<Express> page(ExpressQuery query, int start, int size);

	public List<Express> listAll();
	
	public Express getByCode(String code);
	
}
