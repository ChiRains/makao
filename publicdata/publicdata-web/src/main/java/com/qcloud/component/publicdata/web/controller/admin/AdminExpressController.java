package com.qcloud.component.publicdata.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.AceAjaxView;
import com.qcloud.pirates.mvc.AcePagingView;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.pirates.web.security.annotation.NoReferer;
import com.qcloud.component.publicdata.PublicdataClient;
import com.qcloud.component.publicdata.model.Express;
import com.qcloud.component.publicdata.model.ExpressDistrict;
import com.qcloud.component.publicdata.service.ExpressDistrictService;
import com.qcloud.component.publicdata.service.ExpressService;
import com.qcloud.component.publicdata.web.form.AdminExpressForm;
import com.qcloud.component.publicdata.web.handler.ExpressDistrictHandler;
import com.qcloud.component.publicdata.web.handler.ExpressHandler;
import com.qcloud.component.publicdata.model.query.ExpressQuery;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressDistrictVO;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressFormVo;
import com.qcloud.component.publicdata.web.vo.admin.AdminExpressVO;
		
@Controller
@RequestMapping(value = "/" + AdminExpressController.DIR)
public class AdminExpressController {
	
	public static final String DIR = "admin/express";
	
	@Autowired
	private ExpressService expressService;
	@Autowired
	private ExpressHandler expressHandler;
	@Autowired
    private ExpressDistrictService expressDistrictService;
	@Autowired
	private ExpressDistrictHandler expressDistrictHandler;
	@Autowired
	private PublicdataClient publicdataClient;
	
	@RequestMapping
	@NoReferer
	public ModelAndView list(Integer pageNum, ExpressQuery query) {
		final int PAGE_SIZE = 10;
		pageNum = RequestUtil.getPageid(pageNum);
		int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
		
		Page<Express> page = expressService.page(query, start, PAGE_SIZE);
		List<AdminExpressVO> list = expressHandler.toVOList4Admin(page.getData());
				
		AcePagingView pagingView = new AcePagingView("/admin/publicdata-Express-list", DIR
				+ "/list", pageNum, PAGE_SIZE, page.getCount());		
		pagingView.addObject("result", list);
	
		return pagingView;
	}
	
	@RequestMapping
	public ModelAndView toAdd() {
		ModelAndView model = new ModelAndView("/admin/publicdata-Express-add");
		return model;
	}
	
	@RequestMapping
	public AceAjaxView add(Express express,AdminExpressForm adminExpressForm) {
	    
		Long id=expressService.add(express);
//		if(id!=-1){//添加express成功
//		    List<AdminExpressFormVo> list=adminExpressForm.getList();
//		    for (AdminExpressFormVo form : list) {
//                if(form.getFirstWeight()!=null &&form.getContinuedWeight()!=null
//                        &&!form.getFirstWeight().equals("")&&!form.getContinuedWeight().equals("")){
//                    ExpressDistrict expressDistrict=new ExpressDistrict();
//                    expressDistrict.setFirstPrice(Double.valueOf(form.getFirstWeight()));
//                    expressDistrict.setContinuedPrice(Double.valueOf(form.getContinuedWeight()));
//                    expressDistrict.setExpressId(id);
//                    expressDistrict.setProvince(form.getProvince());
//                    expressDistrict.setCity(form.getCity());
//                    expressDistrictService.add(expressDistrict);
//                }
//            }
//		}
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("添加成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public ModelAndView toEdit(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		Express express=expressService.get(id);
		AdminExpressVO adminExpressVO=expressHandler.toVO4Admin(express);
		List<ExpressDistrict> districts=expressDistrictService.listByExpressId(id);
		List<AdminExpressDistrictVO> adminExpressDistrictVO=expressDistrictHandler.toVOList4Admin(districts);
		List<String> province=publicdataClient.listProvince();
		ModelAndView model = new ModelAndView("/admin/publicdata-Express-edit");
		model.addObject("express", adminExpressVO);
		model.addObject("expressDistrict",adminExpressDistrictVO);
		model.addObject("province",province);
		return model;
	}
	
	@RequestMapping
	public AceAjaxView edit(Express express,AdminExpressForm adminExpressForm) {
		expressService.update(express);		
//        List<AdminExpressFormVo> list=adminExpressForm.getList();
//        List<ExpressDistrict> districts=expressDistrictService.listByExpressId(express.getId());//获取修改前的districts
//        if(list!=null){
//          //修改快递地区
//            for (AdminExpressFormVo form : list) {
//                  if(form.getFirstWeight()!=null &&form.getContinuedWeight()!=null
//                &&!form.getFirstWeight().equals("")&&!form.getContinuedWeight().equals("")){
//                    if(form.getId()!=0){//update
//                        ExpressDistrict expressDistrict=new ExpressDistrict();
//                        expressDistrict.setId(form.getId());
//                        expressDistrict.setExpressId(express.getId());
//                        expressDistrict.setFirstPrice(Double.valueOf(form.getFirstWeight()));
//                        expressDistrict.setContinuedPrice(Double.valueOf(form.getContinuedWeight()));
//                        expressDistrict.setExpressId(express.getId());
//                        expressDistrict.setProvince(form.getProvince());
//                        expressDistrict.setCity(form.getCity());
//                        expressDistrictService.update(expressDistrict);
//                    }else{//add
//                        ExpressDistrict expressDistrict=new ExpressDistrict();
//                        expressDistrict.setId(form.getId());
//                        expressDistrict.setExpressId(express.getId());
//                        expressDistrict.setFirstPrice(Double.valueOf(form.getFirstWeight()));
//                        expressDistrict.setContinuedPrice(Double.valueOf(form.getContinuedWeight()));
//                        expressDistrict.setProvince(form.getProvince());
//                        expressDistrict.setCity(form.getCity());
//                        expressDistrictService.add(expressDistrict);
//                    }
//                }
//            }
//            //删除去除的
//            for (int i = 0; i < districts.size(); i++) {
//                int sum=0;
//                for (int j = 0; j < list.size(); j++) {
//                    if(list.get(j).getId()!=null){
//                        if(list.get(j).getId()!=districts.get(i).getId()){
//                            sum++;
//                        }
//                    }else{
//                        sum++;
//                    }
//                }
//                if(sum==list.size()){
//                    //System.out.println(districts.get(i).getId());
//                    expressDistrictService.delete(districts.get(i).getId());
//                }
//            }
//        }else{//删除全部
//            for (int i = 0; i < districts.size(); i++) {
//                expressDistrictService.delete(districts.get(i).getId());
//            }
//        }
        
        
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("编辑成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}
	
	@RequestMapping
	public AceAjaxView delete(Long id) {
		AssertUtil.assertNotNull(id, "ID不能为空");
		expressService.delete(id);
		AceAjaxView aceAjaxView = new AceAjaxView();
		aceAjaxView.setMessage("删除成功");
		aceAjaxView.setUrl(DIR + "/list");
		return aceAjaxView;
	}	
	
	@RequestMapping
    public FrontAjaxView provinceList(){
        List<String> list=publicdataClient.listProvince();
        FrontAjaxView view=new FrontAjaxView();
        view.addObject("provinceList",list);
        return view;
    }
	
	@RequestMapping
	public FrontAjaxView cityList(String provinceName){
	    List<String> list=publicdataClient.listCity(provinceName);
	    FrontAjaxView view=new FrontAjaxView();
        view.addObject("cityList",list);
        return view;
	}
	@RequestMapping
    public ModelAndView toList(Integer pageNum, ExpressQuery query) {
        final int PAGE_SIZE = 10;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        
        Page<Express> page = expressService.page(query, start, PAGE_SIZE);
        List<AdminExpressVO> list = expressHandler.toVOList4Admin(page.getData());
                
        AcePagingView pagingView = new AcePagingView("/admin/publicdata-toExpress-list", DIR
                + "/list", pageNum, PAGE_SIZE, page.getCount());        
        pagingView.addObject("result", list);
    
        return pagingView;
    }
}
