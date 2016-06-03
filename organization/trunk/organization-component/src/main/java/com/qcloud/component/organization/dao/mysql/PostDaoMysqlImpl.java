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
import com.qcloud.component.organization.dao.PostDao;
import com.qcloud.component.organization.model.Post;
import com.qcloud.component.organization.model.query.PostQuery;
		
@Repository
public class PostDaoMysqlImpl implements PostDao {

	@Resource(name = "sqlOperator-organization")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(Post post) {
		return sqlOperator.insert("com.qcloud.component.organization.dao.mysql.mapper.PostMapper.insert", post) == 1;
	}	
	
	@Override
	public Post get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.organization.dao.mysql.mapper.PostMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.organization.dao.mysql.mapper.PostMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(Post post){
		return sqlOperator.update("com.qcloud.component.organization.dao.mysql.mapper.PostMapper.update", post) > 0;
	}
	
	@Override
	public List<Post> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, Post> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<Post> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Post> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.PostMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.PostMapper.count4page",
				param);
		Page<Post> page = new Page<Post>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<Post> page(PostQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<Post> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.PostMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.organization.dao.mysql.mapper.PostMapper.count4query",
				param);
		Page<Post> page = new Page<Post>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<Post> listAll(){	
		List<Post> list = sqlOperator.selectList(
				"com.qcloud.component.organization.dao.mysql.mapper.PostMapper.listAll");
		return list;
	}
}

