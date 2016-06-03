package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.Abnormal;
import com.qcloud.project.macaovehicle.model.query.AbnormalQuery;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;
		
public interface AbnormalDao extends ISimpleDao<Abnormal, Integer> {

	public boolean add(Abnormal abnormal);	
	
	public Abnormal get(Integer macaovehicleAbnormalId);

	public boolean delete(Integer macaovehicleAbnormalId);
	
	public boolean update(Abnormal abnormal);
	
	public List<Abnormal> list(List<Integer> macaovehicleAbnormalIdList);
	
	public Map<Integer, Abnormal> map(Set<Integer> macaovehicleAbnormalIdSet);
	
	public Page<Abnormal> page(AbnormalQuery query, int start, int size);

	public List<Abnormal> listAll();
	
    public List<Abnormal> list(AbnormalQuery query, int start, int size);

    public int count(AbnormalQuery query);
	
    public List<Abnormal> statisticRecord(int type,String startTime,String endTime);
    
    public int countToday();
}
