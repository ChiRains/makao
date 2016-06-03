package com.qcloud.component.snaker.core;

import java.util.List;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Surrogate;
import com.qcloud.component.snaker.IManagerClient;

public class ManagerClientImpl implements IManagerClient {

    private SnakerEngine engine;

    public ManagerClientImpl(SnakerEngine engine) {

        this.engine = engine;
    }

    @Override
    public void saveOrUpdate(Surrogate surrogate) {

        engine.manager().saveOrUpdate(surrogate);
    }

    @Override
    public void deleteSurrogate(String id) {
        engine.manager().deleteSurrogate(id);
    }

    @Override
    public Surrogate getSurrogate(String id) {

        return engine.manager().getSurrogate(id);
    }

    @Override
    public List<Surrogate> getSurrogate(QueryFilter filter) {

        return engine.manager().getSurrogate(filter);
    }

    @Override
    public String getSurrogate(String operator, String processName) {

        return engine.manager().getSurrogate(operator, processName);
    }

    @Override
    public List<Surrogate> getSurrogate(Page<Surrogate> page, QueryFilter filter) {

        return engine.manager().getSurrogate(page, filter);
    }
}
