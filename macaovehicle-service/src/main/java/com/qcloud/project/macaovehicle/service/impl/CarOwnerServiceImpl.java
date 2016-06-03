package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.dao.CarOwnerDao;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.LoginForm;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerPurchaseService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

    @Value("${macaovehicle.carOwner.department}")
    private long                        MacaoUserDepartmentId;

    @Value("${macaovehicle.carOwner.post}")
    private long                        MacaoUserPostId;

    @Autowired
    private CarOwnerDao                 carOwnerDao;

    @Autowired
    private AutoIdGenerator             autoIdGenerator;

    @Autowired
    private CarOwnerWorkersService      carOwnerWorkersService;

    @Autowired
    private CarOwnerHousersService      carOwnerHousersService;

    @Autowired
    private CarOwnerEnterprisersService carOwnerEnterprisersService;

    @Autowired
    private OrganizationClient          organizationClient;

    @Autowired
    private FileSDKClient               fileSDKClient;

    @Autowired
    private CarOwnerTalentService       carOwnerTalentService;

    @Autowired
    private CarOwnerPurchaseService     carOwnerPurchaseService;

    @Autowired
    private CarOwnerAcquisitionService  carOwnerAcquisitionService;

    private static final String         ID_KEY = "macaovehicle_car_owner";

    @Override
    public boolean add(CarOwner carOwner) {

        long id = autoIdGenerator.get(ID_KEY);
        carOwner.setId(id);
        return carOwnerDao.add(carOwner);
    }

    @Override
    public CarOwner get(Long id) {

        return carOwnerDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return carOwnerDao.delete(id);
    }

    @Override
    public boolean update(CarOwner carOwner) {

        return carOwnerDao.update(carOwner);
    }

    @Override
    public Page<CarOwner> page(CarOwnerQuery query, int start, int count) {

        return carOwnerDao.page(query, start, count);
    }

    public List<CarOwner> listAll() {

        return carOwnerDao.listAll();
    }

    @Transactional
    @Override
    public boolean add(String mobile, String name, String password, int sex, String email, String idCard, CarOwner carOwner, CarOwnerWorkers workers, CarOwnerHousers housers, CarOwnerEnterprisers enterprisers, CarOwnerAcquisition carOwnerAcquisition) {

        // if (carOwner.getType() == UserType.WORKERS.getKey()) {
        // AssertUtil.assertNotNull(workers, "单位信息不能为空");
        // }
        // if (carOwner.getType() == UserType.HOUSERS.getKey()) {
        // AssertUtil.assertNotNull(housers, "房屋信息不能为空");
        // }
        // if (carOwner.getType() == UserType.ENTERPRISERS.getKey()) {
        // AssertUtil.assertNotNull(enterprisers, "企业信息不能为空");
        // }
        // if (carOwner.getType() == UserType.ACQUISITION.getKey()) {
        // AssertUtil.assertNotNull(carOwnerAcquisition, "购地信息不能为空");
        // }
        // Long clerkId = organizationClient.registClerk(name, mobile, MacaoUserDepartmentId, email, carOwner.getIdcardNumber(), password);
        // organizationClient.setSex(clerkId, sex);
        // organizationClient.setClerkPost(clerkId, MacaoUserPostId);
        // carOwner.setUserId(clerkId);
        // if (add(carOwner)) {
        // Long carOwnerId = carOwner.getId();
        // if (carOwner.getType() == UserType.WORKERS.getKey()) {
        // workers.setCarOwnerId(carOwnerId);
        // workers.setWorkCertificate(fileSDKClient.uidToUrl(workers.getWorkCertificate()));
        // return carOwnerWorkersService.add(workers);
        // } else if (carOwner.getType() == UserType.HOUSERS.getKey()) {
        // housers.setCarOwnerId(carOwnerId);
        // return carOwnerHousersService.add(housers);
        // } else if (carOwner.getType() == UserType.ENTERPRISERS.getKey()) {
        // enterprisers.setLicense(fileSDKClient.uidToUrl(enterprisers.getLicense()));
        // enterprisers.setCarOwnerId(carOwnerId);
        // return carOwnerEnterprisersService.add(enterprisers);
        // }else if(carOwner.getType()==UserType.ACQUISITION.getKey())
        // {
        // carOwnerAcquisition.setCarOwnerId(carOwnerId);
        // return carOwnerAcquisitionService.add(carOwnerAcquisition);
        // }
        // }
        return false;
    }

    @Override
    public CarOwner getByClerk(Long clerkId) {

        return carOwnerDao.getByClerk(clerkId);
    }

    @Override
    public CarOwner getByIdcardNumber(String idcardNumber) {

        return carOwnerDao.getByIdcardNumber(idcardNumber);
    }

    @Transactional
    @Override
    public long add(LoginForm form) {

        // 车主信息
        CarOwner carOwner = new CarOwner();
        carOwner.setResidence(form.getResidence());
        carOwner.setIdcardNumber(form.getIdcardNumber());
        carOwner.setIdcardFace(fileSDKClient.uidToUrl(form.getIdcardFace()));
        carOwner.setIdcardBack(fileSDKClient.uidToUrl(form.getIdcardBack()));
        carOwner.setAddress(form.getAddress());
        carOwner.setType(form.getType());
        carOwner.setBirthday(form.getBirthday());
        carOwner.setEmail(form.getEmail());
        carOwner.setMobile(form.getMobile());
        carOwner.setClerkType(form.getClerkType());
        // 注册类型 :1个人2企业
        if (OwnerType.BUSINESS.getKey() == form.getClerkType()) {
            form.setMobile(form.getMobile() + OwnerType.BUSINESS.getKey());
            form.setEmail(form.getEmail() + OwnerType.BUSINESS.getKey());
        } else if (OwnerType.PERSON.getKey() == form.getClerkType()) {
            form.setMobile(form.getMobile() + OwnerType.PERSON.getKey());
            form.setEmail(form.getEmail() + OwnerType.PERSON.getKey());
        } else {
            throw new MacaovehicleException("注册类型不正确");
        }
        // 注册用户
        if (!organizationClient.existByMobile(form.getMobile())) {
            throw new MacaovehicleException("手机号已经使用." + carOwner.getMobile());
        }
        if (!organizationClient.existByJobEmail(form.getEmail())) {
            throw new MacaovehicleException("邮箱号已经使用." + carOwner.getEmail());
        }
        //
        Long clerkId = organizationClient.registClerk(form.getName(), form.getMobile(), MacaoUserDepartmentId, form.getEmail(), carOwner.getIdcardNumber(), form.getPassword());
        organizationClient.setSex(clerkId, form.getSex());
        organizationClient.setClerkPost(clerkId, MacaoUserPostId);
        carOwner.setUserId(clerkId);
        add(carOwner);
        return carOwner.getId();
    }

    @Transactional
    @Override
    public boolean update(CarOwner carOwner, CarOwnerWorkers workers, CarOwnerHousers housers, CarOwnerEnterprisers enterprisers, CarOwnerTalent talent, CarOwnerPurchase purchase, CarOwnerAcquisition carOwnerAcquisition) {

        organizationClient.setName(carOwner.getUserId(), carOwner.getName());
        if (carOwner.getClerkType() == TypeEnum.OwnerType.PERSON.getKey()) {
            if (carOwner.getType() == TypeEnum.UserType.WORKERS.getKey()) {
                CarOwnerWorkers temp = carOwnerWorkersService.getByCarOwner(carOwner.getId());
                workers.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerWorkersService.add(workers);
                } else {
                    workers.setId(temp.getId());
                    carOwnerWorkersService.update(workers);
                }
            }
            if (carOwner.getType() == TypeEnum.UserType.HOUSERS.getKey()) {
                CarOwnerHousers temp = carOwnerHousersService.getByCarOwner(carOwner.getId());
                housers.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerHousersService.add(housers);
                } else {
                    housers.setId(temp.getId());
                    carOwnerHousersService.update(housers);
                }
            }
            if (carOwner.getType() == TypeEnum.UserType.TALENT.getKey()) {
                CarOwnerTalent temp = carOwnerTalentService.getByCarOwner(carOwner.getId());
                talent.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerTalentService.add(talent);
                } else {
                    talent.setId(temp.getId());
                    carOwnerTalentService.update(talent);
                }
            }
            if (carOwner.getType() == TypeEnum.UserType.ACQUISITION.getKey()) {
                CarOwnerAcquisition temp = carOwnerAcquisitionService.getByCarOwner(carOwner.getId());
                carOwnerAcquisition.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerAcquisitionService.add(carOwnerAcquisition);
                } else {
                    carOwnerAcquisition.setId(temp.getId());
                    carOwnerAcquisitionService.update(carOwnerAcquisition);
                }
            }
        }
        if (carOwner.getClerkType() == TypeEnum.OwnerType.BUSINESS.getKey()) {
            if (carOwner.getType() == TypeEnum.UserType.ENTERPRISERS.getKey()) {
                CarOwnerEnterprisers temp = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
                enterprisers.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerEnterprisersService.add(enterprisers);
                } else {
                    enterprisers.setId(temp.getId());
                    carOwnerEnterprisersService.update(enterprisers);
                }
            }
            if (carOwner.getType() == TypeEnum.UserType.ACQUISITION.getKey() && carOwner.getClerkType() == 2) {
                CarOwnerAcquisition temp = carOwnerAcquisitionService.getByCarOwner(carOwner.getId());
                carOwnerAcquisition.setCarOwnerId(carOwner.getId());
                CarOwnerEnterprisers temp1 = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
                enterprisers.setCarOwnerId(carOwner.getId());
                if (temp == null) {
                    carOwnerEnterprisersService.add(enterprisers);
                    carOwnerAcquisitionService.add(carOwnerAcquisition);
                } else {
                    enterprisers.setId(temp1.getId());
                    carOwnerEnterprisersService.update(enterprisers);
                    carOwnerAcquisition.setId(temp.getId());
                    carOwnerAcquisitionService.update(carOwnerAcquisition);
                }
            }
        }
        return carOwnerDao.update(carOwner);
    }
}
