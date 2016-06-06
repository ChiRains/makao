package com.qcloud.component.mvprocesstask.web.handler;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasking;
import com.qcloud.component.mvprocesstask.web.vo.TaskingVO;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskingVO;

public interface TaskingHandler {

	List<TaskingVO> toVOList(List<Tasking> list);

	TaskingVO toVO(Tasking tasking);

	List<AdminTaskingVO> toVOList4Admin(List<Tasking> list);

	AdminTaskingVO toVO4Admin(Tasking tasking);
}
