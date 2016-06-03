package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.ProfilesSuccessDao;
import com.qcloud.project.macaovehicle.model.ProfilesSuccess;
import com.qcloud.project.macaovehicle.service.ProfilesSuccessService;
import com.qcloud.project.macaovehicle.model.query.ProfilesSuccessQuery;

@Service
public class ProfilesSuccessServiceImpl implements ProfilesSuccessService {

    @Autowired
    private ProfilesSuccessDao  profilesSuccessDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "macaovehicle_profiles_success";

    @Override
    public boolean add(ProfilesSuccess profilesSuccess) {

        long id = autoIdGenerator.get(ID_KEY);
        profilesSuccess.setId(id);
        return profilesSuccessDao.add(profilesSuccess);
    }

    @Override
    public ProfilesSuccess get(Long id) {

        return profilesSuccessDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return profilesSuccessDao.delete(id);
    }

    @Override
    public boolean update(ProfilesSuccess profilesSuccess) {

        return profilesSuccessDao.update(profilesSuccess);
    }

    @Override
    public Page<ProfilesSuccess> page(ProfilesSuccessQuery query, int start, int count) {

        return profilesSuccessDao.page(query, start, count);
    }

    public List<ProfilesSuccess> listAll() {

        return profilesSuccessDao.listAll();
    }

    @Override
    public List<ProfilesSuccess> listByDriverId(Long driverId) {

        return profilesSuccessDao.listByDriverId(driverId);
    }

    @Override
    public Page<Object[]> pageByGroup(ProfilesSuccessQuery query, int start, int count) {

        return profilesSuccessDao.pageByGroup(query, start, count);
    }

    @Override
    public List<ProfilesSuccess> listByQuery(ProfilesSuccessQuery query) {

        return profilesSuccessDao.listByQuery(query);
    }
}
