package com.qcloud.component.publicservice.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;
		
public interface CommonQuestionDao extends ISimpleDao<CommonQuestion, Long> {

	public boolean add(CommonQuestion commonQuestion);	
	
	public CommonQuestion get(Long id);

	public boolean delete(Long id);
	
	public boolean update(CommonQuestion commonQuestion);
	
	public List<CommonQuestion> list(List<Long> idList);
	
	public Map<Long, CommonQuestion> map(Set<Long> idSet);
	
	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int size);

	public List<CommonQuestion> listAll();
	
	public CommonQuestion listBySortNo(int sortNo);
	
}
