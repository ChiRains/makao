package com.qcloud.component.publicdata.dao.mysql;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.publicdata.dao.ProvinceDao;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;
@Repository
public class ProvinceDaoMysqlImpl implements ProvinceDao {
    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(Province province) {
        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.insert", province) == 1;
    }

    @Override
    public Province get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.delete", id) > 0;
    }

    @Override
    public boolean update(Province province) {
        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.update", province) > 0;
    }

    @Override
    public List<Province> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, Province> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<Province> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Province> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.count4page", param);
        Page<Province> page = new Page<Province>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<Province> page(ProvinceQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<Province> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.count4query", param);
        Page<Province> page = new Page<Province>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<Province> listAll() {
        List<Province> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.listAll");
        return list;
    }

    @Override
    public Province getByName(String name) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ProvinceMapper.getByName", name);
    }
}
