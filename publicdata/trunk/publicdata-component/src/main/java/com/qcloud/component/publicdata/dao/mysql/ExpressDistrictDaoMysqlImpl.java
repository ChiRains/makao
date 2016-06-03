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
import com.qcloud.component.publicdata.dao.ExpressDistrictDao;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.model.query.ExpressDistrictQuery;
		
@Repository
public class ExpressDistrictDaoMysqlImpl implements ExpressDistrictDao {

	@Resource(name = "sqlOperator-publicdata")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(ExpressDistrict expressDistrict) {
		return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.insert", expressDistrict) == 1;
	}	
	
	@Override
	public ExpressDistrict get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(ExpressDistrict expressDistrict){
		return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.update", expressDistrict) > 0;
	}
	
	@Override
	public List<ExpressDistrict> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ExpressDistrict> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ExpressDistrict> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ExpressDistrict> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.count4page",
				param);
		Page<ExpressDistrict> page = new Page<ExpressDistrict>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<ExpressDistrict> page(ExpressDistrictQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ExpressDistrict> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.count4query",
				param);
		Page<ExpressDistrict> page = new Page<ExpressDistrict>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<ExpressDistrict> listAll(){	
		List<ExpressDistrict> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.listAll");
		return list;
	}

    @Override
    public List<ExpressDistrict> listByExpressId(Long expressId) {
        List<ExpressDistrict> list = sqlOperator.selectList(
                "com.qcloud.component.publicdata.dao.mysql.mapper.ExpressDistrictMapper.listByExpressId",expressId);
        return list;
    }
}

