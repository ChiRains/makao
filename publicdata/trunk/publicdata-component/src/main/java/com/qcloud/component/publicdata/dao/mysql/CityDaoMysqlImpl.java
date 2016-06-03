package com.qcloud.component.publicdata.dao.mysql;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.StringUtils;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.component.publicdata.dao.CityDao;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;
@Repository
public class CityDaoMysqlImpl implements CityDao {
    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(City city) {
        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.insert", city) == 1;
    }

    @Override
    public City get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.delete", id) > 0;
    }

    @Override
    public boolean update(City city) {
        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.update", city) > 0;
    }

    @Override
    public List<City> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, City> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<City> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<City> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.count4page", param);
        Page<City> page = new Page<City>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<City> page(CityQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("provinceId", query.getProvinceId());
        param.put("name", StringUtil.nullToEmpty(query.getName()));
        List<City> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.count4query", param);
        Page<City> page = new Page<City>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<City> listAll() {
        List<City> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.listAll");
        return list;
    }

    @Override
    public City getByName(String name) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.getByName", name);
    }

    @Override
    public List<City> listByProvince(long provinceId) {
        List<City> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.CityMapper.listByProvince", provinceId);
        return list;
    }
}
