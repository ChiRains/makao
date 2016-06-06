package com.qcloud.component.publicdata.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ExpressDao;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.service.ExpressService;
import com.qcloud.component.publicdata.model.query.ExpressQuery;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressDao          expressDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "publicdata_express";

    @Override
    public Long add(Express express) {

        Express temp = getByCode(express.getCode());
        if (temp != null) {
            throw new PublicdataException("物流公司编码已存在");
        }
        long id = autoIdGenerator.get(ID_KEY);
        express.setId(id);
        express.setLogo(fileSDKClient.uidToUrl(express.getLogo()));
        if (expressDao.add(express)) {
            return id;
        } else {
            return -1L;
        }
    }

    @Override
    public Express get(Long id) {

        return expressDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return expressDao.delete(id);
    }

    @Override
    public boolean update(Express express) {

        if (StringUtils.isNotEmpty(express.getLogo())) {
            express.setLogo(fileSDKClient.uidToUrl(express.getLogo()));
        }
        return expressDao.update(express);
    }

    @Override
    public Page<Express> page(ExpressQuery query, int start, int count) {

        return expressDao.page(query, start, count);
    }

    public List<Express> listAll() {

        return expressDao.listAll();
    }

    @Override
    public Express getByCode(String code) {

        return expressDao.getByCode(code.toLowerCase());
    }
}
