package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.web.vo.ExpressVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressVO;

public interface ExpressHandler {

	List<ExpressVO> toVOList(List<Express> list);

	ExpressVO toVO(Express express);

	List<AdminExpressVO> toVOList4Admin(List<Express> list);

	AdminExpressVO toVO4Admin(Express express);
}
