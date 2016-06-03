package com.qcloud.component.publicservice.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.publicservice.model.DistanceConfig;
import com.qcloud.component.publicservice.service.DistanceConfigService;
import com.qcloud.pirates.mvc.FrontAjaxView;

@Controller
@RequestMapping(value = DistanceController.DIR)
public class DistanceController {

    public static final String   DIR = "/distanceConfig";

    @Autowired
    public DistanceConfigService distanceConfigService;

    @RequestMapping
    public FrontAjaxView list(HttpServletRequest request) {

        DistanceConfig distanceConfig = distanceConfigService.get();
        String str = distanceConfig.getDistanceSetting();
        List<String> list = new ArrayList<String>();
        if (StringUtils.isNotEmpty(str)) {
            String[] strs = str.split(",");
            for (String string : strs) {
                list.add(string);
            }
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("获取中心点距离成功.");
        view.addObject("list", list);
        return view;
    }
}
