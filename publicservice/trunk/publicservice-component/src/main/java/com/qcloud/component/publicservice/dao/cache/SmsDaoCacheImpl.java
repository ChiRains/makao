package com.qcloud.component.publicservice.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qcloud.component.publicservice.dao.SmsDao;
import com.qcloud.component.publicservice.model.SmsResult;
import com.qcloud.component.publicservice.model.Ums86Config;

@Repository
public class SmsDaoCacheImpl implements SmsDao {

    @Autowired
    private SmsDao smsDaoOutsideImpl;

    @Override
    public SmsResult[] send(Ums86Config config, String content, String... receivers) {

        // 如果有多家发送短信实现,可以在这里选择
        return smsDaoOutsideImpl.send(config, content, receivers);
    }
}
