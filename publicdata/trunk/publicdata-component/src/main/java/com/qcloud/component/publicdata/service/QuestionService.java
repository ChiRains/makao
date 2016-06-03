package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;

public interface QuestionService {

    public boolean add(Question question);

    public Question get(Long id);

    public boolean delete(Long id);

    public boolean update(Question question);

    public Page<Question> page(QuestionQuery query, int start, int count);

    public List<Question> listAll();

    List<Question> listByQuestionnaire(long questionnaireId);
}
