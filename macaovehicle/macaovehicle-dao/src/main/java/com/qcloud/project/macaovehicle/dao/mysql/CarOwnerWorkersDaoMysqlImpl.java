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
import com.qcloud.project.macaovehicle.dao.CarOwnerWorkersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerWorkersQuery;

@Repository
public class CarOwnerWorkersDaoMysqlImpl implements CarOwnerWorkersDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerWorkers carOwnerWorkers) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.insert", carOwnerWorkers) == 1;
    }

    @Override
    public CarOwnerWorkers get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerWorkers carOwnerWorkers) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.update", carOwnerWorkers) > 0;
    }

    @Override
    public List<CarOwnerWorkers> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerWorkers> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerWorkers> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerWorkers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.count4page", param);
        Page<CarOwnerWorkers> page = new Page<CarOwnerWorkers>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerWorkers> page(CarOwnerWorkersQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerWorkers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.count4query", param);
        Page<CarOwnerWorkers> page = new Page<CarOwnerWorkers>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerWorkers> listAll() {

        List<CarOwnerWorkers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerWorkers getByCarOwner(Long carOwnerId) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerWorkersMapper.getByCarOwner", carOwnerId);
    }
}
