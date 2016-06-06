package com.qcloud.component.metadata.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.core.reflect.BeanUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.metadata.dao.TableDao;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;

@Repository
public class TableDaoMysqlImpl implements TableDao {

    @Resource(name = "sqlOperator-metadata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Table table) {

        return sqlOperator.insert("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.insert", table) == 1;
    }

    @Override
    public Table get(Long id) {

        return sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {

        return sqlOperator.delete("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Table table) {

        return sqlOperator.update("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.update", table) > 0;
    }

    @Override
    public List<Table> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Table> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Table> page(int start, int count) {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Table> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.count4page", param);
        Page<Table> page = new Page<Table>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Table> page(TableQuery query, int start, int count) {

        Map<String, Object> param = BeanUtils.transBean2Map(query);
        param.put("start", start);
        param.put("count", count);
        List<Table> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.count4query", param);
        Page<Table> page = new Page<Table>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Table> listAll() {

        List<Table> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.listAll");
        return list;
    }

    @Override
    public List<Table> getByName(String name) {

        List<Table> list = sqlOperator.selectList("com.qcloud.component.metadata.dao.mysql.mapper.TableMapper.listByName", name);
        return list;
    }
}
