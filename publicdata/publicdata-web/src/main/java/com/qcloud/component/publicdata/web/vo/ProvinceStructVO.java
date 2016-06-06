package com.qcloud.component.publicdata.web.vo;

import java.util.ArrayList;
import java.util.List;

public class ProvinceStructVO {

    private String             p;

    private List<CityStructVO> c = new ArrayList<CityStructVO>();

    public String getP() {

        return p;
    }

    public void setP(String p) {

        this.p = p;
    }

    public List<CityStructVO> getC() {

        return c;
    }

    public void setC(List<CityStructVO> c) {

        this.c = c;
    }
}
