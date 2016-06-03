package com.qcloud.component.publicservice.web.vo;

import java.util.Date;
import java.math.BigDecimal;

public class CommonQuestionVO {
	
	private long id;		
	
	//问题
	private String title;		
	
	//回答
	private String answer;		
	
	//排序
	private int sort;		
	
	//生成日期
    private Date time;
    
    private String timeStr;

	public CommonQuestionVO(){
	
	}

	public CommonQuestionVO(long id,String title,String answer,int sort){
		this.id = id;		
		this.title = title;		
		this.answer = answer;		
		this.sort = sort;		
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	
		
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}	
		
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}	
		
	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getSort() {
		return sort;
	}

    
    public Date getTime() {
    
        return time;
    }

    
    public void setTime(Date time) {
    
        this.time = time;
    }

    
    public String getTimeStr() {
    
        return timeStr;
    }

    
    public void setTimeStr(String timeStr) {
    
        this.timeStr = timeStr;
    }	
		
}
