package com.qcloud.project.macaovehicle.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

public interface OnestopCarRecordService {

    public boolean add(OnestopCarRecord onestopCarRecord);

    public OnestopCarRecord get(Long id);

    public boolean delete(Long id);

    public boolean update(OnestopCarRecord onestopCarRecord);

    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int count);

    public List<OnestopCarRecord> listAll();

    public OnestopCarRecord getByMap(Map<String, Object> map);

    public int getCountByMap(OnestopCarRecordQuery query);

    public List<OnestopCarRecord> listByQuery(OnestopCarRecordQuery query);
}
