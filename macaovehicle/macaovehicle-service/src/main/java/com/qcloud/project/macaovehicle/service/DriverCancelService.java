package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

public interface DriverCancelService {

    public boolean add(DriverCancel driverCancel);

    public DriverCancel get(Long id);

    public boolean delete(Long id);

    public boolean update(DriverCancel driverCancel);

    public Page<DriverCancel> page(DriverCancelQuery query, int start, int count);

    public List<DriverCancel> listAll();

    public List<DriverCancel> listByDriver(Long driverId);

    public DriverCancel getByFormInstCode(String formInstCode);
}
