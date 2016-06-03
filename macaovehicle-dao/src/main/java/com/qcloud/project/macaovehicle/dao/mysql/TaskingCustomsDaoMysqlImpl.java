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
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.TaskingCustomsDao;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;

@Repository
public class TaskingCustomsDaoMysqlImpl implements TaskingCustomsDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(TaskingCustoms taskingCustoms) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.insert", taskingCustoms) == 1;
    }

    @Override
    public TaskingCustoms get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.delete", id) > 0;
    }

    @Override
    public boolean update(TaskingCustoms taskingCustoms) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.update", taskingCustoms) > 0;
    }

    @Override
    public List<TaskingCustoms> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingCustoms> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCustoms> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<TaskingCustoms> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.count4page", param);
        Page<TaskingCustoms> page = new Page<TaskingCustoms>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<TaskingCustoms> page(TaskingCustomsQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("customsStatus", query.getCustomsStatus());
        param.put("status", query.getStatus());
        param.put("statusIgnore", query.getStatusIgnore());
        param.put("type", StringUtil.emptyToNull(query.getType()));
        param.put("clerkType", query.getClerkType());
        param.put("formInstCode", StringUtil.emptyToNull(query.getFormInstCode()));
        param.put("applyType", StringUtil.emptyToNull(query.getApplyType()));
        param.put("applyTimeBack", query.getApplyTimeBack() != null ? DateUtil.addDate(query.getApplyTimeBack(), 1) : null);
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("clerkName", StringUtil.emptyToNull(query.getClerkName()));
        param.put("companyCode", StringUtil.emptyToNull(query.getCompanyCode()));
        param.put("companyName", StringUtil.emptyToNull(query.getCompanyName()));
        param.put("plateNumber", StringUtil.emptyToNull(query.getPlateNumber()));
        param.put("idCard", StringUtil.emptyToNull(query.getIdCard()));
        param.put("ownerName", StringUtil.emptyToNull(query.getOwnerName()));
        List<TaskingCustoms> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.count4query", param);
        Page<TaskingCustoms> page = new Page<TaskingCustoms>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<TaskingCustoms> listAll() {

        List<TaskingCustoms> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.listAll");
        return list;
    }

    @Override
    public TaskingCustoms getByFormInstanceId(Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("formInstanceId", formInstanceId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.getByFormInstanceId", param);
    }

    @Override
    public List<TaskingCustoms> listAllByState(int status) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCustomsMapper.listAllByState", status);
    }
}
