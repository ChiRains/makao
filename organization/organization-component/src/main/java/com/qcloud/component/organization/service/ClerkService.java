package com.qcloud.component.organization.service;

import java.util.List;
import java.util.Map;
import com.qcloud.pirates.data.Page;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.model.query.ClerkQuery;

public interface ClerkService {

    public boolean add(Clerk clerk);

    public Clerk get(Long id);

    public boolean delete(Long id);

    public boolean update(Clerk clerk);

    public Page<Clerk> page(ClerkQuery query, int start, int count);

    public List<Clerk> listAll();

    List<Clerk> listByName(String name);

    // public String getEncodeDefaultPwd();
    // public String getEncodePsw(String psw);
    public boolean changePwd(Long id, String pwd);

    public Clerk getByAccount(String account);

    public String getClerkPermissionAccountCode(String account);

    public List<Clerk> listAll(Map<String, Object> map);

    public boolean isClerk(String account, String password);

    public boolean editEnable(Long id);

    String isClerk(Long id, String password);

    public Clerk getByMobile(String mobile);

    public Clerk getByIdCard(String idCard);

    public Clerk getByJobEmail(String email);

    public boolean updateClerkInfo(Clerk oldClerk, Clerk clerk);

    public boolean updateJobEmail(Clerk oldClerk, String jobEmail);
}
