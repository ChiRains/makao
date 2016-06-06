package com.qcloud.component.metadata;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QueryParam {

    private Map<String, Object> map = new HashMap<String, Object>();

    public Map<String, Object> getMap() {

        return Collections.unmodifiableMap(map);
    }

    public void addParam(String key, Object value) {

        map.put(key, value);
    }
}
