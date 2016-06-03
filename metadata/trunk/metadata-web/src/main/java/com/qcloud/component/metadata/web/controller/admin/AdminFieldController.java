package com.qcloud.component.metadata.web.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.metadata.exception.MetadataException;
import com.qcloud.component.metadata.model.Field;
import com.qcloud.component.metadata.model.Table;
import com.qcloud.component.metadata.model.key.TypeEnum.FieldType;
import com.qcloud.component.metadata.model.query.FieldQuery;
import com.qcloud.component.metadata.service.FieldService;
import com.qcloud.component.metadata.service.TableService;
import com.qcloud.component.metadata.web.handler.FieldHandler;
import com.qcloud.component.metadata.web.vo.admin.AdminFieldVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;

@Controller
@RequestMapping(value = "/" + AdminFieldController.DIR)
public class AdminFieldController {

    public static final String DIR = "admin/field";

    @Autowired
    private FieldService       fieldService;

    @Autowired
    private TableService       tableService;

    @Autowired
    private FieldHandler       fieldHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, FieldQuery query) {

        final int PAGE_SIZE = Integer.MAX_VALUE;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Field> page = fieldService.page(query, start, PAGE_SIZE);
        List<AdminFieldVO> list = fieldHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/metadata-Field-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        pagingView.addObject("typeEnum", FieldType.values());
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd(long tableId) {

        AssertUtil.assertNotNull(tableId, "表id不能为空");
        ModelAndView model = new ModelAndView("/admin/metadata-Field-add");
        model.addObject("typeEnum", FieldType.values());
        model.addObject("tableId", tableId);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Field field) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tableId", field.getTableId());
        map.put("name", field.getName());
        List<Field> fieldList = fieldService.listByMap(map);
        if (fieldList.size() > 0) {
            throw new MetadataException("该表字段名已存在!");
        }
        fieldService.add(field);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list?tableId=" + field.getTableId());
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        Field field = fieldService.get(id);
        AdminFieldVO adminFieldVO = fieldHandler.toVO4Admin(field);
        ModelAndView model = new ModelAndView("/admin/metadata-Field-edit");
        model.addObject("typeEnum", FieldType.values());
        model.addObject("field", adminFieldVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Field field) {

        fieldService.update(field);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list?tableId=" + field.getTableId());
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {

        AssertUtil.assertNotNull(id, "ID不能为空");
        fieldService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public void downloadFile(Long tableId, HttpServletRequest request, HttpServletResponse response) {

        AssertUtil.notNull(tableId, "tableId不能为空!");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tableId", tableId);
        List<Field> fieldList = fieldService.listByMap(map);
        final String dirPath = "/WEB-INF/sql/";
        String realPath = request.getSession().getServletContext().getRealPath("") + dirPath;
        File dir = new File(realPath);
        if (!dir.exists()) dir.mkdir();
        try {
            // 创建sql文件
            String filePath = createSqlFile(request.getRealPath(dirPath), tableService.get(tableId), fieldList);
            // 下载sql文件
            File file = new File(filePath);
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            byte[] content = FileUtils.readFileToByteArray(file);
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建sqkl文件
     * @param path      文件路径
     * @param table     表对象
     * @param fieldList
     * @return
     */
    private String createSqlFile(String path, Table table, List<Field> fieldList) {

        String pathFile = path + File.separator + table.getName() + ".sql";
        try {
            File file = new File(pathFile);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file, true);
            out.write(appendSqlStr(table, fieldList).getBytes("utf-8"));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathFile;
    }

    private String appendSqlStr(Table table, List<Field> fieldList) {

        // =============================================
        String tableName = "metadata_" + table.getName();
        StringBuffer sb = new StringBuffer();
        sb.append("DROP TABLE IF EXISTS `" + tableName + "`;").append("\r\n");
        sb.append("CREATE TABLE `" + tableName + "` (").append("\r\n").append("\t");
        for (Field field : fieldList) {
            String typeStr = "";
            for (FieldType fieldType : FieldType.values()) {
                if (fieldType.getKey() == field.getType()) {
                    switch (fieldType.getKey()) {
                    case 5: // double
                        typeStr = fieldType.getName() + "(" + field.getLength() + "," + field.getPrecision() + ")";
                        break;
                    case 8: // date
                        typeStr = fieldType.getName();
                        break;
                    case 10: // timestamp
                        typeStr = fieldType.getName();
                        break;
                    case 11: // datetime
                        typeStr = fieldType.getName();
                        break;
                    case 12: // blob
                        typeStr = fieldType.getName();
                        break;
                    case 13: // text
                        typeStr = fieldType.getName();
                        break;
                    default:
                        typeStr = fieldType.getName() + "(" + field.getLength() + ")";
                        break;
                    }
                    break;
                }
            }
            // timestamp 比较特殊
            if(field.getType() == 10) {
                sb.append("`" + field.getName() + "` " + typeStr + " NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '" + field.getLabel() + "',").append("\r\n").append("\t");
            } else {
                sb.append("`" + field.getName() + "` " + typeStr + " DEFAULT NULL COMMENT '" + field.getLabel() + "',").append("\r\n").append("\t");
            }
        }
        sb.append("PRIMARY KEY (`id`)").append("\r\n");
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='" + table.getLabel() + "';").append("\r\n");
        return sb.toString();
        // ===============================================
    }
}
