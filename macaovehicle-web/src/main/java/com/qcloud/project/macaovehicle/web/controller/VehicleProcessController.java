package com.qcloud.project.macaovehicle.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snaker.web.FormGetter;
import com.qcloud.component.snaker.web.controller.helper.ProcessHelper;
import com.qcloud.component.snaker.web.vo.admin.ProcessVO;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = VehicleProcessController.DIR)
public class VehicleProcessController {

    public static final String    DIR                 = "/vehicleProcess";

    @Autowired
    private ISnakerClient         snakerClient;

    private static final String[] vehicleProcessNames = new String[] { "carApprove", "carPilot", "supplement", "renewal", "addApprove"};

    @Autowired
    private FormGetter            formGetter;

    @Autowired
    private ProcessHelper         processHelper;

    /**
     * 入境申请流程
     * @return
     */
    @RequestMapping
    @NoReferer
    public FrontAjaxView listVehicleProcesses() {

        Map<String, ProcessVO> map = new HashMap<String, ProcessVO>();
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("processMap", mapProcess(map, "approve", "pilot", "supplement", "renewal", "addApprove"));
        return view;
    }

    /**
     * 入境申请流程
     * @return
     */
    @RequestMapping
    @NoReferer
    public FrontAjaxView getVehicleProcesses(String type) {

        AssertUtil.assertNotNull(type, "流程类型不能为空.");
        FrontAjaxView view = new FrontAjaxView();
        Process process = processHelper.getProcess(type);
        AssertUtil.assertNotNull(process, "流程类型不存在." + type);
        view.addObject("processId", process.getId());
        view.addObject("formId", formGetter.getForm(process));
        return view;
    }

    private Map<String, ProcessVO> vehicleProcess(Map<String, ProcessVO> map, String processType) {

        Page<Process> page = new Page<Process>();
        QueryFilter filter = new QueryFilter();
        filter.setProcessType(processType);
        List<Process> list = snakerClient.process().getProcesss(page, filter);
        for (String str : vehicleProcessNames) {
            ProcessVO vo = new ProcessVO();
            for (Process process : list) {
                if (str.equals(process.getName()) && vo.getVersion() <= process.getVersion()) {
                    vo.setId(process.getId());
                    vo.setName(process.getName());
                    vo.setDisplayName(process.getDisplayName());
                    Long formId = formGetter.getForm(process);
                    vo.setFormId(formId);
                    vo.setVersion(process.getVersion());
                    map.put(str, vo);
                }
            }
        }
        return map;
    }

    private Map<String, ProcessVO> mapProcess(Map<String, ProcessVO> map, String... processType) {

        for (String type : processType) {
            vehicleProcess(map, type);
        }
        return map;
    }
}
