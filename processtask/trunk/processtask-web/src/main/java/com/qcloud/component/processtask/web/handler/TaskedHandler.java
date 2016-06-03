package com.qcloud.component.processtask.web.handler;

import java.util.List;
import com.qcloud.component.processtask.model.Tasked;
import com.qcloud.component.processtask.web.vo.AppTaskedVO;
import com.qcloud.component.processtask.web.vo.TaskedVO;
import com.qcloud.component.processtask.web.vo.admin.AdminTaskedVO;

public interface TaskedHandler {

    List<TaskedVO> toVOList(List<Tasked> list);

    TaskedVO toVO(Tasked tasked);

    List<AppTaskedVO> toVOList4App(List<Tasked> list);

    AppTaskedVO toVO4App(Tasked tasked);

    List<AdminTaskedVO> toVOList4Admin(List<Tasked> list);

    AdminTaskedVO toVO4Admin(Tasked tasked);
}
