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
import com.qcloud.component.publicdata.dao.QuestionnaireDao;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

@Repository
public class QuestionnaireDaoRedisImpl implements QuestionnaireDao {

	//@Resource(name = "redis-publicdata")
	//private Redis redis;

	@Override
	public boolean add(Questionnaire questionnaire) {			
		throw new NotImplementedException();
	}

	@Override
	public Questionnaire get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(Questionnaire questionnaire){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Questionnaire> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Questionnaire> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Questionnaire> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<Questionnaire> page(QuestionnaireQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<Questionnaire> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public Questionnaire getByCode(String code) {
        throw new NotImplementedException();
    }
}

