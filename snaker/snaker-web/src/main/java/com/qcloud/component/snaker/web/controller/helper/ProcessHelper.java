package com.qcloud.component.snaker.web.controller.helper;

import java.util.List;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.snaker.ISnakerClient;

@Component
public class ProcessHelper {

    @Autowired
    private ISnakerClient snakerClient;

    public Process getProcess(String processType) {

        Page<Process> page = new Page<Process>();
        QueryFilter filter = new QueryFilter();
        filter.setProcessType(processType);
        List<Process> list = snakerClient.process().getProcesss(page, filter);
        int version = 0;
        Process p = null;
        for (Process process : list) {
            if (process.getVersion() > version) {
                version = process.getVersion();
                p = process;
            }
        }
        return p;
    }
}
