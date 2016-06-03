package com.qcloud.component.organization.web.vo;

public class ContactsVO {
	//姓名
	private String clerkName;
	//性别
	private int sex;
    //手机
	private String mobile;
   //电子邮箱
	private String  JovEmail;
   //岗位
	private String post;
    //部门
	private String department;
	
	private String inside;
	
	private String headImage;
	
	
	
	public ContactsVO() {
	}

	public ContactsVO(String clerkName, int sex, String mobile,
			String jovEmail, String post, String department) {
		this.clerkName = clerkName;
		this.sex = sex;
		this.mobile = mobile;
		JovEmail = jovEmail;
		this.post = post;
		this.department = department;
	}

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

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

    
    public String getInside() {
    
        return inside;
    }

    
    public void setInside(String inside) {
    
        this.inside = inside;
    }

    
    public String getHeadImage() {
    
        return headImage;
    }

    
    public void setHeadImage(String headImage) {
    
        this.headImage = headImage;
    }

	
}
