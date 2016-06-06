package com.qcloud.component.organization.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.Contacts;
import com.qcloud.component.organization.QContacts;
import com.qcloud.component.organization.model.Department;
import com.qcloud.component.organization.model.key.TypeEnum;
import com.qcloud.component.organization.service.ClerkPostService;
import com.qcloud.component.organization.service.DepartmentClerkService;
import com.qcloud.component.organization.service.DepartmentService;
import com.qcloud.component.organization.service.PostService;
import com.qcloud.component.organization.web.form.ContactsForm;
import com.qcloud.component.organization.web.handler.ContactsHandler;
import com.qcloud.component.organization.web.vo.ContactsVO;
import com.qcloud.component.organization.web.vo.DepartmentKeyValue;
import com.qcloud.component.organization.web.vo.ExportContactsVO;
import com.qcloud.component.template.client.excel.ExcelClient;
import com.qcloud.component.template.client.instance.ClientFactory;
import com.qcloud.component.template.client.instance.OperatePVFactory;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = ContactsController.DIR)
public class ContactsController {

    public static final String DIR = "/contacts";

    @Autowired
    private ContactsHandler    contactsHandler;

    @Autowired
    private Contacts           contacts;

    @Autowired
    DepartmentService          departmentService;

    @Autowired
    DepartmentClerkService     departmentClerkService;

    @Autowired
    ClerkPostService           clerkPostService;

    @Autowired
    PostService                postService;

    @RequestMapping
    @NoReferer
    public FrontPagingView list(Integer pageNum, ContactsForm query, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<QContacts> page = contacts.query(query.getName(), query.getDepartmentId(), start, PAGE_SIZE);
        List<ContactsVO> contactsList = contactsHandler.toVOList(page.getData());
        FrontPagingView pagingView = new FrontPagingView(pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", contactsList);
        return pagingView;
    }

    @SuppressWarnings("deprecation")
    @RequestMapping
    public void export(HttpServletRequest resuest, HttpServletResponse response, ContactsForm query) {

        try {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=contacts.xls");
            Page<QContacts> page = contacts.query(query.getName(), query.getDepartmentId(), 0, Integer.MAX_VALUE);
            List<ExportContactsVO> contactsList = contactsHandler.toVOList4Export(page.getData());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("result", contactsList);
            String fileDir = resuest.getRealPath(TypeEnum.EXCEL_TEMPLATE_DIR);
            ExcelClient excelClient = ClientFactory.getExcelClientInstance();
            excelClient.parse(OperatePVFactory.getTemplateFilePV(fileDir + "/contacts.xls"), OperatePVFactory.getObjectValuePV(map), OperatePVFactory.getROOSPV(response.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping
    public FrontAjaxView departmentKeyValue(String name) {

        List<Department> dList = departmentService.listAll();
        List<DepartmentKeyValue> list = new ArrayList<DepartmentKeyValue>();
        for (Department department : dList) {
            DepartmentKeyValue vo = new DepartmentKeyValue();
            vo.setId(department.getId());
            vo.setName(department.getName());
            Page<QContacts> page = contacts.query(name, department.getId(), 0, Integer.MAX_VALUE);
            List<ContactsVO> voList = contactsHandler.toVOList(page.getData());
            vo.setNumber(page.getCount());
            vo.setContactsVOs(voList);
            list.add(vo);
        }
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("departmentKeyValue", list);
        return view;
    }
}
