package com.qcloud.component.publicdata.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;

public interface PopularSearchesService {

    public boolean add(PopularSearches popularSearches);

    public PopularSearches get(Long id);

    public boolean delete(Long id);

    public boolean update(PopularSearches popularSearches);

    public Page<PopularSearches> page(PopularSearchesQuery query, int start, int count);

    public List<PopularSearches> listAll();

    List<String> listTop(int type, int number);
}
