package com.qcloud.component.file.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.file.dao.FileInformationDao;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;

@Repository
public class FileInformationDaoCacheImpl implements FileInformationDao {
	
	@Autowired
	private FileInformationDao fileInformationDaoMysqlImpl;
	
	@Autowired
	private FileInformationDao fileInformationDaoRedisImpl;

	@Override
	public boolean add(FileInformation fileInformation) {
		return fileInformationDaoMysqlImpl.add(fileInformation);
	}

	@Override
	public FileInformation get(Long id) {
		return  fileInformationDaoMysqlImpl.get( id);
	}

	@Override
	public boolean delete(Long id){
		return fileInformationDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(FileInformation fileInformation){
		return fileInformationDaoMysqlImpl.update(fileInformation);
	}
	
	@Override
	public List<FileInformation> list(List<Long> idList) {
		return CacheLoader.list(fileInformationDaoRedisImpl, fileInformationDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, FileInformation> map(Set<Long> idSet){
		return CacheLoader.map(fileInformationDaoRedisImpl, fileInformationDaoMysqlImpl, idSet);
	}

	@Override
	public Page<FileInformation> page(int start, int count){
		return fileInformationDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<FileInformation> page(FileInformationQuery query, int start, int count){
		return fileInformationDaoMysqlImpl.page(query, start, count);
	}
	
	public List<FileInformation> listAll(){
		return fileInformationDaoMysqlImpl.listAll();
	}

    @Override
    public FileInformation getByCode(String code) {

        return fileInformationDaoMysqlImpl.getByCode(code);
    }
}

