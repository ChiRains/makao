package com.qcloud.component.publicdata.service;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.query.CityQuery;
public interface CityService {
    
    public boolean add(City city);

    public City get(Long id);

    public boolean delete(Long id);

    public boolean update(City city);

    public Page<City> page(CityQuery query, int start, int count);

    public List<City> listAll();

    public List<City> listByProvince(long provinceId);

    public City getByName(String city);
}
