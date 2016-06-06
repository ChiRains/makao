package com.qcloud.component.snakerext.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QSuperior;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snakerext.InterfaceExecutorFinder;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class MyLeaderExecutorFinderImpl implements InterfaceExecutorFinder {

    @Autowired
    private OrganizationClient organizationClient;

    @Override
    public List<KeyValueVO> find(QTask t, Long clerkId) {

        QSuperior superior = organizationClient.getSuperior(clerkId);
        AssertUtil.assertNotNull(superior, "找不到上级." + clerkId);
        List<KeyValueVO> list = new ArrayList<KeyValueVO>();
        KeyValueVO vo = new KeyValueVO();
        vo.setKey(String.valueOf(superior.getLeaderId()));
        vo.setValue(superior.getLeaderName());
        list.add(vo);
        return list;
    }
}
