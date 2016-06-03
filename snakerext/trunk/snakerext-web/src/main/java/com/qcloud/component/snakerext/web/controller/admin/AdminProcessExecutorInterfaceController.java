package com.qcloud.component.snakerext.web.controller.admin;
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
import com.qcloud.component.snakerext.model.ProcessExecutorInterface;
import com.qcloud.component.snakerext.service.ProcessExecutorInterfaceService;
import com.qcloud.component.snakerext.web.handler.ProcessExecutorInterfaceHandler;
import com.qcloud.component.snakerext.model.query.ProcessExecutorInterfaceQuery;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessExecutorInterfaceVO;
@Controller
@RequestMapping(value = "/" + AdminProcessExecutorInterfaceController.DIR)
public class AdminProcessExecutorInterfaceController {
    public static final String              DIR = "admin/processExecutorInterface";
    @Autowired
    private ProcessExecutorInterfaceService processExecutorInterfaceService;
    @Autowired
    private ProcessExecutorInterfaceHandler processExecutorInterfaceHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ProcessExecutorInterfaceQuery query) {
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ProcessExecutorInterface> page = processExecutorInterfaceService.page(query, start, PAGE_SIZE);
        List<AdminProcessExecutorInterfaceVO> list = processExecutorInterfaceHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-ProcessExecutorInterface-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessExecutorInterface-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(ProcessExecutorInterface processExecutorInterface) {
        processExecutorInterfaceService.add(processExecutorInterface);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        ProcessExecutorInterface processExecutorInterface = processExecutorInterfaceService.get(id);
        AdminProcessExecutorInterfaceVO adminProcessExecutorInterfaceVO = processExecutorInterfaceHandler.toVO4Admin(processExecutorInterface);
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessExecutorInterface-edit");
        model.addObject("processExecutorInterface", adminProcessExecutorInterfaceVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ProcessExecutorInterface processExecutorInterface) {
        processExecutorInterfaceService.update(processExecutorInterface);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        processExecutorInterfaceService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
