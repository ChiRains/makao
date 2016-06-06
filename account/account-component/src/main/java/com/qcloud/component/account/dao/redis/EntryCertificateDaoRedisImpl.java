package com.qcloud.component.account.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.account.dao.EntryCertificateDao;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;

@Repository
public class EntryCertificateDaoRedisImpl implements EntryCertificateDao {

	//@Resource(name = "redis-account")
	//private Redis redis;

	@Override
	public boolean add(EntryCertificate entryCertificate) {			
		throw new NotImplementedException();
	}

	@Override
	public EntryCertificate get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(EntryCertificate entryCertificate){
		throw new NotImplementedException();
	}
	
	@Override
	public List<EntryCertificate> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, EntryCertificate> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<EntryCertificate> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<EntryCertificate> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public EntryCertificate getByAccount(String account) {
        throw new NotImplementedException();
    }

    @Override
    public List<EntryCertificate> listByGroup(String group) {
        throw new NotImplementedException();
    }
}

