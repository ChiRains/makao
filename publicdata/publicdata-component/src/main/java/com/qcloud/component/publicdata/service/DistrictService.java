package com.qcloud.component.publicdata.service;
import java.util.List;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
import com.qcloud.pirates.data.Page;
public interface DistrictService {
    
    public boolean add(District district);

    public District get(Long id);

    public boolean delete(Long id);

    public boolean update(District district);

    public Page<District> page(DistrictQuery query, int start, int count);

    public List<District> listAll();

    public List<District> listByCity(long cityId);
}
