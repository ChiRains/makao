package com.qcloud.component.publicservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.parameter.ParamType;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.DistanceConfig;
import com.qcloud.component.publicservice.service.DistanceConfigService;

@Service
public class DistanceConfigServiceImpl implements DistanceConfigService {

    @Autowired
    private ParameterClient     parameterClientImpl;

    private final static String DISTANCE_SETTING = "distance-setting";
    @Override
    public DistanceConfig get() {
        DistanceConfig cfg=new DistanceConfig();
        String distanceSetting=parameterClientImpl.get(DISTANCE_SETTING);
        cfg.setDistanceSetting(distanceSetting);
        return cfg;
    }

    @Override
    public void set(DistanceConfig distanceConfig) {
        
        parameterClientImpl.reg(DISTANCE_SETTING, distanceConfig.getDistanceSetting(), ParamType.STRING);
    }
}
