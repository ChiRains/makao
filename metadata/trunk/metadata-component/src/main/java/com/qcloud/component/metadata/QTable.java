package com.qcloud.component.metadata;

import java.util.List;

public interface QTable {

    Long getTableId();

    String getName();

    List<QField> getFieldList();
}
