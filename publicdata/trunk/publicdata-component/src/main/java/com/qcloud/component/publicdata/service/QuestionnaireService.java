package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

public interface QuestionnaireService {

    public boolean add(Questionnaire questionnaire);

    public Questionnaire get(Long id);

    public Questionnaire getByCode(String code);

    public boolean delete(Long id);

    public boolean update(Questionnaire questionnaire);

    public Page<Questionnaire> page(QuestionnaireQuery query, int start, int count);

    public List<Questionnaire> listAll();
}
