package com.qcloud.component.processtask;

import java.util.List;

public interface ProcesstaskClient {

    Long doTask(Long taskId, Long formHistId, boolean pass, Long operatorClerkId);

    QTask getTask(Long id);

    QTask getTaskByWorkitem(String workitemId);

    List<QTask> listTaskedByProcessInst(String processInstId);

    boolean updateTaskedProcessStateByProcessInst(String processInstId, boolean pass);
}