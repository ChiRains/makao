package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.AbnormalDao;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.service.AbnormalService;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Service
public class AbnormalServiceImpl implements AbnormalService {

    @Autowired
    private AbnormalDao         abnormalDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_abnormal";

    @Override
    public boolean add(Abnormal abnormal) {

        long id = autoIdGenerator.get(ID_KEY);
        abnormal.setId(id);
        return abnormalDao.add(abnormal);
    }

    @Override
    public Abnormal get(Integer macaovehicleAbnormalId) {

        return abnormalDao.get(macaovehicleAbnormalId);
    }

    @Override
    public boolean delete(Integer macaovehicleAbnormalId) {

        return abnormalDao.delete(macaovehicleAbnormalId);
    }

    @Override
    public boolean update(Abnormal abnormal) {

        return abnormalDao.update(abnormal);
    }

    @Override
    public Page<Abnormal> page(AbnormalQuery query, int start, int count) {

        return abnormalDao.page(query, start, count);
    }

    public List<Abnormal> listAll() {

        return abnormalDao.listAll();
    }

    @Override
    public List<Abnormal> list(AbnormalQuery query, int start, int size) {

        return abnormalDao.list(query, start, size);
    }

    @Override
    public int count(AbnormalQuery query) {

        return abnormalDao.count(query);
    }

    @Override
    public List<Abnormal> statisticRecord(int type, String startTime, String endTime) {

        return abnormalDao.statisticRecord(type, startTime, endTime);
    }
    
   @Override
   public int countToday(){
	   return abnormalDao.countToday();
   }
}
