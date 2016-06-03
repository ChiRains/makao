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
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;

@Repository
public class CarOwnerDaoMysqlImpl implements CarOwnerDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwner carOwner) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.insert", carOwner) == 1;
    }

    @Override
    public CarOwner get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwner carOwner) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.update", carOwner) > 0;
    }

    @Override
    public List<CarOwner> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwner> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwner> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwner> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.count4page", param);
        Page<CarOwner> page = new Page<CarOwner>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwner> page(CarOwnerQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwner> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.count4query", param);
        Page<CarOwner> page = new Page<CarOwner>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwner> listAll() {

        List<CarOwner> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.listAll");
        return list;
    }

    @Override
    public CarOwner getByClerk(Long userId) {

        CarOwner carOwner = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.getByUser", userId);
        return carOwner;
    }

    @Override
    public CarOwner getByIdcardNumber(String idcardNumber) {

        CarOwner carOwner = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerMapper.getByIdcardNumber", idcardNumber);
        return carOwner;
    }
}
