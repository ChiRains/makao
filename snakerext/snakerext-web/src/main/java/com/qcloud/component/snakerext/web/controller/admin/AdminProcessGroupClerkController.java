package com.qcloud.component.snakerext.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.model.query.ClerkQuery;
import com.qcloud.component.organization.service.ClerkService;
import com.qcloud.component.snakerext.model.ProcessGroupClerk;
import com.qcloud.component.snakerext.model.query.ProcessGroupClerkQuery;
import com.qcloud.component.snakerext.service.ProcessGroupClerkService;
import com.qcloud.component.snakerext.web.form.ProcessGroupCLerkForm;
import com.qcloud.component.snakerext.web.handler.ProcessGroupClerkHandler;
import com.qcloud.component.snakerext.web.vo.admin.AdminProcessGroupClerkVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminProcessGroupClerkController.DIR)
public class AdminProcessGroupClerkController {

    public static final String       DIR = "admin/processGroupClerk";

    @Autowired
    private ProcessGroupClerkService processGroupClerkService;

    @Autowired
    private ProcessGroupClerkHandler processGroupClerkHandler;

    @Autowired
    private ClerkService             clerkService;
    

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ProcessGroupClerkQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ProcessGroupClerk> page = processGroupClerkService.page(query, start, PAGE_SIZE);
        List<AdminProcessGroupClerkVO> list = processGroupClerkHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/snakerext-ProcessGroupClerk-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessGroupClerk-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Long groupId,ProcessGroupCLerkForm form) {
        
        List<ProcessGroupClerk> clerks=form.getGuList(); 
        processGroupClerkService.deleteByGroupId(groupId);
        if(clerks!=null){
            for(ProcessGroupClerk clerk:clerks){
                if(clerk.getClerkId()!=0){
                    clerk.setGroupId(groupId);
                    processGroupClerkService.add(clerk);
                }
            }
        }
        
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/selectClerk?groupId="+groupId);
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        ProcessGroupClerk processGroupClerk = processGroupClerkService.get(id);
        AdminProcessGroupClerkVO adminProcessGroupClerkVO = processGroupClerkHandler.toVO4Admin(processGroupClerk);
        ModelAndView model = new ModelAndView("/admin/snakerext-ProcessGroupClerk-edit");
        model.addObject("processGroupClerk", adminProcessGroupClerkVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(ProcessGroupClerk processGroupClerk) {

        processGroupClerkService.update(processGroupClerk);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        processGroupClerkService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView selectClerk(Long groupId,ClerkQuery query) {

        ModelAndView view = new ModelAndView("/admin/snakerext-ProcessGroupClerk-allClerk");
        view.addObject("query", query);
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(query.getName());
        map.put("name", query.getName());
        view.addObject("clerkList", clerkService.listAll(map));
        
        view.addObject("guList", processGroupClerkService.listByGroup(groupId));
        view.addObject("groupId", groupId);
        return view;
    }
}
