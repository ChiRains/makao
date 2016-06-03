package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.macaovehicle.dao.ApprovalOutsideDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;
		
@Repository
public class ApprovalOutsideDaoMysqlImpl implements ApprovalOutsideDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(ApprovalOutside approvalOutside) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.insert", approvalOutside) == 1;
	}	
	
	@Override
	public ApprovalOutside get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(ApprovalOutside approvalOutside){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.update", approvalOutside) > 0;
	}
	
	@Override
	public List<ApprovalOutside> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ApprovalOutside> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ApprovalOutside> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ApprovalOutside> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.count4page",
				param);
		Page<ApprovalOutside> page = new Page<ApprovalOutside>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ApprovalOutside> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.count4query",
				param);
		Page<ApprovalOutside> page = new Page<ApprovalOutside>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<ApprovalOutside> listAll(){	
		List<ApprovalOutside> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalOutsideMapper.listAll");
		return list;
	}
}

