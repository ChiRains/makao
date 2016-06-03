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
import com.qcloud.project.macaovehicle.dao.VehicleCancelDao;
import com.qcloud.project.macaovehicle.model.VehicleCancel;
import com.qcloud.project.macaovehicle.model.query.VehicleCancelQuery;

@Repository
public class VehicleCancelDaoMysqlImpl implements VehicleCancelDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(VehicleCancel vehicleCancel) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.insert", vehicleCancel) == 1;
    }

    @Override
    public VehicleCancel get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.delete", id) > 0;
    }

    @Override
    public boolean update(VehicleCancel vehicleCancel) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.update", vehicleCancel) > 0;
    }

    @Override
    public List<VehicleCancel> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, VehicleCancel> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<VehicleCancel> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<VehicleCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.count4page", param);
        Page<VehicleCancel> page = new Page<VehicleCancel>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<VehicleCancel> page(VehicleCancelQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstCode", query.getFormInstCode());
        param.put("plateNumber", query.getPlateNumber());
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("applyTimeBack", query.getApplyTimeBack());
        List<VehicleCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.count4query", param);
        Page<VehicleCancel> page = new Page<VehicleCancel>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<VehicleCancel> listAll() {

        List<VehicleCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleCancelMapper.listAll");
        return list;
    }
}
