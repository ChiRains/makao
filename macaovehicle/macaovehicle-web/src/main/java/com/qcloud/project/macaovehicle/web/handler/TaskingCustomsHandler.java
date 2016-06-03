package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.web.vo.TaskingCustomsVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCustomsVO;

public interface TaskingCustomsHandler {

    List<TaskingCustomsVO> toVOList(List<TaskingCustoms> list);

    TaskingCustomsVO toVO(TaskingCustoms taskingCustoms);

    List<AdminTaskingCustomsVO> toVOList4Admin(List<TaskingCustoms> list);

    AdminTaskingCustomsVO toVO4Admin(TaskingCustoms taskingCustoms);

    TaskingCustoms toEntity(Tasking tasking);
}
