package com.qcloud.component.piratesship.service.impl;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import com.qcloud.component.piratesship.service.ModuleConfigService;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class ModuleConfigServiceImpl implements ModuleConfigService {

    @Override
    public boolean enable(String module) {

        AssertUtil.assertNotEmpty(module, "模块标识不能为空");
        Xml xml = XmlFactory.get("pirates-platform-piratesship-module");
        if (xml == null) {
            return true;
        }
        List<XmlItem> list = xml.getItemList();
        if (CollectionUtils.isNotEmpty(list)) {
            for (XmlItem xmlItem : list) {
                if (module.equals(xmlItem.getAttrMap().get("module")) && !Boolean.valueOf(StringUtil.nullToEmpty(xmlItem.getText()).trim())) {
                    return false;
                }
            }
        }
        return true;
    }
}
