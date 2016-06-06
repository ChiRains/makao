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
import com.qcloud.component.publicdata.dao.ImageInformationDao;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;
		
@Repository
public class ImageInformationDaoMysqlImpl implements ImageInformationDao {

	@Resource(name = "sqlOperator-publicdata")
	private SqlOperator sqlOperator;

	@Override
	public boolean add(ImageInformation imageInformation) {
		return sqlOperator.insert("com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.insert", imageInformation) == 1;
	}	
	
	@Override
	public ImageInformation get(Long id) {
		return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.get", id);
	}	
	
	@Override
	public boolean delete(Long id){
		return sqlOperator.delete("com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.delete", id) > 0;
	}	
		
	@Override
	public boolean update(ImageInformation imageInformation){
		return sqlOperator.update("com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.update", imageInformation) > 0;
	}
	
	@Override
	public List<ImageInformation> list(List<Long> idList) {
		throw new NotImplementedException();
	}

	@Override
	public Map<Long, ImageInformation> map(Set<Long> idSet){
		throw new NotImplementedException();
	}
		
	@Override
	public Page<ImageInformation> page(int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ImageInformation> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.list4page",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.count4page",
				param);
		Page<ImageInformation> page = new Page<ImageInformation>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public Page<ImageInformation> page(ImageInformationQuery query, int start, int count){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", count);

		List<ImageInformation> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.list4query",
				param);
		int total = sqlOperator.selectOne(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.count4query",
				param);
		Page<ImageInformation> page = new Page<ImageInformation>();
		page.setCount(total);
		page.setData(list);
		return page;
	}
	
	@Override
	public List<ImageInformation> listAll(){	
		List<ImageInformation> list = sqlOperator.selectList(
				"com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.listAll");
		return list;
	}

    @Override
    public ImageInformation getByCode(String code) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("code", code);

        return sqlOperator.selectOne("com.qcloud.component.publicdata.dao.mysql.mapper.ImageInformationMapper.getByCode", code);
        
    }
}

