package com.qcloud.component.mvprocesstask.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.mvprocesstask.dao.TaskedDao;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.query.TaskedQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;

@Repository
public class TaskedDaoMysqlImpl implements TaskedDao {

    @Resource(name = "sqlOperator-mvprocesstask")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Tasked tasked) {

        return sqlOperator.insert("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.insert", tasked) == 1;
    }

    @Override
    public Tasked get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Tasked tasked) {

        return sqlOperator.update("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.update", tasked) > 0;
    }

    @Override
    public List<Tasked> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasked> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasked> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.count4page", param);
        Page<Tasked> page = new Page<Tasked>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Tasked> page(TaskedQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("clerkId", query.getClerkId());
        param.put("type", query.getType());
        param.put("formInstCode", StringUtil.emptyToNull(query.getFormInstCode()));
        param.put("clerkType", StringUtil.emptyToNull(query.getClerkType()));
        param.put("applyType", StringUtil.emptyToNull(query.getApplyType()));
        param.put("applyTimeBack", query.getApplyTimeBack() != null ? DateUtil.addDate(query.getApplyTimeBack(), 1) : null);
        param.put("applyTimeFront", query.getApplyTimeFront());
        param.put("clerkName", StringUtil.emptyToNull(query.getClerkName()));
        param.put("companyCode", StringUtil.emptyToNull(query.getCompanyCode()));
        param.put("companyName", StringUtil.emptyToNull(query.getCompanyName()));
        param.put("plateNumber", StringUtil.emptyToNull(query.getPlateNumber()));
        param.put("idCard", StringUtil.emptyToNull(query.getIdCard()));
        param.put("ownerName", StringUtil.emptyToNull(query.getOwnerName()));
        param.put("status", query.getStatus());
        param.put("departmentId", query.getDepartmentId());
        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.count4query", param);
        Page<Tasked> page = new Page<Tasked>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Tasked> listAll() {

        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.listAll");
        return list;
    }

    @Override
    public Tasked getByWorkitem(String workitemId) {

        return sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskedMapper.getByWorkitem", workitemId);
    }

    @Override
    public List<Tasked> listTaskedByProcessInst(String processInstId) {

        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.listTaskedByProcessInst", processInstId);
        return list;
    }

    @Override
    public List<Tasked> listTaskedByFormInstanceId(Long formInstanceId) {

        List<Tasked> list = sqlOperator.selectList("com.qcloud.component.processtask.dao.mysql.mapper.TaskedMapper.listTaskedByFormInstanceId", formInstanceId);
        return list;
    }
}
