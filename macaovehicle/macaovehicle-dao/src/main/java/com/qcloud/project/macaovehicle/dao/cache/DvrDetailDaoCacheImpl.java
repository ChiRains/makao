package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DvrDetailDao;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;

@Repository
public class DvrDetailDaoCacheImpl implements DvrDetailDao {
	
	@Autowired
	private DvrDetailDao dvrDetailDaoMysqlImpl;
	
	@Autowired
	private DvrDetailDao dvrDetailDaoRedisImpl;

	@Override
	public boolean add(DvrDetail dvrDetail) {
		return dvrDetailDaoMysqlImpl.add(dvrDetail);
	}

	@Override
	public DvrDetail get(Long id) {
		
		return dvrDetailDaoMysqlImpl.get(id);

//		return CacheLoader.get(dvrDetailDaoRedisImpl, dvrDetailDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return dvrDetailDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(DvrDetail dvrDetail){
		return dvrDetailDaoMysqlImpl.update(dvrDetail);
	}
	
	@Override
	public List<DvrDetail> list(List<Long> idList) {
		return CacheLoader.list(dvrDetailDaoRedisImpl, dvrDetailDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, DvrDetail> map(Set<Long> idSet){
		return CacheLoader.map(dvrDetailDaoRedisImpl, dvrDetailDaoMysqlImpl, idSet);
	}

	@Override
	public Page<DvrDetail> page(int start, int count){
		return dvrDetailDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<DvrDetail> page(DvrDetailQuery query, int start, int count){
		return dvrDetailDaoMysqlImpl.page(query, start, count);
	}
	
	public List<DvrDetail> listAll(){
		return dvrDetailDaoMysqlImpl.listAll();
	}

	@Override
	public List<DvrDetail> getByArea(long id) {
		return dvrDetailDaoMysqlImpl.getByArea(id);
	}
}

