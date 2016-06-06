package com.qcloud.component.organization.entity;

import com.qcloud.component.organization.QContacts;

public class ContactsEntity implements QContacts  {
	//id
  private   Long id;
	//姓名
	private String clerkName;
	//性别
	private int sex;
    //手机
	private String mobile;
   //电子邮箱
	private String  JovEmail;
   //岗位
	private Long postId;
    //部门
	private Long departmentId;
	
	private String headImage;
	
	
	public String getClerkName() {
		return clerkName;
	}

	public void setClerkName(String clerkName) {
		this.clerkName = clerkName;
	}

	
	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public String getJovEmail() {
		return JovEmail;
	}

	public void setJovEmail(String jovEmail) {
		JovEmail = jovEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

    
    public String getHeadImage() {
    
        return headImage;
    }

    
    public void setHeadImage(String headImage) {
    
        this.headImage = headImage;
    }


}
