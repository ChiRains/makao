package com.qcloud.component.account.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;

public interface CertificateTypeDao extends ISimpleDao<CertificateType, Long> {

    public boolean add(CertificateType certificateType);

    public CertificateType get(Long id);

    public boolean delete(Long id);

    public boolean update(CertificateType certificateType);

    public List<CertificateType> list(List<Long> idList);

    public Map<Long, CertificateType> map(Set<Long> idSet);

    public Page<CertificateType> page(CertificateTypeQuery query, int start, int size);

    public List<CertificateType> listAll();

    CertificateType getByCode(String code);
}
