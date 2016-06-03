package com.qcloud.component.publicdata.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.publicdata.dao.CityDao;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.pirates.data.Page;
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao             cityDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "publicdata_city";

    @Override
    public boolean add(City city) {
        City c = cityDao.getByName(city.getName());
        if (c != null) {
            throw new PublicdataException("地级市名称已经使用:" + city.getName());
        }
        long id = autoIdGenerator.get(ID_KEY);
        city.setId(id);
        return cityDao.add(city);
    }

    @Override
    public City get(Long id) {
        return cityDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return cityDao.delete(id);
    }

    @Override
    public boolean update(City city) {
        City c = cityDao.getByName(city.getName());
        if (c != null && c.getId() != city.getId()) {
            throw new PublicdataException("地级市名称已经使用:" + city.getName());
        }
        return cityDao.update(city);
    }

    @Override
    public Page<City> page(CityQuery query, int start, int count) {
        return cityDao.page(query, start, count);
    }

    public List<City> listAll() {
        return cityDao.listAll();
    }

    @Override
    public List<City> listByProvince(long provinceId) {       
        return cityDao.listByProvince(provinceId);
    }

    @Override
    public City getByName(String city) {       
        return cityDao.getByName(city);
    }
}
