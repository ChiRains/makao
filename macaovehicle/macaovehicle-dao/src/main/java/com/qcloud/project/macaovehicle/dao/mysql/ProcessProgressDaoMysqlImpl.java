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
import com.qcloud.project.macaovehicle.dao.ProcessProgressDao;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.query.ProcessProgressQuery;

@Repository
public class ProcessProgressDaoMysqlImpl implements ProcessProgressDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProcessProgress processProgress) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.insert", processProgress) == 1;
    }

    @Override
    public ProcessProgress get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProcessProgress processProgress) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.update", processProgress) > 0;
    }

    @Override
    public List<ProcessProgress> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessProgress> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessProgress> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.count4page", param);
        Page<ProcessProgress> page = new Page<ProcessProgress>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProcessProgress> page(ProcessProgressQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("carOwnerId", query.getCarOwnerId());
        param.put("type", query.getType());
        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.count4query", param);
        Page<ProcessProgress> page = new Page<ProcessProgress>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProcessProgress> listAll() {

        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.listAll");
        return list;
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("carOwnerId", carOwnerId);
        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.listByCarOwnerId", param);
        return list;
    }

    @Override
    public List<ProcessProgress> listByCarOwnerId(Long carOwnerId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("carOwnerId", carOwnerId);
        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getListByCarOwnerId", param);
        return list;
    }

    @Override
    public ProcessProgress getMaxByFormInstCode(String formInstCode) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("formInstCode", formInstCode);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getMaxByFormInstCode", param);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId, ProgressType progressType) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("carOwnerId", carOwnerId);
        param.put("formInstanceId", formInstanceId);
        param.put("type", progressType.getKey());
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getMap", param);
    }

    @Override
    public List<ProcessProgress> listByQuery(ProcessProgressQuery query) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("state", query.getState());
        param.put("type", query.getType());
        param.put("carOwnerId", query.getCarOwnerId());
        List<ProcessProgress> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.listByquery", param);
        return list;
    }

    @Override
    public ProcessProgress getByFormInstanceId(Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("formInstanceId", formInstanceId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getByFormInstanceId", param);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("carOwnerId", carOwnerId);
        param.put("formInstanceId", formInstanceId);
        param.put("type", -1);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getMap", param);
    }

    @Override
    public ProcessProgress get(Long carOwnerId, String formInstCode) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("carOwnerId", carOwnerId);
        param.put("formInstCode", formInstCode);
        param.put("type", -1);
        param.put("formInstanceId", -1);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.ProcessProgressMapper.getMap", param);
    }
}
