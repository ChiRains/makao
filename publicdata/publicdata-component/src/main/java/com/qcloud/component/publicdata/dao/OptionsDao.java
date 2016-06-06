package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.query.OptionsQuery;

public interface OptionsDao extends ISimpleDao<Options, Long> {

    public boolean add(Options options);

    public Options get(Long id);

    public boolean delete(Long id);

    public boolean update(Options options);

    public List<Options> list(List<Long> idList);

    public Map<Long, Options> map(Set<Long> idSet);

    public Page<Options> page(OptionsQuery query, int start, int size);

    public List<Options> listAll();

    List<Options> listByQuestionnaire(long questionnaireId);

    List<Options> listByQuestion(long questionId);
}
