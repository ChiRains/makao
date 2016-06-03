package com.qcloud.project.macaovehicle.util;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.util.StringUtil;

public class ConfigUtils {

    public Map<String, Object> getXmlDate() {

        Xml xml = XmlFactory.get("publicservice-inside-message");
        if (xml != null) {
            List<XmlItem> list = xml.getItemList();
            for (XmlItem xmlItem : list) {
                StringUtil.nullToEmpty(xmlItem.getAttrMap().get("name")).trim();
                StringUtil.nullToEmpty(xmlItem.getAttrMap().get("code")).trim();
            }
        }
        return null;
    }
}
