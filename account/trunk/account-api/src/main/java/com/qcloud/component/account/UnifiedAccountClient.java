package com.qcloud.component.account;

public interface UnifiedAccountClient {

    String encodePwd(String pwd);

    boolean exist(String account);

    String reg(String code, String account, String name, String pwd);

    boolean regByOtherAccount(String code, String account, String otherAccount, String group);

    boolean updatePwd(String account, String pwd);

    boolean updateName(String account, String name);

    boolean updateAccount(String account, String newAccount);

    boolean canEntrySystem(String code, String account, String group, String pwd);

    QAccount getByAccount(String account);
}