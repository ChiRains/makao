package com.qcloud.component.publicdata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicdata.dao.QuestionDao;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;
		
@Repository
public class QuestionDaoMysqlImpl implements QuestionDao {

	@Resource(name = "sqlOperator-publicdata")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Question question) {
		return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.insert", question) == 1;
	}	
	
	@Override
	public Question get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Question question){
		return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.update", question) > 0;
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
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Question> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.count4page",
				param);
		Page<Question> page = new Page<Question>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Question> page(QuestionQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);
		param.put("questionnaireId", query.getQuestionnaireId());

		List<Question> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.count4query",
				param);
		Page<Question> page = new Page<Question>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Question> listAll(){	
		List<Question> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.listAll");
		return list;
	}

    @Override
    public List<Question> listByQuestionnaire(long questionnaireId) {

        List<Question> list = sqlOperator.selectList(
                "com.qcloud.component.publicdata.dao.mysql.mapper.QuestionMapper.listByQuestionnaire", questionnaireId);
        return list;
    }
}

