package com.qcloud.component.form.model.key;

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
    public enum ElementType {
        TEXT(1, "文本输入框"), NUMBER(2, "数字输入框"), SELECT(3, "下拉框"), RADIO(4, "单选框"), CHECKBOX(5, "多选框"), DATE(6, "日期"), TEXTAREA(7, "文本域"), HEDDIN(8, "隐藏域"), FILE(9, "文件"), PARAMETER(10, "参数");

        private final int    key;

        private final String name;

        private ElementType(int key, String name) {

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

    public static final String QC_ORGANIZATION_CLERK_ID_        = "qc_oc_";

    public static final String QC_ORGANIZATION_CLERK_NAME_      = "name_qc_oc_";

    public static final String QC_ORGANIZATION_DEPARDMENT_ID_   = "qc_od_";

    public static final String QC_ORGANIZATION_DEPARDMENT_NAME_ = "name_qc_od_";

    public static final String QC_ORGANIZATION_POST_ID_         = "qc_op_";

    public static final String QC_ORGANIZATION_POST_NAME_       = "name_qc_op_";

    public static final String QC_SNAKER_WORKITEM_ID_           = "qc_sw_";

    public static final String QC_SNAKER_WORKITEM_NAME_         = "name_qc_sw_";

    public static final String QC_SNAKER_PROCESS_ID_            = "qc_sp_";

    public static final String QC_SNAKER_PROCESS_NAME_          = "name_qc_sp_";

    // current time
    public static final String QC_CURRENT_TIME_                 = "qc_ct_";

    public static final String QC_INNER_NUMBER                  = "qc_inner_number";

    // 意见子表\元素***********************************************
    public static final String QC_NOTION_                       = "qc_notion_";

    public static final String QC_NOTION_CLERK_ID_              = QC_ORGANIZATION_CLERK_ID_ + "clerk";

    public static final String QC_NOTION_CLERK_NAME_            = QC_ORGANIZATION_CLERK_NAME_ + "clerk";

    public static final String QC_NOTION_DEPARDMENT_ID_         = QC_ORGANIZATION_DEPARDMENT_ID_ + "department";

    public static final String QC_NOTION_DEPARDMENT_NAME_       = QC_ORGANIZATION_DEPARDMENT_NAME_ + "department";

    public static final String QC_NOTION_POST_ID_               = QC_ORGANIZATION_POST_ID_ + "post";

    public static final String QC_NOTION_POST_NAME_             = QC_ORGANIZATION_POST_NAME_ + "post";

    public static final String QC_NOTION_WORKITEM_ID_           = QC_SNAKER_WORKITEM_ID_ + "workitem";

    public static final String QC_NOTION_WORKITEM_NAME_         = QC_SNAKER_WORKITEM_NAME_ + "workitem";

    public static final String QC_NOTION_TASK_                  = "qc_st_task";

    public static final String QC_NOTION_TIME_                  = QC_CURRENT_TIME_ + "time";

    public static final String QC_NOTION_RESULT_                = "result";

    public static final String QC_NOTION_CONTENT_               = "content";

    // 意见子表\元素***********************************************
    public static final String QC_MD_ID                         = "id";

    public static final String QC_MD_MASTERID                   = "masterId";

    // 意见子表\元素***********************************************
    public static final String QC_NOTION_MD_CLERK               = "clerk";

    public static final String QC_NOTION_MD_CLERK_NAME          = "clerkName";

    public static final String QC_NOTION_MD_DEPARTMENT          = "department";

    public static final String QC_NOTION_MD_DEPARTMENT_NAME     = "departmentName";

    public static final String QC_NOTION_MD_POST                = "post";

    public static final String QC_NOTION_MD_POST_NAME           = "postName";

    public static final String QC_NOTION_MD_WOEKITEM            = "workitem";

    public static final String QC_NOTION_MD_WOEKITEM_NAME       = "workitemName";

    public static final String QC_NOTION_MD_CONTENT             = "content";

    public static final String QC_NOTION_MD_TIME                = "time";

    public static final String QC_NOTION_MD_RESULT              = "result";

    public static final String QC_NOTION_MD_TASK                = "task";
    // 意见子表\元素***********************************************
}
