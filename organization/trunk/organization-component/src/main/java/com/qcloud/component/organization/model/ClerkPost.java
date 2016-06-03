package com.qcloud.component.organization.model;

import java.util.Date;
import java.math.BigDecimal;

public class ClerkPost {
	
	//ID
	private long id;		
	
	//职员id
	private long clerkId;		
	
	//岗位id
	private long postId;		

	public ClerkPost(){
	
	}

	public ClerkPost(long id,long clerkId,long postId){
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
