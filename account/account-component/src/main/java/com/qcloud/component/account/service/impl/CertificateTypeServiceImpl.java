package com.qcloud.component.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.account.dao.CertificateTypeDao;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.service.CertificateTypeService;
import com.qcloud.component.account.model.query.CertificateTypeQuery;
		
@Service
public class CertificateTypeServiceImpl implements CertificateTypeService{
	
	@Autowired
	private CertificateTypeDao certificateTypeDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "account_certificate_type";

	@Override
	public boolean add(CertificateType certificateType) {
		long id = autoIdGenerator.get(ID_KEY);
		certificateType.setId(id);
		
		return certificateTypeDao.add(certificateType);
	}

	@Override
	public CertificateType get(Long id) {	
		return certificateTypeDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return certificateTypeDao.delete(id);
	}
	
	@Override
	public boolean update(CertificateType certificateType) {
		return certificateTypeDao.update(certificateType);
	}
	
	@Override
	public Page<CertificateType> page(CertificateTypeQuery query, int start, int count) {
		return certificateTypeDao.page(query, start, count);
	}
	
	public List<CertificateType> listAll(){
		return certificateTypeDao.listAll();
	}

    @Override
    public CertificateType getByCode(String code) {
        return certificateTypeDao.getByCode(code);
    }
}

