package com.qcloud.component.publicdata.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.model.Classify;

public class TreeUtils {

    public static List<TreeModel> sort(List<TreeModel> list) {

        Collections.sort(list, new Comparator<TreeModel>() {

            @Override
            public int compare(TreeModel o1, TreeModel o2) {

                return o1.getBsid().compareTo(o2.getBsid());
            }
        });
        return list;
    }

    public static boolean isParent(List<TreeModel> allList, TreeModel treeModel, long parentId) {

        List<TreeModel> list = getParentList(allList, treeModel.getId());
        for (TreeModel t : list) {
            if (t.getId() == parentId) {
                return true;
            }
        }
        return false;
    }

    public static List<KeyValueVO> exchangeObj(List<TreeModel> list, long key, String message) {

        List<KeyValueVO> keyValueVOList = new ArrayList<KeyValueVO>();
        for (TreeModel treeModel : list) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(treeModel.getId()));
            vo.setMessage(key == treeModel.getId() ? message : "");
            String path = calculationPath(list, treeModel);
            vo.setValue(path);
            keyValueVOList.add(vo);
        }
        return keyValueVOList;
    }

    public static String calculationPath(List<TreeModel> allList, TreeModel treeModel) {

        long id = treeModel.getParentId();
        List<TreeModel> list = getParentList(allList, id);
        StringBuffer sb = new StringBuffer();
        for (int index = list.size() - 1; index >= 0; index--) {
            sb.append(list.get(index).getName() + "--");
        }
        sb.append(treeModel.getName());
        return sb.toString();
    }

    public static List<TreeModel> getParentList(List<TreeModel> allList, long id) {

        TreeModel parent = null;
        List<TreeModel> list = new ArrayList<TreeModel>();
        do {
            parent = getParent(allList, id);
            if (parent != null) {
                list.add(parent);
                id = parent.getParentId();
            }
        } while (parent != null);
        return list;
    }

    public static TreeModel getParent(List<TreeModel> allList, long id) {

        for (TreeModel treeModel : allList) {
            if (treeModel.getId() == id) {
                return treeModel;
            }
        }
        return null;
    }
    public static interface TreeModel {

        long getId();

        long getParentId();

        String getBsid();

        String getName();
    }
}
