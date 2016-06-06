package com.qcloud.component.mvprocesstask.core;

import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.model.Tasking;

public interface MvProcesstaskClient {

    Tasking getTaskingByWorkitem(String workitemId);

    Tasked getTaskedByWorkitem(String workitemId);
}