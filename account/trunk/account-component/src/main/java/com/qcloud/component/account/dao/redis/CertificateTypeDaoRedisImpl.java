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
import com.qcloud.component.account.dao.CertificateTypeDao;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;

@Repository
public class CertificateTypeDaoRedisImpl implements CertificateTypeDao {

	//@Resource(name = "redis-account")
	//private Redis redis;

	@Override
	public boolean add(CertificateType certificateType) {			
		throw new NotImplementedException();
	}

	@Override
	public CertificateType get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(CertificateType certificateType){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CertificateType> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CertificateType> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CertificateType> page(int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public Page<CertificateType> page(CertificateTypeQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<CertificateType> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public CertificateType getByCode(String code) {
        throw new NotImplementedException();
    }
}

