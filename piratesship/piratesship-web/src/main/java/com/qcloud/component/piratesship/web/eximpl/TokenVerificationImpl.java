package com.qcloud.component.piratesship.web.eximpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.component.token.TokenClient;
import com.qcloud.pirates.web.filter.TokenVerification;

@Component
public class TokenVerificationImpl implements TokenVerification {

    @Autowired
    TokenClient tokenClient;

    @Override
    public boolean check(String token) {

        String value = tokenClient.get(token);
        return StringUtils.isNotEmpty(value);
    }

    @Override
    public boolean relet(String token) {

        return tokenClient.relet(token);
    }
}
