package com.qcloud.component.snakerext.web.form;
import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.snakerext.model.TaskFormAccess;
public class TaskFormAccessForm {
    private String          processId;
    private String          taskName;
    /**
     * 主表单id_活动任务名称_元素id
     */
    private String[]        element;
    /**
     * 主表单id_子表单id_活动任务名称
     */
    private String[]        childrenForm;
    // 主表单
    public static final int MAINFORM_TYPE  = 0;
    // 子表单
    public static final int CHILDFORM_TYPE = 1;
    // 是否可写
    public static final int ISREAD         = 0;
    public static final int ISWRITE        = 1;

    public String[] getElement() {
        return element;
    }

    public void setElement(String[] element) {
        this.element = element;
    }

    public String[] getChildrenForm() {
        return childrenForm;
    }

    public void setChildrenForm(String[] childrenForm) {
        this.childrenForm = childrenForm;
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

    public List<TaskFormAccess> listTaskFormAccess() {
        List<TaskFormAccess> list = new ArrayList<TaskFormAccess>();
        if (element != null && element.length > 0) {
            for (String elementStr : element) {
                TaskFormAccess tf = new TaskFormAccess();
                String[] obj = elementStr.split("_");
                Long mainFormId = Long.valueOf(obj[0]);
                String taskName = obj[1];
                Long elementId = Long.valueOf(obj[2]);
                tf.setProcessId(processId);
                tf.setTaskName(taskName);
                tf.setFormId(mainFormId);
                tf.setElementId(elementId);
                tf.setFormType(MAINFORM_TYPE);
                tf.setStatus(ISWRITE);
                list.add(tf);
            }
        }
        if (childrenForm != null && childrenForm.length > 0) {
            for (String childrenFormStr : childrenForm) {
                TaskFormAccess tf = new TaskFormAccess();
                String[] obj = childrenFormStr.split("_");
                Long mainFormId = Long.valueOf(obj[0]);
                Long childFormId = Long.valueOf(obj[1]);
                String taskName = obj[2];
                tf.setProcessId(processId);
                tf.setTaskName(taskName);
                tf.setFormId(mainFormId);
                tf.setElementId(childFormId);
                tf.setFormType(CHILDFORM_TYPE);
                tf.setStatus(ISWRITE);
                list.add(tf);
            }
        }
        return list;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
