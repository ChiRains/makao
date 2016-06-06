package com.qcloud.component.snaker.core;

import java.util.List;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.HistoryOrder;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Task;
import org.snaker.engine.entity.WorkItem;
import com.qcloud.component.snaker.IQueryClient;

public class QueryClientImpl implements IQueryClient {

    private SnakerEngine engine;

    public QueryClientImpl(SnakerEngine engine) {

        this.engine = engine;
    }

    @Override
    public Order getOrder(String orderId) {

        return engine.query().getOrder(orderId);
    }

    @Override
    public HistoryOrder getHistOrder(String orderId) {

        return engine.query().getHistOrder(orderId);
    }

    @Override
    public Task getTask(String taskId) {

        return engine.query().getTask(taskId);
    }

    @Override
    public HistoryTask getHistTask(String taskId) {

        return engine.query().getHistTask(taskId);
    }

    @Override
    public String[] getTaskActorsByTaskId(String taskId) {

        return engine.query().getTaskActorsByTaskId(taskId);
    }

    @Override
    public String[] getHistoryTaskActorsByTaskId(String taskId) {

        return engine.query().getHistoryTaskActorsByTaskId(taskId);
    }

    @Override
    public List<Task> getActiveTasks(QueryFilter filter) {

        return engine.query().getActiveTasks(filter);
    }

    @Override
    public List<Task> getActiveTasks(Page<Task> page, QueryFilter filter) {

        return engine.query().getActiveTasks(filter);
    }

    @Override
    public List<Order> getActiveOrders(QueryFilter filter) {

        return engine.query().getActiveOrders(filter);
    }

    @Override
    public List<Order> getActiveOrders(Page<Order> page, QueryFilter filter) {

        return engine.query().getActiveOrders(page, filter);
    }

    @Override
    public List<HistoryOrder> getHistoryOrders(QueryFilter filter) {

        return engine.query().getHistoryOrders(filter);
    }

    @Override
    public List<HistoryOrder> getHistoryOrders(Page<HistoryOrder> page, QueryFilter filter) {

        return engine.query().getHistoryOrders(page, filter);
    }

    @Override
    public List<HistoryTask> getHistoryTasks(QueryFilter filter) {

        return engine.query().getHistoryTasks(filter);
    }

    @Override
    public List<HistoryTask> getHistoryTasks(Page<HistoryTask> page, QueryFilter filter) {

        return engine.query().getHistoryTasks(page, filter);
    }

    @Override
    public List<WorkItem> getWorkItems(Page<WorkItem> page, QueryFilter filter) {

        return engine.query().getWorkItems(page, filter);
    }

    @Override
    public List<HistoryOrder> getCCWorks(Page<HistoryOrder> page, QueryFilter filter) {

        return engine.query().getCCWorks(page, filter);
    }

    @Override
    public List<WorkItem> getHistoryWorkItems(Page<WorkItem> page, QueryFilter filter) {

        return engine.query().getHistoryWorkItems(page, filter);
    }

    @Override
    public <T> T nativeQueryObject(Class<T> T, String sql, Object... args) {

        return engine.query().nativeQueryObject(T, sql, args);
    }

    @Override
    public <T> List<T> nativeQueryList(Class<T> T, String sql, Object... args) {

        return engine.query().nativeQueryList(T, sql, args);
    }

    @Override
    public <T> List<T> nativeQueryList(Page<T> page, Class<T> T, String sql, Object... args) {

        return engine.query().nativeQueryList(page, T, sql, args);
    }
}
