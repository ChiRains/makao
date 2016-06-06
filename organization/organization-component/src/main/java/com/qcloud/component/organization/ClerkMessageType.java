package com.qcloud.component.organization;

public enum ClerkMessageType {
    //
    INSIDE_LETTER(1, "站内信");

    private final int    key;

    private final String name;

    private ClerkMessageType(int key, String name) {

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
