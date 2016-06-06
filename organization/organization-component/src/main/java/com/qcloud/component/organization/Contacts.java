package com.qcloud.component.organization;


import com.qcloud.pirates.data.Page;

public interface Contacts {

	Page<QContacts> query(String name,Long departmentId,int start,int count );
}
