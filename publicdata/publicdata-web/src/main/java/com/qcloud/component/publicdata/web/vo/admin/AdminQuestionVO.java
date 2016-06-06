package com.qcloud.component.publicdata.web.vo.admin;

import java.util.Date;
import java.math.BigDecimal;

public class AdminQuestionVO {
	
	private long id;		
	
	private long questionnaireId;		
	
	private String questionnaireName;
	
	//题目名称
	private String name;		
	
	//选项序号编码
	private String serialNumber;		
	
	//排序
	private int sort;		
	
	//类型
	private int type;	
	
	private String typeStr;
	

	public AdminQuestionVO(){
	
	}

	public AdminQuestionVO(long id,long questionnaireId,String name,String serialNumber,int sort,int type){
		this.id = id;		
		this.questionnaireId = questionnaireId;		
		this.name = name;		
		this.serialNumber = serialNumber;		
		this.sort = sort;		
		this.type = type;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setQuestionnaireId(long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public long getQuestionnaireId() {
		return questionnaireId;
	}	
		
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}	
		
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getSerialNumber() {
		return serialNumber;
	}	
		
	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return sort;
	}	
		
	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

    
    public String getQuestionnaireName() {
    
        return questionnaireName;
    }

    
    public void setQuestionnaireName(String questionnaireName) {
    
        this.questionnaireName = questionnaireName;
    }

    
    public String getTypeStr() {
    
        return typeStr;
    }

    
    public void setTypeStr(String typeStr) {
    
        this.typeStr = typeStr;
    }	
		
}
