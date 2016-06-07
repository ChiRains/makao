package com.qcloud.component.piratesship.web.form;

import java.util.ArrayList;
import java.util.List;

public class ListForm {

    private List<Integer> intList    = new ArrayList<Integer>();

    private List<Long>    longList   = new ArrayList<Long>();

    private List<Double>  doubleList = new ArrayList<Double>();

    private List<String>  stringList = new ArrayList<String>();

    public List<Integer> getIntList() {

        return intList;
    }

    public void setIntList(List<Integer> intList) {

        this.intList = intList;
    }

    public List<Long> getLongList() {

        return longList;
    }

    public void setLongList(List<Long> longList) {

        this.longList = longList;
    }

    public List<Double> getDoubleList() {

        return doubleList;
    }

    public void setDoubleList(List<Double> doubleList) {

        this.doubleList = doubleList;
    }

    public List<String> getStringList() {

        return stringList;
    }

    public void setStringList(List<String> stringList) {

        this.stringList = stringList;
    }
}
