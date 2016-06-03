package com.qcloud.project.macaovehicle.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

public interface ProfilesSuccessDao extends ISimpleDao<ProfilesSuccess, Long> {

    public boolean add(ProfilesSuccess profilesSuccess);

    public ProfilesSuccess get(Long id);

    public boolean delete(Long id);

    public boolean update(ProfilesSuccess profilesSuccess);

    public List<ProfilesSuccess> list(List<Long> idList);

    public Map<Long, ProfilesSuccess> map(Set<Long> idSet);

    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int size);

    public List<ProfilesSuccess> listAll();

    public List<ProfilesSuccess> listByDriverId(Long driverId);

    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count);

    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query);
}
