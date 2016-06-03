package com.qcloud.component.publicdata;

public enum ClassifyType implements IntKeyValue {
    //
    MERCHANT(1, "商家分类"), SPECIFICATIONS(2, "规格列表"), MERCHANTCUSTOM(3, "商家自定义分类"), MALLCUSTOM(4, "商城自定义分类"), MERCHANDISE(5, "商城商品分类");

    private final int    key;

    private final String value;

    private ClassifyType(int key, String value) {

        this.key = key;
        this.value = value;
    }

    public long getKey() {

        return key;
    }

    public String getValue() {

        return value;
    }
}
