package com.qcloud.component.publicdata.entity;

import java.util.List;
import com.qcloud.component.publicdata.QQuestion;
import com.qcloud.component.publicdata.model.Options;
import com.qcloud.component.publicdata.model.Question;
import com.qcloud.pirates.util.StringUtil;

public class QuestionEntity implements QQuestion {

    private Question      question;

    private List<Options> list;

    public QuestionEntity(Question question) {

        super();
        this.question = question;
    }

    public Question getQuestion() {

        return question;
    }

    public void setQuestion(Question question) {

        this.question = question;
    }

    public List<Options> getList() {

        return list;
    }

    public void setList(List<Options> list) {

        this.list = list;
    }

    @Override
    public String getName() {

        return question.getName();
    }

    @Override
    public String getAnswer(String answer) {

        answer = StringUtil.nullToEmpty(answer).trim();
        if (question.getType() == 1) {
            for (Options op : list) {
                if (op.getSerialNumber().equals(answer)) {
                    return op.getSerialNumber() + ". " + op.getContent();
                }
            }
        }
        if (question.getType() == 2) {
            StringBuffer sb = new StringBuffer();
            String[] ow = answer.split(";");
            for (String str : ow) {
                for (Options op : list) {
                    if (op.getSerialNumber().equals(str)) {
                        sb.append(op.getSerialNumber() + ". " + op.getContent());
                        break;
                    }
                }
            }
            return sb.toString();
        }
        if (question.getType() == 3 || question.getType() == 4) {
            return StringUtil.nullToEmpty(answer);
        }
        return answer;
    }
}
