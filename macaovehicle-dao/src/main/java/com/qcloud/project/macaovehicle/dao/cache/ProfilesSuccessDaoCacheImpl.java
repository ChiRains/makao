package com.qcloud.project.macaovehicle.dao.cache;

import java.util.Map;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.data.CacheLoader;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ProfilesSuccessDao;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Repository
public class ProfilesSuccessDaoCacheImpl implements ProfilesSuccessDao {

    @Autowired
    private ProfilesSuccessDao profilesSuccessDaoMysqlImpl;

    @Autowired
    private ProfilesSuccessDao profilesSuccessDaoRedisImpl;

    @Override
    public boolean add(ProfilesSuccess profilesSuccess) {

        return profilesSuccessDaoMysqlImpl.add(profilesSuccess);
    }

    @Override
    public ProfilesSuccess get(Long id) {

        return CacheLoader.get(profilesSuccessDaoRedisImpl, profilesSuccessDaoMysqlImpl, id);
    }

    @Override
    public boolean delete(Long id) {

        return profilesSuccessDaoMysqlImpl.delete(id);
    }

    @Override
    public boolean update(ProfilesSuccess profilesSuccess) {

        return profilesSuccessDaoMysqlImpl.update(profilesSuccess);
    }

    @Override
    public List<ProfilesSuccess> list(List<Long> idList) {

        return CacheLoader.list(profilesSuccessDaoRedisImpl, profilesSuccessDaoMysqlImpl, idList);
    }

    @Override
    public Map<Long, ProfilesSuccess> map(Set<Long> idSet) {

        return CacheLoader.map(profilesSuccessDaoRedisImpl, profilesSuccessDaoMysqlImpl, idSet);
    }

    @Override
    public Page<ProfilesSuccess> page(int start, int count) {

        return profilesSuccessDaoMysqlImpl.page(start, count);
    }

    @Override
    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int count) {

        return profilesSuccessDaoMysqlImpl.page(query, start, count);
    }

    public List<ProfilesSuccess> listAll() {

        return profilesSuccessDaoMysqlImpl.listAll();
    }

    @Override
    public List<ProfilesSuccess> listByDriverId(Long driverId) {

        return profilesSuccessDaoMysqlImpl.listAll();
    }

    @Override
    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count) {

        return profilesSuccessDaoMysqlImpl.pageByGroup(query, start, count);
    }

    @Override
    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query) {

        return profilesSuccessDaoMysqlImpl.listByQuery(query);
    }
}
