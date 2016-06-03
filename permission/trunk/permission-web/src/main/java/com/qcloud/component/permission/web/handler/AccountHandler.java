package com.qcloud.component.permission.web.handler;

import java.util.List;

import com.qcloud.component.permission.model.Account;
import com.qcloud.component.permission.web.vo.AccountVO;

public interface AccountHandler {

	List<AccountVO> toVOList(List<Account> list);
}
