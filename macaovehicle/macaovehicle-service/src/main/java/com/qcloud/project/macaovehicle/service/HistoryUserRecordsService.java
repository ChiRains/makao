package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.HistoryUserRecords;
import com.qcloud.project.macaovehicle.model.query.HistoryUserRecordsQuery;

public interface HistoryUserRecordsService {

    public boolean add(HistoryUserRecords historyUserRecords);

    public HistoryUserRecords get(Long id);

    public boolean delete(Long id);

    public boolean update(HistoryUserRecords historyUserRecords);

    public List<HistoryUserRecords> listByVehicleId(Long vehicleId);

    public Page<HistoryUserRecords> page(HistoryUserRecordsQuery query, int start, int count);

    public List<HistoryUserRecords> listAll();
}
