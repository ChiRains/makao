package com.qcloud.component.publicservice.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;

public interface CommonQuestionService {
	
	public boolean add(CommonQuestion commonQuestion);	
	
	public CommonQuestion get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(CommonQuestion commonQuestion);
	
	public Page<CommonQuestion> page(int start, int count);

	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int count);
	
	public List<CommonQuestion> listAll();
	
	public CommonQuestion listBySortNo(int sortNo);
}

