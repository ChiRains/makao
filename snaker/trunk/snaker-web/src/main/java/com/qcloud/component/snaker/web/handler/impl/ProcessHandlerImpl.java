package com.qcloud.component.snaker.web.handler.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.snaker.web.FormGetter;
import com.qcloud.component.snaker.web.handler.ProcessHandler;
import com.qcloud.component.snaker.web.vo.admin.ProcessVO;

@Component
public class ProcessHandlerImpl implements ProcessHandler {

    @Autowired
    private FormGetter formGetter;

    private Log        logger = LogFactory.getLog(getClass());

    @Override
    public List<ProcessVO> toVOList(List<Process> list) {

        // TODO 权限,启动流程的权限
        List<ProcessVO> voList = new ArrayList<ProcessVO>();
        for (Process process : list) {
            Long id = formGetter.getForm(process);
            if (id == null) {
                logger.info("流程:" + process.getDisplayName() + "[" + process.getName() + "]尚未设置表单");
                continue;
            }
            ProcessVO vo = toVO(process);
            vo.setFormId(id);
            //
            String pcUrl = formGetter.getPcApplyUrl(id);
            String mobileUrl = formGetter.getMobileApplyUrl(id);
            //
            vo.setPcApplyUrl(pcUrl);
            vo.setMobileApplyUrl(formGetter.getMobileDomain() + mobileUrl);
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public ProcessVO toVO(Process process) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("processId", process.getId());
        ProcessVO vo = new ProcessVO();
        vo.setId(process.getId());
        vo.setName(process.getName());
        vo.setDisplayName(process.getDisplayName());
        return vo;
    }
}
