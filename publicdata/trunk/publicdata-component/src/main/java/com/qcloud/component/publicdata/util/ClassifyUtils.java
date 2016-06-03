package com.qcloud.component.publicdata.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.model.Classify;

public class ClassifyUtils {

    public static List<Classify> sort(List<Classify> list) {

        Collections.sort(list, new Comparator<Classify>() {

            @Override
            public int compare(Classify o1, Classify o2) {

                return o1.getBsid().compareTo(o2.getBsid());
            }
        });
        return list;
    }

    public static List<KeyValueVO> exchangeObj(List<Classify> list, long key, String message) {

        List<KeyValueVO> keyValueVOList = new ArrayList<KeyValueVO>();
        for (Classify classify : list) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(classify.getId()));
            vo.setMessage(key == classify.getId() ? message : "");
            String path = calculationPath(list, classify);
            vo.setValue(path);
            keyValueVOList.add(vo);
        }
        return keyValueVOList;
    }

    public static List<KeyValueVO> exchangeObj(List<Classify> list, long key, String message, boolean hasRoot) {

        List<KeyValueVO> keyValueVOList = new ArrayList<KeyValueVO>();
        for (Classify classify : list) {
            if (classify.getParentId() == -1 && !hasRoot) {
                continue;
            }
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(classify.getId()));
            vo.setMessage(key == classify.getId() ? message : "");
            String path = calculationPath(list, classify);
            vo.setValue(path);
            keyValueVOList.add(vo);
        }
        return keyValueVOList;
    }

    public static String calculationPath(List<Classify> allList, Classify classify) {

        long id = classify.getParentId();
        List<Classify> list = getParentList(allList, id);
        StringBuffer sb = new StringBuffer();
        for (int index = list.size() - 1; index >= 0; index--) {
            sb.append(list.get(index).getName() + "--");
        }
        sb.append(classify.getName());
        return sb.toString();
    }

    public static List<Classify> getParentList(List<Classify> allList, long id) {

        Classify parent = null;
        List<Classify> list = new ArrayList<Classify>();
        do {
            parent = getParent(allList, id);
            if (parent != null) {
                list.add(parent);
                id = parent.getParentId();
            }
        } while (parent != null);
        return list;
    }

    public static Classify getParent(List<Classify> allList, long id) {

        for (Classify classify : allList) {
            if (classify.getId() == id) {
                return classify;
            }
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        List<Classify> classifies=new ArrayList<Classify>();
//        Classify classify1=new Classify();
//        classify1.setBsid("8");
//        Classify classify2=new Classify();
//        classify2.setBsid("1");
//        Classify classify3=new Classify();
//        classify3.setBsid("7");
//        Classify classify4=new Classify();
//        classify4.setBsid("6");
//        Classify classify5=new Classify();
//        classify5.setBsid("5");
//        classifies.add(classify1);
//        classifies.add(classify2);
//        classifies.add(classify3);
//        classifies.add(classify4);
//        classifies.add(classify5);
//        
//        classifies=sort(classifies);
//        for (Classify classify : classifies) {
//            System.out.println(classify.getBsid());
//        }
//    }
}
