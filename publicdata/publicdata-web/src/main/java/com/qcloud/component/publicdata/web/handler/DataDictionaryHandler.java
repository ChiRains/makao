package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.DataDictionary;
import com.qcloud.component.publicdata.web.vo.DataDictionaryVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminDataDictionaryVO;

public interface DataDictionaryHandler {

	List<DataDictionaryVO> toVOList(List<DataDictionary> list);

	DataDictionaryVO toVO(DataDictionary dataDictionary);

	List<AdminDataDictionaryVO> toVOList4Admin(List<DataDictionary> list);

	AdminDataDictionaryVO toVO4Admin(DataDictionary dataDictionary);
}
