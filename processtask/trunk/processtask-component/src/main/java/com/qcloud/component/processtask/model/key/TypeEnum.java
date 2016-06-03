package com.qcloud.component.processtask.model.key;

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
    public enum ProcessStateType {
        DOING(1, "启用"), PASS(2, "通过"), REFUSE(3, "拒绝");

        private final int    key;

        private final String name;

        private ProcessStateType(int key, String name) {

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
    public enum TaskStartStateType {
        START(1, "启动"), APPROVAL(2, "审批");

        private final int    key;

        private final String name;

        private TaskStartStateType(int key, String name) {

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
