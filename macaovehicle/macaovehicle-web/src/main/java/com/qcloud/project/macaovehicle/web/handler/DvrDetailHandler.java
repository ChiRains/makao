package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DvrDetail;
import com.qcloud.project.macaovehicle.web.vo.DvrDetailVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrDetailVO;

public interface DvrDetailHandler {

	List<DvrDetailVO> toVOList(List<DvrDetail> list);

	DvrDetailVO toVO(DvrDetail dvrDetail);

	List<AdminDvrDetailVO> toVOList4Admin(List<DvrDetail> list);

	AdminDvrDetailVO toVO4Admin(DvrDetail dvrDetail);
}
