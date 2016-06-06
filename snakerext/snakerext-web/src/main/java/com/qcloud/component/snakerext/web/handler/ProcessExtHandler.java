package com.qcloud.component.snakerext.web.handler;

import java.util.List;
import org.snaker.engine.entity.Process;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExtVO;

public interface ProcessExtHandler {

    List<AdminProcessExtVO> toVOList4Admin(List<Process> list);
}
