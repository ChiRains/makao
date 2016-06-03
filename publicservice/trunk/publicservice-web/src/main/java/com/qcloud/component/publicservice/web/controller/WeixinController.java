package com.qcloud.component.publicservice.web.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.filesdk.QFile;
import com.qcloud.component.parameter.ParameterClient;
import com.qcloud.component.publicservice.model.WeiXinConfig;
import com.qcloud.component.publicservice.service.WeiXinAPIService;
import com.qcloud.component.publicservice.service.WeiXinConfigService;
import com.qcloud.component.publicservice.service.WeiXinUserService;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.HtmlView;
import com.qcloud.pirates.util.AssertUtil;
import com.tencent.WXUtil;
import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.entity.WXUserEntity;

@Controller
@RequestMapping(value = WeixinController.DIR)
public class WeixinController {

    public static final String  DIR        = "/weixinConfig";

    @Autowired
    private ParameterClient     parameterClient;

    @Autowired
    private FileSDKClient       fileSDKClient;

    @Autowired
    private WeiXinConfigService weiXinConfigService;

    @Autowired
    private WeiXinAPIService    weiXinAPIService;

    @Autowired
    private WeiXinUserService   weiXinUserService;

    private final String        DOMAIN_KEY = "domain-key";

    private final String        THIRD      = "user_third";

    /**
     * 得到获取code的url
     * @param redirectPage
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView getAuthorizeUrl(String redirectPage, HttpServletRequest request) {

        AssertUtil.assertNotNull(redirectPage, "redirectPage不能为空!");
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("appid", appId);
        map.put("redirect_uri", "http://" + parameterClient.get(DOMAIN_KEY) + "/user/loginByWeixin.do?pageUri=" + redirectPage);
        map.put("response_type", "code");
        map.put("scope", "snsapi_base");
        map.put("state", "STATE");
        String url = WXUtil.mapToUrl(Configure.CODE_API, map);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("url", url);
        return view;
    }

    /**
     * 得到获取code的url
     * @param redirectPage
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView getCodeUrl(String redirectUri, HttpServletRequest request) {

        AssertUtil.assertNotNull(redirectUri, "redirectUri不能为空!");
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("appid", appId);
        map.put("redirect_uri", redirectUri);
        map.put("response_type", "code");
        map.put("scope", "snsapi_base");
        map.put("state", "STATE");
        String url = WXUtil.mapToUrl(Configure.CODE_API, map);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("url", url);
        return view;
    }

    /**
     * 获取JSSDKConfig配置
     * @param url
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public FrontAjaxView getJSSDKConfig(String url, HttpServletRequest request) {

        AssertUtil.assertNotNull(url, "url不能为空!");
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        String appSecret = weiXinConfig.getAppSecret();
        String jsapiTicket = weiXinAPIService.getJsapiTicket(appId, appSecret);
        long timestamp = (new Date()).getTime()/1000;
        String nonceStr = RandomStringGenerator.getRandomStringByLength(16);
        String signature = WXUtil.getJSSDKSign(jsapiTicket, nonceStr, timestamp, url);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("appId", appId);
        view.addObject("timestamp", timestamp);
        view.addObject("nonceStr", nonceStr);
        view.addObject("signature", signature);
        return view;
    }

    /**
     * 添加图片(微信端)
     * @param media_id      媒体文件ID
     * @return
     */
    @RequestMapping
    public FrontAjaxView addWeixinImage(String media_id) {

        AssertUtil.assertNotNull(media_id, "media_id不能为空!");
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        String appSecret = weiXinConfig.getAppSecret();
        String accessToken = weiXinAPIService.getAccessToken(appId, appSecret);
        QFile file = WXUtil.getImageFile(media_id, accessToken);
        String uid = fileSDKClient.saveToUid(file);
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加图片成功");
        view.addObject("url", fileSDKClient.uidToUrl(uid));
        return view;
    }

    /**
     * 获取用户是否关注公众号
     * @param code
     * @return
     */
    @RequestMapping
    public FrontAjaxView isSubscribe(HttpServletRequest request) {

        String openId = (String) request.getSession().getAttribute(THIRD);
        WeiXinConfig weiXinConfig = weiXinConfigService.get();
        String appId = weiXinConfig.getAppId();
        String appSecret = weiXinConfig.getAppSecret();
        String accessToken = weiXinAPIService.getAccessToken(appId, appSecret);
        WXUserEntity userEntity = WXUtil.getUserInfo(accessToken, openId);
        FrontAjaxView view = new FrontAjaxView();
        view.addObject("subscribe", userEntity.getSubscribe());
        return view;
    }

    /**
     * 访问获取openId
     * @param code
     * @return
     */
    @RequestMapping
    public HtmlView loadOpenId(HttpServletRequest request, String code, String pageUri) {

        String openId = weiXinUserService.requestOpenId(code);
        request.getSession(true).setAttribute(THIRD, openId);
        String url = "http://" + request.getServerName();
        HtmlView view = new HtmlView("<script>window.location.href='" + url + "/" + pageUri + "'</script>");
        return view;
    }
}
