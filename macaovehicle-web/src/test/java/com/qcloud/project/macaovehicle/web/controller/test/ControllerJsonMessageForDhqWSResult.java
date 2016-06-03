package com.qcloud.project.macaovehicle.web.controller.test;

import java.io.Serializable;

/**
 * 
 * @author morgan.tan
 * 描述：大横琴 WS json 返回结果类
 */
public class ControllerJsonMessageForDhqWSResult implements Serializable{

	private static final long serialVersionUID = 1L;

	private int status;
	
	private String message;
	
//	private ControllerJsonMessageForDhqWSResultData data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public ControllerJsonMessageForDhqWSResultData getData() {
//        return data;
//    }
//
//    public void setData(ControllerJsonMessageForDhqWSResultData data) {
//        this.data = data;
//    }
	
}
