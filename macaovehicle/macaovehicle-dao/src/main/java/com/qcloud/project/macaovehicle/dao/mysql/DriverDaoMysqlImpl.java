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
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.EnableType;
import com.qcloud.project.macaovehicle.model.query.DriverQuery;

@Repository
public class DriverDaoMysqlImpl implements DriverDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Driver driver) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.insert", driver) == 1;
    }

    @Override
    public Driver get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Driver driver) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.update", driver) > 0;
    }

    @Override
    public List<Driver> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Driver> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Driver> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Driver> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.count4page", param);
        Page<Driver> page = new Page<Driver>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Driver> page(DriverQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Driver> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.count4query", param);
        Page<Driver> page = new Page<Driver>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Driver> listAll() {

        List<Driver> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.listAll");
        return list;
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId) {

        List<Driver> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.listByCarOwner", carOwnerId);
        return list;
    }

    @Override
    public Driver getByName(String driverName, long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("driverName", driverName);
        param.put("carOwnerId", carOwnerId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.getByName", param);
    }

    @Override
    public List<Driver> listByCarOwner(Long carOwnerId, EnableType driverIcState) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        param.put("driverIcState", driverIcState.getKey());
        List<Driver> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverMapper.listByCarOwnerMap", param);
        return list;
    }
}
