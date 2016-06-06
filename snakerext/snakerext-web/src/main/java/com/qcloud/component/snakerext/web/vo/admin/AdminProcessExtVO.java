package com.qcloud.component.snakerext.web.vo.admin;
import com.qcloud.component.form.model.FormDef;
public class AdminProcessExtVO {
    /**
     * 主键ID
     */
    private String  id;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 流程定义名称
     */
    private String  name;
    /**
     * 流程定义显示名称
     */
    private String  displayName;
    /**
     * 流程定义类型（预留字段）
     */
    private String  type;
    /**
     * 当前流程的实例url（一般为流程第一步的url）
     * 该字段可以直接打开流程申请的表单
     */
    private String  instanceUrl;
    /**
     * 是否可用的开关
     */
    private Integer state;
    /**
     * 创建时间
     */
    private String  createTime;
    /**
     * 创建人
     */
    private String  creator;
    private FormDef formDef;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public FormDef getFormDef() {
        return formDef;
    }

    public void setFormDef(FormDef formDef) {
        this.formDef = formDef;
    }
}
