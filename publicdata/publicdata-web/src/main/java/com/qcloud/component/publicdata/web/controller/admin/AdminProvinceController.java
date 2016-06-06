package com.qcloud.component.publicdata.web.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.handler.ProvinceHandler;
import com.qcloud.component.publicdata.model.query.ProvinceQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminProvinceVO;
@Controller
@RequestMapping(value = "/" + AdminProvinceController.DIR)
public class AdminProvinceController {
    public static final String DIR = "admin/province";
    @Autowired
    private ProvinceService    provinceService;
    @Autowired
    private ProvinceHandler    provinceHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, ProvinceQuery query) {
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<Province> page = provinceService.page(query, start, PAGE_SIZE);
        List<AdminProvinceVO> list = provinceHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-Province-list", DIR + "/list", pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd() {
        ModelAndView model = new ModelAndView("/admin/publicdata-Province-add");
        return model;
    }

    @RequestMapping
    public AceAjaxView add(Province province) {
        AssertUtil.assertNotEmpty(province.getName(), "省名不能为空.");
        provinceService.add(province);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        Province province = provinceService.get(id);
        AdminProvinceVO adminProvinceVO = provinceHandler.toVO4Admin(province);
        ModelAndView model = new ModelAndView("/admin/publicdata-Province-edit");
        model.addObject("province", adminProvinceVO);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(Province province) {
        AssertUtil.assertNotEmpty(province.getName(), "省名不能为空.");
        provinceService.update(province);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        provinceService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
    
    
}
