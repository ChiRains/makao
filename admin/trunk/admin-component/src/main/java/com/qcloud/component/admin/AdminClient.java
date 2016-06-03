package com.qcloud.component.admin;

import java.util.List;

public interface AdminClient {

    String ADMIN_LOGIN_PARAMETER_KEY       = "admin-login-admin";

    String ADMIN_TOKEN_LOGIN_PARAMETER_KEY = "admin-login-token";

    //
    QAdmin getAdminById(Long id);

    QAdmin getAdminByAccount(String account);

    List<QAdmin> listAll();
}
