package com.qcloud.component.account.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;

public interface CertificateTypeService {

    public boolean add(CertificateType certificateType);

    public CertificateType get(Long id);

    public CertificateType getByCode(String code);

    public boolean delete(Long id);

    public boolean update(CertificateType certificateType);

    public Page<CertificateType> page(CertificateTypeQuery query, int start, int count);

    public List<CertificateType> listAll();
}
