package com.qcloud.component.snakerext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.processtask.QTask;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.snakerext.InterfaceExecutorFinder;
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.service.ExecutorFinderService;
import com.qcloud.component.snakerext.service.ProcessExecutorInterfaceService;
import com.qcloud.pirates.core.context.PiratesBeanFactoryAware;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;

@Component
public class InterfaceExecutorFinderServiceImpl implements ExecutorFinderService {

    @Autowired
    private ProcessExecutorInterfaceService      processExecutorInterfaceService;

    private Map<String, InterfaceExecutorFinder> map    = new HashMap<String, InterfaceExecutorFinder>();

    private Log                                  logger = LogFactory.getLog(getClass());

    @PostConstruct
    public void init() {

        Xml xml = XmlFactory.get("qi-cloud-ProcessExecutorList");
        if (xml == null) {
            logger.info("qi-cloud-ProcessExecutorList:自定义执行人接口没有定义.");
            return;
        }
        List<XmlItem> itemList = xml.getItemList();
        for (XmlItem xmlItem : itemList) {
            String bean = xmlItem.getText();
            String key = xmlItem.getAttrMap().get("key");
            InterfaceExecutorFinder interfaceExecutorFinder = (InterfaceExecutorFinder) PiratesBeanFactoryAware.getBeanFactory().getBean(bean);
            map.put(key, interfaceExecutorFinder);
        }
    }

    @Override
    public List<KeyValueVO> find(QTask t, Long clerkId, Long targetId) {

        ProcessExecutorInterface processExecutorInterface = processExecutorInterfaceService.get(targetId);
        AssertUtil.assertNotNull(processExecutorInterface, "执行人接口信息尚未配置." + targetId);
        InterfaceExecutorFinder interfaceExecutorFinder = map.get(processExecutorInterface.getMethod());
        AssertUtil.assertNotNull(interfaceExecutorFinder, "执行人接口尚未在app.xml文件配置." + processExecutorInterface.getMethod());
        return interfaceExecutorFinder.find(t, clerkId);
    }
}
