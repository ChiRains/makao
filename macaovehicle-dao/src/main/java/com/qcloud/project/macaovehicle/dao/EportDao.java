package com.qcloud.project.macaovehicle.dao;

/**
 * 电子口岸对外访问接口
 */
public interface EportDao {

    /**
     * 国检备案
     * @param vehicleId
     * @param driverId
     * @param formInstanceCode
     */
    void ciqPost(Long vehicleId, Long driverId, String formInstanceCode);
    
    /**
     * 海关备案
     * @param vehicleId
     * @param driverId
     * @param formInstanceCode
     */
    void customsPost(Long vehicleId, Long driverId, String formInstanceCode);
}
