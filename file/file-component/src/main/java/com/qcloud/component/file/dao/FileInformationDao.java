package com.qcloud.component.file.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;
		
public interface FileInformationDao extends ISimpleDao<FileInformation, Long> {

	public boolean add(FileInformation fileInformation);	
	
	public FileInformation get(Long id);

	public boolean delete(Long id);
	
	public boolean update(FileInformation fileInformation);
	
	public List<FileInformation> list(List<Long> idList);
	
	public Map<Long, FileInformation> map(Set<Long> idSet);
	
	public Page<FileInformation> page(FileInformationQuery query, int start, int size);

	public List<FileInformation> listAll();
	
	public FileInformation getByCode(String code);
	
}
