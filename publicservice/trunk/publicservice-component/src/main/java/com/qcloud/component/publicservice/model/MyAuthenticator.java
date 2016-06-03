package com.qcloud.component.publicservice.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class MyAuthenticator extends Authenticator{

    String userName = null; // 邮件箱用户名

    String password = null; // 邮件箱用户密码

    public MyAuthenticator() {

    }

    public MyAuthenticator(String username, String password) {

        this.userName = username;
        this.password = password;
    }

    /**
     * 验证用户
     * return PasswordAuthentication
     * */
    protected synchronized PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication(userName, password);
    }
}
