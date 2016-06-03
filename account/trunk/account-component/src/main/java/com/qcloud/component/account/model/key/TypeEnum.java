package com.qcloud.component.account.model.key;

public class TypeEnum {

    public enum EntryCertificateStateType {
        ENABLE(1, "启用"), DISABLE(2, "禁用"), FROZEN(3, "禁用");

        private final int    key;

        private final String name;

        private EntryCertificateStateType(int key, String name) {

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
