package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

public interface DriverCancelDao extends ISimpleDao<DriverCancel, Long> {

    public boolean add(DriverCancel driverCancel);

    public DriverCancel get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverCancel driverCancel);

    public List<DriverCancel> list(List<Long> idList);

    public Map<Long, DriverCancel> map(Set<Long> idSet);

    public Page<DriverCancel> page(DriverCancelQuery query, int start, int size);

    public List<DriverCancel> listAll();

    public List<DriverCancel> listByDriver(Long driverId);

    public DriverCancel getByFormInstCode(String formInstCode);
}
