package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;
import com.qcloud.pirates.data.Page;

public interface OptionsService {

    public boolean add(Options options);

    public Options get(Long id);

    public boolean delete(Long id);

    public boolean update(Options options);

    public Page<Options> page(OptionsQuery query, int start, int count);

    public List<Options> listAll();

    List<Options> listByQuestionnaire(long questionnaireId);

    List<Options> listByQuestion(long questionId);
}
