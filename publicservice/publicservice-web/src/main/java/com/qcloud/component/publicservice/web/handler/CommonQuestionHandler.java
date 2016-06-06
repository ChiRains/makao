package com.qcloud.component.publicservice.web.handler;

import java.util.List;

import com.qcloud.component.publicservice.model.CommonQuestion;
import com.qcloud.component.publicservice.web.vo.CommonQuestionVO;
import com.qcloud.component.publicservice.web.vo.admin.AdminCommonQuestionVO;

public interface CommonQuestionHandler {

	List<CommonQuestionVO> toVOList(List<CommonQuestion> list);

	CommonQuestionVO toVO(CommonQuestion commonQuestion);

	List<AdminCommonQuestionVO> toVOList4Admin(List<CommonQuestion> list);

	AdminCommonQuestionVO toVO4Admin(CommonQuestion commonQuestion);
}
