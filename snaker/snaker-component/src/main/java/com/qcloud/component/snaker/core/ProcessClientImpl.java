package com.qcloud.component.snaker.core;

import java.io.InputStream;
import java.util.List;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import com.qcloud.component.snaker.IProcessClient;

public class ProcessClientImpl implements IProcessClient {

    private SnakerEngine engine;

    public ProcessClientImpl(SnakerEngine engine) {

        this.engine = engine;
    }

    @Override
    public void check(Process process, String idOrName) {

        engine.process().check(process, idOrName);
    }

    @Override
    public void saveProcess(Process process) {

        engine.process().saveProcess(process);
    }

    @Override
    public void updateType(String id, String type) {

        engine.process().updateType(id, type);
    }

    @Override
    public Process getProcessById(String id) {

        return engine.process().getProcessById(id);
    }

    @Override
    public Process getProcessByName(String name) {

        return engine.process().getProcessByName(name);
    }

    @Override
    public Process getProcessByVersion(String name, Integer version) {

        return engine.process().getProcessByVersion(name, version);
    }

    @Override
    public List<Process> getProcesss(QueryFilter filter) {

        return engine.process().getProcesss(filter);
    }

    @Override
    public List<Process> getProcesss(Page<Process> page, QueryFilter filter) {

        return engine.process().getProcesss(page, filter);
    }

    @Override
    public String deploy(InputStream input) {

        return engine.process().deploy(input);
    }

    @Override
    public String deploy(InputStream input, String creator, String type) {

        return engine.process().deploy(input, creator, type);
    }

    @Override
    public void redeploy(String id, InputStream input) {

        engine.process().redeploy(id, input);
    }

    @Override
    public void undeploy(String id) {

        engine.process().undeploy(id);
    }

    @Override
    public void cascadeRemove(String id) {

        engine.process().cascadeRemove(id);
    }
}
