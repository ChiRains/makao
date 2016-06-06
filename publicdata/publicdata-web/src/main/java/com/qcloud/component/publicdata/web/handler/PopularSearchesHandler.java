package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.PopularSearches;
import com.qcloud.component.publicdata.web.vo.PopularSearchesVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminPopularSearchesVO;

public interface PopularSearchesHandler {

	List<PopularSearchesVO> toVOList(List<PopularSearches> list);

	PopularSearchesVO toVO(PopularSearches popularSearches);

	List<AdminPopularSearchesVO> toVOList4Admin(List<PopularSearches> list);

	AdminPopularSearchesVO toVO4Admin(PopularSearches popularSearches);
}
