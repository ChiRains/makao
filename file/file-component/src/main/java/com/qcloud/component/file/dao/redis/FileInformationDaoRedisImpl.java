package com.qcloud.component.file.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.component.file.dao.FileInformationDao;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;

@Repository
public class FileInformationDaoRedisImpl implements FileInformationDao {

	//@Resource(name = "redis-file")
	//private Redis redis;

	@Override
	public boolean add(FileInformation fileInformation) {			
		throw new NotImplementedException();
	}

	@Override
	public FileInformation get(Long id) {		
		throw new NotImplementedException();
	}
	
	@Override
	public boolean delete(Long id){
		throw new NotImplementedException();
	}
	
	@Override
	public boolean update(FileInformation fileInformation){
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}
	
	@Override
	public Page<FileInformation> page(FileInformationQuery query, int start, int count){
		throw new NotImplementedException();
	}
	
	@Override
	public List<FileInformation> listAll(){	
		throw new NotImplementedException();
	}

    @Override
    public FileInformation getByCode(String code) {
        throw new NotImplementedException();
    }
}

