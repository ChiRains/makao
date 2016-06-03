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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.DriverVehicleDao;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.DriverVehicleQuery;

@Repository
public class DriverVehicleDaoMysqlImpl implements DriverVehicleDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DriverVehicle driverVehicle) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.insert", driverVehicle) == 1;
    }

    @Override
    public DriverVehicle get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DriverVehicle driverVehicle) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.update", driverVehicle) > 0;
    }

    @Override
    public List<DriverVehicle> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverVehicle> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverVehicle> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DriverVehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.count4page", param);
        Page<DriverVehicle> page = new Page<DriverVehicle>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DriverVehicle> page(DriverVehicleQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstCode", StringUtil.emptyToNull(query.getFormInstCode()));
        param.put("groupByStr", StringUtil.emptyToNull(query.getGroupByStr()));
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("state", query.getState());
        List<DriverVehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.count4query", param);
        Page<DriverVehicle> page = new Page<DriverVehicle>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DriverVehicle> listAll() {

        List<DriverVehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.listAll");
        return list;
    }

    @Override
    public List<DriverVehicle> getListByFormInstCode(String formInstCode) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.getByFormInstCode", formInstCode);
    }

    @Override
    public List<DriverVehicle> listByQuery(DriverVehicleQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("formInstCode", query.getFormInstCode());
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("type", query.getType());
        param.put("state", query.getState());
        param.put("vehicleId", query.getVehicleId());
        param.put("driverId", query.getDriverId());
        param.put("ric", StringUtil.emptyToNull(query.getRic()));
        param.put("driverIc", StringUtil.emptyToNull(query.getDriverIc()));
        param.put("formInstanceId", query.getFormInstanceId());
        param.put("groupByStr", query.getGroupByStr());
        List<DriverVehicle> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.listByQuery", param);
        return list;
    }

    @Override
    public List<DriverVehicle> getListByDriverId(Long driverId, ProgressType progressType) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("driverId", driverId);
        param.put("type", progressType.getKey());
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.getListByDriverId", param);
    }

    @Override
    public List<DriverVehicle> getListByFormInstanceId(Long formInstanceId) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.getListByFormInstanceId", formInstanceId);
    }

    @Override
    public List<DriverVehicle> getListByVehicleId(Long vehicleId, ProgressType progressType) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vehicleId", vehicleId);
        param.put("type", progressType.getKey());
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.getListByVehicleId", param);
    }

    @Override
    public List<DriverVehicle> getListByDriverIc(String driverIc, ProgressType progressType) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("driverIc", driverIc);
        param.put("type", progressType.getKey());
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.getListByDriverIc", param);
    }

    @Override
    public int countAllVehicle(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverVehicleMapper.countAllVehicle", param);
    }
}
