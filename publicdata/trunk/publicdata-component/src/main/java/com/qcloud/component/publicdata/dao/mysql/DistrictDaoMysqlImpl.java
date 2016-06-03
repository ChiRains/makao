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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.component.publicdata.dao.DistrictDao;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
@Repository
public class DistrictDaoMysqlImpl implements DistrictDao {
    @Resource(name = "sqlOperator-publicdata")
    private SqlOperator sqlOperator;

    @Override
    public boolean add(District district) {
        return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.insert", district) == 1;
    }

    @Override
    public District get(Long id) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.get", id);
    }

    @Override
    public boolean delete(Long id) {
        return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.delete", id) > 0;
    }

    @Override
    public boolean update(District district) {
        return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.update", district) > 0;
    }

    @Override
    public List<District> list(List<Long> idList) {
        throw new NotImplementedException();
    }

    @Override
    public Map<Long, District> map(Set<Long> idSet) {
        throw new NotImplementedException();
    }

    @Override
    public Page<District> page(int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        List<District> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.list4page", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.count4page", param);
        Page<District> page = new Page<District>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public Page<District> page(DistrictQuery query, int start, int count) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("start", start);
        param.put("count", count);
        param.put("provinceId", query.getProvinceId());
        param.put("cityId", query.getCityId());
        param.put("name", StringUtil.nullToEmpty(query.getName()));
        List<District> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.list4query", param);
        int total = sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.count4query", param);
        Page<District> page = new Page<District>();
        page.setCount(total);
        page.setData(list);
        return page;
    }

    @Override
    public List<District> listAll() {
        List<District> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.listAll");
        return list;
    }

    @Override
    public District getByName(String name) {
        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.getByName", name);
    }

    @Override
    public List<District> listByCity(long cityId) {
        List<District> list = sqlOperator.selectList("com.qcloud.component.publicdata.dao.mysql.mapper.DistrictMapper.listByCity", cityId);
        return list;
    }
}
