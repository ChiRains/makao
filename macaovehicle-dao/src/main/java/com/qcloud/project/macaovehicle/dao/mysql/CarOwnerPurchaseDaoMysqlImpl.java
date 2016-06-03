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
import com.qcloud.project.macaovehicle.dao.CarOwnerPurchaseDao;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.query.CarOwnerPurchaseQuery;

@Repository
public class CarOwnerPurchaseDaoMysqlImpl implements CarOwnerPurchaseDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerPurchase carOwnerPurchase) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.insert", carOwnerPurchase) == 1;
    }

    @Override
    public CarOwnerPurchase get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerPurchase carOwnerPurchase) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.update", carOwnerPurchase) > 0;
    }

    @Override
    public List<CarOwnerPurchase> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerPurchase> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerPurchase> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerPurchase> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.count4page", param);
        Page<CarOwnerPurchase> page = new Page<CarOwnerPurchase>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerPurchase> page(CarOwnerPurchaseQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerPurchase> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.count4query", param);
        Page<CarOwnerPurchase> page = new Page<CarOwnerPurchase>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerPurchase> listAll() {

        List<CarOwnerPurchase> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerPurchase getByCarOwner(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerPurchaseMapper.getByCarOwner", param);
    }
}
