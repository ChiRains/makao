package com.qcloud.component.publicdata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.OptionsDao;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.service.OptionsService;
import com.qcloud.component.publicdata.model.query.OptionsQuery;
		
@Service
public class OptionsServiceImpl implements OptionsService{
	
	@Autowired
	private OptionsDao optionsDao;
	
	@Autowired
	private AutoIdGenerator autoIdGenerator;
	
	private static final String ID_KEY = "publicdata_options";

	@Override
	public boolean add(Options options) {
		long id = autoIdGenerator.get(ID_KEY);
		options.setId(id);
		
		return optionsDao.add(options);
	}

	@Override
	public Options get(Long id) {	
		return optionsDao.get(id);		
	}

	@Override
	public boolean delete(Long id) {
		return optionsDao.delete(id);
	}
	
	@Override
	public boolean update(Options options) {
		return optionsDao.update(options);
	}
	
	@Override
	public Page<Options> page(OptionsQuery query, int start, int count) {
		return optionsDao.page(query, start, count);
	}
	
	public List<Options> listAll(){
		return optionsDao.listAll();
	}

    @Override
    public List<Options> listByQuestionnaire(long questionnaireId) {
        return optionsDao.listByQuestionnaire(questionnaireId);
    }

    @Override
    public List<Options> listByQuestion(long questionId) {
        return optionsDao.listByQuestion(questionId);
    }
}

