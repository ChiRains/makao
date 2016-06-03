package com.qcloud.component.publicdata.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.data.api.ISimpleDao;
		
public interface DistrictDao extends ISimpleDao<District, Long> {

	public boolean add(District district);	
	
	public District get(Long id);

	public boolean delete(Long id);
	
	public boolean update(District district);
	
	public List<District> list(List<Long> idList);
	
	public Map<Long, District> map(Set<Long> idSet);
	
	public Page<District> page(DistrictQuery query, int start, int size);

	public List<District> listAll();

    public District getByName(String name);
    
    List<District> listByCity(long cityId);
}
