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
import com.qcloud.project.macaovehicle.dao.ApprovalResultsDao;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;

@Repository
public class ApprovalResultsDaoMysqlImpl implements ApprovalResultsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ApprovalResults approvalResults) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.insert", approvalResults) == 1;
    }

    @Override
    public ApprovalResults get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ApprovalResults approvalResults) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.update", approvalResults) > 0;
    }

    @Override
    public List<ApprovalResults> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ApprovalResults> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ApprovalResults> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ApprovalResults> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.count4page", param);
        Page<ApprovalResults> page = new Page<ApprovalResults>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ApprovalResults> page(ApprovalResultsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("state", query.getState());
        List<ApprovalResults> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.count4query", param);
        Page<ApprovalResults> page = new Page<ApprovalResults>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ApprovalResults> listAll() {

        List<ApprovalResults> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.listAll");
        return list;
    }

    @Override
    public boolean updateResultState(Long id, int state) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        param.put("state", state);
        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.updateResultState", param) > 0;
    }

    @Override
    public ApprovalResults getResultByCardNumber(String cardNumber, int type) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("type", type);
        param.put("cardNumber", cardNumber);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.getResultByCardNumber", param);
    }

    @Override
    public ApprovalResults getResultByAppointmentNumber(String appointmentNumber) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appointmentNumber", appointmentNumber);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.getResultByAppointmentNumber", param);
    }

    @Override
    public List<ApprovalResults> listByState(int state) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("state", state);
        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.listByState", param);
    }

    @Override
    public List<ApprovalResults> getListByFormInstanceId(Long formInstanceId) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.getListByFormInstanceId", formInstanceId);
    }

    @Override
    public List<ApprovalResults> getListByFormInstCode(String formInstCode) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ApprovalResultsMapper.getListByFormInstCode", formInstCode);
    }
}
