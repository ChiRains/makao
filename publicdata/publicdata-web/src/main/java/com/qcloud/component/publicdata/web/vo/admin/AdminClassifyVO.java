package com.qcloud.component.publicdata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminClassifyVO {

    // ID
    private long   id;

    private long   parentId;

    // 名称
    private String name;

    private String path;

    // 图片
    private String image;

    // 图片标识
    private String imageUid;

    private String selected;

    // 分类类型
    private long   type;

    private String remark;

    private int    enable;

    private int    sort;

    public AdminClassifyVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setParentId(long parentId) {

        this.parentId = parentId;
    }

    public long getParentId() {

        return parentId;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setType(long type) {

        this.type = type;
    }

    public long getType() {

        return type;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public String getImage() {

        return image;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public String getImageUid() {

        return imageUid;
    }

    public void setImageUid(String imageUid) {

        this.imageUid = imageUid;
    }

    public String getSelected() {

        return selected;
    }

    public void setSelected(String selected) {

        this.selected = selected;
    }

    public String getRemark() {

        return remark;
    }

    public void setRemark(String remark) {

        this.remark = remark;
    }

    public int getEnable() {

        return enable;
    }

    public void setEnable(int enable) {

        this.enable = enable;
    }

    public int getSort() {

        return sort;
    }

    public void setSort(int sort) {

        this.sort = sort;
    }
}
