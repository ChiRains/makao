package com.qcloud.project.macaovehicle.dao.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.stereotype.Repository;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.redis.Redis;
import com.qcloud.project.macaovehicle.dao.ProfilesSuccessDao;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Repository
public class ProfilesSuccessDaoRedisImpl implements ProfilesSuccessDao {

    // @Resource(name = "redis-macaovehicle")
    // private Redis redis;
    @Override
    public boolean add(ProfilesSuccess profilesSuccess) {

        throw new NotImplementedException();
    }

    @Override
    public ProfilesSuccess get(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean delete(Long id) {

        throw new NotImplementedException();
    }

    @Override
    public boolean update(ProfilesSuccess profilesSuccess) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProfilesSuccess> list(List<Long> idList) {

        throw new NotImplementedException();
    }

    @Override
    public Map<Long, ProfilesSuccess> map(Set<Long> idSet) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProfilesSuccess> page(int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProfilesSuccess> listAll() {

        throw new NotImplementedException();
    }

    @Override
    public List<ProfilesSuccess> listByDriverId(Long driverId) {

        throw new NotImplementedException();
    }

    @Override
    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count) {

        throw new NotImplementedException();
    }

    @Override
    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query) {

        throw new NotImplementedException();
    }
}
