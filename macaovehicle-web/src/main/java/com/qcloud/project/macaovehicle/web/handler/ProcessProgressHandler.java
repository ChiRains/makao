package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.web.vo.ProcessProgressVO;

public interface ProcessProgressHandler {

    List<ProcessProgressVO> toVOList(List<ProcessProgress> list);

    ProcessProgressVO toVO(ProcessProgress processProgress);

    List<ProcessProgressVO> toApproveInfo(List<ProcessProgress> list);

    List<ProcessProgressVO> toPilotInfo(List<ProcessProgress> list);

    List<ProcessProgressVO> toRenewalInfo(List<ProcessProgress> list);
}
