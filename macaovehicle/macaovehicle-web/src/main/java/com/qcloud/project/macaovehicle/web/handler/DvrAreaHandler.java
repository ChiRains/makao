package com.qcloud.project.macaovehicle.web.handler;

import java.util.List;

import com.qcloud.project.macaovehicle.model.DvrArea;
import com.qcloud.project.macaovehicle.web.vo.DvrAreaVO;
import com.qcloud.project.macaovehicle.web.vo.admin.AdminDvrAreaVO;

public interface DvrAreaHandler {

	List<DvrAreaVO> toVOList(List<DvrArea> list);

	DvrAreaVO toVO(DvrArea dvrArea);

	List<AdminDvrAreaVO> toVOList4Admin(List<DvrArea> list);

	AdminDvrAreaVO toVO4Admin(DvrArea dvrArea);
}
