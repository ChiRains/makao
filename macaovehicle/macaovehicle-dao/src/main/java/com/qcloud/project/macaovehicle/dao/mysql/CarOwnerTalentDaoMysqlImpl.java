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
import com.qcloud.project.macaovehicle.dao.CarOwnerTalentDao;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.query.CarOwnerTalentQuery;

@Repository
public class CarOwnerTalentDaoMysqlImpl implements CarOwnerTalentDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(CarOwnerTalent carOwnerTalent) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.insert", carOwnerTalent) == 1;
    }

    @Override
    public CarOwnerTalent get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.delete", id) > 0;
    }

    @Override
    public boolean update(CarOwnerTalent carOwnerTalent) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.update", carOwnerTalent) > 0;
    }

    @Override
    public List<CarOwnerTalent> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, CarOwnerTalent> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<CarOwnerTalent> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerTalent> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.count4page", param);
        Page<CarOwnerTalent> page = new Page<CarOwnerTalent>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<CarOwnerTalent> page(CarOwnerTalentQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<CarOwnerTalent> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.count4query", param);
        Page<CarOwnerTalent> page = new Page<CarOwnerTalent>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<CarOwnerTalent> listAll() {

        List<CarOwnerTalent> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.listAll");
        return list;
    }

    @Override
    public CarOwnerTalent getByCarOwner(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.CarOwnerTalentMapper.getByCarOwner", param);
    }
}
