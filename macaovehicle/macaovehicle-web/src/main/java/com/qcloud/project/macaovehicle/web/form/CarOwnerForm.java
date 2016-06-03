package com.qcloud.project.macaovehicle.web.form;

import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;

public class CarOwnerForm {

    private CarOwner             carOwner;

    private CarOwnerWorkers      carOwnerWorkers;

    private CarOwnerEnterprisers enterprisers;

    private CarOwnerWorkers      workers;

    private CarOwnerHousers      housers;

    private CarOwnerTalent       talent;

    private CarOwnerAcquisition  acquisition;

    public CarOwnerWorkers getCarOwnerWorkers() {

        return carOwnerWorkers;
    }

    public CarOwnerEnterprisers getEnterprisers() {

        return enterprisers;
    }

    public CarOwnerWorkers getWorkers() {

        return workers;
    }

    public CarOwnerHousers getHousers() {

        return housers;
    }

    public CarOwnerTalent getTalent() {

        return talent;
    }

    public CarOwnerAcquisition getAcquisition() {

        return acquisition;
    }

    public void setCarOwnerWorkers(CarOwnerWorkers carOwnerWorkers) {

        this.carOwnerWorkers = carOwnerWorkers;
    }

    public void setEnterprisers(CarOwnerEnterprisers enterprisers) {

        this.enterprisers = enterprisers;
    }

    public void setWorkers(CarOwnerWorkers workers) {

        this.workers = workers;
    }

    public void setHousers(CarOwnerHousers housers) {

        this.housers = housers;
    }

    public void setTalent(CarOwnerTalent talent) {

        this.talent = talent;
    }

    public void setAcquisition(CarOwnerAcquisition acquisition) {

        this.acquisition = acquisition;
    }

    public CarOwner getCarOwner() {

        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {

        this.carOwner = carOwner;
    }
}
