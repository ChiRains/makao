package com.qcloud.component.file.dao.mysql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.apache.commons.lang.NotImplementedException;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.sql.mybatis.SqlOperator;
import com.qcloud.component.file.dao.FileInformationDao;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;
		
@Repository
public class FileInformationDaoMysqlImpl implements FileInformationDao {

	@Resource(name = "sqlOperator-file")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(FileInformation fileInformation) {
		return sqlOperator.insert("com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.insert", fileInformation) == 1;
	}	
	
	@Override
	public FileInformation get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(FileInformation fileInformation){
		return sqlOperator.update("com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.update", fileInformation) > 0;
	}
	
	@Override
	public List<FileInformation> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, FileInformation> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<FileInformation> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<FileInformation> list = sqlOperator.selectList(
				"com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.count4page",
				param);
		Page<FileInformation> page = new Page<FileInformation>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<FileInformation> page(FileInformationQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<FileInformation> list = sqlOperator.selectList(
				"com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.count4query",
				param);
		Page<FileInformation> page = new Page<FileInformation>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<FileInformation> listAll(){	
		List<FileInformation> list = sqlOperator.selectList(
				"com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.listAll");
		return list;
	}

    @Override
    public FileInformation getByCode(String code) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", code);
        FileInformation fileInformation=sqlOperator.selectOne(
                "com.qcloud.component.file.dao.mysql.mapper.FileInformationMapper.getByCode",
                param);
        return fileInformation;
    }
}

