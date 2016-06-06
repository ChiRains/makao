package com.qcloud.component.permission.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.permission.dao.ResourcesDao;
import com.qcloud.component.permission.model.Resources;

@Repository
public class ResourcesDaoMysqlImpl implements ResourcesDao {

    @Resource(name = "sqlOperator-permission")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Resources resources) {

        return sqlOperator.insert("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.insert", resources) == 1;
    }

    @Override
    public Resources get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Resources resources) {

        return sqlOperator.update("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.update", resources) > 0;
    }

    @Override
    public List<Resources> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Resources> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Resources> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Resources> list = sqlOperator.selectList("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.count4page", param);
        Page<Resources> page = new Page<Resources>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Resources getByClassifyId(long classifyId) {

        return sqlOperator.selectOne("com.qcloud.component.permission.dao.mysql.mapper.ResourcesMapper.getByClassifyId", classifyId);
    }
}
