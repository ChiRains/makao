package com.qcloud.component.publicdata;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import com.qcloud.pirates.util.StringUtil;

public class QClassify {

    private Long            id;

    private String          name;

    private String          image;

    private List<QClassify> childrenList = new ArrayList<QClassify>();

    private String          remark;
    
    private int enable ;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public List<QClassify> getChildrenList() {

        return childrenList;
    }

    public void setChildrenList(List<QClassify> childrenList) {

        this.childrenList = childrenList;
    }

    public String getRemark() {

        return StringUtil.nullToEmpty(remark);
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
}
