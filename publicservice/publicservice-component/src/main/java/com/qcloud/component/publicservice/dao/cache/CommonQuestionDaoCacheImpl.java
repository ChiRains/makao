package com.qcloud.component.publicservice.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.CommonQuestionDao;
import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.model.query.CommonQuestionQuery;

@Repository
public class CommonQuestionDaoCacheImpl implements CommonQuestionDao {
	
	@Autowired
	private CommonQuestionDao commonQuestionDaoMysqlImpl;
	
	@Autowired
	private CommonQuestionDao commonQuestionDaoRedisImpl;

	@Override
	public boolean add(CommonQuestion commonQuestion) {
		return commonQuestionDaoMysqlImpl.add(commonQuestion);
	}

	@Override
	public CommonQuestion get(Long id) {
		return commonQuestionDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return commonQuestionDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CommonQuestion commonQuestion){
		return commonQuestionDaoMysqlImpl.update(commonQuestion);
	}
	
	@Override
	public List<CommonQuestion> list(List<Long> idList) {
		return CacheLoader.list(commonQuestionDaoRedisImpl, commonQuestionDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CommonQuestion> map(Set<Long> idSet){
		return CacheLoader.map(commonQuestionDaoRedisImpl, commonQuestionDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CommonQuestion> page(int start, int count){
		return commonQuestionDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CommonQuestion> page(CommonQuestionQuery query, int start, int count){
		return commonQuestionDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CommonQuestion> listAll(){
		return commonQuestionDaoMysqlImpl.listAll();
	}

	@Override
	public CommonQuestion listBySortNo(int sortNo) {
		return commonQuestionDaoMysqlImpl.listBySortNo(sortNo);
	}
}

