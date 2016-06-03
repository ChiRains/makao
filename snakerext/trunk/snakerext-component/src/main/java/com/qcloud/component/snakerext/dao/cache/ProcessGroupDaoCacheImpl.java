package com.qcloud.component.snakerext.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.ProcessGroupDao;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;

@Repository
public class ProcessGroupDaoCacheImpl implements ProcessGroupDao {
	
	@Autowired
	private ProcessGroupDao processGroupDaoMysqlImpl;
	
	@Autowired
	private ProcessGroupDao processGroupDaoRedisImpl;

	@Override
	public boolean add(ProcessGroup processGroup) {
		return processGroupDaoMysqlImpl.add(processGroup);
	}

	@Override
	public ProcessGroup get(Long id) {
		return processGroupDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return processGroupDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ProcessGroup processGroup){
		return processGroupDaoMysqlImpl.update(processGroup);
	}
	
	@Override
	public List<ProcessGroup> list(List<Long> idList) {
		return CacheLoader.list(processGroupDaoRedisImpl, processGroupDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ProcessGroup> map(Set<Long> idSet){
		return CacheLoader.map(processGroupDaoRedisImpl, processGroupDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ProcessGroup> page(int start, int count){
		return processGroupDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int count){
		return processGroupDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ProcessGroup> listAll(){
		return processGroupDaoMysqlImpl.listAll();
	}

    @Override
    public List<ProcessGroup> listByName(String name) {

        return processGroupDaoMysqlImpl.listByName(name);
    }

    @Override
    public ProcessGroup getByName(String name) {

        return processGroupDaoMysqlImpl.getByName(name);
    }
}

