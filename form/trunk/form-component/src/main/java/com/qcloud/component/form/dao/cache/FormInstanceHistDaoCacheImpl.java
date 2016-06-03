package com.qcloud.component.form.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormInstanceHistDao;
import com.qcloud.component.form.model.FormInstanceHist;
import com.qcloud.component.form.model.query.FormInstanceHistQuery;

@Repository
public class FormInstanceHistDaoCacheImpl implements FormInstanceHistDao {
	
	@Autowired
	private FormInstanceHistDao formInstanceHistDaoMysqlImpl;
	
    // @Autowired
    // private FormInstanceHistDao formInstanceHistDaoRedisImpl;

	@Override
	public boolean add(FormInstanceHist formInstanceHist) {
		return formInstanceHistDaoMysqlImpl.add(formInstanceHist);
	}

	@Override
	public FormInstanceHist get(Long id) {
	    return formInstanceHistDaoMysqlImpl.get(id);
//		return CacheLoader.get(formInstanceHistDaoRedisImpl, formInstanceHistDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return formInstanceHistDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(FormInstanceHist formInstanceHist){
		return formInstanceHistDaoMysqlImpl.update(formInstanceHist);
	}
	
	@Override
	public List<FormInstanceHist> list(List<Long> idList) {
		return CacheLoader.list(formInstanceHistDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, FormInstanceHist> map(Set<Long> idSet){
		return CacheLoader.map(formInstanceHistDaoMysqlImpl, idSet);
	}

	@Override
	public Page<FormInstanceHist> page(int start, int count){
		return formInstanceHistDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<FormInstanceHist> page(FormInstanceHistQuery query, int start, int count){
		return formInstanceHistDaoMysqlImpl.page(query, start, count);
	}
	
	public List<FormInstanceHist> listAll(){
		return formInstanceHistDaoMysqlImpl.listAll();
	}
}

