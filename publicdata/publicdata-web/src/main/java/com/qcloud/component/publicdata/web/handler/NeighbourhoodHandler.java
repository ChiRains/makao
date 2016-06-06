package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.Neighbourhood;
import com.qcloud.component.publicdata.web.vo.NeighbourhoodVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminNeighbourhoodVO;

public interface NeighbourhoodHandler {

	List<NeighbourhoodVO> toVOList(List<Neighbourhood> list);

	NeighbourhoodVO toVO(Neighbourhood neighbourhood);

	List<AdminNeighbourhoodVO> toVOList4Admin(List<Neighbourhood> list);

	AdminNeighbourhoodVO toVO4Admin(Neighbourhood neighbourhood);
}
