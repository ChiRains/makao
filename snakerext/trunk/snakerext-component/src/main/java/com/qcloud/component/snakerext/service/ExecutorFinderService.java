package com.qcloud.component.snakerext.service;

import java.util.List;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;

public interface ExecutorFinderService {

    List<KeyValueVO> find(QTask t, Long clerkId, Long targetId);
}
