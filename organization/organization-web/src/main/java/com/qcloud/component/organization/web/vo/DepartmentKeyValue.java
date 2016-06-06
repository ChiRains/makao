package com.qcloud.component.organization.web.vo;

import java.util.List;

public class DepartmentKeyValue {
	
	private long id;
	
	private String name;
	
	private int number;
	
	private List<ContactsVO> contactsVOs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

    
    public List<ContactsVO> getContactsVOs() {
    
        return contactsVOs;
    }

    
    public void setContactsVOs(List<ContactsVO> contactsVOs) {
    
        this.contactsVOs = contactsVOs;
    }

	
}
