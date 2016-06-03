package com.qcloud.project.macaovehicle.web.controller.outside;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = ResultsController.DIR)
public class ResultsController {

    public static final String DIR    = "/results";

    private Log                logger = LogFactory.getLog(getClass());
}
