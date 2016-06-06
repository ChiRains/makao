package com.qcloud.component.snakerext.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessGroupClerkDao;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;

@Repository
public class ProcessGroupClerkDaoCacheImpl implements ProcessGroupClerkDao {
	
	@Autowired
	private ProcessGroupClerkDao processGroupClerkDaoMysqlImpl;
	
	@Autowired
	private ProcessGroupClerkDao processGroupClerkDaoRedisImpl;

	@Override
	public boolean add(ProcessGroupClerk processGroupClerk) {
		return processGroupClerkDaoMysqlImpl.add(processGroupClerk);
	}

	@Override
	public ProcessGroupClerk get(Long id) {
		return  processGroupClerkDaoMysqlImpl.get( id);
	}

	@Override
	public boolean delete(Long id){
		return processGroupClerkDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ProcessGroupClerk processGroupClerk){
		return processGroupClerkDaoMysqlImpl.update(processGroupClerk);
	}
	
	@Override
	public List<ProcessGroupClerk> list(List<Long> idList) {
		return CacheLoader.list(processGroupClerkDaoRedisImpl, processGroupClerkDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ProcessGroupClerk> map(Set<Long> idSet){
		return CacheLoader.map(processGroupClerkDaoRedisImpl, processGroupClerkDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ProcessGroupClerk> page(int start, int count){
		return processGroupClerkDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ProcessGroupClerk> page(ProcessGroupClerkQuery query, int start, int count){
		return processGroupClerkDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ProcessGroupClerk> listAll(){
		return processGroupClerkDaoMysqlImpl.listAll();
	}

    @Override
    public List<ProcessGroupClerk> listByGroup(Long groupId) {

        return processGroupClerkDaoMysqlImpl.listByGroup(groupId);
    }

    @Override
    public boolean deleteByGroupId(Long groupId) {

        return processGroupClerkDaoMysqlImpl.deleteByGroupId(groupId);
    }
}

