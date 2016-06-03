package com.qcloud.component.publicdata.web.vo;

import java.util.ArrayList;
import java.util.List;

public class QuestionVO {

    private long            id;

    // 题目名称
    private String          name;

    // 类型
    private int             type;

    private List<OptionsVO> list = new ArrayList<OptionsVO>();

    public QuestionVO() {

    }

    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getType() {

        return type;
    }

    public List<OptionsVO> getList() {

        return list;
    }

    public void setList(List<OptionsVO> list) {

        this.list = list;
    }
}
