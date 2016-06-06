package com.qcloud.component.file.web.handler;

import java.util.List;

import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.web.vo.FileInformationVO;
import com.qcloud.component.file.web.vo.admin.AdminFileInformationVO;

public interface FileInformationHandler {

	List<FileInformationVO> toVOList(List<FileInformation> list);

	FileInformationVO toVO(FileInformation fileInformation);

	List<AdminFileInformationVO> toVOList4Admin(List<FileInformation> list);

	AdminFileInformationVO toVO4Admin(FileInformation fileInformation);
}
