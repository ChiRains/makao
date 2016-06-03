package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

public interface DriverLossDao extends ISimpleDao<DriverLoss, Long> {

    public boolean add(DriverLoss driverLoss);

    public DriverLoss get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverLoss driverLoss);

    public List<DriverLoss> list(List<Long> idList);

    public Map<Long, DriverLoss> map(Set<Long> idSet);

    public Page<DriverLoss> page(DriverLossQuery query, int start, int size);

    public List<DriverLoss> listAll();

    public DriverLoss getByDriverId(Long driverId);
}
