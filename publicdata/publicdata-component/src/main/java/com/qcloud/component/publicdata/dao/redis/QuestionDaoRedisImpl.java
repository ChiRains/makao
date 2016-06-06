package com.qcloud.component.publicdata.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.publicdata.dao.QuestionDao;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;

@Repository
public class QuestionDaoRedisImpl implements QuestionDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(Question question) {			
		throw new NotImplementedException();
	}

	@Override
	public Question get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Question question){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Question> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Question> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Question> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Question> page(QuestionQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Question> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public List<Question> listByQuestionnaire(long questionnaireId) {
        throw new NotImplementedException();
    }
}

