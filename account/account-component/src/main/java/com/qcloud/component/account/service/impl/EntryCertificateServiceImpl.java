package com.qcloud.component.account.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.account.dao.EntryCertificateDao;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.key.TypeEnum.EntryCertificateStateType;
import com.qcloud.component.account.model.query.EntryCertificateQuery;
import com.qcloud.component.account.service.EntryCertificateService;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;

@Service
public class EntryCertificateServiceImpl implements EntryCertificateService {

    @Autowired
    private EntryCertificateDao entryCertificateDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "account_entry_certificate";

    @Override
    public boolean add(EntryCertificate entryCertificate) {

        long id = autoIdGenerator.get(ID_KEY);
        entryCertificate.setId(id);
        entryCertificate.setRegistTime(new Date());
        entryCertificate.setFrozenTime(null);
        entryCertificate.setState(EntryCertificateStateType.ENABLE.getKey());
        return entryCertificateDao.add(entryCertificate);
    }

    @Override
    public EntryCertificate get(Long id) {

        return entryCertificateDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return entryCertificateDao.delete(id);
    }

    @Override
    public boolean update(EntryCertificate entryCertificate) {

        return entryCertificateDao.update(entryCertificate);
    }

    @Override
    public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int count) {

        return entryCertificateDao.page(query, start, count);
    }

    public List<EntryCertificate> listAll() {

        return entryCertificateDao.listAll();
    }

    @Override
    public EntryCertificate getByAccount(String account) {

        return entryCertificateDao.getByAccount(account);
    }

    @Override
    public List<EntryCertificate> listByGroup(String group) {

        return entryCertificateDao.listByGroup(group);
    }
}
