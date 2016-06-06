package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.QuestionDao;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;

@Repository
public class QuestionDaoCacheImpl implements QuestionDao {
	
	@Autowired
	private QuestionDao questionDaoMysqlImpl;
	
//	@Autowired
//	private QuestionDao questionDaoRedisImpl;

	@Override
	public boolean add(Question question) {
		return questionDaoMysqlImpl.add(question);
	}

	@Override
	public Question get(Long id) {
	    return questionDaoMysqlImpl.get(id); 
//		return CacheLoader.get(questionDaoRedisImpl, questionDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return questionDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Question question){
		return questionDaoMysqlImpl.update(question);
	}
	
	@Override
	public List<Question> list(List<Long> idList) {
		return CacheLoader.list(questionDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Question> map(Set<Long> idSet){
		return CacheLoader.map(questionDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Question> page(int start, int count){
		return questionDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Question> page(QuestionQuery query, int start, int count){
		return questionDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Question> listAll(){
		return questionDaoMysqlImpl.listAll();
	}

    @Override
    public List<Question> listByQuestionnaire(long questionnaireId) {
        return questionDaoMysqlImpl.listByQuestionnaire(questionnaireId);
    }
}

