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
import com.qcloud.project.macaovehicle.dao.VehicleLossDao;
import com.qcloud.project.macaovehicle.model.VehicleLoss;
import com.qcloud.project.macaovehicle.model.query.VehicleLossQuery;

@Repository
public class VehicleLossDaoMysqlImpl implements VehicleLossDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(VehicleLoss vehicleLoss) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.insert", vehicleLoss) == 1;
    }

    @Override
    public VehicleLoss get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.delete", id) > 0;
    }

    @Override
    public boolean update(VehicleLoss vehicleLoss) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.update", vehicleLoss) > 0;
    }

    @Override
    public List<VehicleLoss> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, VehicleLoss> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<VehicleLoss> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<VehicleLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.count4page", param);
        Page<VehicleLoss> page = new Page<VehicleLoss>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<VehicleLoss> page(VehicleLossQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstCode", StringUtil.emptyToNull(query.getFormInstCode()));
        param.put("plateNumber", StringUtil.emptyToNull(query.getPlateNumber()));
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("applyTimeBack", query.getApplyTimeBack());
        List<VehicleLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.count4query", param);
        Page<VehicleLoss> page = new Page<VehicleLoss>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<VehicleLoss> listAll() {

        List<VehicleLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.listAll");
        return list;
    }

    @Override
    public VehicleLoss getByVehicleId(Long vehicleId) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.VehicleLossMapper.getByVehicleId", vehicleId);
    }
}
