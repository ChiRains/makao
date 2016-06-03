package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.OnestopCarRecordDao;
import com.qcloud.project.macaovehicle.model.OnestopCarRecord;
import com.qcloud.project.macaovehicle.service.OnestopCarRecordService;
import com.qcloud.project.macaovehicle.model.query.OnestopCarRecordQuery;

@Service
public class OnestopCarRecordServiceImpl implements OnestopCarRecordService {

    @Autowired
    private OnestopCarRecordDao onestopCarRecordDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_onestop_car_record";

    @Override
    public boolean add(OnestopCarRecord onestopCarRecord) {

        long id = autoIdGenerator.get(ID_KEY);
        onestopCarRecord.setId(id);
        return onestopCarRecordDao.add(onestopCarRecord);
    }

    @Override
    public OnestopCarRecord get(Long id) {

        return onestopCarRecordDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return onestopCarRecordDao.delete(id);
    }

    @Override
    public boolean update(OnestopCarRecord onestopCarRecord) {

        return onestopCarRecordDao.update(onestopCarRecord);
    }

    @Override
    public Page<OnestopCarRecord> page(OnestopCarRecordQuery query, int start, int count) {

        return onestopCarRecordDao.page(query, start, count);
    }

    public List<OnestopCarRecord> listAll() {

        return onestopCarRecordDao.listAll();
    }

    @Override
    public OnestopCarRecord getByMap(Map<String, Object> map) {

        return onestopCarRecordDao.getByMap(map);
    }

    @Override
    public int getCountByMap(OnestopCarRecordQuery query) {

        return onestopCarRecordDao.getCountByMap(query);
    }
}
