package com.qcloud.component.snakerext.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snakerext.service.ExecutorFinderService;

@Component
public class ProcessRoleExecutorFinderServiceImpl implements ExecutorFinderService {

    @Override
    public List<KeyValueVO> find(QTask t, Long clerkId, Long targetId) {

        // TODO
        return new ArrayList<KeyValueVO>();
    }
}
