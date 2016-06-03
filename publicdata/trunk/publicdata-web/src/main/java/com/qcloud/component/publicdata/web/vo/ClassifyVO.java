package com.qcloud.component.publicdata.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class ClassifyVO {

    // ID
    private long   id;

    private long   parentId;

    // 名称
    private String name;

    // 图片
    private String image;

    private String remark;

    private int    enable;

    private int    sort;

    public ClassifyVO() {

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

    public void setImage(String image) {

        this.image = image;
    }

    public String getImage() {

        return image;
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
