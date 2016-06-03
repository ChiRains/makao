package com.qcloud.component.publicdata.model.query;
public class CityQuery {
    
    private long   provinceId;
    
    private String name;

    public CityQuery() {
    }

    public long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
