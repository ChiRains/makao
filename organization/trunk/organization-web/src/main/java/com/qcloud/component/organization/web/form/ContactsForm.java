package com.qcloud.component.organization.web.form;

public class ContactsForm {
	
    private String name;
	
	private Long departmentId;
	

	private ContactsForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	
}
