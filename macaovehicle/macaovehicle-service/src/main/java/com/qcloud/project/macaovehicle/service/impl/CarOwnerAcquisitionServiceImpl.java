package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.dao.CarOwnerAcquisitionDao;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.model.query.CarOwnerAcquisitionQuery;

@Service
public class CarOwnerAcquisitionServiceImpl implements CarOwnerAcquisitionService {

    @Autowired
    private CarOwnerAcquisitionDao carOwnerAcquisitionDao;

    @Autowired
    private AutoIdGenerator        autoIdGenerator;

    @Autowired
    private FileSDKClient          fileSDKClient;

    private static final String    ID_KEY = "macaovehicle_car_owner_acquisition";

    @Override
    public boolean add(CarOwnerAcquisition carOwnerAcquisition) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwnerAcquisition.setId(id);
        if (carOwnerAcquisition.getContractUrls().size() > 0) {
            String contractUrls = "";
            for (String contractUrl : carOwnerAcquisition.getContractUrls()) {
                contractUrls = contractUrls + fileSDKClient.uidToUrl(contractUrl) + ",";
            }
            if (!StringUtils.isEmpty(contractUrls)) {
                contractUrls = contractUrls.substring(0, contractUrls.length() - 1);
            }
            carOwnerAcquisition.setContractUrl(contractUrls);
        }
        return carOwnerAcquisitionDao.add(carOwnerAcquisition);
    }

    @Override
    public CarOwnerAcquisition get(Long id) {

        return carOwnerAcquisitionDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerAcquisitionDao.delete(id);
    }

    @Override
    public boolean update(CarOwnerAcquisition carOwnerAcquisition) {

        if (carOwnerAcquisition.getContractUrls().size() > 0) {
            String contractUrls = "";
            for (String contractUrl : carOwnerAcquisition.getContractUrls()) {
                contractUrls = contractUrls + fileSDKClient.uidToUrl(contractUrl) + ",";
            }
            if (!StringUtils.isEmpty(contractUrls)) {
                contractUrls = contractUrls.substring(0, contractUrls.length() - 1);
            }
            carOwnerAcquisition.setContractUrl(contractUrls);
        }
        return carOwnerAcquisitionDao.update(carOwnerAcquisition);
    }

    @Override
    public Page<CarOwnerAcquisition> page(CarOwnerAcquisitionQuery query, int start, int count) {

        return carOwnerAcquisitionDao.page(query, start, count);
    }

    public List<CarOwnerAcquisition> listAll() {

        return carOwnerAcquisitionDao.listAll();
    }

    @Override
    public CarOwnerAcquisition getByCarOwner(Long carOwnerId) {

        return carOwnerAcquisitionDao.getByCarOwner(carOwnerId);
    }
}
