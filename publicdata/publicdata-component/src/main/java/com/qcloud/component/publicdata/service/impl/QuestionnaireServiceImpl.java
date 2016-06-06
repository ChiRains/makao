package com.qcloud.component.publicdata.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.autoid.UniqueCodeGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.dao.QuestionnaireDao;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.service.QuestionnaireService;
import com.qcloud.component.publicdata.model.query.QuestionnaireQuery;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    @Autowired
    private QuestionnaireDao    questionnaireDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private UniqueCodeGenerator uniqueCodeGenerator;

    final static String         questionnaireCode = "publicdata-questionnaire-code";

    private static final String ID_KEY            = "publicdata_questionnaire";

    @Override
    public boolean add(Questionnaire questionnaire) {

        long id = autoIdGenerator.get(ID_KEY);
        questionnaire.setId(id);
        String code = uniqueCodeGenerator.generate(questionnaireCode, new HashMap<String, String>());
        questionnaire.setCode(code);
        return questionnaireDao.add(questionnaire);
    }

    @Override
    public Questionnaire get(Long id) {

        return questionnaireDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return questionnaireDao.delete(id);
    }

    @Override
    public boolean update(Questionnaire questionnaire) {

        return questionnaireDao.update(questionnaire);
    }

    @Override
    public Page<Questionnaire> page(QuestionnaireQuery query, int start, int count) {

        return questionnaireDao.page(query, start, count);
    }

    public List<Questionnaire> listAll() {

        return questionnaireDao.listAll();
    }

    @Override
    public Questionnaire getByCode(String code) {

        return questionnaireDao.getByCode(code);
    }
}
