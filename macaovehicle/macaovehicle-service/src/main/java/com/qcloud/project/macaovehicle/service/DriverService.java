package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

public interface DriverService {

    public boolean add(Driver driver);

    public Driver get(Long id);

    public boolean delete(Long id);

    public boolean update(Driver driver);

    public Page<Driver> page(DriverQuery query, int start, int count);

    public List<Driver> listAll();

    public List<Driver> listByCarOwner(Long carOwnerId);

    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState);

    public Driver getByName(String name, long carOwnerId);
}
