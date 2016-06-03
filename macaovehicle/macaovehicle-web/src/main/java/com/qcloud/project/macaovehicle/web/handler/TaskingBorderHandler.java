package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.web.vo.TaskingBorderVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminTaskingBorderVO;

public interface TaskingBorderHandler {

    List<TaskingBorderVO> toVOList(List<TaskingBorder> list);

    TaskingBorderVO toVO(TaskingBorder taskingBorder);

    List<AdminTaskingBorderVO> toVOList4Admin(List<TaskingBorder> list);

    AdminTaskingBorderVO toVO4Admin(TaskingBorder taskingBorder);

    TaskingBorder toEntity(Tasking tasking);
}
