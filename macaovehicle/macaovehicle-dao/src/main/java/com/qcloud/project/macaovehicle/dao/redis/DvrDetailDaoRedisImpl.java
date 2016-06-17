package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.DvrDetailDao;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;

@Repository
public class DvrDetailDaoRedisImpl implements DvrDetailDao {

	//@Resource(name = "redis-macaovehicle")
	//private Redis redis;

	@Override
	public boolean add(DvrDetail dvrDetail) {			
		throw new NotImplementedException();
	}

	@Override
	public DvrDetail get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(DvrDetail dvrDetail){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DvrDetail> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, DvrDetail> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<DvrDetail> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<DvrDetail> page(DvrDetailQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<DvrDetail> listAll(){	
		throw new NotImplementedException();
	}

	@Override
	public List<DvrDetail> getByArea(long id) {
		throw new NotImplementedException();
	}
}

