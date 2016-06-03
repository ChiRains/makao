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
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.query.VehicleQuery;

@Repository
public class VehicleDaoMysqlImpl implements VehicleDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Vehicle vehicle) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.insert", vehicle) == 1;
    }

    @Override
    public Vehicle get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Vehicle vehicle) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.update", vehicle) > 0;
    }

    @Override
    public List<Vehicle> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Vehicle> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Vehicle> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Vehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.count4page", param);
        Page<Vehicle> page = new Page<Vehicle>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Vehicle> page(VehicleQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("models", query.getModels());
        param.put("licenseNumber", query.getLicenseNumber());
        param.put("plateNumber", query.getPlateNumber());
        param.put("carOwnerId", query.getCarOwnerId());
        List<Vehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.count4query", param);
        Page<Vehicle> page = new Page<Vehicle>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Vehicle> listAll() {

        List<Vehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.listAll");
        return list;
    }

    @Override
    public Vehicle getByPlateNumber(String plateNumber) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("plateNumber", plateNumber);
        Vehicle vehicle = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.getByPlateNumber", param);
        return vehicle;
    }

    @Override
    public List<Vehicle> listByCarOwner(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        List<Vehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.listByCarOwner", param);
        return list;
    }

    @Override
    public Vehicle getByRic(String ric) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ric", ric);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleMapper.getByRic", param);
    }
}
