package com.qcloud.component.publicdata.model.key;

public class TypeEnum {

    public enum Kilometer {
        KM1(1, "1km"), KM2(2, "2km"), KM5(3, "5km"), KM10(4, "10km");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private Kilometer(int key, String name) {

            this.key = key;
            this.name = name;
        }
    }
    public enum SortType {
        TOP(0, "置顶"), UPWARD(-1, "向上排序"), DOWN(1, "向下排序");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private SortType(int key, String name) {

            this.key = key;
            this.name = name;
        }
    }
   
    public enum PictureType {
        MERCHANT(1, "shangjiafenlei"), SPECIFICATIONS(2, "guigeleimu"), MERCHANDISE(5, "shangpinfenlei");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private PictureType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public static String get(long type) {

            for (PictureType p : PictureType.values()) {
                if (p.getKey() == type) {
                    return p.getName();
                }
            }
            return null;
        }
    }
    
    public enum QuestionType {
        INPUT(1, "输入框"), TEXTAREA(2, "文本域"), RADIO(3, "单选"),CHECKBOX(4, "多选");

        private final int    key;

        private final String name;

        public int getKey() {

            return key;
        }

        public String getName() {

            return name;
        }

        private QuestionType(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public static String getName(long type) {

            for (QuestionType t : QuestionType.values()) {
                if (t.getKey() == type) {
                    return t.getName();
                }
            }
            return null;
        }
    }
}
