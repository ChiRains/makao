package com.qcloud.project.macaovehicle.web.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.file.exception.FileException;
import com.qcloud.component.form.FormClient;
import com.qcloud.component.form.QFormInstance;
import com.qcloud.component.organization.OrganizationClient;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.DateUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.entity.MessageEntity;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.TaskingBorder;
import com.qcloud.project.macaovehicle.model.TaskingCustoms;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApplyType;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.StatusType;
import com.qcloud.project.macaovehicle.model.query.TaskingCustomsQuery;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.TaskingBorderService;
import com.qcloud.project.macaovehicle.service.TaskingCustomsService;
import com.qcloud.project.macaovehicle.web.handler.TaskingCustomsHandler;
import com.qcloud.project.macaovehicle.web.vo.TaskingCustomsVO;

@Controller
@RequestMapping(value = TaskingCustomsController.DIR)
public class TaskingCustomsController {

    public static final String     DIR = "/taskingCustoms";

    @Autowired
    private TaskingCustomsService  taskingCustomsService;

    @Autowired
    private TaskingCustomsHandler  taskingCustomsHandler;

    @Autowired
    private ClerkHelper            clerkHelper;

    @Autowired
    private FormClient             formClient;

    @Autowired
    private TaskingBorderService   taskingBorderService;

    @Autowired
    private OrganizationClient     organizationClient;

    @Autowired
    private ProcessProgressService processProgressService;

    /**
     * 未处理
     * 
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView list(TaskingCustomsQuery query, Integer pageNum, Integer pageSize, String type) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        query.setStatus(StatusType.NOTDO.getKey());
        query.setType(type);
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingCustoms> page = taskingCustomsService.page(query, start, PAGE_SIZE);
        List<TaskingCustomsVO> volist = taskingCustomsHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(volist);
        return view;
    }

    /**
     * 已处理
     * 
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping
    public FrontPagingView listed(TaskingCustomsQuery query, Integer pageNum, Integer pageSize, String type) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        query.setStatusIgnore(StatusType.NOTDO.getKey());
        query.setType(type);
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<TaskingCustoms> page = taskingCustomsService.page(query, start, PAGE_SIZE);
        List<TaskingCustomsVO> volist = taskingCustomsHandler.toVOList(page.getData());
        FrontPagingView view = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        view.setList(volist);
        return view;
    }

    @RequestMapping
    public AceAjaxView doTasking(HttpServletRequest request, String formInstCode, int state, String reason) {

        if (StatusType.PASSED.getKey() != state && StatusType.REJECT.getKey() != state) {
            throw new MacaovehicleException("类型state非法." + state);
        }
        AssertUtil.assertNotNull(formInstCode, "formInstCode不能为空!");
        QClerk clerk = clerkHelper.getClerkModel(request);
        QFormInstance qFormInstance = formClient.getByCode(formInstCode);
        AssertUtil.assertNotNull(qFormInstance, "流程表单对象不存在." + formInstCode);
        TaskingCustoms taskingCustoms = taskingCustomsService.getByFormInstanceId(qFormInstance.getId());
        taskingCustoms.setStatus(state);
        taskingCustoms.setRecordTime(new Date());
        taskingCustoms.setOperatorClerkId(clerk.getId());
        taskingCustoms.setCustomsStatus(state);
        if (state == StatusType.REJECT.getKey()) {
            AssertUtil.assertNotNull(reason, "拒绝原因不能为空.");
            taskingCustoms.setReason(reason);
            MessageEntity messageEntity = new MessageEntity();
            messageEntity.setNotionReason(reason);
            processProgressService.changeState(qFormInstance.getId(), ApplyType.REJECT.getKey(), ProgressState.BEIAN.getKey(), taskingCustoms.getCreator(), messageEntity);
        }
        taskingCustomsService.update(taskingCustoms);
        //
        TaskingBorder taskingBorder = taskingBorderService.getByFormInstanceId(qFormInstance.getId());
        taskingBorder.setStatus(StatusType.NOTDO.getKey());
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
        TaskingCustoms taskingCustoms = taskingCustomsService.getByFormInstanceId(qFormInstance.getId());
        Map<String, Object> taskingCustomsMap = new HashMap<String, Object>();
        taskingCustomsMap.put("status", taskingCustoms.getStatus());
        taskingCustomsMap.put("customsStatus", taskingCustoms.getCustomsStatus());
        taskingCustomsMap.put("recordTime", DateUtil.date2String(taskingCustoms.getRecordTime()));
        taskingCustomsMap.put("operator", organizationClient.getClerk(taskingCustoms.getOperatorClerkId()).getName());
        taskingCustomsMap.put("reason", taskingCustoms.getReason());
        aceAjaxView.addObject("taskingCustoms", taskingCustomsMap);
        aceAjaxView.setMessage("状态查看成功.");
        return aceAjaxView;
    }

    @RequestMapping
    public void exportFile(HttpServletRequest resuest, HttpServletResponse response) {

        String sourceFilePath = resuest.getSession().getServletContext().getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_SOURCE;
        String zipFilePath = resuest.getSession().getServletContext().getRealPath("/WEB-INF") + "/" + TypeEnum.EXCEL_TEMPLATE_DIR_EXPORT;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        File sourceFile = new File(sourceFilePath);
        File zipFile = new File(zipFilePath + "/" + "exportZip.zip");
        System.out.println(sourceFilePath);
        try {
            if (sourceFile.exists() == false) {
                sourceFile.createNewFile();
                System.out.println("该文件不存在");
            }
            if (zipFile.exists()) {
                System.out.println(zipFilePath + "目录下存在名字为:" + "exportFile.zip" + "打包文件.");
            } else {
                File[] sourceFiles = sourceFile.listFiles();
                if (null == sourceFiles || sourceFiles.length < 1) {
                    System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                } else {
                    fos = new FileOutputStream(zipFile);
                    zos = new ZipOutputStream(new BufferedOutputStream(fos));
                    byte[] bufs = new byte[1024 * 10];
                    for (int i = 0; i < sourceFiles.length; i++) {
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
                if (null != bis) bis.close();
                if (null != zos) zos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        response.setContentType("application/zip");
        response.addHeader("Content-Disposition", "attachment;filename=exportZip.zip");
        try {
            String fileDir = zipFilePath;
            byte[] content = FileUtils.readFileToByteArray(new File(fileDir + "/exportZip.zip"));
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            throw new FileException("下载文件失败.", e);
        } finally {
            zipFile.delete();
        }
    }
}
