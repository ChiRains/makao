package com.qcloud.component.publicdata.web.controller.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.publicdata.IntKeyValue;
import com.qcloud.component.publicdata.KeyValueVO;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.City;
import com.qcloud.component.publicdata.model.District;
import com.qcloud.component.publicdata.model.Province;
import com.qcloud.component.publicdata.model.query.DistrictQuery;
import com.qcloud.component.publicdata.service.CityService;
import com.qcloud.component.publicdata.service.DistrictService;
import com.qcloud.component.publicdata.service.ProvinceService;
import com.qcloud.component.publicdata.web.handler.CityHandler;
import com.qcloud.component.publicdata.web.handler.DistrictHandler;
import com.qcloud.component.publicdata.web.handler.ProvinceHandler;
import com.qcloud.component.publicdata.web.vo.admin.AdminCityVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminDistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminProvinceVO;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.util.StringUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
@Controller
@RequestMapping(value = "/" + AdminDistrictController.DIR)
public class AdminDistrictController {
    public static final String DIR = "admin/district";
    @Autowired
    private DistrictService    districtService;
    @Autowired
    private DistrictHandler    districtHandler;
    @Autowired
    private PublicdataClient   publicdataClient;
    @Autowired
    private ProvinceService    provinceService;
    @Autowired
    private ProvinceHandler    provinceHandler;
    @Autowired
    private CityService        cityService;
    @Autowired
    private CityHandler        cityHandler;

    @RequestMapping
    @NoReferer
    public ModelAndView list(Integer pageNum, DistrictQuery query) {
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<District> page = districtService.page(query, start, PAGE_SIZE);
        List<AdminDistrictVO> list = districtHandler.toVOList4Admin(page.getData());
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-District-list", DIR + "/list?provinceId=" + query.getProvinceId() + "&cityId=" + query.getCityId() + "&name=" + StringUtil.nullToEmpty(query.getName()), pageNum, PAGE_SIZE, page.getCount());
        pagingView.addObject("result", list);
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> pList = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), query.getProvinceId(), "selected");
        pagingView.addObject("provinceList", pList);
        if (query.getProvinceId() > 0) {
            List<City> cityList = cityService.listByProvince(query.getProvinceId());
            List<AdminCityVO> cityVOList = cityHandler.toVOList4Admin(cityList);
            List<KeyValueVO> cityKVList = publicdataClient.exchageObj(cityVOList.toArray(new IntKeyValue[cityVOList.size()]), query.getCityId(), "selected");
            pagingView.addObject("cityList", cityKVList);
        }
        pagingView.addObject("query", query);
        return pagingView;
    }

    @RequestMapping
    public ModelAndView toAdd(Long provinceId) {
        provinceId = provinceId == null ? -1 : provinceId;
        ModelAndView model = new ModelAndView("/admin/publicdata-District-add");
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> list = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), provinceId, "selected");
        model.addObject("provinceList", list);
        return model;
    }

    @RequestMapping
    public AceAjaxView add(District district) {
        AssertUtil.assertNotEmpty(district.getName(), "区/县名不能为空.");
        districtService.add(district);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("添加成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public ModelAndView toEdit(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        District district = districtService.get(id);
        AdminDistrictVO adminDistrictVO = districtHandler.toVO4Admin(district);
        ModelAndView model = new ModelAndView("/admin/publicdata-District-edit");
        model.addObject("district", adminDistrictVO);
        List<Province> provinceList = provinceService.listAll();
        List<AdminProvinceVO> voList = provinceHandler.toVOList4Admin(provinceList);
        List<KeyValueVO> list = publicdataClient.exchageObj(voList.toArray(new IntKeyValue[voList.size()]), district.getProvinceId(), "selected");
        model.addObject("provinceList", list);
        if (district.getProvinceId() > 0) {
            List<City> cityList = cityService.listByProvince(district.getProvinceId());
            List<AdminCityVO> cityVOList = cityHandler.toVOList4Admin(cityList);
            List<KeyValueVO> cityKVList = publicdataClient.exchageObj(cityVOList.toArray(new IntKeyValue[cityVOList.size()]), district.getCityId(), "selected");
            model.addObject("cityList", cityKVList);
        }
        return model;
    }

    @RequestMapping
    public AceAjaxView edit(District district) {
        AssertUtil.assertNotEmpty(district.getName(), "区/县名不能为空.");
        districtService.update(district);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("编辑成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }

    @RequestMapping
    public AceAjaxView delete(Long id) {
        AssertUtil.assertNotNull(id, "ID不能为空");
        districtService.delete(id);
        AceAjaxView aceAjaxView = new AceAjaxView();
        aceAjaxView.setMessage("删除成功");
        aceAjaxView.setUrl(DIR + "/list");
        return aceAjaxView;
    }
}
