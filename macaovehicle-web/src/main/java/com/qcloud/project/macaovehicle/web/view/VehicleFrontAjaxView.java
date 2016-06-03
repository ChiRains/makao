package com.qcloud.project.macaovehicle.web.view;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import com.qcloud.pirates.core.json.DateJson;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.mvc.AjaxView;
import com.qcloud.pirates.mvc.JsonpUtil;

public class VehicleFrontAjaxView extends AjaxView {

    private Map<String, Object> map = new HashMap<String, Object>();

    public VehicleFrontAjaxView() {

        this(200);
    }

    public VehicleFrontAjaxView(int status) {

        super(status, null);
        super.setData(map);
    }

    @Override
    public ModelAndView addObject(String attributeName, Object attributeValue) {

        map.put(attributeName, attributeValue);
        return super.addObject(attributeName, attributeValue);
    }

    @Override
    public String getContentType() {

        return "application/json; charset=UTF-8";
    }

    /**
     * 
     * 1、默认返回json <br/>
     * URL:http://message.game.yy.com/test/json.do<br/>
     * 返回:{"status":200,"message":"","data":{"username":"hctan","nickname":
     * "pirates"}}<br/>
     * 2、自定义callback参数，返回jsonp<br/>
     * URL:http://message.game.yy.com/test/json.do?callback=callback2 <br/>
     * 返回:callback2({"status":200,"message":"","data":{"username":"hctan",
     * "nickname":"pirates"}}); <br/>
     * 3、非法callback参数 <br/>
     * URL:http://message.game.yy.com/test/json.do?callback=callback.aa <br/>
     * 返回:// 非法callback[callback.aa]. <br/>
     * 
     * 4、自定义var参数，返回script <br/>
     * URL:http://message.game.yy.com/test/json.do?var=abc <br/>
     * 返回:var abc =
     * {"status":200,"message":"","data":{"username":"hctan","nickname"
     * :"pirates"}}; <br/>
     * 5、非法var参数 <br/>
     * URL:http://message.game.yy.com/test/json.do?var=var.aa <br/>
     * 返回:// 非法var[var.aa].
     */
    @Override
    public String getBody(HttpServletRequest request, HttpServletResponse response) {

        boolean format = "true".equals(request.getParameter("format"));
        String dateFormat = request.getParameter("dateFormat");
        Object result = this.getResult();
        {
            String callback = request.getParameter("callback");
            if (StringUtils.isNotEmpty(callback)) {
                // JSON劫持漏洞防范
                // RefererSecurityValidator.checkReferer(request);
                return new JsonpOutput(callback).output(result, format, dateFormat, request);
            }
        }
        {
            String var = request.getParameter("var");
            if (StringUtils.isNotEmpty(var)) {
                // JSON劫持漏洞防范
                // RefererSecurityValidator.checkReferer(request);
                return new ScriptOutput(var).output(result, format, dateFormat, request);
            }
        }
        return new JsonOutput().output(result, format, dateFormat, request);
    }
    public static class JsonOutput {

        public String output(Object data, boolean format, String dateFormat, HttpServletRequest request) {

            if (StringUtils.isEmpty(dateFormat)) {
                if (useStringDateFormat) {
                    return toStringDateJson(data, format);
                } else {
                    return toTimestampJson(data, format);
                }
            } else if ("string".equals(dateFormat)) {
                return toStringDateJson(data, format);
            } else {
                return toTimestampJson(data, format);
            }
        }

        protected String toTimestampJson(Object data, boolean format) {

            if (format) {
                return Json.toFormatJson(data);
            } else {
                return Json.toJson(data);
            }
        }

        protected String toStringDateJson(Object data, boolean format) {

            if (format) {
                return DateJson.toFormatJson(data);
            } else {
                return DateJson.toDateJson(data);
            }
        }
    }
    public static class JsonpOutput extends JsonOutput {

        protected static final Log logger = LogFactory.getLog(JsonpOutput.class);

        private final String       callback;

        public JsonpOutput(String callback) {

            this.callback = callback;
        }

        @Override
        public String output(Object data, boolean format, String dateFormat, HttpServletRequest request) {

            try {
                if (JsonpUtil.isDenyFolder(request)) {
                    throw new IllegalArgumentException("当前目录不允许使用jsonp方式输出数据.");
                }
                JsonpUtil.checkCallback(callback);
                String json = super.output(data, format, dateFormat, request);
                return callback + "(" + json + ");";
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return "// " + e.getMessage();
            }
        }
    }
    public static class ScriptOutput extends JsonOutput {

        protected static final Log logger = LogFactory.getLog(ScriptOutput.class);

        private final String       var;

        public ScriptOutput(String var) {

            this.var = var;
        }

        @Override
        public String output(Object data, boolean format, String dateFormat, HttpServletRequest request) {

            try {
                if (JsonpUtil.isDenyFolder(request)) {
                    throw new IllegalArgumentException("当前目录不允许使用script方式输出数据.");
                }
                JsonpUtil.checkVar(var);
                String json = super.output(data, format, dateFormat, request);
                return "var " + var + " = " + json + ";";
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                return "// " + e.getMessage();
            }
        }
    }
}
