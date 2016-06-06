package com.qcloud.component.file;



public interface FileClient {

    public String getUrlByCode(String code);
    
//    public FileInformation getByCode(String code);
    
    public boolean regUrlByCode(String code,String url);
}