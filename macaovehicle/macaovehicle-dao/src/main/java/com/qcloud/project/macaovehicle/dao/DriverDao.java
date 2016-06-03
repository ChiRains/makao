package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

public interface DriverDao extends ISimpleDao<Driver, Long> {

    public boolean add(Driver driver);

    public Driver get(Long id);

    public boolean delete(Long id);

    public boolean update(Driver driver);

    public List<Driver> list(List<Long> idList);

    public Map<Long, Driver> map(Set<Long> idSet);

    public Page<Driver> page(DriverQuery query, int start, int size);

    public List<Driver> listAll();

    public List<Driver> listByCarOwner(Long carOwnerId);

    public Driver getByName(String name, long carOwnerId);

    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState);
}
