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
import com.qcloud.project.macaovehicle.dao.TaskingCiqDao;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.query.TaskingCiqQuery;

@Repository
public class TaskingCiqDaoMysqlImpl implements TaskingCiqDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(TaskingCiq taskingCiq) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.insert", taskingCiq) == 1;
    }

    @Override
    public TaskingCiq get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.delete", id) > 0;
    }

    @Override
    public boolean update(TaskingCiq taskingCiq) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.update", taskingCiq) > 0;
    }

    @Override
    public List<TaskingCiq> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingCiq> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingCiq> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<TaskingCiq> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.count4page", param);
        Page<TaskingCiq> page = new Page<TaskingCiq>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<TaskingCiq> page(TaskingCiqQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("ciqStatus", query.getCiqStatus());
        param.put("status", query.getStatus());
        param.put("statusIgnore", query.getStatusIgnore());
        param.put("type", StringUtil.emptyToNull(query.getType()));
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
        List<TaskingCiq> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.count4query", param);
        Page<TaskingCiq> page = new Page<TaskingCiq>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<TaskingCiq> listAll() {

        List<TaskingCiq> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.listAll");
        return list;
    }

    @Override
    public TaskingCiq getByFormInstanceId(Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("formInstanceId", formInstanceId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.getByFormInstanceId", param);
    }

    @Override
    public List<TaskingCiq> listAllByState(int status) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingCiqMapper.listAllByState", status);
    }
}
