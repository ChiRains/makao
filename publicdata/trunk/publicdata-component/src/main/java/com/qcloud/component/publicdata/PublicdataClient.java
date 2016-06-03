package com.qcloud.component.publicdata;

import java.util.List;
import java.util.Map;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.Classify;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.model.Province;

public interface PublicdataClient {

    List<String> listProvince();

    List<Province> listAllProvince();

    Province getProvince(Long provinceId);

    List<String> listCity(String provinceName);

    List<City> listAllCity(String provinceName);

    List<City> listAllCity();

    City getCity(Long cityId);

    District getDistrict(Long districtId);

    Map<Long, List<City>> listAllCityMap();

    List<String> listDistrict(String cityName);

    List<District> listAllDistrict(String cityName);

    List<Classify> listClassify(ClassifyType type);

    List<Classify> listClassify(Long type);

    List<QClassify> listClassifyForTree(Long type);

    List<QClassify> listLeafClassify(Long type);

    List<QClassify> listTopClassify(Long type);

    List<QClassify> listClassifyForTreeByParent(Long parentId, Long type);

    List<QClassify> listClassifyForTree(ClassifyType type);

    Classify getClassify(Long id);

    Classify getTopClassify(Long id);

    List<Classify> listParentClassifyIncludeMe(Long id);

    List<Classify> listParentClassify(Long id);

    List<KeyValueVO> listDataDictionaryByType(String type);

    String getDataDictionary(String type, int key);

    // 转换工具方法
    List<KeyValueVO> exchageStr(List<String> strList, String key, String message);

    List<KeyValueVO> exchageObj(List<IntKeyValue> kvList, long key, String message);

    List<KeyValueVO> exchageObj(List<StrKeyValue> kvList, String key, String message);

    List<KeyValueVO> exchageObj(IntKeyValue[] kvs, long key, String message);

    List<KeyValueVO> exchageObj(StrKeyValue[] kvs, String key, String message);

    List<KeyValueVO> exchageStrSpec(List<String> strList, String key, String message, Long attrIdStr);

    // 转换工具方法
    boolean addClassify(Classify classify);

    boolean update(Classify classify);

    boolean delete(Long id);

    // boolean sort(Long id, int sort);
    //
    // boolean enable(Long id, int enable);
    String getImageInformationByCode(String code);

    boolean setImageInformationByCode(ImageInformation imageInformation);

    KeyValueVO getDataDictionaryByKey(String type, Long key);

    Express getExpressByCode(String code);

    boolean addSearch(int type, String keywords);

    List<String> listHotSearch(int type, int number);

    QQuestionnaire getQuestionnaire(long questionnaireId);
}