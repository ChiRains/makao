package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DvrAreaDao;
import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.model.query.DvrAreaQuery;

@Repository
public class DvrAreaDaoCacheImpl implements DvrAreaDao {
	
	@Autowired
	private DvrAreaDao dvrAreaDaoMysqlImpl;
	
	@Autowired
	private DvrAreaDao dvrAreaDaoRedisImpl;

	@Override
	public boolean add(DvrArea dvrArea) {
		return dvrAreaDaoMysqlImpl.add(dvrArea);
	}

	@Override
	public DvrArea get(Long id) {
		return dvrAreaDaoMysqlImpl.get(id);
//		return CacheLoader.get(dvrAreaDaoRedisImpl, dvrAreaDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return dvrAreaDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(DvrArea dvrArea){
		return dvrAreaDaoMysqlImpl.update(dvrArea);
	}
	
	@Override
	public List<DvrArea> list(List<Long> idList) {
		return CacheLoader.list(dvrAreaDaoRedisImpl, dvrAreaDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, DvrArea> map(Set<Long> idSet){
		return CacheLoader.map(dvrAreaDaoRedisImpl, dvrAreaDaoMysqlImpl, idSet);
	}

	@Override
	public Page<DvrArea> page(int start, int count){
		return dvrAreaDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<DvrArea> page(DvrAreaQuery query, int start, int count){
		return dvrAreaDaoMysqlImpl.page(query, start, count);
	}
	
	public List<DvrArea> listAll(){
		return dvrAreaDaoMysqlImpl.listAll();
	}
}

