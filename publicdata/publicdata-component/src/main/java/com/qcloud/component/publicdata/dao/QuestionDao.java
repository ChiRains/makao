package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.query.QuestionQuery;

public interface QuestionDao extends ISimpleDao<Question, Long> {

    public boolean add(Question question);

    public Question get(Long id);

    public boolean delete(Long id);

    public boolean update(Question question);

    public List<Question> list(List<Long> idList);

    public Map<Long, Question> map(Set<Long> idSet);

    public Page<Question> page(QuestionQuery query, int start, int size);

    public List<Question> listAll();

    List<Question> listByQuestionnaire(long questionnaireId);
}
