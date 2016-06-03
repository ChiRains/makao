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
import com.qcloud.project.macaovehicle.dao.CarOwnerIndicatorsDao;
import com.qcloud.project.macaovehicle.model.CarOwnerIndicators;
import com.qcloud.project.macaovehicle.model.query.CarOwnerIndicatorsQuery;

@Repository
public class CarOwnerIndicatorsDaoMysqlImpl implements CarOwnerIndicatorsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerIndicators carOwnerIndicators) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.insert", carOwnerIndicators) == 1;
    }

    @Override
    public CarOwnerIndicators get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerIndicators carOwnerIndicators) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.update", carOwnerIndicators) > 0;
    }

    @Override
    public List<CarOwnerIndicators> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerIndicators> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerIndicators> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerIndicators> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.count4page", param);
        Page<CarOwnerIndicators> page = new Page<CarOwnerIndicators>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerIndicators> page(CarOwnerIndicatorsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerIndicators> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.count4query", param);
        Page<CarOwnerIndicators> page = new Page<CarOwnerIndicators>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerIndicators> listAll() {

        List<CarOwnerIndicators> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerIndicators getByVehicleId(Long vehicleId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("vehicleId", vehicleId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerIndicatorsMapper.getByVehicleId", param);
    }
}
