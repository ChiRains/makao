package com.qcloud.component.file.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.file.web.handler.FileInformationHandler;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.web.vo.FileInformationVO;
import com.qcloud.component.file.web.vo.admin.AdminFileInformationVO;
import com.qcloud.component.filesdk.FileSDKClient;

@Component
public class FileInformationHandlerImpl implements FileInformationHandler {

    @Autowired
    private FileSDKClient fileSDKClient;

    @Override
    public List<FileInformationVO> toVOList(List<FileInformation> list) {

        List<FileInformationVO> voList = new ArrayList<FileInformationVO>();
        for (FileInformation fileInformation : list) {
            voList.add(toVO(fileInformation));
        }
        return voList;
    }

    @Override
    public FileInformationVO toVO(FileInformation fileInformation) {

        String json = Json.toJson(fileInformation);
        return Json.toObject(json, FileInformationVO.class, true);
    }

    @Override
    public List<AdminFileInformationVO> toVOList4Admin(List<FileInformation> list) {

        List<AdminFileInformationVO> voList = new ArrayList<AdminFileInformationVO>();
        for (FileInformation adminFileInformation : list) {
            voList.add(toVO4Admin(adminFileInformation));
        }
        return voList;
    }

    @Override
	public AdminFileInformationVO toVO4Admin(FileInformation fileInformation){
		String json = Json.toJson(fileInformation);
		AdminFileInformationVO vo=Json.toObject(json, AdminFileInformationVO.class, true);
		vo.setUid(fileSDKClient.urlToUid(vo.getUrl()));
		return vo;
	}
}
