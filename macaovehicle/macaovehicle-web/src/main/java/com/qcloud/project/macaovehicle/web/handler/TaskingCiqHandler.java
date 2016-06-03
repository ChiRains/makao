package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.web.vo.TaskingCiqVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingCiqVO;

public interface TaskingCiqHandler {

    List<TaskingCiqVO> toVOList(List<TaskingCiq> list);

    TaskingCiqVO toVO(TaskingCiq taskingCiq);

    List<AdminTaskingCiqVO> toVOList4Admin(List<TaskingCiq> list);

    AdminTaskingCiqVO toVO4Admin(TaskingCiq taskingCiq);

    TaskingCiq toEntity(Tasking tasking);
}
