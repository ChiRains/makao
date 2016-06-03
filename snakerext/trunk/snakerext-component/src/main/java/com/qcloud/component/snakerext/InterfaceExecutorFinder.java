package com.qcloud.component.snakerext;

import java.util.List;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;

public interface InterfaceExecutorFinder {

    List<KeyValueVO> find(QTask t, Long clerkId);
}
