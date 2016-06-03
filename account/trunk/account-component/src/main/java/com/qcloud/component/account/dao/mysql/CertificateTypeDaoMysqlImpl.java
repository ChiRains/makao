package com.qcloud.component.account.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.account.dao.CertificateTypeDao;
import com.qcloud.component.account.model.CertificateType;
import com.qcloud.component.account.model.query.CertificateTypeQuery;
		
@Repository
public class CertificateTypeDaoMysqlImpl implements CertificateTypeDao {

	@Resource(name = "sqlOperator-account")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(CertificateType certificateType) {
		return sqlOperator.insert("com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.insert", certificateType) == 1;
	}	
	
	@Override
	public CertificateType get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(CertificateType certificateType){
		return sqlOperator.update("com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.update", certificateType) > 0;
	}
	
	@Override
	public List<CertificateType> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, CertificateType> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<CertificateType> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CertificateType> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.count4page",
				param);
		Page<CertificateType> page = new Page<CertificateType>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<CertificateType> page(CertificateTypeQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<CertificateType> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.count4query",
				param);
		Page<CertificateType> page = new Page<CertificateType>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<CertificateType> listAll(){	
		List<CertificateType> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.listAll");
		return list;
	}

    @Override
    public CertificateType getByCode(String code) {
        return sqlOperator.selectOne("com.qcloud.component.account.dao.mysql.mapper.CertificateTypeMapper.getByCode", code);
    }
}

