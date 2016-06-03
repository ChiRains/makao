package com.qcloud.component.publicdata.entity;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.component.publicdata.QQuestion;
import com.qcloud.component.publicdata.QQuestionnaire;
import com.qcloud.component.publicdata.model.Questionnaire;

public class QuestionnaireEntity implements QQuestionnaire {

    private Questionnaire        questionnaire;

    private List<QuestionEntity> list = new ArrayList<QuestionEntity>();

    public QuestionnaireEntity(Questionnaire questionnaire) {

        super();
        this.questionnaire = questionnaire;
    }

    public Questionnaire getQuestionnaire() {

        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {

        this.questionnaire = questionnaire;
    }

    public List<QuestionEntity> getList() {

        return list;
    }

    public void setList(List<QuestionEntity> list) {

        this.list = list;
    }

    @Override
    public String getName() {

        return questionnaire.getName();
    }

    @Override
    public List<QQuestion> listQuestion() {

        return new ArrayList<QQuestion>(getList());
    }

    @Override
    public QQuestion getQuestion(long questionId) {

        for (QuestionEntity question : getList()) {
            if (question.getQuestion().getId() == questionId) {
                return question;
            }
        }
        return null;
    }
}
