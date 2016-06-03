package com.qcloud.component.mvprocesstask.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.component.mvprocesstask.dao.TaskingDao;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.model.query.TaskingQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.StringUtil;

@Repository
public class TaskingDaoMysqlImpl implements TaskingDao {

    @Resource(name = "sqlOperator-mvprocesstask")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Tasking tasking) {

        return sqlOperator.insert("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.insert", tasking) == 1;
    }

    @Override
    public Tasking get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Tasking tasking) {

        return sqlOperator.update("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.update", tasking) > 0;
    }

    @Override
    public List<Tasking> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Tasking> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Tasking> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.count4page", param);
        Page<Tasking> page = new Page<Tasking>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Tasking> page(TaskingQuery query, int start, int count) {

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
        param.put("departmentId", query.getDepartmentId());
        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.count4query", param);
        Page<Tasking> page = new Page<Tasking>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Tasking> listAll() {

        List<Tasking> list = sqlOperator.selectList("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.listAll");
        return list;
    }

    @Override
    public Tasking getByWorkitem(String workitemId) {

        return sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.getByWorkitem", workitemId);
    }

    @Override
    public Tasking getByFormInstanceId(Long formInstanceId) {

        return sqlOperator.selectOne("com.qcloud.component.mvprocesstask.dao.mysql.mapper.TaskingMapper.getByFormInstanceId", formInstanceId);
    }
}
