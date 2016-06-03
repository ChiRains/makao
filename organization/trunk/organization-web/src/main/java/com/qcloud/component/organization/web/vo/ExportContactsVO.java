package com.qcloud.component.organization.web.vo;

public class ExportContactsVO {
	//姓名
		private String clerkName;
		//性别
		private String sexStr;
	    //手机
		private String mobile;
	   //电子邮箱
		private String  jovEmail;
	   //岗位
		private String post;
	    //部门
		private String department;
		
		
		public ExportContactsVO() {
		}
		public ExportContactsVO(String clerkName, String sexStr,
				String mobile, String jovEmail, String post, String department) {
			this.clerkName = clerkName;
			this.sexStr = sexStr;
			this.mobile = mobile;
			this.jovEmail = jovEmail;
			this.post = post;
			this.department = department;
		}
		public String getClerkName() {
			return clerkName;
		}
		public void setClerkName(String clerkName) {
			this.clerkName = clerkName;
		}
		public String getSexStr() {
			return sexStr;
		}
		public void setSexStr(String sexStr) {
			this.sexStr = sexStr;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getJovEmail() {
			return jovEmail;
		}
		public void setJovEmail(String jovEmail) {
			this.jovEmail = jovEmail;
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
		
		
}
