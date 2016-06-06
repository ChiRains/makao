package com.qcloud.component.permission.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.permission.model.Resources;

public interface ResourcesService {

    public boolean add(Resources resources);

    public Resources get(Long id);

    public boolean delete(Long id);

    public boolean update(Resources resources);

    public Page<Resources> page(int start, int count);

    List<Resources> list(List<Long> idList);

    public Resources getByClassifyId(long classifyId);
}
