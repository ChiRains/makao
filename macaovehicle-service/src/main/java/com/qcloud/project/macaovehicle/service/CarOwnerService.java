package com.qcloud.project.macaovehicle.service;

import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.LoginForm;
import com.qcloud.project.macaovehicle.model.query.CarOwnerQuery;

public interface CarOwnerService {

    public boolean add(CarOwner carOwner);

    public CarOwner get(Long id);

    public boolean delete(Long id);

    public boolean update(CarOwner carOwner);

    public Page<CarOwner> page(CarOwnerQuery query, int start, int count);

    public List<CarOwner> listAll();

    boolean add(String mobile, String name, String password, int sex, String email, String idCard, CarOwner carOwner, CarOwnerWorkers workers, CarOwnerHousers housers, CarOwnerEnterprisers enterprisers, CarOwnerAcquisition carOwnerAcquisition);

    public CarOwner getByClerk(Long clerkId);

    public CarOwner getByIdcardNumber(String idcardNumber);

    public long add(LoginForm form);

    public boolean update(CarOwner carOwner, CarOwnerWorkers workers, CarOwnerHousers housers, CarOwnerEnterprisers enterprisers, CarOwnerTalent talent, CarOwnerPurchase purchase, CarOwnerAcquisition carOwnerAcquisition);
}
