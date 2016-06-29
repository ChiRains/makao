package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

public interface OnestopCarRecordDao extends ISimpleDao<OnestopCarRecord, Long> {

    public boolean add(OnestopCarRecord onestopCarRecord);

    public OnestopCarRecord get(Long id);

    public boolean delete(Long id);

    public boolean update(OnestopCarRecord onestopCarRecord);

    public List<OnestopCarRecord> list(List<Long> idList);

    public Map<Long, OnestopCarRecord> map(Set<Long> idSet);

    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int size);

    public List<OnestopCarRecord> listAll();

    public OnestopCarRecord getByMap(Map<String, Object> map);

    public int getCountByMap(OnestopCarRecordQuery query);

    public List<OnestopCarRecord> listByQuery(OnestopCarRecordQuery query);
}
