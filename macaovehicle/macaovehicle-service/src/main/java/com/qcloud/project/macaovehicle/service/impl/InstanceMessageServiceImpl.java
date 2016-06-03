package com.qcloud.project.macaovehicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.project.macaovehicle.dao.DriverDao;
import com.qcloud.project.macaovehicle.dao.DriverVehicleDao;
import com.qcloud.project.macaovehicle.dao.InstanceMessageDao;
import com.qcloud.project.macaovehicle.dao.VehicleDao;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.InstanceMessage;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.MessageType;
import com.qcloud.project.macaovehicle.model.query.InstanceMessageQuery;
import com.qcloud.project.macaovehicle.service.InstanceMessageService;

@Service
public class InstanceMessageServiceImpl implements InstanceMessageService {

    @Autowired
    private InstanceMessageDao  instanceMessageDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private ParameterClient     parameterClient;

    @Autowired
    private DriverVehicleDao    driverVehicleDao;

    @Autowired
    private DriverDao           driverDao;

    @Autowired
    private VehicleDao          vehicleDao;

    private static final String ID_KEY = "macaovehicle_instance_message";

    @Override
    public boolean add(InstanceMessage instanceMessage) {

        long id = autoIdGenerator.get(ID_KEY);
        instanceMessage.setId(id);
        return instanceMessageDao.add(instanceMessage);
    }

    @Override
    public InstanceMessage get(Long id) {

        return instanceMessageDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return instanceMessageDao.delete(id);
    }

    @Override
    public boolean update(InstanceMessage instanceMessage) {

        return instanceMessageDao.update(instanceMessage);
    }

    public List<InstanceMessage> listByFormInstanceId(Long formInstanceId) {

        return instanceMessageDao.listByFormInstanceId(formInstanceId);
    }

    public List<InstanceMessage> listByMessageCerkId(Long messageCerkId) {

        return instanceMessageDao.listByMessageCerkId(messageCerkId);
    }

    @Override
    public Page<InstanceMessage> page(InstanceMessageQuery query, int start, int count) {

        return instanceMessageDao.page(query, start, count);
    }

    public List<InstanceMessage> listAll() {

        return instanceMessageDao.listAll();
    }

    @Override
    public String getMessageContent(Long formInstanceId, MessageType messageType) {

        List<DriverVehicle> driverVehicles = driverVehicleDao.getListByFormInstanceId(formInstanceId);
        // List<DriverVehicle> driverVehicles = driverVehicleDao.getListByFormInstanceId(formInstanceId);
        AssertUtil.notNull(driverVehicles, "流程实例id不存在车辆关系表." + formInstanceId);
        Long vehicleId = driverVehicles.get(0).getVehicleId();
        Vehicle vehicle = vehicleDao.get(vehicleId);
        String ownerName = StringUtil.nullToEmpty(vehicle.getOwnerName());
        String plateNumber = StringUtil.nullToEmpty(vehicle.getPlateNumber());
        String brand = StringUtil.nullToEmpty(vehicle.getBrand());
        String specification = StringUtil.nullToEmpty(vehicle.getSpecification());
        String content = "";
        if (messageType == MessageType.YCTZ) {
            content = (String) parameterClient.get("message-content-yanche");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
        }
        if (messageType == MessageType.ZWCJ) {
            String driverNames = "";
            for (DriverVehicle driverVehicle : driverVehicles) {
                Driver driver = driverDao.get(driverVehicle.getDriverId());
                AssertUtil.assertNotNull(driver, "驾驶员不存在." + driverVehicle.getDriverId());
                driverNames = driverNames + driver.getDriverName() + ",";
            }
            if (driverNames.length() > 0) {
                driverNames = driverNames.substring(0, driverNames.length() - 1);
            }
            content = (String) parameterClient.get("message-content-zhiwen");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            content = content.replaceAll("\\{driverNames\\}", driverNames);
        }
        if (messageType == MessageType.PQJG) {
            content = (String) parameterClient.get("message-content-paiqi");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
        }
        if (messageType == MessageType.GWH) {
            content = (String) parameterClient.get("message-content-refuse-gwhck");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            // content = content.replaceAll("\\{reason\\}", reason);
        }
        if (messageType == MessageType.CJSP) {
            content = (String) parameterClient.get("message-content-refuse-cj");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            // content = content.replaceAll("\\{reason\\}", reason);
        }
        if (messageType == MessageType.GWHXC) {
            content = (String) parameterClient.get("message-content-refuse-gwhxc");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            // content = content.replaceAll("\\{reason\\}", reason);
        }
        if (messageType == MessageType.JJSP) {
            content = (String) parameterClient.get("message-content-refuse-jj");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            // content = content.replaceAll("\\{reason\\}", reason);
        }
        if (messageType == MessageType.BASP) {
            content = (String) parameterClient.get("message-content-refuse-ba");
            content = content.replaceAll("\\{ownerName\\}", ownerName);
            content = content.replaceAll("\\{plateNumber\\}", plateNumber);
            content = content.replaceAll("\\{brand\\}", brand);
            content = content.replaceAll("\\{specification\\}", specification);
            // content = content.replaceAll("\\{reason\\}", reason);
        }
        return content;
    }
}
