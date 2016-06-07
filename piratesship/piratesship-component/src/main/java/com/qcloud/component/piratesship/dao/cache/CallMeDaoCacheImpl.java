package com.qcloud.component.piratesship.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.piratesship.dao.CallMeDao;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

@Repository
public class CallMeDaoCacheImpl implements CallMeDao {

    @Autowired
    private CallMeDao callMeDaoMysqlImpl;

    // @Autowired
    // private CallMeDao callMeDaoRedisImpl;
    @Override
    public boolean add(CallMe callMe) {

        return callMeDaoMysqlImpl.add(callMe);
    }

    @Override
    public CallMe get(Long id) {

        return callMeDaoMysqlImpl.get(id);
        // return CacheLoader.get(callMeDaoRedisImpl, callMeDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return callMeDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(CallMe callMe) {

        return callMeDaoMysqlImpl.update(callMe);
    }

    @Override
    public List<CallMe> list(List<Long> idList) {

        return CacheLoader.list(callMeDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, CallMe> map(Set<Long> idSet) {

        return CacheLoader.map(callMeDaoMysqlImpl, idSet);
    }

    @Override
    public Page<CallMe> page(int start, int count) {

        return callMeDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<CallMe> page(CallMeQuery query, int start, int count) {

        return callMeDaoMysqlImpl.page(query, start, count);
    }

    public List<CallMe> listAll() {

        return callMeDaoMysqlImpl.listAll();
    }
}
