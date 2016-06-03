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
import com.qcloud.project.macaovehicle.dao.TaskingBorderDao;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;

@Repository
public class TaskingBorderDaoMysqlImpl implements TaskingBorderDao {

    @Resource(name = "sqlOperator-macaovehicle")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(TaskingBorder taskingBorder) {

        return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.insert", taskingBorder) == 1;
    }

    @Override
    public TaskingBorder get(Long id) {

        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.delete", id) > 0;
    }

    @Override
    public boolean update(TaskingBorder taskingBorder) {

        return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.update", taskingBorder) > 0;
    }

    @Override
    public List<TaskingBorder> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskingBorder> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<TaskingBorder> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<TaskingBorder> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.count4page", param);
        Page<TaskingBorder> page = new Page<TaskingBorder>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<TaskingBorder> page(TaskingBorderQuery query, int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("ciqStatus", query.getCiqStatus());
        param.put("borderStatus", query.getBorderStatus());
        param.put("customsStatus", query.getCustomsStatus());
        param.put("status", query.getStatus());
        param.put("statusIgnore", query.getStatusIgnore());
        param.put("clerkType", query.getClerkType());
        param.put("type", StringUtil.emptyToNull(query.getType()));
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
        List<TaskingBorder> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.count4query", param);
        Page<TaskingBorder> page = new Page<TaskingBorder>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<TaskingBorder> listAll() {

        List<TaskingBorder> list = sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.listAll");
        return list;
    }

    @Override
    public TaskingBorder getByFormInstanceId(Long formInstanceId) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", 0);
        param.put("count", 1);
        param.put("formInstanceId", formInstanceId);
        return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.getByFormInstanceId", param);
    }

    @Override
    public List<TaskingBorder> listAllByState(int status) {

        return sqlOperator.selectList("com.qcloud.project.macaovehicle.dao.mysql.mapper.TaskingBorderMapper.listAllByState", status);
    }
}
