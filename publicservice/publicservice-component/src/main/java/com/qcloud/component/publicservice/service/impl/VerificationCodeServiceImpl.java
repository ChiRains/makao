package com.qcloud.component.publicservice.service.impl;

import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicservice.dao.VerificationCodeDao;
import com.qcloud.component.publicservice.exception.PublicServiceException;
import com.qcloud.component.publicservice.model.VerificationCode;
import com.qcloud.component.publicservice.service.VerificationCodeService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeDao verificationCodeDao;

    private byte[]              lock        = new byte[0];

    private static final int    MAX_MINUTES = 60 * 24;

    @Override
    public VerificationCode create(final String target, int minutes) {

        AssertUtil.isGreaterZero(minutes, "有效时间必须大于零." + minutes);
        if (minutes >= MAX_MINUTES) {
            throw new PublicServiceException("检验码组件有效时间不能超过一天." + minutes);
        }
        synchronized (lock) {
            String code = null;
            boolean exist = false;
            do {
                code = newCode();
                exist = verificationCodeDao.exist(target, code);
                if (!exist) {
                    break;
                }
            } while (true);
            VerificationCode verificationCode = new VerificationCode();
            verificationCode.setCode(code);
            verificationCode.setTarget(target);
            verificationCode.setCreateTime(new Date());
            verificationCode.setEffectiveMinutes(minutes);
            verificationCodeDao.add(verificationCode);
            return verificationCode;
        }
    }

    @Override
    public boolean verification(String target, String code) {

        VerificationCode verificationCode = verificationCodeDao.get(target, code);
        if (verificationCode != null) {
            return true;
        }
        return false;
    }

    // 搞出六位验证码
    private String newCode() {

        StringBuffer sb = new StringBuffer();
        for (int index = 0; index < 6; index++) {
            int number = new Random().nextInt(10);
            sb.append(number);
        }
        return sb.toString();
    }

    @Override
    public boolean remove(String target, String code) {

        return verificationCodeDao.remove(target, code);
    }
}
