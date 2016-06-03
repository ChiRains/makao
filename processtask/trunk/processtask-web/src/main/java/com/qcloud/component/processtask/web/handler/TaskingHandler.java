package com.qcloud.component.processtask.web.handler;

import java.util.List;
import com.qcloud.component.processtask.model.Tasking;
import com.qcloud.component.processtask.web.vo.AppTaskingVO;
import com.qcloud.component.processtask.web.vo.TaskingVO;
import com.qcloud.component.processtask.web.vo.admin.AdminTaskingVO;

public interface TaskingHandler {

    List<TaskingVO> toVOList(List<Tasking> list);

    TaskingVO toVO(Tasking tasking);

    List<AppTaskingVO> toVOList4App(List<Tasking> list);

    AppTaskingVO toVO4App(Tasking tasking);

    List<AdminTaskingVO> toVOList4Admin(List<Tasking> list);

    AdminTaskingVO toVO4Admin(Tasking tasking);
}
