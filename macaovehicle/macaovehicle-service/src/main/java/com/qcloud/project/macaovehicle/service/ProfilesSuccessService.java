package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

public interface ProfilesSuccessService {

    public boolean add(ProfilesSuccess profilesSuccess);

    public ProfilesSuccess get(Long id);

    public boolean delete(Long id);

    public boolean update(ProfilesSuccess profilesSuccess);

    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int count);

    public List<ProfilesSuccess> listAll();

    public List<ProfilesSuccess> listByDriverId(Long driverId);

    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count);

    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query);
}
