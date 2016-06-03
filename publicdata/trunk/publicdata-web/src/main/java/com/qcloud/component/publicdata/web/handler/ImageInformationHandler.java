package com.qcloud.component.publicdata.web.handler;

import java.util.List;

import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.web.vo.ImageInformationVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminImageInformationVO;

public interface ImageInformationHandler {

	List<ImageInformationVO> toVOList(List<ImageInformation> list);

	ImageInformationVO toVO(ImageInformation imageInformation);

	List<AdminImageInformationVO> toVOList4Admin(List<ImageInformation> list);

	AdminImageInformationVO toVO4Admin(ImageInformation imageInformation);
}
