package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverCancelDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

@Repository
public class DriverCancelDaoCacheImpl implements DriverCancelDao {
	
	@Autowired
	private DriverCancelDao driverCancelDaoMysqlImpl;
	
	@Autowired
	private DriverCancelDao driverCancelDaoRedisImpl;

	@Override
	public boolean add(DriverCancel driverCancel) {
		return driverCancelDaoMysqlImpl.add(driverCancel);
	}

	@Override
	public DriverCancel get(Long id) {
	    return driverCancelDaoMysqlImpl.get(id);
//		return CacheLoader.get(driverCancelDaoRedisImpl, driverCancelDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return driverCancelDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(DriverCancel driverCancel){
		return driverCancelDaoMysqlImpl.update(driverCancel);
	}
	
	@Override
	public List<DriverCancel> list(List<Long> idList) {
		return CacheLoader.list(driverCancelDaoRedisImpl, driverCancelDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, DriverCancel> map(Set<Long> idSet){
		return CacheLoader.map(driverCancelDaoRedisImpl, driverCancelDaoMysqlImpl, idSet);
	}

	@Override
	public Page<DriverCancel> page(int start, int count){
		return driverCancelDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<DriverCancel> page(DriverCancelQuery query, int start, int count){
		return driverCancelDaoMysqlImpl.page(query, start, count);
	}
	
	public List<DriverCancel> listAll(){
		return driverCancelDaoMysqlImpl.listAll();
	}
}

