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
import com.qcloud.component.snakerext.dao.ProcessFormDao;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
@Repository
public class ProcessFormDaoMysqlImpl implements ProcessFormDao {
    @Resource(name = "sqlOperator-snakerext")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(ProcessForm processForm) {
        return sqlOperator.insert("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.insert", processForm) == 1;
    }

    @Override
    public ProcessForm get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.delete", id) > 0;
    }

    @Override
    public boolean update(ProcessForm processForm) {
        return sqlOperator.update("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.update", processForm) > 0;
    }

    @Override
    public List<ProcessForm> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProcessForm> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<ProcessForm> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessForm> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.count4page", param);
        Page<ProcessForm> page = new Page<ProcessForm>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<ProcessForm> page(ProcessFormQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<ProcessForm> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.count4query", param);
        Page<ProcessForm> page = new Page<ProcessForm>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<ProcessForm> listAll() {
        List<ProcessForm> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.listAll");
        return list;
    }

    @Override
    public List<ProcessForm> list(Map<String, Object> map) {
        List<ProcessForm> list = sqlOperator.selectList("com.qcloud.component.snakerext.dao.mysql.mapper.ProcessFormMapper.listByMap", map);
        return list;
    }
}
