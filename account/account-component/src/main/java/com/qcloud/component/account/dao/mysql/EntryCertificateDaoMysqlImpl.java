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
import com.qcloud.component.account.dao.EntryCertificateDao;
import com.qcloud.component.account.model.EntryCertificate;
import com.qcloud.component.account.model.query.EntryCertificateQuery;
		
@Repository
public class EntryCertificateDaoMysqlImpl implements EntryCertificateDao {

	@Resource(name = "sqlOperator-account")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(EntryCertificate entryCertificate) {
		return sqlOperator.insert("com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.insert", entryCertificate) == 1;
	}	
	
	@Override
	public EntryCertificate get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(EntryCertificate entryCertificate){
		return sqlOperator.update("com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.update", entryCertificate) > 0;
	}
	
	@Override
	public List<EntryCertificate> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, EntryCertificate> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<EntryCertificate> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<EntryCertificate> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.count4page",
				param);
		Page<EntryCertificate> page = new Page<EntryCertificate>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<EntryCertificate> page(EntryCertificateQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<EntryCertificate> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.count4query",
				param);
		Page<EntryCertificate> page = new Page<EntryCertificate>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<EntryCertificate> listAll(){	
		List<EntryCertificate> list = sqlOperator.selectList(
				"com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.listAll");
		return list;
	}

    @Override
    public EntryCertificate getByAccount(String account) {
        EntryCertificate entryCertificate = sqlOperator.selectOne(
                "com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.getByAccount", account);
        return entryCertificate;
    }

    @Override
    public List<EntryCertificate> listByGroup(String group) {
        List<EntryCertificate> list = sqlOperator.selectList(
                "com.qcloud.component.account.dao.mysql.mapper.EntryCertificateMapper.listByGroup", group);
        return list;
    }
}

