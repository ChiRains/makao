package com.qcloud.component.snaker;

import java.util.List;
import java.util.Map;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.model.NodeModel;

public interface ISnakerClient extends SnakerEngine {

    IProcessClient process();

    IQueryClient query();

    IOrderClient order();

    ITaskClient task();

    IManagerClient manager();

    List<NodeModel> nextTaskModels(String taskId, Map<String, Object> args);
}
