package com.qcloud.component.publicdata.web.vo;

import java.util.ArrayList;
import java.util.List;

public class CityStructVO {

    private String                 n;

    private List<DistrictStructVO> a = new ArrayList<DistrictStructVO>();

    public String getN() {

        return n;
    }

    public void setN(String n) {

        this.n = n;
    }

    public List<DistrictStructVO> getA() {

        return a;
    }

    public void setA(List<DistrictStructVO> a) {

        this.a = a;
    }
}
