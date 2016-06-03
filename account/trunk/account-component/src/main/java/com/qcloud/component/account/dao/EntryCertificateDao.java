package com.qcloud.component.account.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;

public interface EntryCertificateDao extends ISimpleDao<EntryCertificate, Long> {

    public boolean add(EntryCertificate entryCertificate);

    public EntryCertificate get(Long id);

    public boolean delete(Long id);

    public boolean update(EntryCertificate entryCertificate);

    public List<EntryCertificate> list(List<Long> idList);

    public Map<Long, EntryCertificate> map(Set<Long> idSet);

    public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int size);

    public List<EntryCertificate> listAll();

    EntryCertificate getByAccount(String account);

    List<EntryCertificate> listByGroup(String group);
}
