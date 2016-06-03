package com.qcloud.component.mvprocesstask.web.handler;

import java.util.List;
import com.qcloud.component.mvprocesstask.model.Tasked;
import com.qcloud.component.mvprocesstask.web.vo.TaskedVO;
import com.qcloud.component.mvprocesstask.web.vo.admin.AdminTaskedVO;

public interface TaskedHandler {

	List<TaskedVO> toVOList(List<Tasked> list);

	TaskedVO toVO(Tasked tasked);

	List<AdminTaskedVO> toVOList4Admin(List<Tasked> list);

	AdminTaskedVO toVO4Admin(Tasked tasked);
}
