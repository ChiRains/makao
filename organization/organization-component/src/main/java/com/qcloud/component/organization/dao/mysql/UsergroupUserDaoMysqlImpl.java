package com.qcloud.component.organization.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.organization.dao.UsergroupUserDao;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;
		
@Repository
public class UsergroupUserDaoMysqlImpl implements UsergroupUserDao {

	@Resource(name = "sqlOperator-organization")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(UsergroupUser usergroupUser) {
		return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.insert", usergroupUser) == 1;
	}	
	
	@Override
	public UsergroupUser get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(UsergroupUser usergroupUser){
		return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.update", usergroupUser) > 0;
	}
	
	@Override
	public List<UsergroupUser> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, UsergroupUser> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<UsergroupUser> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<UsergroupUser> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.count4page",
				param);
		Page<UsergroupUser> page = new Page<UsergroupUser>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<UsergroupUser> page(UsergroupUserQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<UsergroupUser> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.count4query",
				param);
		Page<UsergroupUser> page = new Page<UsergroupUser>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<UsergroupUser> listAll(){	
		List<UsergroupUser> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.listAll");
		return list;
	}

    @Override
    public List<UsergroupUser> getUserByGroupId(long groupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("groupId", groupId);
        List<UsergroupUser> list = sqlOperator.selectList(
                "com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.getUserByGroupId",param);
        return list;
    }

    @Override
    public boolean deleteByGroupId(long groupId) {
        return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.UsergroupUserMapper.deleteByGroupId", groupId) > 0;
    }
}

