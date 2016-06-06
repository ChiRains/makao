package com.qcloud.component.file.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.model.query.FileInformationQuery;

public interface FileInformationService {
	
	public boolean add(FileInformation fileInformation);	
	
	public FileInformation get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(FileInformation fileInformation);

	public Page<FileInformation> page(FileInformationQuery query, int start, int count);
	
	public List<FileInformation> listAll();
	
	public FileInformation getByCode(String code);
}

