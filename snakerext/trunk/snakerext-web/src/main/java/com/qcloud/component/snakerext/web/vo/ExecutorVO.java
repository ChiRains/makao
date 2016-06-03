package com.qcloud.component.snakerext.web.vo;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.publicdata.KeyValueVO;

public class ExecutorVO {

    private String           taskName;

    private String           executorKey;

    private List<KeyValueVO> executorList = new ArrayList<KeyValueVO>();

    public String getTaskName() {

        return taskName;
    }

    public void setTaskName(String taskName) {

        this.taskName = taskName;
    }

    public List<KeyValueVO> getExecutorList() {

        return executorList;
    }

    public void setExecutorList(List<KeyValueVO> executorList) {

        this.executorList = executorList;
    }

    public String getExecutorKey() {

        return executorKey;
    }

    public void setExecutorKey(String executorKey) {

        this.executorKey = executorKey;
    }
}
