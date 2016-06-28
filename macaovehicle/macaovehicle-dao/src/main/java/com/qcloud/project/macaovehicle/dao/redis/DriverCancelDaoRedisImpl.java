package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.DriverCancelDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

@Repository
public class DriverCancelDaoRedisImpl implements DriverCancelDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(DriverCancel driverCancel) {

        throw new NotImplementedException();
    }

    @Override
    public DriverCancel get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DriverCancel driverCancel) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverCancel> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverCancel> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverCancel> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverCancel> page(DriverCancelQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverCancel> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverCancel> listByDriver(Long driverId) {

        throw new NotImplementedException();
    }

    @Override
    public DriverCancel getByFormInstCode(String formInstCode) {

        throw new NotImplementedException();
    }
}
