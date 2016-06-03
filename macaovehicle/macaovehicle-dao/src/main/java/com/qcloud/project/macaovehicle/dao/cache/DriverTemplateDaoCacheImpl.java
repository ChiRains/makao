package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.DriverTemplateDao;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

@Repository
public class DriverTemplateDaoCacheImpl implements DriverTemplateDao {

    @Autowired
    private DriverTemplateDao driverTemplateDaoMysqlImpl;

    @Autowired
    private DriverTemplateDao driverTemplateDaoRedisImpl;

    @Override
    public boolean add(DriverTemplate driverTemplate) {

        return driverTemplateDaoMysqlImpl.add(driverTemplate);
    }

    @Override
    public DriverTemplate get(Long id) {

        return driverTemplateDaoMysqlImpl.get(id);
        // return CacheLoader.get(driverTemplateDaoRedisImpl, driverTemplateDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return driverTemplateDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(DriverTemplate driverTemplate) {

        return driverTemplateDaoMysqlImpl.update(driverTemplate);
    }

    @Override
    public List<DriverTemplate> list(List<Long> idList) {

        return CacheLoader.list(driverTemplateDaoRedisImpl, driverTemplateDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, DriverTemplate> map(Set<Long> idSet) {

        return CacheLoader.map(driverTemplateDaoRedisImpl, driverTemplateDaoMysqlImpl, idSet);
    }

    @Override
    public Page<DriverTemplate> page(int start, int count) {

        return driverTemplateDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int count) {

        return driverTemplateDaoMysqlImpl.page(query, start, count);
    }

    public List<DriverTemplate> listAll() {

        return driverTemplateDaoMysqlImpl.listAll();
    }

    @Override
    public List<DriverTemplate> listByClerkId(Long clerkId) {

        return driverTemplateDaoMysqlImpl.listByClerkId(clerkId);
    }

    @Override
    public boolean deleteByClerkId(Long clerkId) {

        return driverTemplateDaoMysqlImpl.deleteByClerkId(clerkId);
    }
}
