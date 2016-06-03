package com.qcloud.component.snakerext.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snakerext.service.ExecutorFinderService;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class ClerkExecutorFinderServiceImpl implements ExecutorFinderService {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<KeyValueVO> find(QTask t, Long clerkId, Long targetId) {

        QClerk clerk = organizationClient.getClerk(targetId);
        AssertUtil.assertNotNull(clerk, "执行人不存在.");
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        KeyValueVO vo = new KeyValueVO();
        vo.setKey(String.valueOf(clerk.getId()));
        vo.setValue(clerk.getName());
        list.add(vo);
        return list;
    }
}
