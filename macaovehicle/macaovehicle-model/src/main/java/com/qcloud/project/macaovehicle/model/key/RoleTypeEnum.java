package com.qcloud.project.macaovehicle.model.key;

public class RoleTypeEnum {

    public enum StatusType {
        ENABLE(1, "启用"), DISABLE(2, "停用");

        private final int    key;

        private final String name;

        private StatusType(int key, String name) {

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
    public enum PermissionType {
        MENU(1, "菜单"), RESOURCES(2, "资源");

        private final int    key;

        private final String name;

        private PermissionType(int key, String name) {

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
