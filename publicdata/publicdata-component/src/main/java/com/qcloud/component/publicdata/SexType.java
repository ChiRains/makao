package com.qcloud.component.publicdata;

public enum SexType implements IntKeyValue {
    MALE(1, "男"), FEMALE(2, "女"), UNKNOW(3, "保密");

    private final long   key;

    private final String value;

    private SexType(int key, String value) {

        this.key = key;
        this.value = value;
    }

    public long getKey() {

        return key;
    }

    public String getValue() {

        return value;
    }

    public static SexType getSexType(long type) {

        SexType st = null;
        for (SexType sex : SexType.values()) {
            if (sex.getKey() == type) {
                st = sex;
                break;
            }
        }
        return st == null ? UNKNOW : st;
    }
    
}
