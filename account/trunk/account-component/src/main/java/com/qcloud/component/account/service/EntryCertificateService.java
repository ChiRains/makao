package com.qcloud.component.account.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;

public interface EntryCertificateService {

    public boolean add(EntryCertificate entryCertificate);

    public EntryCertificate get(Long id);

    EntryCertificate getByAccount(String account);

    public List<EntryCertificate> listByGroup(String group);

    public boolean delete(Long id);

    public boolean update(EntryCertificate entryCertificate);

    public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int count);

    public List<EntryCertificate> listAll();
}
