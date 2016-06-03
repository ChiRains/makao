package com.qcloud.component.metadata.entity;

import com.qcloud.component.metadata.ObjectType;
import com.qcloud.component.metadata.QField;

public class DBField implements QField {

    private Long       id;

    private String     name;

    private ObjectType type;

    private DBTable    table;

    public DBField(DBTable table) {

        super();
        this.table = table;
    }

    public DBTable getTable() {

        return table;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public ObjectType getType() {

        return type;
    }

    public void setType(ObjectType type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "DBField [name=" + name + "]";
    }
}
