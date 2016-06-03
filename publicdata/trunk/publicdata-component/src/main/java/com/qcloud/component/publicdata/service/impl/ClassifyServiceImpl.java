package com.qcloud.component.publicdata.service.impl;

import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.publicdata.EnableType;
import com.qcloud.component.publicdata.dao.ClassifyDao;
import com.qcloud.component.publicdata.exception.PublicdataException;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.query.ClassifyQuery;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyDao         classifyDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    private static final String ID_KEY = "publicdata_classify";

    @Autowired
    private FileSDKClient       fileSDKClient;

    @Override
    public boolean add(Classify classify) {

        Classify c = classifyDao.getByName(classify.getType(), classify.getName());
        if (c != null) {
//            throw new PublicdataException("分类名称已经使用." + classify.getName());
        }
        List<Classify> list = classifyDao.listChildren(classify.getType(), classify.getParentId());
        String bsid = calculateBsid(list);
        Classify p = classifyDao.get(classify.getParentId());
        if (p == null) {
            classify.setParentId(-1);
            String typeStr = StringUtils.leftPad(String.valueOf(classify.getType()), 2, "0");
            classify.setBsid(typeStr + bsid);
        } else {
            classify.setBsid(p.getBsid() + bsid);
        }
        long id = autoIdGenerator.get(ID_KEY);
        classify.setId(id);
        if (StringUtils.isNotEmpty(classify.getImage())) {
            classify.setImage(fileSDKClient.uidToUrl(classify.getImage()));
        }
        classify.setEnable(EnableType.ENABLE.getKey());
        return classifyDao.add(classify);
    }

    private String calculateBsid(List<Classify> list) {

        int bsid = 0;
        for (Classify classify : list) {
            String bsidStr = classify.getBsid();
            bsidStr = bsidStr.substring(bsidStr.length() - 5, bsidStr.length());
            int brother = Integer.valueOf(bsidStr);
            if (brother > bsid) {
                bsid = brother;
            }
        }
        return StringUtils.leftPad(String.valueOf(bsid + 1), 5, "0");
    }

    @Override
    public Classify get(Long id) {

        return classifyDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return classifyDao.delete(id);
    }

    @Override
    public boolean update(Classify classify) {
//        Classify temp = classifyDao.getByName(classify.getType(), classify.getName());
//        if (temp != null&&temp.getId()!=classify.getId()) {
//            throw new PublicdataException("分类名称已经使用." + classify.getName());
//        }
        Classify c = classifyDao.get(classify.getId());
        if (c.getParentId() != classify.getParentId()) {
            List<Classify> list = classifyDao.listChildren(classify.getType(), classify.getParentId());
            Classify p = classifyDao.get(classify.getParentId());
            String bsid = calculateBsid(list);
            if (p == null) {
                classify.setParentId(-1);
                String typeStr = StringUtils.leftPad(String.valueOf(classify.getType()), 2, "0");
                classify.setBsid(typeStr + bsid);
            } else {
                classify.setBsid(p.getBsid() + bsid);
            }
            List<Classify> children = classifyDao.listAllChildren(c.getBsid());
            for (Classify cc : children) {
                cc.setBsid(cc.getBsid().replaceFirst(c.getBsid(), classify.getBsid()));
                classifyDao.update(cc);
            }
        } else {
            classify.setBsid(c.getBsid());
        }
        classify.setImage(fileSDKClient.uidToUrl(classify.getImage()));
        return classifyDao.update(classify);
    }

    @Override
    public Page<Classify> page(ClassifyQuery query, int start, int count) {

        return classifyDao.page(query, start, count);
    }

    public List<Classify> listAll(long type) {

        return classifyDao.listAll(type);
    }

    @Transactional
    @Override
    public boolean sort(Long id, int sort) { // 0 1 -1

        Classify classify = classifyDao.get(id);
        AssertUtil.assertNotNull(classify, "指定分类不存在." + id);
        List<Classify> sameLevel = classifyDao.listChildrenToSort(classify.getType(), classify.getParentId());
        boolean flag = true;
        for (int i = 0; i < sameLevel.size(); i++) {
            if (sameLevel.get(i).getId() == classify.getId()) {
                sameLevel.remove(i);
            }
        }
        if (sort == 0) {// 置顶
            for (int i = 0; i < sameLevel.size(); i++) {
                Classify temp = sameLevel.get(i);
                temp.setSort(i + 1);
                classifyDao.sort(temp.getId(), temp.getSort());
            }
            flag = classifyDao.sort(classify.getId(), 0);
        } else if (sort == -1) {// 向上
            Classify upward = new Classify();
            for (Classify temp : sameLevel) {
                if (temp.getSort() == classify.getSort() - 1) {
                    temp.setSort(temp.getSort() + 1);
                    upward = temp;
                }
            }
            classifyDao.sort(upward.getId(), upward.getSort());
            flag = classifyDao.sort(classify.getId(), classify.getSort() > 0 ? classify.getSort() - 1 : 0);
        } else {// 向下
            Classify down = null;
            for (Classify temp : sameLevel) {
                if (temp.getSort() == classify.getSort() + 1) {
                    temp.setSort(temp.getSort() - 1);
                    down = temp;
                }
            }
            if (down != null) {
                classifyDao.sort(down.getId(), down.getSort());
                flag = classifyDao.sort(classify.getId(), classify.getSort() + 1);
            }
        }
        return flag;
    }

    @Transactional
    @Override
    public boolean enable(Long id, int enable) {

        Classify classify = classifyDao.get(id);
        AssertUtil.assertNotNull(classify, "指定分类不存在." + id);
        List<Classify> childrenList = classifyDao.listAllChildrenToEnable(classify.getBsid());
        for (Classify c : childrenList) {
            classifyDao.enable(c.getId(), enable);
        }
        boolean flag = classifyDao.enable(id, enable);
        return flag;
    }

    @Override
    public boolean withoutDelete(Long id) {

        Classify classify = classifyDao.get(id);
        AssertUtil.assertNotNull(classify, "指定分类不存在." + id);
        return false;
    }
}
