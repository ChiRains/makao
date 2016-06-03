package com.qcloud.component.organization.model.key;

public class TypeEnum {

    public static final String CLERK_ACCOUNT_CODE  = "clerk";

    public static final String CLERK_MESSAGE_CODE = "clerk";
    //
    public enum SexType {
        MAN(1, "男"), WOMEN(2, "女"), BAOMI(3, "保密");

        private final int    key;

        private final String name;

        private SexType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        public static String getValue(int type) {

            String sexStr = null;
            for (SexType s : SexType.values()) {
                if (s.getKey() == type) {
                    sexStr = s.getName();
                    break;
                }
            }
            return sexStr;
        }
    }
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
    public enum DepartmentClerkType {
        BELONGS(1, "所属"), BORROW(2, "借用");

        private final int    key;

        private final String name;

        private DepartmentClerkType(int key, String name) {

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

    public final static String EXCEL_TEMPLATE_DIR = "/WEB-INF/excel";
}
