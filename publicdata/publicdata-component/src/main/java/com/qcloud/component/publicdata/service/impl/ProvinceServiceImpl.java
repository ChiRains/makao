package com.qcloud.component.publicdata.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.publicdata.dao.ProvinceDao;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.pirates.data.Page;
@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceDao         provinceDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "publicdata_province";

    @Override
    public boolean add(Province province) {
        Province p = provinceDao.getByName(province.getName());
        if (p != null) {
            throw new PublicdataException("省份名称已经使用:" + p.getName());
        }
        long id = autoIdGenerator.get(ID_KEY);
        province.setId(id);
        return provinceDao.add(province);
    }

    @Override
    public Province get(Long id) {
        return provinceDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return provinceDao.delete(id);
    }

    @Override
    public boolean update(Province province) {
        Province p = provinceDao.getByName(province.getName());
        if (p != null && p.getId() != province.getId()) {
            throw new PublicdataException("省份名称已经使用:" + p.getName());
        }
        return provinceDao.update(province);
    }

    @Override
    public Page<Province> page(ProvinceQuery query, int start, int count) {
        return provinceDao.page(query, start, count);
    }

    public List<Province> listAll() {
        return provinceDao.listAll();
    }

    @Override
    public Province getByName(String name) {      
        return provinceDao.getByName(name);
    }
}
