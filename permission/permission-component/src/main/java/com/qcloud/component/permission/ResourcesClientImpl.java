package com.qcloud.component.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.permission.entity.ResourcesEntity;
import com.qcloud.component.permission.model.Resources;
import com.qcloud.component.permission.service.ResourcesService;

@Service
public class ResourcesClientImpl implements ResourcesClient {

    @Autowired
    private ResourcesService resourcesService;

    @Override
    public QResources getByClassifyId(long classifyId) {

        Resources resources = resourcesService.getByClassifyId(classifyId);
        ResourcesEntity entity = new ResourcesEntity();
        entity.setId(resources.getId());
        entity.setName(resources.getName());
        entity.setCode(resources.getCode());
        entity.setUri(resources.getUri());
        entity.setClassifyId(resources.getClassifyId());
        return entity;
    }
}
