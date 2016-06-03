package com.qcloud.project.macaovehicle.web.form;

import java.util.ArrayList;
import java.util.List;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.LoginForm;
import com.qcloud.project.macaovehicle.model.Vehicle;

public class AllCarOwnerForm {

    private LoginForm    loginForm;

    private Vehicle      vehicle;

    private List<Driver> driver = new ArrayList<Driver>();

    public LoginForm getLoginForm() {

        return loginForm;
    }

    public List<Driver> getDriver() {

        return driver;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public void setLoginForm(LoginForm loginForm) {

        this.loginForm = loginForm;
    }

    public void setDriver(List<Driver> driver) {

        this.driver = driver;
    }

    public void setVehicle(Vehicle vehicle) {

        this.vehicle = vehicle;
    }
}
