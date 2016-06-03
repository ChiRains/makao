package com.qcloud.component.publicdata.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qcloud.pirates.core.reflect.BeanUtils;

/**
 * Created by brook on 2015/7/8.
 */
public class Common {
    public static <T> List<Map> listToTree(List<T> list, String pk, String pid, String children, long root) {
        List<Map> tree = new ArrayList<Map>();
        if (list.size() > 0) {
            HashMap<String, Map> indexMap = new HashMap<String, Map>();
            for (Object object : list) {
                Map map = BeanUtils.transBean2Map(object);
                indexMap.put(map.get(pk).toString(), map);
                if (Long.parseLong(map.get(pid).toString()) == root) {
                    tree.add(map);
                }
            }
            for (Map.Entry<String, Map> map : indexMap.entrySet()) {
                if (Long.parseLong(map.getValue().get(pid).toString()) != root) {
                    Map parent = indexMap.get(map.getValue().get(pid).toString());
                    if (parent.containsKey(children)) {
                        ((List) parent.get(children)).add(map.getValue());
                    } else {
                        parent.put(children, new ArrayList());
                        ((List) parent.get(children)).add(map.getValue());
                    }
                }
            }
        }
        return tree;
    }
}
