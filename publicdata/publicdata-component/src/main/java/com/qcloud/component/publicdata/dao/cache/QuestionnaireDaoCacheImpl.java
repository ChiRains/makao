package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.QuestionnaireDao;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

@Repository
public class QuestionnaireDaoCacheImpl implements QuestionnaireDao {
	
	@Autowired
	private QuestionnaireDao questionnaireDaoMysqlImpl;
	
//	@Autowired
//	private QuestionnaireDao questionnaireDaoRedisImpl;

	@Override
	public boolean add(Questionnaire questionnaire) {
		return questionnaireDaoMysqlImpl.add(questionnaire);
	}

	@Override
	public Questionnaire get(Long id) {
	    return questionnaireDaoMysqlImpl.get(id);
//		return CacheLoader.get(questionnaireDaoRedisImpl, questionnaireDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return questionnaireDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(Questionnaire questionnaire){
		return questionnaireDaoMysqlImpl.update(questionnaire);
	}
	
	@Override
	public List<Questionnaire> list(List<Long> idList) {
		return CacheLoader.list(questionnaireDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, Questionnaire> map(Set<Long> idSet){
		return CacheLoader.map(questionnaireDaoMysqlImpl, idSet);
	}

	@Override
	public Page<Questionnaire> page(int start, int count){
		return questionnaireDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<Questionnaire> page(QuestionnaireQuery query, int start, int count){
		return questionnaireDaoMysqlImpl.page(query, start, count);
	}
	
	public List<Questionnaire> listAll(){
		return questionnaireDaoMysqlImpl.listAll();
	}

    @Override
    public Questionnaire getByCode(String code) {
        return questionnaireDaoMysqlImpl.getByCode(code);
    }
}

