package com.qcloud.component.snaker.core;

import java.util.List;
import java.util.Map;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.core.Execution;
import org.snaker.engine.entity.HistoryTask;
import org.snaker.engine.entity.Task;
import org.snaker.engine.model.CustomModel;
import org.snaker.engine.model.ProcessModel;
import org.snaker.engine.model.TaskModel;
import com.qcloud.component.snaker.ITaskClient;

public class TaskClientImpl implements ITaskClient {

    private SnakerEngine engine;

    public TaskClientImpl(SnakerEngine engine) {

        this.engine = engine;
    }

    @Override
    public Task complete(String taskId) {

        return engine.task().complete(taskId);
    }

    @Override
    public Task complete(String taskId, String operator) {

        return engine.task().complete(taskId, operator);
    }

    @Override
    public Task complete(String taskId, String operator, Map<String, Object> args) {

        return engine.task().complete(taskId, operator, args);
    }

    @Override
    public void updateTask(Task task) {
        engine.task().updateTask(task);
    }

    @Override
    public HistoryTask history(Execution execution, CustomModel model) {

        return engine.task().history(execution, model);
    }

    @Override
    public Task take(String taskId, String operator) {

        return engine.task().take(taskId, operator);
    }

    @Override
    public Task resume(String taskId, String operator) {

        return engine.task().resume(taskId, operator);
    }

    @Override
    public void addTaskActor(String taskId, String... actors) {
        engine.task().addTaskActor(taskId, actors);
    }

    @Override
    public void addTaskActor(String taskId, Integer performType, String... actors) {
        engine.task().addTaskActor(taskId, performType, actors);
    }

    @Override
    public void removeTaskActor(String taskId, String... actors) {
        engine.task().removeTaskActor(taskId, actors);
    }

    @Override
    public Task withdrawTask(String taskId, String operator) {

        return engine.task().withdrawTask(taskId, operator);
    }

    @Override
    public Task rejectTask(ProcessModel model, Task currentTask) {

        return engine.task().rejectTask(model, currentTask);
    }

    @Override
    public boolean isAllowed(Task task, String operator) {

        return engine.task().isAllowed(task, operator);
    }

    @Override
    public List<Task> createTask(TaskModel taskModel, Execution execution) {

        return engine.task().createTask(taskModel, execution);
    }

    @Override
    public List<Task> createNewTask(String taskId, int taskType, String... actors) {

        return engine.task().createNewTask(taskId, taskType, actors);
    }

    @Override
    public TaskModel getTaskModel(String taskId) {

        return engine.task().getTaskModel(taskId);
    }
}
