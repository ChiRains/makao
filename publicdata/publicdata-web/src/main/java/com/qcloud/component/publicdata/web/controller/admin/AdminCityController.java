package com.qcloud.component.publicdata.web.controller.admin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.CityQuery;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.handler.CityHandler;
import com.qcloud.component.publicdata.web.handler.ProvinceHandler;
import com.qcloud.component.publicdata.web.vo.admin.AdminCityVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminProvinceVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
@Controller
@RequestMapping(value = "/" + AdminCityController.DIR)
public class AdminCityController {
    public static final String DIR = "admin/city";
    @Autowired
    private CityService        cityService;
    @Autowired
    private CityHandler        cityHandler;
    @Autowired
    private PublicdataClient   publicdataClient;
    @Autowired
    private ProvinceService    provinceService;
    @Autowired
    private ProvinceHandler    provinceHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, CityQuery query) {
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<City> page = cityService.page(query, start, PAGE_SIZE);
        List<AdminCityVO> list = cityHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-City-list", DIR + "/list?provinceId=" + query.getProvinceId() + "&name=" + StringUtil.nullToEmpty(query.getName()), pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> pList = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), query.getProvinceId(), "selected");
        pagingView.addObject("provinceList", pList);
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public FrontAjaxView queryByProvince(Long provinceId) {
        List<City> list = new ArrayList<City>();
        if (provinceId != null && provinceId > 0) {
            CityQuery query = new CityQuery();
            query.setProvinceId(provinceId);
            Page<City> page = cityService.page(query, 0, Integer.MAX_VALUE);
            list = page.getData();
        }
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("cityList", list);
        return frontAjaxView;
    }

    @RequestMapping
    public ModelAndView toAdd() {
        ModelAndView model = new ModelAndView("/admin/publicdata-City-add");
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> list = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), -1, "selected");
        model.addObject("provinceList", list);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(City city) {
        AssertUtil.assertNotEmpty(city.getName(), "市名不能为空.");
        cityService.add(city);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        City city = cityService.get(id);
        AdminCityVO adminCityVO = cityHandler.toVO4Admin(city);
        ModelAndView model = new ModelAndView("/admin/publicdata-City-edit");
        model.addObject("city", adminCityVO);
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> list = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), city.getProvinceId(), "selected");
        model.addObject("provinceList", list);
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(City city) {
        AssertUtil.assertNotEmpty(city.getName(), "市名不能为空.");
        cityService.update(city);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        cityService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
    
    
}
