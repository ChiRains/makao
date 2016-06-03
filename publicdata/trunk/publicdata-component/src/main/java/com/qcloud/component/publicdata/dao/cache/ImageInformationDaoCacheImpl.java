package com.qcloud.component.publicdata.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.ImageInformationDao;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;

@Repository
public class ImageInformationDaoCacheImpl implements ImageInformationDao {
	
	@Autowired
	private ImageInformationDao imageInformationDaoMysqlImpl;
	
	@Autowired
	private ImageInformationDao imageInformationDaoRedisImpl;

	@Override
	public boolean add(ImageInformation imageInformation) {
		return imageInformationDaoMysqlImpl.add(imageInformation);
	}

	@Override
	public ImageInformation get(Long id) {
		return imageInformationDaoMysqlImpl.get(id);
	}

	@Override
	public boolean delete(Long id){
		return imageInformationDaoMysqlImpl.delete(id);
	}
	
	@Override
	public boolean update(ImageInformation imageInformation){
		return imageInformationDaoMysqlImpl.update(imageInformation);
	}
	
	@Override
	public List<ImageInformation> list(List<Long> idList) {
		return CacheLoader.list(imageInformationDaoRedisImpl, imageInformationDaoMysqlImpl, idList);
	}

	@Override
	public Map<Long, ImageInformation> map(Set<Long> idSet){
		return CacheLoader.map(imageInformationDaoRedisImpl, imageInformationDaoMysqlImpl, idSet);
	}

	@Override
	public Page<ImageInformation> page(int start, int count){
		return imageInformationDaoMysqlImpl.page(start, count);
	}
	
	@Override
	public Page<ImageInformation> page(ImageInformationQuery query, int start, int count){
		return imageInformationDaoMysqlImpl.page(query, start, count);
	}
	
	public List<ImageInformation> listAll(){
		return imageInformationDaoMysqlImpl.listAll();
	}

    @Override
    public ImageInformation getByCode(String code) {

        return imageInformationDaoMysqlImpl.getByCode(code);
    }
}

