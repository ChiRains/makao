package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ApprovalOutsideDao;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.query.ApprovalOutsideQuery;

@Repository
public class ApprovalOutsideDaoCacheImpl implements ApprovalOutsideDao {
	
	@Autowired
	private ApprovalOutsideDao approvalOutsideDaoMysqlImpl;
	
	@Autowired
	private ApprovalOutsideDao approvalOutsideDaoRedisImpl;

	@Override
	public boolean add(ApprovalOutside approvalOutside) {
		return approvalOutsideDaoMysqlImpl.add(approvalOutside);
	}

	@Override
	public ApprovalOutside get(Long id) {
		return CacheLoader.get(approvalOutsideDaoRedisImpl, approvalOutsideDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return approvalOutsideDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ApprovalOutside approvalOutside){
		return approvalOutsideDaoMysqlImpl.update(approvalOutside);
	}
	
	@Override
	public List<ApprovalOutside> list(List<Long> idList) {
		return CacheLoader.list(approvalOutsideDaoRedisImpl, approvalOutsideDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ApprovalOutside> map(Set<Long> idSet){
		return CacheLoader.map(approvalOutsideDaoRedisImpl, approvalOutsideDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ApprovalOutside> page(int start, int count){
		return approvalOutsideDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ApprovalOutside> page(ApprovalOutsideQuery query, int start, int count){
		return approvalOutsideDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ApprovalOutside> listAll(){
		return approvalOutsideDaoMysqlImpl.listAll();
	}
}

