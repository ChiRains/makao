package com.qcloud.component.admin.dao.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qcloud.component.admin.dao.AdminDao;
import com.qcloud.component.admin.model.Admin;
import com.qcloud.pirates.data.Page;


@Repository
public class AdminDaoCacheImpl implements AdminDao {

	@Autowired
	private AdminDao adminDaoMysqlImpl;

	@Override
	public boolean add(Admin bean) {
		return adminDaoMysqlImpl.add(bean);
	}

	@Override
	public Page<Admin> list(int start, int count) {
		return adminDaoMysqlImpl.list(start, count);
	}

	@Override
	public boolean delete(long key) {
		return adminDaoMysqlImpl.delete(key);
	}

	@Override
	public boolean update(Admin bean) {
		return adminDaoMysqlImpl.update(bean);
	}

	@Override
	public Admin get(long key) {
		return adminDaoMysqlImpl.get(key);
	}

	@Override
	public Admin getByAccount(String code) {		
		return adminDaoMysqlImpl.getByAccount(code);
	}
}
