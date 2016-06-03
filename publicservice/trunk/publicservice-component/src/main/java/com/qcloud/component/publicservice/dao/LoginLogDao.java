package com.qcloud.component.publicservice.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicservice.model.LoginLog;
import com.qcloud.component.publicservice.model.query.LoginLogQuery;

public interface LoginLogDao extends ISimpleDao<LoginLog, Long> {

    public boolean add(LoginLog loginLog);

    public LoginLog get(Long id);

    public boolean delete(Long id);

    public boolean update(LoginLog loginLog);

    public List<LoginLog> list(List<Long> idList);

    public Map<Long, LoginLog> map(Set<Long> idSet);

    public Page<LoginLog> page(LoginLogQuery query, int start, int size);

    public List<LoginLog> listAll();

    public List<LoginLog> list(long consumerId, int consumerType, int operate);
}
