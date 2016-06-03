package com.qcloud.component.metadata.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.metadata.exception.MetadataException;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.query.TableQuery;
import com.qcloud.component.metadata.service.FieldService;
import com.qcloud.component.metadata.service.TableService;
import com.qcloud.component.metadata.web.handler.TableHandler;
import com.qcloud.component.metadata.web.vo.admin.AdminTableVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminTableController.DIR)
public class AdminTableController {

    public static final String DIR = "admin/table";

    @Autowired
    private TableService       tableService;

    @Autowired
    private FieldService       fieldService;

    @Autowired
    private TableHandler       tableHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, TableQuery query) {

        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Table> page = tableService.page(query, start, PAGE_SIZE);
        List<AdminTableVO> list = tableHandler.toVOList4Admin(page.getData());
        String param = "label=" + StringUtil.nullToEmpty(query.getLabel()) + "&name=" + StringUtil.nullToEmpty(query.getName());
        AcePagingView pagingView = new AcePagingView("/admin/metadata-Table-list", DIR + "/list?" + param, pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {

        ModelAndView model = new ModelAndView("/admin/metadata-Table-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Table table) {

        List<Table> tbList = tableService.getByName(table.getName());
        if (tbList.size() > 0) {
            throw new MetadataException("表名已存在!");
        }
        tableService.add(table);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Table table = tableService.get(id);
        AdminTableVO adminTableVO = tableHandler.toVO4Admin(table);
        ModelAndView model = new ModelAndView("/admin/metadata-Table-edit");
        model.addObject("table", adminTableVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Table table) {

        tableService.update(table);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        tableService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView initBackup(Long tableId) {

        Table table = tableService.get(tableId);
        AssertUtil.assertNotNull(table, "表定义不存在." + tableId);
        String backupName = table.getName() + "_hist";
        List<Table> backupTableList = tableService.getByName(backupName);
        if (backupTableList.size() > 0) {
            throw new MetadataException("元数据备份表已经存在,如数据表有变化,请修改字段定义." + backupName);
        }
        Table backupTable = new Table();
        backupTable.setLabel(table.getLabel() + "-备份表");
        backupTable.setName(backupName);
        backupTable.setRemark(table.getRemark());
        tableService.add(backupTable);
        List<Field> fieldList = fieldService.listByTable(table.getId());
        for (Field field : fieldList) {
            Field backupField = new Field();
            backupField.setLabel(field.getLabel());
            backupField.setLength(field.getLength());
            backupField.setName(field.getName());
            backupField.setPrecision(field.getPrecision());
            backupField.setRemark(field.getRemark());
            backupField.setTableId(backupTable.getId());
            backupField.setType(field.getType());
            fieldService.add(backupField);
        }
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("初始化备份表成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
