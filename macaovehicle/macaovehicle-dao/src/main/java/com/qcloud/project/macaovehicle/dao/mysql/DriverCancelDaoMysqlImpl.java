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
import com.qcloud.project.macaovehicle.dao.DriverCancelDao;
import com.qcloud.project.macaovehicle.model.DriverCancel;
import com.qcloud.project.macaovehicle.model.query.DriverCancelQuery;

@Repository
public class DriverCancelDaoMysqlImpl implements DriverCancelDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(DriverCancel driverCancel) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.insert", driverCancel) == 1;
    }

    @Override
    public DriverCancel get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.delete", id) > 0;
    }

    @Override
    public boolean update(DriverCancel driverCancel) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.update", driverCancel) > 0;
    }

    @Override
    public List<DriverCancel> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, DriverCancel> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<DriverCancel> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<DriverCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.count4page", param);
        Page<DriverCancel> page = new Page<DriverCancel>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<DriverCancel> page(DriverCancelQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("formInstCode", query.getFormInstCode());
        param.put("certificateNo", query.getCertificateNo());
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("applyTimeBack", query.getApplyTimeBack());
        List<DriverCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.count4query", param);
        Page<DriverCancel> page = new Page<DriverCancel>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<DriverCancel> listAll() {

        List<DriverCancel> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.DriverCancelMapper.listAll");
        return list;
    }
}
