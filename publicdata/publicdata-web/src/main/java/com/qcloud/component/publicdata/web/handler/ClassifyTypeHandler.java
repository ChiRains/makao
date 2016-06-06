package com.qcloud.component.publicdata.web.handler;
import javax.servlet.http.HttpServletRequest;
import com.qcloud.component.publicdata.IntKeyValue;

public interface ClassifyTypeHandler {
    
    IntKeyValue[] listType(HttpServletRequest request);
}
