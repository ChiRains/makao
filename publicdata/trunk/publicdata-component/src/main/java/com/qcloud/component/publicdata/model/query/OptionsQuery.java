package com.qcloud.component.publicdata.model.query;

public class OptionsQuery {
    
    private long questionnaireId;
    
    private long questionId;

	public OptionsQuery(){
	
	}

    
    public long getQuestionnaireId() {
    
        return questionnaireId;
    }

    
    public void setQuestionnaireId(long questionnaireId) {
    
        this.questionnaireId = questionnaireId;
    }

    
    public long getQuestionId() {
    
        return questionId;
    }

    
    public void setQuestionId(long questionId) {
    
        this.questionId = questionId;
    }
}
