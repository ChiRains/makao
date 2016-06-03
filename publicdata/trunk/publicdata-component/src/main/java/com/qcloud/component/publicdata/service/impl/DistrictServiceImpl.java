package com.qcloud.component.publicdata.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.publicdata.dao.DistrictDao;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
import com.qcloud.component.publicdata.service.DistrictService;
import com.qcloud.pirates.data.Page;
@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictDao         districtDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "publicdata_district";

    @Override
    public boolean add(District district) {
        District d = districtDao.getByName(district.getName());
        if (d != null) {
            throw new PublicdataException("区/县名称已经使用:" + district.getName());
        }
        long id = autoIdGenerator.get(ID_KEY);
        district.setId(id);
        return districtDao.add(district);
    }

    @Override
    public District get(Long id) {
        return districtDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return districtDao.delete(id);
    }

    @Override
    public boolean update(District district) {
        District d = districtDao.getByName(district.getName());
        if (d != null && d.getId() != district.getId()) {
            throw new PublicdataException("区/县名称已经使用:" + district.getName());
        }
        return districtDao.update(district);
    }

    @Override
    public Page<District> page(DistrictQuery query, int start, int count) {
        return districtDao.page(query, start, count);
    }

    public List<District> listAll() {
        return districtDao.listAll();
    }

    @Override
    public List<District> listByCity(long cityId) {       
        return districtDao.listByCity(cityId);
    }
}
