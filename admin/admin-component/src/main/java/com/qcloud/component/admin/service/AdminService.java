package com.qcloud.component.admin.service;

import com.qcloud.component.admin.model.Admin;
import com.qcloud.pirates.data.Page;

public interface AdminService {

	Page<Admin> list(int start, int count);

	boolean add(Admin bean);

	boolean delete(long key);

	boolean update(Admin bean);

	Admin get(long key);

	/**
	 * 是否超级管理员
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	boolean isSuperman(String account, String password);

	/**
	 * 是否管理员
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	boolean isAdmin(String account, String password);

	/**
	 * 是否业务管理员
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	boolean isBussnessAdmin(String account, String password);

	Admin getByAccount(String code);

	String getEncodeDefaultPsw();

	String getEncodePsw(String psw);

	String getAdminPermissionAccountCode(Admin admin);

	String getAdminPermissionAccountCode(String username);

	String getSupermanPermissionAccountCode();

	String[] getBusinessAdminAccountCode(String username);

	String getBusinessIdentificationKey(String username);
}