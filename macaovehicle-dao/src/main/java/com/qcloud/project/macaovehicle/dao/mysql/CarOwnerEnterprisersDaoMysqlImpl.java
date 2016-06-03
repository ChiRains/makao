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
import com.qcloud.project.macaovehicle.dao.CarOwnerEnterprisersDao;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.query.CarOwnerEnterprisersQuery;

@Repository
public class CarOwnerEnterprisersDaoMysqlImpl implements CarOwnerEnterprisersDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerEnterprisers carOwnerEnterprisers) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.insert", carOwnerEnterprisers) == 1;
    }

    @Override
    public CarOwnerEnterprisers get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerEnterprisers carOwnerEnterprisers) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.update", carOwnerEnterprisers) > 0;
    }

    @Override
    public List<CarOwnerEnterprisers> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerEnterprisers> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerEnterprisers> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerEnterprisers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.count4page", param);
        Page<CarOwnerEnterprisers> page = new Page<CarOwnerEnterprisers>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerEnterprisers> page(CarOwnerEnterprisersQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerEnterprisers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.count4query", param);
        Page<CarOwnerEnterprisers> page = new Page<CarOwnerEnterprisers>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerEnterprisers> listAll() {

        List<CarOwnerEnterprisers> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerEnterprisers getByCarOwner(Long carOwnerId) {
    	
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerEnterprisersMapper.getByCarOwner", carOwnerId);
    }
}
