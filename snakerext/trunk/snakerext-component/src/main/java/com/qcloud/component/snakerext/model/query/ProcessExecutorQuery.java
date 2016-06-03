package com.qcloud.component.snakerext.model.query;
import com.qcloud.component.snakerext.model.key.TypeEnum.ExecutorType;
public class ProcessExecutorQuery {
    private String  processId;
    private String  taskName;
    private String  name;
    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getType() {
        if (type == null) {
            type = ExecutorType.USER.getKey();
        }
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
