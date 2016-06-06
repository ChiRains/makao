package com.qcloud.component.file.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.file.FileClient;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.service.FileInformationService;
import com.qcloud.pirates.util.AssertUtil;

@Service
public class FileClientImpl implements FileClient {

    @Autowired
    private FileInformationService fileInformationService;

    @Override
    public String getUrlByCode(String code) {
        AssertUtil.assertNotNull(code, "文件编码不能为空");    
        FileInformation fileInformation = fileInformationService.getByCode(code);
        if (fileInformation == null) {
            return "";
        } else {
            return fileInformation.getUrl();
        }
    }

    @Override
    public boolean regUrlByCode(String code, String url) {
        AssertUtil.assertNotNull(code, "文件编码不能为空");    
        FileInformation fileInformation = fileInformationService.getByCode(code);
        AssertUtil.assertNotNull(fileInformation, "文件不存在");   
        fileInformation.setUrl(url);
        return fileInformationService.update(fileInformation);
    }
}