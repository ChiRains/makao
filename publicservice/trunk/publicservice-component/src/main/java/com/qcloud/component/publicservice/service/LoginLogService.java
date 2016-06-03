package com.qcloud.component.publicservice.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

public interface LoginLogService {

    public boolean add(LoginLog loginLog);

    public LoginLog get(Long id);

    public boolean delete(Long id);

    public boolean update(LoginLog loginLog);

    public Page<LoginLog> page(LoginLogQuery query, int start, int count);

    public List<LoginLog> listAll();

    public List<LoginLog> list(long consumerId, int consumerType, int operate);
}
