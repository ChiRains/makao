package com.qcloud.component.permission;

import java.util.List;
import com.qcloud.component.permission.model.Account;

public interface AccountClient {

    boolean addAccount(Account account);

    Account getAccount(String code);

    List<Account> listByRoleId(Long roleId);
}
