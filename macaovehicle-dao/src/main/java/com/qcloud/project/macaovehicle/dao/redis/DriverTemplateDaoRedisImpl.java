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
import com.qcloud.project.macaovehicle.dao.DriverTemplateDao;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

@Repository
public class DriverTemplateDaoRedisImpl implements DriverTemplateDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(DriverTemplate driverTemplate) {

        throw new NotImplementedException();
    }

    @Override
    public DriverTemplate get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(DriverTemplate driverTemplate) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverTemplate> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverTemplate> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverTemplate> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverTemplate> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<DriverTemplate> listByClerkId(Long clerkId) {

        throw new NotImplementedException();
    }

    @Override
    public boolean deleteByClerkId(Long clerkId) {

        throw new NotImplementedException();
    }
}
