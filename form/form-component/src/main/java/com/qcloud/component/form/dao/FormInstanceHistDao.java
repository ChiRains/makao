package com.qcloud.component.form.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;
		
public interface FormInstanceHistDao extends ISimpleDao<FormInstanceHist, Long> {

	public boolean add(FormInstanceHist formInstanceHist);	
	
	public FormInstanceHist get(Long id);

	public boolean delete(Long id);
	
	public boolean update(FormInstanceHist formInstanceHist);
	
	public List<FormInstanceHist> list(List<Long> idList);
	
	public Map<Long, FormInstanceHist> map(Set<Long> idSet);
	
	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int size);

	public List<FormInstanceHist> listAll();
	
}
