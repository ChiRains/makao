package com.qcloud.component.piratesship.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.core.xml.Xml;
import com.qcloud.pirates.core.xml.XmlFactory;
import com.qcloud.pirates.core.xml.XmlItem;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.piratesship.dao.CallMeDao;
import com.qcloud.component.piratesship.model.CallMe;
import com.qcloud.component.piratesship.service.CallMeService;
import com.qcloud.component.piratesship.model.query.CallMeQuery;

@Service
public class CallMeServiceImpl implements CallMeService {

    @Autowired
    private CallMeDao           callMeDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "piratesship_call_me";

    @Override
    public boolean add(CallMe callMe) {

        long id = autoIdGenerator.get(ID_KEY);
        callMe.setId(id);
        return callMeDao.add(callMe);
    }

    @Override
    public CallMe get(Long id) {

        return callMeDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return callMeDao.delete(id);
    }

    @Override
    public boolean update(CallMe callMe) {

        return callMeDao.update(callMe);
    }

    @Override
    public Page<CallMe> page(CallMeQuery query, int start, int count) {

        return callMeDao.page(query, start, count);
    }

    public List<CallMe> listAll() {

        return callMeDao.listAll();
    }

    @Override
    public List<String> listCallMember() {

        Xml xml = XmlFactory.get("pirates-@-member");
        if (xml == null) {
            return new ArrayList<String>();
        } else {
            List<String> memberList = new ArrayList<String>();
            List<XmlItem> xmlItemList = xml.getItemList();
            for (XmlItem xmlItem : xmlItemList) {
                memberList.add(xmlItem.getAttrMap().get("name"));
            }
            return memberList;
        }
    }
}
