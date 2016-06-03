package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.IllegalOwnerRecordDao;
import com.qcloud.project.macaovehicle.model.IllegalOwnerRecord;
import com.qcloud.project.macaovehicle.model.query.IllegalOwnerRecordQuery;

@Repository
public class IllegalOwnerRecordDaoCacheImpl implements IllegalOwnerRecordDao {
	
	@Autowired
	private IllegalOwnerRecordDao illegalOwnerRecordDaoMysqlImpl;
	
	@Autowired
	private IllegalOwnerRecordDao illegalOwnerRecordDaoRedisImpl;

	@Override
	public boolean add(IllegalOwnerRecord illegalOwnerRecord) {
		return illegalOwnerRecordDaoMysqlImpl.add(illegalOwnerRecord);
	}

	@Override
	public IllegalOwnerRecord get(Long id) {
	    
	    return illegalOwnerRecordDaoMysqlImpl.get(id);
//		return CacheLoader.get(illegalOwnerRecordDaoRedisImpl, illegalOwnerRecordDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return illegalOwnerRecordDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(IllegalOwnerRecord illegalOwnerRecord){
		return illegalOwnerRecordDaoMysqlImpl.update(illegalOwnerRecord);
	}
	
	@Override
	public List<IllegalOwnerRecord> list(List<Long> idList) {
		return CacheLoader.list(illegalOwnerRecordDaoRedisImpl, illegalOwnerRecordDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, IllegalOwnerRecord> map(Set<Long> idSet){
		return CacheLoader.map(illegalOwnerRecordDaoRedisImpl, illegalOwnerRecordDaoMysqlImpl, idSet);
	}

	@Override
	public Page<IllegalOwnerRecord> page(int start, int count){
		return illegalOwnerRecordDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<IllegalOwnerRecord> page(IllegalOwnerRecordQuery query, int start, int count){
		return illegalOwnerRecordDaoMysqlImpl.page(query, start, count);
	}
	
	public List<IllegalOwnerRecord> listAll(){
		return illegalOwnerRecordDaoMysqlImpl.listAll();
	}
}

