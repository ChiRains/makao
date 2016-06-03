package com.qcloud.component.form.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.form.dao.ElementFieldMappingDao;
import com.qcloud.component.form.model.ElementDef;
import com.qcloud.component.form.model.ElementFieldMapping;
import com.qcloud.component.form.model.query.ElementFieldMappingQuery;
import com.qcloud.component.form.service.ElementDefService;
import com.qcloud.component.form.service.ElementFieldMappingService;
import com.qcloud.pirates.data.Page;

@Service
public class ElementFieldMappingServiceImpl implements ElementFieldMappingService {

    @Autowired
    private ElementFieldMappingDao elementFieldMappingDao;

    @Autowired
    private AutoIdGenerator        autoIdGenerator;

    private static final String    ID_KEY = "form_element_field_mapping";

    @Autowired
    private ElementDefService      elementDefService;

    @Override
    public boolean add(ElementFieldMapping elementFieldMapping) {

        long id = autoIdGenerator.get(ID_KEY);
        elementFieldMapping.setId(id);
        return elementFieldMappingDao.add(elementFieldMapping);
    }

    @Override
    public ElementFieldMapping get(Long id) {

        return elementFieldMappingDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return elementFieldMappingDao.delete(id);
    }

    @Override
    public boolean update(ElementFieldMapping elementFieldMapping) {

        return elementFieldMappingDao.update(elementFieldMapping);
    }

    @Override
    public Page<ElementFieldMapping> page(ElementFieldMappingQuery query, int start, int count) {

        return elementFieldMappingDao.page(query, start, count);
    }

    public List<ElementFieldMapping> listAll() {

        return elementFieldMappingDao.listAll();
    }

    @Override
    public List<ElementFieldMapping> listAll(Map<String, Object> map) {

        return elementFieldMappingDao.listAll(map);
    }

    @Override
    public boolean delete(Map<String, Object> map) {

        return elementFieldMappingDao.delete(map);
    }

    @Override
    public List<ElementFieldMapping> listByForm(Long formId) {

        List<ElementDef> eleList = elementDefService.listByForm(formId);
        List<ElementFieldMapping> list = new ArrayList<ElementFieldMapping>();
        for (ElementDef elementDef : eleList) {
            ElementFieldMapping mapping = elementFieldMappingDao.getByElement(elementDef.getId());
            if (mapping != null) {
                list.add(mapping);
            }
        }
        return list;
    }
}
