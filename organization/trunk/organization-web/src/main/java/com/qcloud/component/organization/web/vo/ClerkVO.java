package com.qcloud.component.organization.web.vo;

public class ClerkVO {

    // ID
    private long   id;

    // 账号 唯一 登录使用
    private String account;

    // 姓名
    private String name;

    // 手机号
    private String mobile;

    // 头像
    private String headImage;

    private long   departmentId;

    private String departmentName;

    private int    sex;

    private String sexStr;

    private long   postId;

    private String postName;

    private long   leader;

    private String leaderName;

    private String headImageUid;

    private String inside;

    public ClerkVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setAccount(String account) {

        this.account = account;
    }

    public String getAccount() {

        return account;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile;
    }

    public String getMobile() {

        return mobile;
    }

    public void setHeadImage(String headImage) {

        this.headImage = headImage;
    }

    public String getHeadImage() {

        return headImage;
    }

    public long getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(long departmentId) {

        this.departmentId = departmentId;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public long getPostId() {

        return postId;
    }

    public void setPostId(long postId) {

        this.postId = postId;
    }

    public String getPostName() {

        return postName;
    }

    public void setPostName(String postName) {

        this.postName = postName;
    }

    public long getLeader() {

        return leader;
    }

    public void setLeader(long leader) {

        this.leader = leader;
    }

    public String getLeaderName() {

        return leaderName;
    }

    public void setLeaderName(String leaderName) {

        this.leaderName = leaderName;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {

        this.sex = sex;
    }

    public String getSexStr() {

        return sexStr;
    }

    public void setSexStr(String sexStr) {

        this.sexStr = sexStr;
    }

    public String getHeadImageUid() {

        return headImageUid;
    }

    public void setHeadImageUid(String headImageUid) {

        this.headImageUid = headImageUid;
    }

    public String getInside() {

        return inside;
    }

    public void setInside(String inside) {

        this.inside = inside;
    }
}
