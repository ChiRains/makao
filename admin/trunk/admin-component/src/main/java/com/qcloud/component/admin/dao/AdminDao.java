package com.qcloud.component.admin.dao;

import com.qcloud.component.admin.model.Admin;
import com.qcloud.pirates.data.Page;

public interface AdminDao {

	Page<Admin> list(int start, int count);

	boolean add(Admin bean);

	boolean delete(long key);

	boolean update(Admin bean);

	Admin get(long key);

	Admin getByAccount(String code);
}
