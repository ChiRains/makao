package com.qcloud.component.publicservice.model;

import java.util.Date;

/**
 * 校验码
 * 
 * @author Zoro 
 */
public class VerificationCode {

    /**
     * 校验码
     */
    private String code;

    /**
     * 校验码发送目标
     */
    private String target;

    /**
     * 生成时间
     */
    private Date   createTime;

    /**
     * 有效时间
     */
    private int    effectiveMinutes;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    public int getEffectiveMinutes() {

        return effectiveMinutes;
    }

    public void setEffectiveMinutes(int effectiveMinutes) {

        this.effectiveMinutes = effectiveMinutes;
    }

    public String getTarget() {

        return target;
    }

    public void setTarget(String target) {

        this.target = target;
    }
}
