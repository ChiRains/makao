package com.qcloud.project.macaovehicle.web.form;

public class HistoryRecordsForm {

    private HistoryCarOwnerForm     carOwner;

    private HistoryEnterprisersForm enterprisers;

    private HistoryWorkersForm      workers;

    private HistoryHousersForm      housers;

    private HistoryTalentForm       talent;

    private HistoryAcquisitionForm  acquisition;

    public HistoryCarOwnerForm getCarOwner() {

        return carOwner;
    }

    public void setCarOwner(HistoryCarOwnerForm carOwner) {

        this.carOwner = carOwner;
    }

    public HistoryEnterprisersForm getEnterprisers() {

        return enterprisers;
    }

    public void setEnterprisers(HistoryEnterprisersForm enterprisers) {

        this.enterprisers = enterprisers;
    }

    public HistoryWorkersForm getWorkers() {

        return workers;
    }

    public void setWorkers(HistoryWorkersForm workers) {

        this.workers = workers;
    }

    public HistoryHousersForm getHousers() {

        return housers;
    }

    public void setHousers(HistoryHousersForm housers) {

        this.housers = housers;
    }

    public HistoryTalentForm getTalent() {

        return talent;
    }

    public void setTalent(HistoryTalentForm talent) {

        this.talent = talent;
    }

    public HistoryAcquisitionForm getAcquisition() {

        return acquisition;
    }

    public void setAcquisition(HistoryAcquisitionForm acquisition) {

        this.acquisition = acquisition;
    }
}
