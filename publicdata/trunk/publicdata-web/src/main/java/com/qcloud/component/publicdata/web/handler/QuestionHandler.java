package com.qcloud.component.publicdata.web.handler;

import java.util.List;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.component.publicdata.web.vo.QuestionVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminQuestionVO;

public interface QuestionHandler {

    List<QuestionVO> toVOList(List<Question> list, List<Options> optionsList);

    List<QuestionVO> toVOList(List<Question> list);

    QuestionVO toVO(Question question);

    List<AdminQuestionVO> toVOList4Admin(List<Question> list);

    AdminQuestionVO toVO4Admin(Question question);
}
