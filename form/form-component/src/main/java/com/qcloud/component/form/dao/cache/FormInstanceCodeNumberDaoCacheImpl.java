package com.qcloud.component.form.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.form.dao.FormInstanceCodeNumberDao;
import com.qcloud.component.form.model.FormInstanceCodeNumber;
import com.qcloud.component.form.model.query.FormInstanceCodeNumberQuery;

@Repository
public class FormInstanceCodeNumberDaoCacheImpl implements FormInstanceCodeNumberDao {
	
	@Autowired
	private FormInstanceCodeNumberDao formInstanceCodeNumberDaoMysqlImpl;
	
//	@Autowired
//	private FormInstanceCodeNumberDao formInstanceCodeNumberDaoRedisImpl;

	@Override
	public boolean add(FormInstanceCodeNumber formInstanceCodeNumber) {
		return formInstanceCodeNumberDaoMysqlImpl.add(formInstanceCodeNumber);
	}

	@Override
	public FormInstanceCodeNumber get(Long id) {
	    return formInstanceCodeNumberDaoMysqlImpl.get(id);
//		return CacheLoader.get(formInstanceCodeNumberDaoRedisImpl, formInstanceCodeNumberDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return formInstanceCodeNumberDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(FormInstanceCodeNumber formInstanceCodeNumber){
		return formInstanceCodeNumberDaoMysqlImpl.update(formInstanceCodeNumber);
	}
	
	@Override
	public List<FormInstanceCodeNumber> list(List<Long> idList) {
		return CacheLoader.list(formInstanceCodeNumberDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, FormInstanceCodeNumber> map(Set<Long> idSet){
		return CacheLoader.map(formInstanceCodeNumberDaoMysqlImpl, idSet);
	}

	@Override
	public Page<FormInstanceCodeNumber> page(int start, int count){
		return formInstanceCodeNumberDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<FormInstanceCodeNumber> page(FormInstanceCodeNumberQuery query, int start, int count){
		return formInstanceCodeNumberDaoMysqlImpl.page(query, start, count);
	}
	
	public List<FormInstanceCodeNumber> listAll(){
		return formInstanceCodeNumberDaoMysqlImpl.listAll();
	}

    @Override
    public FormInstanceCodeNumber getByCode(String code) {
        return formInstanceCodeNumberDaoMysqlImpl.getByCode(code);
    }  

    @Override
    public boolean incr(Long id, long number) {
        return formInstanceCodeNumberDaoMysqlImpl.incr(id, number);
    }
}

