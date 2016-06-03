package com.qcloud.component.publicservice.model.key;

public class TypeEnum {

    public enum MessageStateType {
        //
        UNREAD(1, "未读"),
        //
        READ(2, "已读"),
        //
        DELETE(3, "删除");

        //
        private final int    key;

        //
        private final String name;

        private MessageStateType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public static MessageStateType get(int key) {

            for (MessageStateType messageStateType : MessageStateType.values()) {
                if (messageStateType.getKey() == key) {
                    return messageStateType;
                }
            }
            return UNREAD;
        }
    }
    public enum ParamPaySettingType {
        OPEN(1, "启用"), CLOSE(2, "禁用");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private ParamPaySettingType(int key, String name) {

            this.key = key;
            this.name = name;
        }
    }
    public enum LoginLogOperateType {
        LOGIN_IN(1, "登录"), LOGIN_OUT(2, "注销");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private LoginLogOperateType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public static LoginLogOperateType getByKey(int key) {

            LoginLogOperateType[] types = LoginLogOperateType.values();
            for (LoginLogOperateType type : types) {
                if (type.getKey() == key) {
                    return type;
                }
            }
            return null;
        }
    }
    public enum LoginLogConsumerType {
        User(1, "用户"), Clerk(2, "职员");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private LoginLogConsumerType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public static LoginLogConsumerType getByKey(int key) {

            LoginLogConsumerType[] types = LoginLogConsumerType.values();
            for (LoginLogConsumerType type : types) {
                if (type.getKey() == key) {
                    return type;
                }
            }
            return null;
        }
    }
}
