package com.qcloud.project.macaovehicle.web.controller.outside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.component.form.FormClient;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.TextView;
import com.qcloud.project.macaovehicle.model.ApprovalOutside;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCiq;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalCardType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.service.ApprovalOutsideService;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCiqService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.util.MessageGetter;
import com.qcloud.project.macaovehicle.util.SignUtils;
import com.qcloud.project.macaovehicle.util.XmlParseUtils;

// 提供给电子口岸的接口
@Controller
@RequestMapping(value = EportController.DIR)
public class EportController {

    public static final String     DIR    = "/eport";

    private Log                    logger = LogFactory.getLog(getClass());

    @Autowired
    TaskingBorderService           taskingBorderService;

    @Autowired
    TaskingCiqService              taskingCiqService;

    @Autowired
    TaskingCustomsService          taskingCustomsService;

    @Autowired
    private FormClient             formClient;

    @Autowired
    private ApprovalResultsService approvalResultsService;

    @RequestMapping(value = "/eportTest", method = RequestMethod.GET)
    public FrontAjaxView eportTest(String name, String name2, String name3, String sign) {

        logger.info("测试访问.=================================================");
        if (!SignUtils.checkSign("test", sign, name, name2, name3)) {
            FrontAjaxView view = new FrontAjaxView();
            view.setStatus(1);
            view.setMessage("签名错误");
            logger.info("签名错误");
            return view;
        }
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage(name + name2 + name3 + ".测试访问成功.sign签名" + sign);
        logger.info(name + name2 + name3 + ".测试访问成功.sign签名" + sign);
        logger.info("测试访问成功.=================================================");
        return view;
    }

    @RequestMapping
    public AceAjaxView borderPost(HttpServletRequest request, Long formInstanceId, String appointmentNumber) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        // 边检反馈备案结果
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(formInstanceId);
        taskingBorder.setBorderStatus(StatusType.PASSED.getKey());
        taskingBorderService.update(taskingBorder);
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView ciqPost(HttpServletRequest request, Long formInstanceId, String appointmentNumber) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        // 国检
        TaskingCiq taskingCiq = taskingCiqService.getByFormInstanceId(formInstanceId);
        taskingCiq.setCiqStatus(StatusType.PASSED.getKey());
        taskingCiqService.update(taskingCiq);
        // 边检
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(formInstanceId);
        taskingBorder.setCiqStatus(StatusType.PASSED.getKey());
        taskingBorderService.update(taskingBorder);
        ApprovalResults results = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        results.setState(ApprovalResultState.CIQ_RECORD.getKey());
        approvalResultsService.update(results);
        aceAjaxView.setMessage("国检反馈备案结果成功.");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView customsPost(HttpServletRequest request, Long formInstanceId, String appointmentNumber) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        // 国检
        TaskingCustoms taskingCustoms = taskingCustomsService.getByFormInstanceId(formInstanceId);
        taskingCustoms.setCustomsStatus(StatusType.PASSED.getKey());
        taskingCustomsService.update(taskingCustoms);
        // 边检
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(formInstanceId);
        taskingBorder.setCustomsStatus(StatusType.PASSED.getKey());
        taskingBorder.setStatus(1);
        taskingBorderService.update(taskingBorder);
        ApprovalResults results = approvalResultsService.getResultByAppointmentNumber(appointmentNumber);
        results.setState(ApprovalResultState.CUSTOMS_RECORD.getKey());
        approvalResultsService.update(results);
        aceAjaxView.setMessage("海关反馈备案结果成功.");
        return aceAjaxView;
    }

    /**
     * 国检备案回执(待定.)
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public TextView cipXmlReceive(HttpServletRequest request) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = XmlParseUtils.XmlToMap(sb.toString());
        System.out.println(sb.toString());
        TextView view = new TextView(sb.toString());
        return view;
    }

    /**
     * 海关的备案回执
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public TextView customsXmlReceive(HttpServletRequest request) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 录入数据成功
        Map<String, Object> map = XmlParseUtils.XmlToMap(sb.toString());
        if (map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.equals("true")) {
               // TODO 录入成功.
            }
        }
        TextView view = new TextView(sb.toString());
        return view;
    }

    /**
     * 审批的接口
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public TextView checkXmlReceive(HttpServletRequest request) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = XmlParseUtils.XmlToMap(sb.toString());
        String text = sb.toString();
        Object obj = map.get("success");
        if (obj.equals("false")) {
            text = sb.toString().replace("<success>false</success>", "<success>true</success>");
            // TODO  海关审批的接口
        }
        TextView view = new TextView(text);
        return view;
    }
}
