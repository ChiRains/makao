package com.qcloud.component.account.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.account.dao.EntryCertificateDao;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;

@Repository
public class EntryCertificateDaoCacheImpl implements EntryCertificateDao {
	
	@Autowired
	private EntryCertificateDao entryCertificateDaoMysqlImpl;
	
//	@Autowired
//	private EntryCertificateDao entryCertificateDaoRedisImpl;

	@Override
	public boolean add(EntryCertificate entryCertificate) {
		return entryCertificateDaoMysqlImpl.add(entryCertificate);
	}

	@Override
	public EntryCertificate get(Long id) {
	    return entryCertificateDaoMysqlImpl.get(id);
//		return CacheLoader.get(entryCertificateDaoRedisImpl, entryCertificateDaoMysqlImpl, id);
	}

	@Override
	public boolean delete(Long id){
		return entryCertificateDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(EntryCertificate entryCertificate){
		return entryCertificateDaoMysqlImpl.update(entryCertificate);
	}
	
	@Override
	public List<EntryCertificate> list(List<Long> idList) {
		return CacheLoader.list(entryCertificateDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, EntryCertificate> map(Set<Long> idSet){
		return CacheLoader.map(entryCertificateDaoMysqlImpl, idSet);
	}

	@Override
	public Page<EntryCertificate> page(int start, int count){
		return entryCertificateDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int count){
		return entryCertificateDaoMysqlImpl.page(query, start, count);
	}
	
	public List<EntryCertificate> listAll(){
		return entryCertificateDaoMysqlImpl.listAll();
	}

    @Override
    public EntryCertificate getByAccount(String account) {
        return entryCertificateDaoMysqlImpl.getByAccount(account);
    }

    @Override
    public List<EntryCertificate> listByGroup(String group) {
        return entryCertificateDaoMysqlImpl.listByGroup(group);
    }
}

