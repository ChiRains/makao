package com.qcloud.component.publicdata.service;

import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;

public interface ImageInformationService {
	
	public boolean add(ImageInformation imageInformation);	
	
	public ImageInformation get(Long id);
	
	public	boolean delete(Long id);
	
	public	boolean update(ImageInformation imageInformation);

	public Page<ImageInformation> page(ImageInformationQuery query, int start, int count);
	
	public List<ImageInformation> listAll();
	
	public ImageInformation getByCode(String code);
}

