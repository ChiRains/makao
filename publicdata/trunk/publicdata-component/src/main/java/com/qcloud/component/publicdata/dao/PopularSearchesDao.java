package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

public interface PopularSearchesDao extends ISimpleDao<PopularSearches, Long> {

    public boolean add(PopularSearches popularSearches);

    public PopularSearches get(Long id);

    PopularSearches get(int type, String keywords);

    public boolean delete(Long id);

    public boolean update(PopularSearches popularSearches);

    public List<PopularSearches> list(List<Long> idList);

    public Map<Long, PopularSearches> map(Set<Long> idSet);

    public Page<PopularSearches> page(PopularSearchesQuery query, int start, int size);

    public List<PopularSearches> listAll();

    List<PopularSearches> listTop(int type, int number);
}
