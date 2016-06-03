package com.qcloud.component.snakerext.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.snakerext.dao.ProcessGroupDao;
import com.qcloud.component.snakerext.model.ProcessGroup;
import com.qcloud.component.snakerext.model.query.ProcessGroupQuery;
		
@Repository
public class ProcessGroupDaoMysqlImpl implements ProcessGroupDao {

	@Resource(name = "sqlOperator-snakerext")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(ProcessGroup processGroup) {
		return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.insert", processGroup) == 1;
	}	
	
	@Override
	public ProcessGroup get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(ProcessGroup processGroup){
		return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.update", processGroup) > 0;
	}
	
	@Override
	public List<ProcessGroup> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ProcessGroup> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ProcessGroup> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ProcessGroup> list = sqlOperator.selectList(
				"com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.count4page",
				param);
		Page<ProcessGroup> page = new Page<ProcessGroup>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<ProcessGroup> page(ProcessGroupQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ProcessGroup> list = sqlOperator.selectList(
				"com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.count4query",
				param);
		Page<ProcessGroup> page = new Page<ProcessGroup>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<ProcessGroup> listAll(){	
		List<ProcessGroup> list = sqlOperator.selectList(
				"com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.listAll");
		return list;
	}

    @Override
    public List<ProcessGroup> listByName(String name) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", name);
        List<ProcessGroup> list = sqlOperator.selectList(
                "com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.listByName",param);
        return list;
    }

    @Override
    public ProcessGroup getByName(String name) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("name", name);
        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessGroupMapper.getByName",param);
    }
}

