package com.qcloud.component.organization.web.controller.admin;

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
import com.qcloud.component.organization.model.UsergroupUser;
import com.qcloud.component.organization.service.UsergroupUserService;
import com.qcloud.component.organization.web.form.UsergroupUserForm;
import com.qcloud.component.organization.web.handler.UsergroupUserHandler;
import com.qcloud.component.organization.model.query.UsergroupUserQuery;
import com.qcloud.component.organization.web.vo.admin.AdminUsergroupUserVO;
		
@Controller
@RequestMapping(value = "/" + AdminUsergroupUserController.DIR)
public class AdminUsergroupUserController {
	
	public static final String DIR = "admin/usergroupUser";
	
	@Autowired
	private UsergroupUserService usergroupUserService;
	@Autowired
	private UsergroupUserHandler usergroupUserHandler;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, UsergroupUserQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<UsergroupUser> page = usergroupUserService.page(query, start, PAGE_SIZE);
		List<AdminUsergroupUserVO> list = usergroupUserHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/organization-UsergroupUser-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/organization-UsergroupUser-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(UsergroupUserForm usergroupUserForm,Long groupId) {
	   
	    List<UsergroupUser> users=usergroupUserForm.getGuList(); 
	    usergroupUserService.deleteByGroupId(groupId);
	    if(users!=null){
    	    for(UsergroupUser guser:users){
    	        if(guser.getUserId()!=0){
    	            guser.setGroupId(groupId);
    	            usergroupUserService.add(guser);
    	        }
    	    }
	    }
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("保存成功");
		aceAjaxView.setUrl("admin/usergroup/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		UsergroupUser usergroupUser=usergroupUserService.get(id);
		AdminUsergroupUserVO adminUsergroupUserVO=usergroupUserHandler.toVO4Admin(usergroupUser);
		ModelAndView model = new ModelAndView("/admin/organization-UsergroupUser-edit");
		model.addObject("usergroupUser", adminUsergroupUserVO);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(UsergroupUser usergroupUser) {
		usergroupUserService.update(usergroupUser);		
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		usergroupUserService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
	
	
}
