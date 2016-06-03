package com.qcloud.component.metadata.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.metadata.service.FieldService;
import com.qcloud.component.metadata.web.handler.FieldHandler;

@Controller
@RequestMapping(value = FieldController.DIR)
public class FieldController {

    public static final String DIR = "/field";

    @Autowired
    private FieldService       fieldService;

    @Autowired
    private FieldHandler       fieldHandler;
}
