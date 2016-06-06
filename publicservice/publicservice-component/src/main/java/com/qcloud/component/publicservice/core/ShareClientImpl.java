package com.qcloud.component.publicservice.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.qcloud.component.publicservice.ShareClient;

@Component
public class ShareClientImpl implements ShareClient {

    @Value("${pirates.share.domain}")
    private String domain;

    @Override
    public String getShareDomain() {
        
        return domain;
    }
}
