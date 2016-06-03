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
import com.qcloud.project.macaovehicle.dao.CarOwnerAcquisitionDao;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

@Repository
public class CarOwnerAcquisitionDaoMysqlImpl implements CarOwnerAcquisitionDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerAcquisition carOwnerAcquisition) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.insert", carOwnerAcquisition) == 1;
    }

    @Override
    public CarOwnerAcquisition get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerAcquisition carOwnerAcquisition) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.update", carOwnerAcquisition) > 0;
    }

    @Override
    public List<CarOwnerAcquisition> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerAcquisition> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerAcquisition> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerAcquisition> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.count4page", param);
        Page<CarOwnerAcquisition> page = new Page<CarOwnerAcquisition>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerAcquisition> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.count4query", param);
        Page<CarOwnerAcquisition> page = new Page<CarOwnerAcquisition>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerAcquisition> listAll() {

        List<CarOwnerAcquisition> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerAcquisition getByCarOwner(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("carOwnerId", carOwnerId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerAcquisitionMapper.getByCarOwner", param);
    }
}
