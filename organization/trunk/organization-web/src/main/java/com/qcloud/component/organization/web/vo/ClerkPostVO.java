package com.qcloud.component.organization.web.vo;



public class ClerkPostVO {
	
	//ID
	private long id;		
	
	//职员id
	private long clerkId;		
	
	//岗位id
	private long postId;		

	public ClerkPostVO(){
	
	}

	public ClerkPostVO(long id,long clerkId,long postId){
		this.id = id;		
		this.clerkId = clerkId;		
		this.postId = postId;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setClerkId(long clerkId) {
		this.clerkId = clerkId;
	}

	public long getClerkId() {
		return clerkId;
	}	
		
	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getPostId() {
		return postId;
	}	
		
}
