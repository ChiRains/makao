package com.qcloud.component.publicdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.component.publicdata.dao.ImageInformationDao;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.service.ImageInformationService;
import com.qcloud.component.publicdata.model.query.ImageInformationQuery;
		
@Service
public class ImageInformationServiceImpl implements ImageInformationService{
	
	@Autowired
	private ImageInformationDao imageInformationDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicdata_image_information";

	@Override
	public boolean add(ImageInformation imageInformation) {
	    ImageInformation information=imageInformationDao.getByCode(imageInformation.getCode());
	    AssertUtil.assertTrue(information==null, "code编码已存在."+imageInformation.getCode());
		long id = autoIdGenerator.get(ID_KEY);
		imageInformation.setId(id);
		
		return imageInformationDao.add(imageInformation);
	}

	@Override
	public ImageInformation get(Long id) {	
		return imageInformationDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return imageInformationDao.delete(id);
	}
	
	@Override
	public boolean update(ImageInformation imageInformation) {
	    ImageInformation information=imageInformationDao.getByCode(imageInformation.getCode());
        AssertUtil.assertTrue(information!=null, "code编码不存在."+imageInformation.getCode());
		return imageInformationDao.update(imageInformation);
	}
	
	@Override
	public Page<ImageInformation> page(ImageInformationQuery query, int start, int count) {
		return imageInformationDao.page(query, start, count);
	}
	
	public List<ImageInformation> listAll(){
		return imageInformationDao.listAll();
	}

    @Override
    public ImageInformation getByCode(String code) {

        return imageInformationDao.getByCode(code);
    }
}

