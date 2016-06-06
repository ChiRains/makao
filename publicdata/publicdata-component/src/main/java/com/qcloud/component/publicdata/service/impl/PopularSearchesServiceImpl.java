package com.qcloud.component.publicdata.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.publicdata.dao.PopularSearchesDao;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.query.PopularSearchesQuery;
import com.qcloud.component.publicdata.service.PopularSearchesService;
import com.qcloud.pirates.data.Page;

@Service
public class PopularSearchesServiceImpl implements PopularSearchesService {

    @Autowired
    private PopularSearchesDao  popularSearchesDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicdata_popular_searches";

    @Override
    public boolean add(PopularSearches popularSearches) {

        if (StringUtils.isEmpty(popularSearches.getKeywords())) {
            return false;
        }
        PopularSearches ps = popularSearchesDao.get(popularSearches.getType(), popularSearches.getKeywords());
        if (ps == null) {
            popularSearches.setTimes(1L);
            long id = autoIdGenerator.get(ID_KEY);
            popularSearches.setId(id);
            return popularSearchesDao.add(popularSearches);
        } else {
            ps.setTimes(ps.getTimes() + 1);
            return update(ps);
        }
    }

    @Override
    public PopularSearches get(Long id) {

        return popularSearchesDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return popularSearchesDao.delete(id);
    }

    @Override
    public boolean update(PopularSearches popularSearches) {

        return popularSearchesDao.update(popularSearches);
    }

    @Override
    public Page<PopularSearches> page(PopularSearchesQuery query, int start, int count) {

        return popularSearchesDao.page(query, start, count);
    }

    public List<PopularSearches> listAll() {

        return popularSearchesDao.listAll();
    }

    @Override
    public List<String> listTop(int type, int number) {

        List<PopularSearches> list = popularSearchesDao.listTop(type, number);
        List<String> strList = new ArrayList<String>();
        for (PopularSearches popularSearches : list) {
            strList.add(popularSearches.getKeywords());
        }
        return strList;
    }
}
