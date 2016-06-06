package com.qcloud.component.snaker.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.SnakerException;
import org.snaker.engine.cfg.Configuration;
import org.snaker.engine.core.Execution;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.snaker.engine.model.EndModel;
import org.snaker.engine.model.NodeModel;
import org.snaker.engine.model.ProcessModel;
import org.snaker.engine.model.TaskModel;
import org.springframework.stereotype.Service;
import com.qcloud.component.snaker.IManagerClient;
import com.qcloud.component.snaker.IOrderClient;
import com.qcloud.component.snaker.IProcessClient;
import com.qcloud.component.snaker.IQueryClient;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snaker.ITaskClient;

@Service
public class SnakerClientImpl implements ISnakerClient {

    @Resource(name = "snakerEngine")
    private SnakerEngine engine = null;

    @Override
    public SnakerEngine configure(Configuration config) {

        return engine;
    }

    @Override
    public IProcessClient process() {

        return new ProcessClientImpl(engine);
    }

    @Override
    public IQueryClient query() {

        return new QueryClientImpl(engine);
    }

    @Override
    public IOrderClient order() {

        return new OrderClientImpl(engine);
    }

    @Override
    public ITaskClient task() {

        return new TaskClientImpl(engine);
    }

    @Override
    public IManagerClient manager() {

        return new ManagerClientImpl(engine);
    }

    @Override
    public Order startInstanceById(String id) {

        return engine.startInstanceById(id);
    }

    @Override
    public Order startInstanceById(String id, String operator) {

        return engine.startInstanceById(id, operator);
    }

    @Override
    public Order startInstanceById(String id, String operator, Map<String, Object> args) {

        return engine.startInstanceById(id, operator, args);
    }

    @Override
    public Order startInstanceByName(String name) {

        return engine.startInstanceByName(name);
    }

    @Override
    public Order startInstanceByName(String name, Integer version) {

        return engine.startInstanceByName(name, version);
    }

    @Override
    public Order startInstanceByName(String name, Integer version, String operator) {

        return engine.startInstanceByName(name, version, operator);
    }

    @Override
    public Order startInstanceByName(String name, Integer version, String operator, Map<String, Object> args) {

        return engine.startInstanceByName(name, version, operator, args);
    }

    @Override
    public Order startInstanceByExecution(Execution execution) {

        return engine.startInstanceByExecution(execution);
    }

    @Override
    public List<Task> executeTask(String taskId) {

        return engine.executeTask(taskId);
    }

    @Override
    public List<Task> executeTask(String taskId, String operator) {

        return engine.executeTask(taskId, operator);
    }

    @Override
    public List<Task> executeTask(String taskId, String operator, Map<String, Object> args) {

        return engine.executeTask(taskId, operator, args);
    }

    @Override
    public List<Task> executeAndJumpTask(String taskId, String operator, Map<String, Object> args, String nodeName) {

        return engine.executeAndJumpTask(taskId, operator, args, nodeName);
    }

    @Override
    public List<Task> createFreeTask(String orderId, String operator, Map<String, Object> args, TaskModel model) {

        return engine.createFreeTask(orderId, operator, args, model);
    }

    @Override
    public List<NodeModel> nextTaskModels(String taskId, Map<String, Object> args) {

        Task task = query().getTask(taskId);
        Order order = query().getOrder(task.getOrderId());
        Map<String, Object> orderMaps = order.getVariableMap();
        if (orderMaps != null) {
            for (Map.Entry<String, Object> entry : orderMaps.entrySet()) {
                if (args.containsKey(entry.getKey())) {
                    continue;
                }
                args.put(entry.getKey(), entry.getValue());
            }
        }
        Process process = process().getProcessById(order.getProcessId());
        ProcessModel model = process.getModel();
        NodeModel nodeModel = model.getNode(task.getTaskName());
        Execution execution = new Execution(this, process, order, args);
        execution.setTask(task);
        List<NodeModel> list = nodeModel.nextNodes(execution);
        List<NodeModel> tasks = new ArrayList<NodeModel>();
        for (NodeModel node : list) {
            if (node instanceof TaskModel || node instanceof EndModel) {
                tasks.add(node);
            } else {
                throw new SnakerException("流程计算出错,获取下一步任务失败." + node.getClass());
            }
        }
        return tasks;
    }
}
