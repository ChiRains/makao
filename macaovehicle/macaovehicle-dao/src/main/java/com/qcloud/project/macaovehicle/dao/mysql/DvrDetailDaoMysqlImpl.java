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
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.DvrDetailDao;
import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.model.query.DvrDetailQuery;
		
@Repository
public class DvrDetailDaoMysqlImpl implements DvrDetailDao {

	@Resource(name = "sqlOperator-macaovehicle")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(DvrDetail dvrDetail) {
		return sqlOperator.insert("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.insert", dvrDetail) == 1;
	}	
	
	@Override
	public DvrDetail get(Long id) {
		return sqlOperator.selectOne("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(DvrDetail dvrDetail){
		return sqlOperator.update("com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.update", dvrDetail) > 0;
	}
	
	@Override
	public List<DvrDetail> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, DvrDetail> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<DvrDetail> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<DvrDetail> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.count4page",
				param);
		Page<DvrDetail> page = new Page<DvrDetail>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<DvrDetail> page(DvrDetailQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("areaId", query.getAreaId());
		param.put("start", start);
		param.put("count", count);
		List<DvrDetail> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.count4query",
				param);
		Page<DvrDetail> page = new Page<DvrDetail>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<DvrDetail> listAll(){	
		List<DvrDetail> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.listAll");
		return list;
	}
	
	@Override
	public List<DvrDetail> getByArea(long id){	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("areaId", id);
		List<DvrDetail> list = sqlOperator.selectList(
				"com.qcloud.project.macaovehicle.dao.mysql.mapper.DvrDetailMapper.getByArea",param);
		return list;
	}
}

