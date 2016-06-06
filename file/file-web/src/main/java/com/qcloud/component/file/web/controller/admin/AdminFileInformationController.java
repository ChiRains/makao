package com.qcloud.component.file.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.service.FileInformationService;
import com.qcloud.component.file.web.handler.FileInformationHandler;
import com.qcloud.component.file.model.query.FileInformationQuery;
import com.qcloud.component.file.web.vo.admin.AdminFileInformationVO;
import com.qcloud.component.publicdata.PublicdataClient;

@Controller
@RequestMapping(value = "/" + AdminFileInformationController.DIR)
public class AdminFileInformationController {

    public static final String     DIR = "admin/fileInformation";

    @Autowired
    private FileInformationService fileInformationService;

    @Autowired
    private FileInformationHandler fileInformationHandler;

    @Autowired
    private PublicdataClient       publicdataClient;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, FileInformationQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<FileInformation> page = fileInformationService.page(query, start, PAGE_SIZE);
        List<AdminFileInformationVO> list = fileInformationHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/file-FileInformation-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/file-FileInformation-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(FileInformation fileInformation) {

        fileInformationService.add(fileInformation);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        FileInformation fileInformation = fileInformationService.get(id);
        AdminFileInformationVO adminFileInformationVO = fileInformationHandler.toVO4Admin(fileInformation);
        ModelAndView model = new ModelAndView("/admin/file-FileInformation-edit");
        String fileSize=publicdataClient.getImageInformationByCode(fileInformation.getCode());
        model.addObject("fileInformation", adminFileInformationVO);
        model.addObject("fileSize",fileSize);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(FileInformation fileInformation) {

        fileInformationService.update(fileInformation);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        fileInformationService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
