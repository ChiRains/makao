package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;
		
public interface ImageInformationDao extends ISimpleDao<ImageInformation, Long> {

	public boolean add(ImageInformation imageInformation);	
	
	public ImageInformation get(Long id);

	public boolean delete(Long id);
	
	public boolean update(ImageInformation imageInformation);
	
	public List<ImageInformation> list(List<Long> idList);
	
	public Map<Long, ImageInformation> map(Set<Long> idSet);
	
	public Page<ImageInformation> page(ImageInformationQuery query, int start, int size);

	public List<ImageInformation> listAll();
	
	public ImageInformation getByCode(String code);
}
