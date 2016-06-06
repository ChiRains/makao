package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;
		
public interface QuestionnaireDao extends ISimpleDao<Questionnaire, Long> {

	public boolean add(Questionnaire questionnaire);	
	
	public Questionnaire get(Long id);

	public boolean delete(Long id);
	
	public boolean update(Questionnaire questionnaire);
	
	public List<Questionnaire> list(List<Long> idList);
	
	public Map<Long, Questionnaire> map(Set<Long> idSet);
	
	public Page<Questionnaire> page(QuestionnaireQuery query, int start, int size);

	public List<Questionnaire> listAll();
	
	Questionnaire getByCode(String code);
}
