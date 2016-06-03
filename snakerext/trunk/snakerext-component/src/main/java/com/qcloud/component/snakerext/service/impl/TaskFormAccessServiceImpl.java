package com.qcloud.component.snakerext.service.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.form.ProcessActivityFormElementMappingExtend.ActivityElementMapping;
import com.qcloud.component.form.ProcessActivityFormElementMappingExtend.ControlType;
import com.qcloud.component.form.ProcessActivityFormElementMappingExtend.IDType;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.snakerext.dao.TaskFormAccessDao;
import com.qcloud.component.snakerext.model.TaskFormAccess;
import com.qcloud.component.snakerext.service.TaskFormAccessService;
import com.qcloud.component.snakerext.model.query.TaskFormAccessQuery;
@Service
public class TaskFormAccessServiceImpl implements TaskFormAccessService {
    @Autowired
    private TaskFormAccessDao   taskFormAccessDao;
    @Autowired
    private AutoIdGenerator     autoIdGenerator;
    private static final String ID_KEY = "snakerext_task_form_access";

    @Override
    public boolean add(TaskFormAccess taskFormAccess) {
        long id = autoIdGenerator.get(ID_KEY);
        taskFormAccess.setId(id);
        return taskFormAccessDao.add(taskFormAccess);
    }

    @Override
    public TaskFormAccess get(Long id) {
        return taskFormAccessDao.get(id);
    }

    @Override
    public boolean delete(Long id) {
        return taskFormAccessDao.delete(id);
    }

    @Override
    public boolean update(TaskFormAccess taskFormAccess) {
        return taskFormAccessDao.update(taskFormAccess);
    }

    @Override
    public Page<TaskFormAccess> page(TaskFormAccessQuery query, int start, int count) {
        return taskFormAccessDao.page(query, start, count);
    }

    public List<TaskFormAccess> listAll() {
        return taskFormAccessDao.listAll();
    }

    @Override
    public boolean delete(Map<String, Object> map) {
        return taskFormAccessDao.delete(map);
    }

    @Override
    public Map<Long, Integer> mapAllElementStatus(TaskFormAccessQuery query) {
        Map<Long, Integer> mapVo = new HashMap<Long, Integer>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", query.getProcessId());
        map.put("taskName", query.getTaskName());
        List<TaskFormAccess> list = taskFormAccessDao.listAll(map);
        for (TaskFormAccess taskFormAccess : list) {
            mapVo.put(taskFormAccess.getElementId(), taskFormAccess.getStatus());
        }
        return mapVo;
    }

    @Override
    public List<ActivityElementMapping> listAllActivityElementMapping(TaskFormAccessQuery query) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("processId", query.getProcessId());
        map.put("taskName", query.getTaskName());
        map.put("formId", query.getFormId());
        List<ActivityElementMapping> voList = new ArrayList<ActivityElementMapping>();
        for (TaskFormAccess taskFormAccess : taskFormAccessDao.listAll(map)) {
            IDType idType = null;
            ControlType controlType = null;
            if (taskFormAccess.getFormType() == TaskFormAccessQuery.MAINFORM_TYPE) {
                idType = IDType.ELEMENT;
            }
            if (taskFormAccess.getFormType() == TaskFormAccessQuery.CHILDFORM_TYPE) {
                idType = IDType.CHILDFORM;
            }
            if (taskFormAccess.getStatus() == TaskFormAccessQuery.READ) {
                controlType = ControlType.READ;
            }
            if (taskFormAccess.getStatus() == TaskFormAccessQuery.WRITE) {
                controlType = ControlType.WRITE;
            }
            ActivityElementMapping activityElementMapping = new ActivityElementMapping();
            activityElementMapping.setElementId(taskFormAccess.getElementId());
            activityElementMapping.setIdType(idType);
            activityElementMapping.setControlType(controlType);
            voList.add(activityElementMapping);
        }
        return voList;
    }
}
