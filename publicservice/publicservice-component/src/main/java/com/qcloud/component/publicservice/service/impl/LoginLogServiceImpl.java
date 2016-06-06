package com.qcloud.component.publicservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.dao.LoginLogDao;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.service.LoginLogService;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogDao         loginLogDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicservice_login_log";

    @Override
    public boolean add(LoginLog loginLog) {

        long id = autoIdGenerator.get(ID_KEY);
        loginLog.setId(id);
        return loginLogDao.add(loginLog);
    }

    @Override
    public LoginLog get(Long id) {

        return loginLogDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return loginLogDao.delete(id);
    }

    @Override
    public boolean update(LoginLog loginLog) {

        return loginLogDao.update(loginLog);
    }

    @Override
    public Page<LoginLog> page(LoginLogQuery query, int start, int count) {

        return loginLogDao.page(query, start, count);
    }

    public List<LoginLog> listAll() {

        return loginLogDao.listAll();
    }

    @Override
    public List<LoginLog> list(long consumerId, int consumerType, int operate) {

        return loginLogDao.list(consumerId, consumerType, operate);
    }
}
