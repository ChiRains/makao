package com.qcloud.component.publicdata.web.handler.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.qcloud.pirates.core.json.Json;
import com.qcloud.component.publicdata.web.handler.ImageInformationHandler;
import com.qcloud.component.publicdata.model.ImageInformation;
import com.qcloud.component.publicdata.web.vo.ImageInformationVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminImageInformationVO;

@Component
public class ImageInformationHandlerImpl implements ImageInformationHandler {

	@Override
	public List<ImageInformationVO> toVOList(List<ImageInformation> list){
		List<ImageInformationVO> voList = new ArrayList<ImageInformationVO>();
		for (ImageInformation imageInformation : list) {
			voList.add(toVO(imageInformation));
		}
		return voList;
	}

	@Override
	public ImageInformationVO toVO(ImageInformation imageInformation){
		String json = Json.toJson(imageInformation);
		return Json.toObject(json, ImageInformationVO.class, true);

	}

	@Override
	public List<AdminImageInformationVO> toVOList4Admin(List<ImageInformation> list){
		List<AdminImageInformationVO> voList = new ArrayList<AdminImageInformationVO>();
		for (ImageInformation adminImageInformation : list) {
			voList.add(toVO4Admin(adminImageInformation));
		}
		return voList;
	}

	@Override
	public AdminImageInformationVO toVO4Admin(ImageInformation imageInformation){
		String json = Json.toJson(imageInformation);
		return Json.toObject(json, AdminImageInformationVO.class, true);
	}
}
