package com.qcloud.component.publicservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.CommonQuestionDao;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.service.CommonQuestionService;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;
		
@Service
public class CommonQuestionServiceImpl implements CommonQuestionService{
	
	@Autowired
	private CommonQuestionDao commonQuestionDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicservice_common_question";

	@Override
	public boolean add(CommonQuestion commonQuestion) {
		long id = autoIdGenerator.get(ID_KEY); 				// 这里已经实现了生成long类型id的逻辑，传入即可
		commonQuestion.setId(id);
		
		return commonQuestionDao.add(commonQuestion);
	}

	@Override
	public CommonQuestion get(Long id) {	
		return commonQuestionDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return commonQuestionDao.delete(id);
	}
	
	@Override
	public boolean update(CommonQuestion commonQuestion) {
		return commonQuestionDao.update(commonQuestion);
	}
	
	@Override
	public Page<CommonQuestion> page(int start, int count) {
		return commonQuestionDao.page(start, count);
	}
	
	@Override
	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int count) {
		return commonQuestionDao.page(query, start, count);
	}
	
	public List<CommonQuestion> listAll(){
		return commonQuestionDao.listAll();
	}
	
	@Override
	public CommonQuestion listBySortNo(int sortNo) {
		return commonQuestionDao.listBySortNo(sortNo);
	}
}

