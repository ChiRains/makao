package com.qcloud.component.metadata;

public enum ObjectType {
    STRING(1, "字符串"), INTEGER(2, "整型"), LONG(3, "长整形"), DOUBLE(4, "实数"), DATE(5, "日期"), BYTEARRAY(6, "字节数组");

    private final int    key;

    private final String name;

    private ObjectType(int key, String name) {

        this.key = key;
        this.name = name;
    }

    public int getKey() {

        return key;
    }

    public String getName() {

        return name;
    }
}
