package com.qcloud.project.macaovehicle.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.project.macaovehicle.dao.DriverTemplateDao;
import com.qcloud.project.macaovehicle.model.DriverTemplate;
import com.qcloud.project.macaovehicle.model.query.DriverTemplateQuery;

@Repository
public class DriverTemplateDaoMysqlImpl implements DriverTemplateDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DriverTemplate driverTemplate) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.insert", driverTemplate) == 1;
    }

    @Override
    public DriverTemplate get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DriverTemplate driverTemplate) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.update", driverTemplate) > 0;
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

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DriverTemplate> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.count4page", param);
        Page<DriverTemplate> page = new Page<DriverTemplate>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DriverTemplate> page(DriverTemplateQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DriverTemplate> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.count4query", param);
        Page<DriverTemplate> page = new Page<DriverTemplate>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DriverTemplate> listAll() {

        List<DriverTemplate> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.listAll");
        return list;
    }

    @Override
    public List<DriverTemplate> listByClerkId(Long clerkId) {

        List<DriverTemplate> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.listByClerkId", clerkId);
        return list;
    }

    @Override
    public boolean deleteByClerkId(Long clerkId) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverTemplateMapper.deleteByClerkId", clerkId) > 0;
    }
}
