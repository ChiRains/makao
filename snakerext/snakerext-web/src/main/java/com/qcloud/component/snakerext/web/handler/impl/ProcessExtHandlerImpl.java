package com.qcloud.component.snakerext.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.model.FormDef;
import com.qcloud.component.snakerext.model.ProcessForm;
import com.qcloud.component.snakerext.model.query.ProcessFormQuery;
import com.qcloud.component.snakerext.service.ProcessFormService;
import com.qcloud.component.snakerext.web.handler.ProcessExtHandler;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExtVO;
import com.qcloud.pirates.core.reflect.BeanUtils;

@Component
public class ProcessExtHandlerImpl implements ProcessExtHandler {

    @Autowired
    private ProcessFormService processFormService;

    @Autowired
    private FormClient         formClient;

    @Override
    public List<AdminProcessExtVO> toVOList4Admin(List<Process> list) {

        List<AdminProcessExtVO> voList = new ArrayList<AdminProcessExtVO>();
        for (Process process : list) {
            AdminProcessExtVO vo = new AdminProcessExtVO();
            vo.setId(process.getId());
            vo.setName(process.getName());
            vo.setDisplayName(process.getDisplayName());
            vo.setVersion(process.getVersion());
            vo.setCreateTime(process.getCreateTime());
            vo.setCreator(process.getCreator());
            vo.setState(process.getState());
            ProcessFormQuery query = new ProcessFormQuery();
            query.setProcessId(process.getId());
            List<ProcessForm> processForms = processFormService.list(BeanUtils.transBean2Map(query));
            if (processForms.size() > 0) {
                FormDef formDef = formClient.getFormDef(processForms.get(0).getMainFormId());
                vo.setFormDef(formDef);
            }
            voList.add(vo);
        }
        return voList;
    }
}
