package com.qcloud.component.form.util;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.qcloud.component.form.exception.FormException;
import com.qcloud.component.metadata.ObjectType;
import com.qcloud.component.metadata.QField;
import com.qcloud.pirates.util.DateUtil;

public class MetadataObjValueUtils {

    // 字段定义默认值
    public static Object getFieldObject(QField field, String value) {

        ObjectType type = field.getType();
        if (StringUtils.isEmpty(value)) {
            if (ObjectType.STRING.getKey() == type.getKey()) {
                return value;
            } else if (ObjectType.INTEGER.getKey() == type.getKey()) {
                return new Integer(0);
            } else if (ObjectType.LONG.getKey() == type.getKey()) {
                return new Long(0);
            } else if (ObjectType.DOUBLE.getKey() == type.getKey()) {
                return new Double(0.0);
            } else if (ObjectType.DATE.getKey() == type.getKey()) {
                return new Date();
            } else if (ObjectType.BYTEARRAY.getKey() == type.getKey()) {
                return null;
            } else {
                throw new FormException("不支持的字段类型定义" + field.getType());
            }
        } else {
            if (ObjectType.STRING.getKey() == type.getKey()) {
                return value;
            } else if (ObjectType.INTEGER.getKey() == type.getKey()) {
                return Integer.parseInt(value);
            } else if (ObjectType.LONG.getKey() == type.getKey()) {
                return Long.parseLong(value);
            } else if (ObjectType.DOUBLE.getKey() == type.getKey()) {
                return Double.parseDouble(value);
            } else if (ObjectType.DATE.getKey() == type.getKey()) {
                return DateUtil.str2Date(value);
            } else if (ObjectType.BYTEARRAY.getKey() == type.getKey()) {
                return value.getBytes();
            } else {
                throw new FormException("不支持的字段类型定义" + field.getType());
            }
        }
    }
}
