package com.qcloud.component.publicdata.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.publicdata.ClassifyType;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.QClassify;
import com.qcloud.component.publicdata.QQuestionnaire;
import com.qcloud.component.publicdata.StrKeyValue;
import com.qcloud.component.publicdata.entity.QuestionEntity;
import com.qcloud.component.publicdata.entity.QuestionnaireEntity;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.model.Questionnaire;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.component.publicdata.service.ClassifyService;
import com.qcloud.component.publicdata.service.DataDictionaryService;
import com.qcloud.component.publicdata.service.DistrictService;
import com.qcloud.component.publicdata.service.ExpressService;
import com.qcloud.component.publicdata.service.ImageInformationService;
import com.qcloud.component.publicdata.service.OptionsService;
import com.qcloud.component.publicdata.service.PopularSearchesService;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.service.QuestionService;
import com.qcloud.component.publicdata.service.QuestionnaireService;
import com.qcloud.component.publicdata.util.ClassifyUtils;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;

@Service
public class PublicdataClientImpl implements PublicdataClient {

    @Autowired
    private ProvinceService         provinceService;

    @Autowired
    private CityService             cityService;

    @Autowired
    private DistrictService         districtService;

    @Autowired
    private ClassifyService         classifyService;

    @Autowired
    private DataDictionaryService   dataDictionaryService;

    @Autowired
    private ImageInformationService imageInformationService;

    @Autowired
    private ExpressService          expressService;

    @Autowired
    private PopularSearchesService  popularSearchesService;

    @Autowired
    private QuestionnaireService    questionnaireService;

    @Autowired
    private QuestionService         questionService;

    @Autowired
    private OptionsService          optionsService;

    @Override
    public List<String> listProvince() {

        List<Province> list = provinceService.listAll();
        List<String> strList = new ArrayList<String>();
        for (Province province : list) {
            strList.add(province.getName());
        }
        return strList;
    }

    @Override
    public List<Province> listAllProvince() {

        return provinceService.listAll();
    }

    @Override
    public List<String> listCity(String provinceName) {

        List<City> list = new ArrayList<City>();
        if (StringUtils.isNotEmpty(provinceName)) {
            Province p = provinceService.getByName(provinceName);
            if (p != null) {
                list = cityService.listByProvince(p.getId());
            }
        }
        List<String> strList = new ArrayList<String>();
        for (City city : list) {
            strList.add(city.getName());
        }
        return strList;
    }

    @Override
    public List<City> listAllCity() {

        return cityService.listAll();
    }

    @Override
    public Map<Long, List<City>> listAllCityMap() {

        Map<Long, List<City>> map = new HashMap<Long, List<City>>();
        List<City> list = listAllCity();
        for (final City city : list) {
            if (map.containsKey(city.getProvinceId())) {
                map.get(city.getProvinceId()).add(city);
            } else {
                map.put(city.getProvinceId(), new ArrayList<City>() {

                    {
                        add(city);
                    }
                });
            }
        }
        return map;
    }

    @Override
    public List<String> listDistrict(String cityName) {

        List<District> list = new ArrayList<District>();
        if (StringUtils.isNotEmpty(cityName)) {
            City c = cityService.getByName(cityName);
            if (c != null) {
                list = districtService.listByCity(c.getId());
            }
        }
        List<String> strList = new ArrayList<String>();
        for (District district : list) {
            strList.add(district.getName());
        }
        return strList;
    }

    @Override
    public List<KeyValueVO> exchageStr(List<String> strList, String str, String message) {

        if (strList == null) {
            return null;
        }
        List<KeyValueVO> voList = new ArrayList<KeyValueVO>();
        for (String string : strList) {
            KeyValueVO kv = new KeyValueVO();
            kv.setKey(string);
            kv.setValue(string);
            kv.setMessage(StringUtils.isNotEmpty(string) && string.equals(str) ? message : "");
            voList.add(kv);
        }
        return voList;
    }

    @Override
    public List<KeyValueVO> exchageObj(List<IntKeyValue> kvList, long key, String message) {

        if (kvList == null) {
            return null;
        }
        return exchageObj(kvList.toArray(new IntKeyValue[kvList.size()]), key, message);
    }

    @Override
    public List<KeyValueVO> exchageObj(List<StrKeyValue> kvList, String key, String message) {

        if (kvList == null) {
            return null;
        }
        return exchageObj(kvList.toArray(new StrKeyValue[kvList.size()]), key, message);
    }

    @Override
    public List<KeyValueVO> exchageObj(IntKeyValue[] kvs, long key, String message) {

        if (kvs == null) {
            return null;
        }
        List<KeyValueVO> voList = new ArrayList<KeyValueVO>();
        for (IntKeyValue ikv : kvs) {
            KeyValueVO kv = new KeyValueVO();
            kv.setKey(String.valueOf(ikv.getKey()));
            kv.setValue(ikv.getValue());
            kv.setMessage(key == ikv.getKey() ? message : "");
            voList.add(kv);
        }
        return voList;
    }

    @Override
    public List<KeyValueVO> exchageObj(StrKeyValue[] kvs, String key, String message) {

        if (kvs == null) {
            return null;
        }
        List<KeyValueVO> voList = new ArrayList<KeyValueVO>();
        for (StrKeyValue skv : kvs) {
            KeyValueVO kv = new KeyValueVO();
            kv.setKey(skv.getKey());
            kv.setValue(skv.getValue());
            kv.setMessage(StringUtils.isNotEmpty(skv.getKey()) && skv.getKey().equals(key) ? message : "");
            voList.add(kv);
        }
        return voList;
    }

    @Override
    public List<Classify> listClassify(ClassifyType type) {

        return classifyService.listAll(new Long(type.getKey()).intValue());
    }

    @Override
    public List<Classify> listClassify(Long type) {

        return classifyService.listAll(type);
    }

    @Override
    public Classify getClassify(Long id) {

        return classifyService.get(id);
    }

    @Override
    public List<QClassify> listClassifyForTree(ClassifyType type) {

        List<Classify> list = listClassify(type);
        List<QClassify> qList = new ArrayList<QClassify>();
        for (Classify classify : list) {
            Classify p = ClassifyUtils.getParent(list, classify.getParentId());
            if (p == null) {
                QClassify qc = new QClassify();
                qc.setId(classify.getId());
                qc.setImage(classify.getImage());
                qc.setName(classify.getName());
                qc.setRemark(classify.getRemark());
                qc.setEnable(classify.getEnable());
                fillTree(qc, list);
                qList.add(qc);
            }
        }
        return qList;
    }

    private void fillTree(QClassify qc, List<Classify> list) {

        List<QClassify> childrenList = new ArrayList<QClassify>();
        for (Classify classify : list) {
            if (classify.getParentId() == qc.getId()) {
                QClassify child = new QClassify();
                child.setId(classify.getId());
                child.setImage(classify.getImage());
                child.setName(classify.getName());
                child.setRemark(classify.getRemark());
                child.setEnable(classify.getEnable());
                fillTree(child, list);
                childrenList.add(child);
            }
        }
        qc.setChildrenList(childrenList);
    }

    @Override
    public List<QClassify> listClassifyForTree(Long type) {

        List<Classify> list = classifyService.listAll(type);
        List<QClassify> qList = new ArrayList<QClassify>();
        for (Classify classify : list) {
            Classify p = ClassifyUtils.getParent(list, classify.getParentId());
            if (p == null) {
                QClassify qc = new QClassify();
                qc.setId(classify.getId());
                qc.setImage(classify.getImage());
                qc.setName(classify.getName());
                qc.setRemark(classify.getRemark());
                qc.setEnable(classify.getEnable());
                fillTree(qc, list);
                qList.add(qc);
            }
        }
        return qList;
    }

    @Override
    public List<QClassify> listTopClassify(Long type) {

        List<Classify> list = classifyService.listAll(type);
        List<QClassify> qList = new ArrayList<QClassify>();
        for (Classify classify : list) {
            Classify p = ClassifyUtils.getParent(list, classify.getParentId());
            if (p == null) {
                QClassify qc = new QClassify();
                qc.setId(classify.getId());
                qc.setImage(classify.getImage());
                qc.setName(classify.getName());
                qc.setRemark(classify.getRemark());
                qc.setEnable(classify.getEnable());
                qList.add(qc);
            }
        }
        return qList;
    }

    @Override
    public List<QClassify> listClassifyForTreeByParent(Long parentId, Long type) {

        List<Classify> list = classifyService.listAll(type);
        List<QClassify> qList = new ArrayList<QClassify>();
        Classify parent = null;
        for (Classify classify : list) {
            if (classify.getId() == parentId) {
                parent = classify;
            }
        }
        if (parent == null) {
            return qList;
        } else {
            QClassify qc = new QClassify();
            qc.setId(parent.getId());
            qc.setImage(parent.getImage());
            qc.setName(parent.getName());
            qc.setRemark(parent.getRemark());
            qc.setEnable(parent.getEnable());
            fillTree(qc, list);
            return qc.getChildrenList();
        }
    }

    @Override
    public List<KeyValueVO> listDataDictionaryByType(String type) {

        if (type == null) {
            return null;
        }
        List<DataDictionary> list = dataDictionaryService.listAll(type);
        List<KeyValueVO> kvList = new ArrayList<KeyValueVO>();
        for (DataDictionary data : list) {
            KeyValueVO vo = new KeyValueVO();
            vo.setKey(String.valueOf(data.getKey()));
            vo.setValue(data.getValue());
            kvList.add(vo);
        }
        return kvList;
    }

    @Override
    public boolean addClassify(Classify classify) {

        return classifyService.add(classify);
    }

    @Override
    public boolean update(Classify classify) {

        return classifyService.update(classify);
    }

    @Override
    public boolean delete(Long id) {

        return classifyService.delete(id);
    }

    @Override
    public List<KeyValueVO> exchageStrSpec(List<String> strList, String str, String message, Long attrIdStr) {

        if (strList == null) {
            return null;
        }
        List<KeyValueVO> voList = new ArrayList<KeyValueVO>();
        // 商品属性值判断
        String strStr[] = str.split(",");
        if (strStr.length > 0) {
            for (int j = 0; j < strList.size(); j++) {
                String string = strList.get(j);
                KeyValueVO kv = new KeyValueVO();
                kv.setKey(String.valueOf(attrIdStr).substring(String.valueOf(attrIdStr).length() - 4) + String.valueOf(j));
                kv.setValue(string.trim());
                for (int i = 0; i < strStr.length; i++) {
                    if (strStr[i].equals(string)) {
                        kv.setMessage(message);
                    }
                }
                voList.add(kv);
            }
        } else {// 普通情况下使用
            for (String string : strList) {
                KeyValueVO kv = new KeyValueVO();
                kv.setKey(String.valueOf(string.hashCode()));
                kv.setValue(string.trim());
                kv.setMessage(StringUtils.isNotEmpty(string) && string.equals(str) ? message : "");
                voList.add(kv);
            }
        }
        return voList;
    }

    @Override
    public List<Classify> listParentClassify(Long id) {

        List<Classify> list = new ArrayList<Classify>();
        Classify classify = getClassify(id);
        AssertUtil.assertNotNull(classify, "指定分类不存在." + id);
        Long cId = classify.getParentId();
        do {
            classify = getClassify(cId);
            if (classify == null) {
                break;
            }
            list.add(0, classify);
            cId = classify.getParentId();
        } while (classify != null);
        return list;
    }

    @Override
    public List<Classify> listParentClassifyIncludeMe(Long id) {

        Classify classify = getClassify(id);
        List<Classify> list = listParentClassify(id);
        list.add(classify);
        return list;
    }

    @Override
    public Province getProvince(Long provinceId) {

        return provinceService.get(provinceId);
    }

    @Override
    public City getCity(Long cityId) {

        return cityService.get(cityId);
    }

    @Override
    public District getDistrict(Long districtId) {

        return districtService.get(districtId);
    }

    @Override
    public String getImageInformationByCode(String code) {

        ImageInformation imageInformation = imageInformationService.getByCode(code);
        if (imageInformation == null) {
            return "";
        } else {
            return imageInformation.getSize();
        }
    }

    @Override
    public List<City> listAllCity(String provinceName) {

        List<City> list = new ArrayList<City>();
        if (StringUtils.isNotEmpty(provinceName)) {
            Province p = provinceService.getByName(provinceName);
            if (p != null) {
                list = cityService.listByProvince(p.getId());
            }
        }
        return list;
    }

    @Override
    public List<District> listAllDistrict(String cityName) {

        List<District> list = new ArrayList<District>();
        if (StringUtils.isNotEmpty(cityName)) {
            City c = cityService.getByName(cityName);
            if (c != null) {
                list = districtService.listByCity(c.getId());
            }
        }
        return list;
    }

    @Override
    public boolean setImageInformationByCode(ImageInformation imageInformation) {

        return imageInformationService.add(imageInformation);
    }

    @Override
    public KeyValueVO getDataDictionaryByKey(String type, Long key) {

        DataDictionary data = dataDictionaryService.getDataDictionaryByKey(type, key);
        if (data == null) {
            return new KeyValueVO();
        }
        KeyValueVO vo = new KeyValueVO();
        vo.setKey(String.valueOf(data.getKey()));
        vo.setValue(data.getValue());
        return vo;
    }

    @Override
    public Express getExpressByCode(String code) {

        return expressService.getByCode(code);
    }

    @Override
    public boolean addSearch(int type, String keywords) {

        PopularSearches popularSearches = new PopularSearches();
        popularSearches.setKeywords(StringUtil.nullToEmpty(keywords).trim());
        popularSearches.setSort(-1);
        popularSearches.setTimes(1);
        popularSearches.setType(type);
        return popularSearchesService.add(popularSearches);
    }

    @Override
    public List<String> listHotSearch(int type, int number) {

        return popularSearchesService.listTop(type, number);
    }

    @Override
    public String getDataDictionary(String type, int key) {

        if (type == null) {
            return null;
        }
        List<DataDictionary> list = dataDictionaryService.listAll(type);
        for (DataDictionary dataDictionary : list) {
            if (dataDictionary.getKey() == key) {
                return dataDictionary.getValue();
            }
        }
        return null;
    }

    @Override
    public Classify getTopClassify(Long id) {

        Long pId = id;
        Classify p = null;
        while (pId != -1L) {
            p = getClassify(pId);
            AssertUtil.assertNotNull(p, "分类不存在." + pId);
            pId = p.getParentId();
        }
        return p;
    }

    @Override
    public QQuestionnaire getQuestionnaire(long questionnaireId) {

        Questionnaire questionnaire = questionnaireService.get(questionnaireId);
        AssertUtil.assertNotNull(questionnaire, "问卷不存在." + questionnaireId);
        List<Question> questionList = questionService.listByQuestionnaire(questionnaireId);
        List<Options> optionsList = optionsService.listByQuestionnaire(questionnaireId);
        QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity(questionnaire);
        List<QuestionEntity> qList = new ArrayList<QuestionEntity>();
        for (Question question : questionList) {
            QuestionEntity questionEntity = new QuestionEntity(question);
            List<Options> oList = new ArrayList<Options>();
            for (Options options : optionsList) {
                if (options.getQuestionId() == question.getId()) {
                    oList.add(options);
                }
            }
            questionEntity.setList(oList);
            qList.add(questionEntity);
        }
        questionnaireEntity.setList(qList);
        return questionnaireEntity;
    }

    @Override
    public List<QClassify> listLeafClassify(Long type) {

        List<Classify> classifyList = listClassify(type);
        List<QClassify> qList = new ArrayList<QClassify>();
        for (Classify classify : classifyList) {
            boolean isLeaf = true;
            for (Classify cal : classifyList) {
                if (cal.getBsid().startsWith(classify.getBsid()) && cal.getId() != classify.getId()) {
                    isLeaf = false;
                    break;
                }
            }
            if (isLeaf) {
                QClassify qc = new QClassify();
                qc.setId(classify.getId());
                qc.setImage(classify.getImage());
                qc.setName(classify.getName());
                qc.setRemark(classify.getRemark());
                qc.setEnable(classify.getEnable());
                qList.add(qc);
            }
        }
        return qList;
    }
}