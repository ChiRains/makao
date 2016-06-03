package com.qcloud.component.publicdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.QuestionDao;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.service.QuestionService;
import com.qcloud.component.publicdata.model.query.QuestionQuery;
		
@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicdata_question";

	@Override
	public boolean add(Question question) {
		long id = autoIdGenerator.get(ID_KEY);
		question.setId(id);
		
		return questionDao.add(question);
	}

	@Override
	public Question get(Long id) {	
		return questionDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return questionDao.delete(id);
	}
	
	@Override
	public boolean update(Question question) {
		return questionDao.update(question);
	}
	
	@Override
	public Page<Question> page(QuestionQuery query, int start, int count) {
		return questionDao.page(query, start, count);
	}
	
	public List<Question> listAll(){
		return questionDao.listAll();
	}

    @Override
    public List<Question> listByQuestionnaire(long questionnaireId) {
        return questionDao.listByQuestionnaire(questionnaireId);
    }
}

