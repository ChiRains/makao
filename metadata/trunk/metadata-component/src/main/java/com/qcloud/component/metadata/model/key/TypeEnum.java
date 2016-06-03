package com.qcloud.component.metadata.model.key;

public class TypeEnum {

    public enum FieldType {
        TINYINT(1, "tinyint"), INT(2, "int"), INTEGER(3, "integer"), BIGINT(4, "bigint"), DOUBLE(5, "double"), CHAR(6, "char"), VARCHAR(7, "varchar"), DATE(8, "date"), TIME(9, "time"), TIMESTAMP(10, "timestamp"), DATETIME(11, "datetime"), BLOB(12, "blob"), TEXT(13, "text");

        private final int    key;

        private final String name;

        private FieldType(int key, String name) {

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
    public enum DataObjectStateType {
        SELECT(1, "查询状态"), INSERT(2, "新增状态"), UPDATE(3, "更新状态"), DELETE(4, "删除状态");

        private final int    key;

        private final String name;

        private DataObjectStateType(int key, String name) {

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
