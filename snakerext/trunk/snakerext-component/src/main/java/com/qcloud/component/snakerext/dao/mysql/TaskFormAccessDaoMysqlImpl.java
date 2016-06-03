package com.qcloud.component.snakerext.dao.mysql;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.snakerext.dao.TaskFormAccessDao;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
@Repository
public class TaskFormAccessDaoMysqlImpl implements TaskFormAccessDao {
    @Resource(name = "sqlOperator-snakerext")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(TaskFormAccess taskFormAccess) {
        return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.insert", taskFormAccess) == 1;
    }

    @Override
    public TaskFormAccess get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.delete", id) > 0;
    }

    @Override
    public boolean update(TaskFormAccess taskFormAccess) {
        return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.update", taskFormAccess) > 0;
    }

    @Override
    public List<TaskFormAccess> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, TaskFormAccess> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<TaskFormAccess> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<TaskFormAccess> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.count4page", param);
        Page<TaskFormAccess> page = new Page<TaskFormAccess>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<TaskFormAccess> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.count4query", param);
        Page<TaskFormAccess> page = new Page<TaskFormAccess>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<TaskFormAccess> listAll() {
        List<TaskFormAccess> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.listAll");
        return list;
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.deleteByMap", map) > 0;
    }

    @Override
    public List<TaskFormAccess> listAll(Map<String, Object> map) {
        List<TaskFormAccess> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.TaskFormAccessMapper.listByMap", map);
        return list;
    }
}
