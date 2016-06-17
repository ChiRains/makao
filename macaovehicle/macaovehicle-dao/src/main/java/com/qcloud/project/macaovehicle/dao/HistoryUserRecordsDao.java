package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

public interface HistoryUserRecordsDao extends ISimpleDao<HistoryUserRecords, Long> {

    public boolean add(HistoryUserRecords historyUserRecords);

    public HistoryUserRecords get(Long id);

    public boolean delete(Long id);

    public boolean update(HistoryUserRecords historyUserRecords);

    public List<HistoryUserRecords> list(List<Long> idList);

    public Map<Long, HistoryUserRecords> map(Set<Long> idSet);

    public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int size);

    public List<HistoryUserRecords> listAll();

    public List<HistoryUserRecords> listByVehicleId(Long vehicleId);

    public HistoryUserRecords getByFormInstCode(String formInstCode);
}
