package com.qcloud.project.macaovehicle.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;

public interface AbnormalService {

    public boolean add(Abnormal abnormal);

    public Abnormal get(Integer macaovehicleAbnormalId);

    public boolean delete(Integer macaovehicleAbnormalId);

    public boolean update(Abnormal abnormal);

    public Page<Abnormal> page(AbnormalQuery query, int start, int count);

    public List<Abnormal> listAll();

    public List<Abnormal> list(AbnormalQuery query, int start, int size);

    public int count(AbnormalQuery query);
    
    public List<Abnormal> statisticRecord(int type,String startTime,String endTime);
    
    public int countToday();
}
