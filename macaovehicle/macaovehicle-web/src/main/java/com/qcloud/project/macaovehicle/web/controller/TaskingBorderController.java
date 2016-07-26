package com.qcloud.project.macaovehicle.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import com.qcloud.component.file.exception.FileException;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QFormInstance;
import com.qcloud.component.mvprocesstask.model.key.TypeEnum.TaskType;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.template.client.excel.ExcelClient;
import com.qcloud.component.template.client.instance.ClientFactory;
import com.qcloud.component.template.client.instance.OperatePVFactory;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.DriverVehicle;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.OwnerType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingBorderQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.DriverVehicleService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.util.HttpUtils;
import com.qcloud.project.macaovehicle.web.handler.TaskingBorderHandler;
import com.qcloud.project.macaovehicle.web.vo.TaskingBorderVO;

@Controller
@RequestMapping(value = TaskingBorderController.DIR)
public class TaskingBorderController {

    public static final String          DIR = "/taskingBorder";

    @Autowired
    private TaskingBorderService        taskingBorderService;

    @Autowired
    private TaskingBorderHandler        taskingBorderHandler;

    @Autowired
    private ClerkHelper                 clerkHelper;

    @Autowired
    private FormClient                  formClient;

    @Autowired
    private OrganizationClient          organizationClient;

    @Autowired
    private ProcessProgressService      processProgressService;

    @Autowired
    private VehicleService              vehicleService;

    @Autowired
    private DriverVehicleService        driverVehicleService;

    @Autowired
    private DriverService               driverService;

    @Autowired
    private CarOwnerService             carOwnerService;

    @Autowired
    private CarOwnerEnterprisersService carOwnerEnterprisersService;

    @Autowired
    private FileSDKClient               fileSDKClient;

    private Date                        now = new Date();

    /**
     * 待处理
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize 
     * @return
     */
    @RequestMapping
    public FrontPagingView list(HttpServletRequest request, TaskingBorderQuery query, Integer pageNum, Integer pageSize, String type) {

        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingBorder> page = taskingBorderService.page(query, start, PAGE_SIZE);
        List<TaskingBorderVO> volist = taskingBorderHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(volist);
        return view;
    }

    /**
     * 已处理
     * @param request
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listed(HttpServletRequest request, TaskingBorderQuery query, Integer pageNum, Integer pageSize, String type) {

        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        query.setStatusIgnore(StatusType.NOTDO.getKey());
        query.setType(type);
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingBorder> page = taskingBorderService.page(query, start, PAGE_SIZE);
        List<TaskingBorderVO> volist = taskingBorderHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(volist);
        return view;
    }

    /**
     * 确定备案
     * @param request
     * @param formInstCode
     * @param state
     * @return
     */
    @RequestMapping
    public AceAjaxView doTasking(HttpServletRequest request, String formInstCode, int state, String reason) {

        if (StatusType.PASSED.getKey() != state && StatusType.REJECT.getKey() != state) {
            throw new MacaovehicleException("类型state非法." + state);
        }
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        QClerk clerk = clerkHelper.getClerkModel(request);
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(qFormInstance.getId());
        taskingBorder.setStatus(state);
        taskingBorder.setRecordTime(now);
        taskingBorder.setOperatorClerkId(clerk.getId());
        if (state == StatusType.REJECT.getKey()) {
            AssertUtil.assertNotNull(reason, "拒绝原因不能为空.");
            taskingBorder.setReason(reason);
        }
        taskingBorderService.update(taskingBorder);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("状态处理成功.");
        return aceAjaxView;
    }

    /**
     * 标记备案成功
     * @param request
     * @param formInstCode
     * @param state
     * @return
     */
    @RequestMapping
    public AceAjaxView markTasking(HttpServletRequest request, String formInstCode, int state, String reason) {

        if (StatusType.PASSED.getKey() != state && StatusType.REJECT.getKey() != state) {
            throw new MacaovehicleException("类型state非法." + state);
        }
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        // QClerk clerk = clerkHelper.getClerkModel(request);
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(qFormInstance.getId());
        taskingBorder.setBorderStatus(state);
        // 备案通过、失败
        if (StatusType.PASSED.getKey() == state) {
            processProgressService.changeState(qFormInstance.getId(), ApplyType.PASS.getKey(), ProgressState.BEIAN.getKey(), taskingBorder.getCreator(), null);
        } else {
            AssertUtil.assertNotNull(reason, "拒绝原因不能为空.");
            taskingBorder.setReason(reason);
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setNotionReason(reason);
            processProgressService.changeState(qFormInstance.getId(), ApplyType.REJECT.getKey(), ProgressState.BEIAN.getKey(), taskingBorder.getCreator(), messageEntity);
        }
        taskingBorderService.update(taskingBorder);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("状态处理成功.");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView get(String formInstCode) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(qFormInstance.getId());
        Map<String, Object> taskingBorderMap = new HashMap<String, Object>();
        taskingBorderMap.put("status", taskingBorder.getStatus());
        taskingBorderMap.put("borderStatus", taskingBorder.getBorderStatus());
        taskingBorderMap.put("recordTime", DateUtil.date2String(taskingBorder.getRecordTime()));
        taskingBorderMap.put("operator", organizationClient.getClerk(taskingBorder.getOperatorClerkId()).getName());
        taskingBorderMap.put("reason", taskingBorder.getReason());
        aceAjaxView.addObject("taskingBorder", taskingBorderMap);
        aceAjaxView.setMessage("状态查看成功.");
        return aceAjaxView;
    }

    /**
     * @description 导出车辆资料
     * @param query
     * @param request
     * @param type
     * @throws Exception
     */
    @RequestMapping
    public void exportVehicle(TaskingBorderQuery query, HttpServletRequest request, String type) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        // 获取车辆信息数据
        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        Page<TaskingBorder> page = taskingBorderService.page(query, 0, Integer.MAX_VALUE);
        for (TaskingBorder taskingBorder : page.getData()) {
            Vehicle vehicle = vehicleService.getByPlateNumber(taskingBorder.getPlateNumber());
            Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
            dataMap.put("ric", vehicle.getRic());
            dataMap.put("ownerName", vehicle.getOwnerName());
            dataMap.put("plateNumber", vehicle.getPlateNumber());
            dataMap.put("temporaryplate", vehicle.getTemporaryplate());
            dataMap.put("area", "MAC");
            dataMap.put("models", 43);
            dataMap.put("height", vehicle.getHeight());
            dataMap.put("steeringWheel", 1);
            dataMap.put("gate", 478);
            dataMap.put("indicatorsTime", vehicle.getIndicatorsTime() != null ? DateUtil.date2String(vehicle.getIndicatorsTime(), "yyyyMMdd") : "-");
            dataMap.put("indicatorsNo", vehicle.getIndicators());
            dataMap.put("color", vehicle.getColor());
            dataMap.put("seat", vehicle.getSeat());
            list.add(dataMap);
        }
        map.put("result", list);
        //
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String templateFileDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR;
        String filename = "车辆资料_" + DateUtil.date2String(now, "yyyyMMddHHmmss") + ".xls";
        String exportExcelDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE + "/" + filename;
        File myFile = new File(exportExcelDir);
        if (!myFile.exists()) {
            myFile.createNewFile();
        } else {
            throw new Exception("The new file already exists!");
        }
        ExcelClient excelClient = ClientFactory.getExcelClientInstance();
        excelClient.parse(OperatePVFactory.getTemplateFilePV(templateFileDir + "/车辆资料字段.xls"), OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROFilePV(exportExcelDir));
    }

    /**
     * @description 导出司机资料
     * @param query
     * @param request
     * @param type
     * @throws Exception
     */
    @RequestMapping
    public void exportDriver(TaskingBorderQuery query, HttpServletRequest request, HttpServletResponse response, String type) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        // 获取车辆信息数据
        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        Page<TaskingBorder> page = taskingBorderService.page(query, 0, Integer.MAX_VALUE);
        for (TaskingBorder taskingBorder : page.getData()) {
            Vehicle vehicle = vehicleService.getByPlateNumber(taskingBorder.getPlateNumber());
            List<DriverVehicle> driverVehicles = driverVehicleService.getListByVehicleId(vehicle.getId(), ProgressType.APPLY);
            for (DriverVehicle driverVehicle : driverVehicles) {
                Long driverId = driverVehicle.getDriverId();
                Driver driver = driverService.get(driverId);
                Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
                dataMap.put("driverIc", "DRIVER0000000002");
                dataMap.put("driverIdCard", driver.getDriverIdCard() + "\t");
                dataMap.put("driverName", driver.getDriverName());
                dataMap.put("certificateType", 10);
                dataMap.put("sex", driver.getSex());
                dataMap.put("birthday", driver.getBirthday());
                dataMap.put("nationCode", "MAC");
                dataMap.put("certificateDate", driver.getCertificateDate());
                dataMap.put("indicatorsTime", DateUtil.date2String(vehicle.getIndicatorsTime()));
                dataMap.put("ownerName", vehicle.getOwnerName());
                dataMap.put("endorsementType", driver.getEndorsementType());
                dataMap.put("endorsementValidtime", driver.getEndorsementValidtime());
                dataMap.put("seconddrivername", driver.getSeconddrivername());
                dataMap.put("secondbirthday", driver.getSecondbirthday());
                dataMap.put("certificateNo", driver.getCertificateNo() + "\t");
                dataMap.put("certificateType", driver.getCertificateType());
                dataMap.put("endorsementCode", driver.getEndorsementCode());
                dataMap.put("endorsementStay", driver.getEndorsementStay());
                dataMap.put("driverPhone", driver.getDriverPhone());
                dataMap.put("driverAddress", driver.getDriverAddress());
                dataMap.put("driverworkplace", driver.getDriverworkplace());
                list.add(dataMap);
            }
        }
        map.put("result", list);
        //
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        // ServletContext servletContext = request.getSession().getServletContext();
        String templateFileDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR;
        String filename = "司机资料_" + DateUtil.date2String(now, "yyyyMMddHHmmss") + ".xls";
        String exportExcelDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE + "/" + filename;
        File myFile = new File(exportExcelDir);
        if (!myFile.exists()) {
            myFile.createNewFile();
        } else {
            throw new Exception("The new file already exists!");
        }
        ExcelClient excelClient = ClientFactory.getExcelClientInstance();
        excelClient.parse(OperatePVFactory.getTemplateFilePV(templateFileDir + "/司机资料字段.xls"), OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROFilePV(exportExcelDir));
    }

    /**
     * @description 车辆司机关联关系
     * @param query
     * @param request
     * @param type
     * @throws Exception
     */
    @RequestMapping
    public void exportDriverVehicle(TaskingBorderQuery query, HttpServletRequest request, HttpServletResponse response, String type) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        // 获取车辆信息数据
        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        Page<TaskingBorder> page = taskingBorderService.page(query, 0, Integer.MAX_VALUE);
        for (TaskingBorder taskingBorder : page.getData()) {
            Vehicle vehicle = vehicleService.getByPlateNumber(taskingBorder.getPlateNumber());
            List<DriverVehicle> driverVehicles = driverVehicleService.getListByVehicleId(vehicle.getId(), ProgressType.APPLY);
            for (DriverVehicle driverVehicle : driverVehicles) {
                Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
                Long driverId = driverVehicle.getDriverId();
                Driver driver = driverService.get(driverId);
                dataMap.put("plateNumber", vehicle.getPlateNumber());
                dataMap.put("certificateType", 24);
                dataMap.put("certificateNo", driver.getCertificateNo() + "\t");
                list.add(dataMap);
            }
        }
        map.put("result", list);
        //
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String templateFileDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR;
        String filename = "车辆司机关联关系_" + DateUtil.date2String(now, "yyyyMMddHHmmss") + ".xls";
        String exportExcelDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE + "/" + filename;
        File myFile = new File(exportExcelDir);
        if (!myFile.exists()) {
            myFile.createNewFile();
        } else {
            throw new Exception("The new file already exists!");
        }
        ExcelClient excelClient = ClientFactory.getExcelClientInstance();
        excelClient.parse(OperatePVFactory.getTemplateFilePV(templateFileDir + "/车辆司机关联关系.xls"), OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROFilePV(exportExcelDir));
    }

    /**
     * @description 导出公司资料
     * @param query
     * @param request
     * @param type
     * @throws Exception
     */
    @RequestMapping
    public void exportEnterprise(TaskingBorderQuery query, HttpServletRequest request, HttpServletResponse response, String type) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> list = new ArrayList<Object>();
        // 获取车辆信息数据
        AssertUtil.assertTrue(checkType(type), "流程类型非法." + type);
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        // query.setClerkType(OwnerType.BUSINESS.getName());
        Page<TaskingBorder> page = taskingBorderService.page(query, 0, Integer.MAX_VALUE);
        query.setClerkType(null);
        for (TaskingBorder taskingBorder : page.getData()) {
            CarOwner carOwner = carOwnerService.getByClerk(taskingBorder.getCreator());
            CarOwnerEnterprisers carOwnerEnterprisers = carOwnerEnterprisersService.getByCarOwner(carOwner.getId());
            if (carOwnerEnterprisers == null) {
                continue;
            }
            Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
            dataMap.put("company", carOwnerEnterprisers.getCompany());
            dataMap.put("contacts", carOwnerEnterprisers.getContacts());
            list.add(dataMap);
        }
        map.put("result", list);
        //
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String templateFileDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR;
        String filename = "公司资料_" + DateUtil.date2String(now, "yyyyMMddHHmmss") + ".xls";
        String exportExcelDir = servletContext.getRealPath("/WEB-INF") + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE + "/" + filename;
        File myFile = new File(exportExcelDir);
        if (!myFile.exists()) {
            myFile.createNewFile();
        } else {
            throw new Exception("The new file already exists!");
        }
        ExcelClient excelClient = ClientFactory.getExcelClientInstance();
        excelClient.parse(OperatePVFactory.getTemplateFilePV(templateFileDir + "/公司资料字段.xls"), OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROFilePV(exportExcelDir));
    }

    // TODO
    @RequestMapping
    public void downloadImage(TaskingBorderQuery query, HttpServletRequest request, HttpServletResponse response, String type) throws Exception {

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String sourceFilePath = servletContext.getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE;
        String clzpPath = sourceFilePath + "/CLZP";
        String sjzpPath = sourceFilePath + "/SJZP";
        File clzpFile = new File(clzpPath);
        if (!clzpFile.exists() && !clzpFile.isDirectory()) {
            System.out.println("//不存在");
            clzpFile.mkdir();
        } else {
            System.out.println("//目录存在");
        }
        //
        File sjzpFile = new File(sjzpPath);
        if (!sjzpFile.exists() && !sjzpFile.isDirectory()) {
            System.out.println("//不存在");
            sjzpFile.mkdir();
        } else {
            System.out.println("//目录存在");
        }
        //
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        Page<TaskingBorder> page = taskingBorderService.page(query, 0, Integer.MAX_VALUE);
        for (TaskingBorder taskingBorder : page.getData()) {
            Vehicle vehicle = vehicleService.getByPlateNumber(taskingBorder.getPlateNumber());
            List<DriverVehicle> driverVehicles = driverVehicleService.getListByVehicleId(vehicle.getId(), ProgressType.APPLY);
            String faceImageUrl = fileSDKClient.getFileServerUrl() + vehicle.getFaceImage();
            String leftfaceImageUrl = fileSDKClient.getFileServerUrl() + vehicle.getLeftfaceImage();
            // 下载车辆图片
            HttpUtils.httpDownload(faceImageUrl, clzpPath + "/" + vehicle.getPlateNumber() + "_ZM.jpg");
            HttpUtils.httpDownload(leftfaceImageUrl, clzpPath + "/" + vehicle.getPlateNumber() + "_ZMZC45.jpg");
            for (DriverVehicle driverVehicle : driverVehicles) {
                Long driverId = driverVehicle.getDriverId();
                Driver driver = driverService.get(driverId);
                String idcardFaceUrl = fileSDKClient.getFileServerUrl() + driver.getIdcardFace();
                String idcardBackUrl = fileSDKClient.getFileServerUrl() + driver.getIdcardBack();
                // 下载司机证件图片
                HttpUtils.httpDownload(idcardFaceUrl, sjzpPath + "/" + driver.getCertificateNo() + "_ZM.jpg");
                HttpUtils.httpDownload(idcardBackUrl, sjzpPath + "/" + driver.getCertificateNo() + "_FM.jpg");
            }
        }
    }

    @RequestMapping
    public void exportFile(HttpServletRequest resuest, HttpServletResponse response, TaskingBorderQuery query, String type) {

        try {
            exportDriver(query, resuest, response, type);
            exportVehicle(query, resuest, type);
            exportDriverVehicle(query, resuest, response, type);
            exportEnterprise(query, resuest, response, type);
            downloadImage(query, resuest, response, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String sourceFilePath = servletContext.getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE;
        List<String> sourceFileList = new ArrayList<String>();
        sourceFileList.add(sourceFilePath);
        String zipFilePath = servletContext.getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_EXPORT;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        File sourceFile = new File(sourceFilePath);
        String subName = DateUtil.date2String(now, "yyyyMMddHHmmss").toString();
        File zipFile = new File(zipFilePath + "/" + "archive_" + subName + ".zip");
        System.out.println(sourceFilePath);
        try {
            if (sourceFile.exists() == false) {
                sourceFile.createNewFile();
                System.out.println("该文件不存在");
            }
            if (zipFile.exists()) {
                System.out.println(zipFilePath + "目录下存在名字为:" + "archive_" + subName + ".zip" + "打包文件.");
            } else {
                File[] sourceFiles = sourceFile.listFiles();
                if (null == sourceFiles || sourceFiles.length < 1) {
                    System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024 * 10];
                    for (int i = 0; i < sourceFiles.length; i++) {
                        if (sourceFiles[i].isDirectory()) {
                            File[] files = sourceFiles[i].listFiles();
                            for (int j = 0; j < files.length; j++) {
                                // 创建ZIP实体，并添加进压缩包
                                ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName() + "/" + files[j].getName());
                                zos.setEncoding(System.getProperty("sun.jnu.encoding"));
                                zos.putNextEntry(zipEntry);
                                // 读取待压缩的文件并写进压缩包里
                                fis = new FileInputStream(files[j]);
                                bis = new BufferedInputStream(fis, 1024 * 10);
                                int read = 0;
                                while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                                    zos.write(bufs, 0, read);
                                }
                                if (null != bis) bis.close();
                                if (null != fis) fis.close();
                            }
                            continue;
                        }
                        // 创建ZIP实体，并添加进压缩包
                        ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                        zos.setEncoding(System.getProperty("sun.jnu.encoding"));
                        zos.putNextEntry(zipEntry);
                        // 读取待压缩的文件并写进压缩包里
                        fis = new FileInputStream(sourceFiles[i]);
                        bis = new BufferedInputStream(fis, 1024 * 10);
                        int read = 0;
                        while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
                            zos.write(bufs, 0, read);
                        }
                        if (null != bis) bis.close();
                        if (null != fis) fis.close();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 关闭流
            try {
                if (null != zos) zos.close();
                if (null != fos) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        response.setContentType("application/zip");
        response.addHeader("Content-Disposition", "attachment;filename=" + toUtf8String("单排") + "_" + subName + ".zip");
        try {
            String fileDir = zipFilePath;
            byte[] content = FileUtils.readFileToByteArray(new File(fileDir + "/" + "archive_" + subName + ".zip"));
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            throw new FileException("下载文件失败.", e);
        } finally {
            zipFile.delete();
        }
        try {
            deleteOriginalFiles(resuest, response);
        } catch (IOException ex) {
            ex.getMessage();
            ex.printStackTrace();
        }
    }

    // 导出压缩文件后删掉原始文件
    public void deleteOriginalFiles(HttpServletRequest resuest, HttpServletResponse response) throws IOException {

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        String originalFilePath = servletContext.getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE;
        File originalFile = new File(originalFilePath);
        File[] originalFiles = originalFile.listFiles();
        for (int j = 0; j < originalFiles.length; j++) {
            // 如果删除时遇到文件夹，则先吧文件夹里面的文件逐个删除
            if (originalFiles[j].isDirectory()) {
                File[] files = originalFiles[j].listFiles();
                for (int k = 0; k < files.length; k++) {
                    System.out.println(files[k].getName());
                    System.out.println(files[k].delete());
                }
            }
            System.out.println(originalFiles[j].getName());
            System.out.println(originalFiles[j].delete());
        }
    }

    public String toUtf8String(String s) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = Character.toString(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0) k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

    private boolean checkType(String type) {

        boolean isOK = false;
        for (TaskType taskType : TaskType.values()) {
            if (taskType.getKey().equals(type)) {
                isOK = true;
            }
        }
        return isOK;
    }
}
