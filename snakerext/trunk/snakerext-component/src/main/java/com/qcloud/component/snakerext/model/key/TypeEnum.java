package com.qcloud.component.snakerext.model.key;
public class TypeEnum {
    public enum EnableType {
        ENABLE(1, "启用"), DISABLE(0, "禁用");
        private final int    key;
        private final String name;

        private EnableType(int key, String name) {
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
    public enum ExecutorType {
        USER(1, "用户"), CHARACTER(2, "角色"), INTERFACE(3, "接口");
        private final int    key;
        private final String name;

        private ExecutorType(int key, String name) {
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
}
