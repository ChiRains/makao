package com.qcloud.component.snaker.web.handler;

import java.util.List;
import org.snaker.engine.entity.Process;
import com.qcloud.component.snaker.web.vo.admin.ProcessVO;

public interface ProcessHandler {

    List<ProcessVO> toVOList(List<Process> list);

    ProcessVO toVO(Process process);
}
