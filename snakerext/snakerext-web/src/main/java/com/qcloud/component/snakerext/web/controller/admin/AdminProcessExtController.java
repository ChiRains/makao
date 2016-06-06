package com.qcloud.component.snakerext.web.controller.admin;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.snaker.engine.SnakerException;
import org.snaker.engine.access.Page;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.snaker.ISnakerClient;
import com.qcloud.component.snakerext.SnakerExtClient;
import com.qcloud.component.snakerext.web.handler.ProcessExtHandler;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExtVO;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminProcessExtController.DIR)
public class AdminProcessExtController {

    public static final String DIR = "admin/process";

    @Autowired
    private ISnakerClient      snakerClient;

    @Autowired
    private SnakerExtClient    snakerExtClient;

    @Autowired
    private ProcessExtHandler  processExtHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, String displayName) {

        QueryFilter filter = new QueryFilter();
        if (StringUtils.isNotEmpty(displayName)) {
            filter.setDisplayName(displayName);
        }
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        Page<Process> page = new Page<Process>();
        page.setPageNo(pageNum);
        page.setPageSize(PAGE_SIZE);
        List<Process> list = snakerClient.process().getProcesss(page, filter);
        List<AdminProcessExtVO> voList = processExtHandler.toVOList4Admin(list);
        int count = ((Number) page.getTotalCount()).intValue();
        String param = "displayName=" + StringUtil.nullToEmpty(filter.getDisplayName());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-Process-list", DIR + "/list?" + param, pageNum, PAGE_SIZE, count);
        pagingView.addObject("result", voList);
        pagingView.addObject("query", filter);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/snakerext-Process-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(MultipartHttpServletRequest request, String creator, String type) {

        try {
            Iterator<String> names = request.getFileNames();
            while (names.hasNext()) {
                String name = names.next();
                MultipartFile multipartFile = request.getFile(name);
                snakerClient.process().deploy(multipartFile.getInputStream(), creator, type);
            }
        } catch (Exception e) {
            throw new SnakerException("文件错误!");
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView enable(Long id, Integer value) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView start(String processId) {

        AceAjaxView aceAjaxView = new AceAjaxView();
        snakerClient.startInstanceById(String.valueOf(processId));
        return aceAjaxView;
    }
}
