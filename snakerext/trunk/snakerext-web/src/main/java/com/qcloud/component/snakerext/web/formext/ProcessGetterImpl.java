package com.qcloud.component.snakerext.web.formext;

import org.snaker.engine.entity.Process;
import org.snaker.engine.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.ProcessGetter;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class ProcessGetterImpl implements ProcessGetter {

    @Autowired
    private ISnakerClient snakerClient;

    @Override
    public String getProcessName(String processId) {

        Process process = snakerClient.process().getProcessById(processId);
        AssertUtil.assertNotNull(process, "流程不存在" + processId);
        return process.getDisplayName();
    }

    @Override
    public String getWorkitemName(String workitemId) {

        Task task = snakerClient.query().getTask(workitemId);
        if (task == null) {
            return null;
        }
        return task.getDisplayName();
    }
}
