package com.qcloud.component.organization.web.form;

public class ClerkPostForm {

    // ID
    private long    id;

    // 部门id
    private long    postId;

    // 职员id
    private long    clerkId;

    private Boolean isSelected;

    public ClerkPostForm() {

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

    public Boolean getIsSelected() {

        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {

        this.isSelected = isSelected;
    }

    public long getPostId() {

        return postId;
    }

    public void setPostId(long postId) {

        this.postId = postId;
    }
}
