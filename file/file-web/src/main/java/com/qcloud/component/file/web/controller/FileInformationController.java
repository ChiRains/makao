package com.qcloud.component.file.web.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.file.FileClient;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;

@Controller
@RequestMapping(value = FileInformationController.DIR)
public class FileInformationController {

    public static final String DIR = "/fileInformation";

    @Autowired
    private FileClient         fileClient;

    @Autowired
    private FileSDKClient      fileSDKClient;
    
    private Log logger=LogFactory.getLog(getClass());

    // 后端在使用
    @RequestMapping
    public FrontAjaxView get(String code) {
        logger.info("开始调用查看获取图片");
        
        AssertUtil.assertNotNull(code, "文件码不能为空.");
        String fileUrl = fileClient.getUrlByCode(code);
        fileUrl = StringUtils.isEmpty(fileUrl) ? "" : fileSDKClient.getFileServerUrl() + fileUrl;
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("url", fileUrl);
        logger.info("code==========" +code);
        logger.info("url==========" +fileUrl);
        return frontAjaxView;
    }
}
