package com.qcloud.component.publicdata;

import java.util.List;

public interface QQuestionnaire {

    String getName();

    QQuestion getQuestion(long questionId);

    List<QQuestion> listQuestion();
}
