package com.qcloud.component.snakerext.extend;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.ProcessActivityFormElementMappingExtend;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
import com.qcloud.component.snakerext.service.TaskFormAccessService;
@Component
public class ProcessActivityFormElementMappingExtendImpl implements ProcessActivityFormElementMappingExtend {
    @Autowired
    private TaskFormAccessService taskFormAccessService;

    public List<ActivityElementMapping> listMapping(String processId, String activityName, Long formId) {
        TaskFormAccessQuery query = new TaskFormAccessQuery();
        query.setProcessId(processId);
        query.setTaskName(activityName);
        query.setFormId(formId);
        List<ActivityElementMapping> list = taskFormAccessService.listAllActivityElementMapping(query);
        return list;
    }
}
