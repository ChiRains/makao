package com.qcloud.component.account.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.account.dao.CertificateTypeDao;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;

@Repository
public class CertificateTypeDaoCacheImpl implements CertificateTypeDao {
	
	@Autowired
	private CertificateTypeDao certificateTypeDaoMysqlImpl;
	
//	@Autowired
//	private CertificateTypeDao certificateTypeDaoRedisImpl;

	@Override
	public boolean add(CertificateType certificateType) {
		return certificateTypeDaoMysqlImpl.add(certificateType);
	}

	@Override
	public CertificateType get(Long id) {
	    return certificateTypeDaoMysqlImpl.get(id);	
	}

	@Override
	public boolean delete(Long id){
		return certificateTypeDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(CertificateType certificateType){
		return certificateTypeDaoMysqlImpl.update(certificateType);
	}
	
	@Override
	public List<CertificateType> list(List<Long> idList) {
		return CacheLoader.list(certificateTypeDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, CertificateType> map(Set<Long> idSet){
		return CacheLoader.map(certificateTypeDaoMysqlImpl, idSet);
	}

	@Override
	public Page<CertificateType> page(int start, int count){
		return certificateTypeDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<CertificateType> page(CertificateTypeQuery query, int start, int count){
		return certificateTypeDaoMysqlImpl.page(query, start, count);
	}
	
	public List<CertificateType> listAll(){
		return certificateTypeDaoMysqlImpl.listAll();
	}

    @Override
    public CertificateType getByCode(String code) {
        return certificateTypeDaoMysqlImpl.getByCode(code);
    }
}

