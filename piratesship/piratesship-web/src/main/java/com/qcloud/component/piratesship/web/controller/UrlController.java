package com.qcloud.component.piratesship.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.component.piratesship.web.vo.admin.UrlDescVO;
import com.qcloud.pirates.core.urlXml.URLDescFactory;
import com.qcloud.pirates.core.urlXml.UrlDesc;
import com.qcloud.pirates.core.urlXml.UrlIndex;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.StringUtil;

@Controller
@RequestMapping(value = UrlController.DIR)
public class UrlController {

    public static final String DIR = "/url";

    @RequestMapping
    public FrontAjaxView query(String keyword) {

        //
        List<UrlDesc> list = URLDescFactory.listUrl();
        // List<UrlDesc> result = new ArrayList<UrlDesc>();
        List<UrlDescVO> voList = new ArrayList<UrlDescVO>();
        if (StringUtils.isNotEmpty(keyword)) {
            for (UrlDesc urlDesc : list) {
                if (StringUtil.nullToEmpty(urlDesc.getModule()).indexOf(keyword) > -1 || StringUtil.nullToEmpty(urlDesc.getName()).indexOf(keyword) > -1 || StringUtil.nullToEmpty(urlDesc.getUrl()).indexOf(keyword) > -1) {
                    // result.add(urlDesc);
                    UrlDescVO vo = new UrlDescVO();
                    vo.setName(urlDesc.getName());
                    vo.setUrl(urlDesc.getUrl());
                    vo.setRequestStr(urlDesc.getRequestStr());
                    voList.add(vo);
                }
            }
        } else {
            // result = list;
            for (UrlDesc urlDesc : list) {
                UrlDescVO vo = new UrlDescVO();
                vo.setName(urlDesc.getName());
                vo.setUrl(urlDesc.getUrl());
                // vo.setRequestList(urlDesc.getRequestStr());
                vo.setRequestStr(urlDesc.getRequestStr());
                voList.add(vo);
            }
        }
        FrontAjaxView frontAjaxView = new FrontAjaxView();
        frontAjaxView.setMessage("查询成功");
        frontAjaxView.addObject("list", voList);
        return frontAjaxView;
    }

    @RequestMapping
    public ModelAndView index(String keyword) {

        List<UrlIndex> indexList = URLDescFactory.listIndex();
        List<UrlDesc> list = URLDescFactory.listUrl();
        List<UrlDesc> result = new ArrayList<UrlDesc>();
        int total = 0;
        int linkTotal = 0;
        for (UrlIndex urlIndex : indexList) {
            if (urlIndex.isEnable()) {
                total++;
                for (UrlDesc urlDesc : list) {
                    if (isMatch(urlDesc, urlIndex)) {
                        linkTotal++;
                        break;
                    }
                }
            }
        }
        for (UrlIndex urlIndex : indexList) {
            if (urlIndex.isEnable()) {
                if (StringUtils.isNotEmpty(keyword)) {
                    for (UrlDesc urlDesc : list) {
                        if (isMatch(urlDesc, urlIndex) && (StringUtil.nullToEmpty(urlIndex.getUrl()).indexOf(keyword) > -1 || StringUtil.nullToEmpty(urlDesc.getName()).indexOf(keyword) > -1)) {
                            result.add(urlDesc);
                        }
                    }
                } else {
                    for (UrlDesc urlDesc : list) {
                        if (isMatch(urlDesc, urlIndex)) {
                            result.add(urlDesc);
                        }
                    }
                }
            }
        }
        ModelAndView view = new ModelAndView("piratesship/url-index");
        view.addObject("list", result);
        view.addObject("keyword", StringUtil.nullToEmpty(keyword));
        view.addObject("total", total);
        view.addObject("linkTotal", linkTotal);
        return view;
    }

    private boolean isMatch(UrlDesc url, UrlIndex urlIndex) {

        String urlStr = StringUtil.nullToEmpty(url.getUrl());
        return urlStr.startsWith("/app") && urlStr.substring(4, urlStr.length()).equals(urlIndex.getUrl()) || urlStr.equals(urlIndex.getUrl());
    }

    @RequestMapping
    public ModelAndView notconfiguredIndex() {

        int total = 0;
        int notLinkTotal = 0;
        List<UrlIndex> indexList = URLDescFactory.listIndex();
        List<UrlDesc> list = URLDescFactory.listUrl();
        List<UrlIndex> result = new ArrayList<UrlIndex>();
        for (UrlIndex urlIndex : indexList) {
            if (urlIndex.isEnable()) {
                total++;
                boolean exist = false;
                for (UrlDesc urlDesc : list) {
                    if (isMatch(urlDesc, urlIndex)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    result.add(urlIndex);
                    notLinkTotal++;
                }
            }
        }
        ModelAndView view = new ModelAndView("piratesship/url-notconfigured-index");
        view.addObject("list", result);
        view.addObject("total", total);
        view.addObject("notLinkTotal", notLinkTotal);
        return view;
    }

    @RequestMapping
    public ModelAndView list(String keyword) {

        List<UrlDesc> list = URLDescFactory.listUrl();
        List<UrlDesc> result = new ArrayList<UrlDesc>();
        if (StringUtils.isNotEmpty(keyword)) {
            for (UrlDesc urlDesc : list) {
                if (StringUtil.nullToEmpty(urlDesc.getModule()).indexOf(keyword) > -1 || StringUtil.nullToEmpty(urlDesc.getName()).indexOf(keyword) > -1 || StringUtil.nullToEmpty(urlDesc.getUrl()).indexOf(keyword) > -1) {
                    result.add(urlDesc);
                }
            }
        } else {
            result = list;
        }
        ModelAndView view = new ModelAndView("piratesship/url-list");
        view.addObject("list", result);
        view.addObject("keyword", StringUtil.nullToEmpty(keyword));
        return view;
    }
}
