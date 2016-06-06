package com.qcloud.component.publicservice.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicservice.dao.CommonQuestionDao;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;
		
@Repository
public class CommonQuestionDaoMysqlImpl implements CommonQuestionDao {

	@Resource(name = "sqlOperator-publicservice")
	private SqlOperator sqlOperator;
	
	@Override
	public boolean add(CommonQuestion commonQuestion) {
		return sqlOperator.insert("com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.insert", commonQuestion) == 1;
	}	
	
	@Override
	public CommonQuestion get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(CommonQuestion commonQuestion){
		return sqlOperator.update("com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.update", commonQuestion) > 0;
	}
	
	@Override
	public List<CommonQuestion> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CommonQuestion> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CommonQuestion> page(int start, int count){
		return page(null, start, count);
	}
	
	@Override
	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CommonQuestion> list = sqlOperator.selectList(
				"com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.count4query",
				param);
		Page<CommonQuestion> page = new Page<CommonQuestion>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<CommonQuestion> listAll(){	
		throw new NotImplementedException();
	}
	
	@Override
	public CommonQuestion listBySortNo(int sortNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sort", sortNo);
		return sqlOperator.selectOne("com.qcloud.component.publicservice.dao.mysql.mapper.CommonQuestionMapper.listBySortNo", param);
	}	
}

