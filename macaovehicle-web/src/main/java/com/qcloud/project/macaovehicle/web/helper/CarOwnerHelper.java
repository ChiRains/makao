package com.qcloud.project.macaovehicle.web.helper;

import org.springframework.stereotype.Component;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;

@Component
public class CarOwnerHelper {

    /** 个人-务工可用车辆 */
    public final int PERSON_WORKERS        = 1;

    /** 个人-购房可用车辆 */
    public final int PERSON_HOUSERS        = 2;

    /** 个人-高级人才可用车辆 */
    public final int PERSON_TALENT         = 1;

    /** 个人-购地可用车辆 */
    public final int PERSON_ACQUISITION    = 5;

    /** 企业-投资可用车辆 */
    public final int BUSINESS_ENTERPRISERS = 5;

    /** 企业-购地可用车辆 */
    public final int BUSINESS_ACQUISITION  = 5;

    public int getAvailVehicle(int clerkType, int type) {

        int availCount = 0;
        if (clerkType == OwnerType.PERSON.getKey()) {
            if (type == UserType.WORKERS.getKey()) availCount = PERSON_WORKERS;
            if (type == UserType.HOUSERS.getKey()) availCount = PERSON_HOUSERS;
            if (type == UserType.TALENT.getKey()) availCount = PERSON_TALENT;
            if (type == UserType.ACQUISITION.getKey()) availCount = PERSON_ACQUISITION;
        } else if (clerkType == OwnerType.BUSINESS.getKey()) {
            if (type == UserType.ENTERPRISERS.getKey()) availCount = BUSINESS_ENTERPRISERS;
            if (type == UserType.ACQUISITION.getKey()) availCount = BUSINESS_ACQUISITION;
        }
        return availCount;
    }
}
