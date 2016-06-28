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
import com.qcloud.project.macaovehicle.dao.DriverLossDao;
import com.qcloud.project.macaovehicle.model.DriverLoss;
import com.qcloud.project.macaovehicle.model.query.DriverLossQuery;

@Repository
public class DriverLossDaoMysqlImpl implements DriverLossDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DriverLoss driverLoss) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.insert", driverLoss) == 1;
    }

    @Override
    public DriverLoss get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DriverLoss driverLoss) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.update", driverLoss) > 0;
    }

    @Override
    public List<DriverLoss> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverLoss> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverLoss> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DriverLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.count4page", param);
        Page<DriverLoss> page = new Page<DriverLoss>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DriverLoss> page(DriverLossQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstCode", query.getFormInstCode());
        param.put("newDriverIc", query.getNewDriverIc());
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("applyTimeBack", query.getApplyTimeBack());
        List<DriverLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.count4query", param);
        Page<DriverLoss> page = new Page<DriverLoss>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DriverLoss> listAll() {

        List<DriverLoss> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.listAll");
        return list;
    }

    @Override
    public List<DriverLoss> listByDriver(Long driverId) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.listByDriverId", driverId);
    }

    @Override
    public DriverLoss getByFormInstCode(String formInstCode) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverLossMapper.getByFormInstCode", formInstCode);
    }
}
