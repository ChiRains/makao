package com.qcloud.component.publicservice.web.handler.url;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qcloud.pirates.web.filter.AbstractUriHandler;

public class CommonQuestionUriHandlerImpl extends AbstractUriHandler {

	@Override
	public List<String> adminUris() {						// 表示这些页面成功登陆后就能进入
		List<String> list = new ArrayList<String>();
		list.add("/admin/commonQuestion/list.do");
		list.add("/admin/commonQuestion/upward.do");
		list.add("/admin/commonQuestion/downward.do");
		list.add("/admin/commonQuestion/toAdd.do");
		list.add("/admin/commonQuestion/toEdit.do");
		list.add("/admin/commonQuestion/add.do");
		list.add("/admin/commonQuestion/edit.do");
		list.add("/admin/commonQuestion/delete.do");
		
		return list;
	}

	@Override
	public List<String> permissionUris() {					// 表示这些页授权之后，就能进入
		List<String> list = new ArrayList<String>();
		list.add("/admin/commonQuestion/list.do");
		
		return list;
	}
	
	@Override
    public Map<String, List<String>> permissionRelaMap() {	// 注册按钮与菜单的关系，表示只要有权限进入相关菜单，就能使用与菜单相关的按钮
        List<String> list = stringToList("/admin/commonQuestion/list.do");		// 菜单的Url
        Map<String, List<String>> map = new HashMap<String, List<String>>();	// 属于相关菜单的按钮
        map.put("/admin/commonQuestion/list.do", list);
        map.put("/admin/commonQuestion/upward.do", list);
        map.put("/admin/commonQuestion/downward.do", list);
        map.put("/admin/commonQuestion/toAdd.do", list);
        map.put("/admin/commonQuestion/toEdit.do", list);
        map.put("/admin/commonQuestion/add.do", list);
        map.put("/admin/commonQuestion/edit.do", list);
        map.put("/admin/commonQuestion/delete.do", list);
        
        return map;
    }
	
	@Override
    public List<String> whiteNameUris() {	// 前台页面加入白名单，不需要授权也可以进入
		List<String> list = new ArrayList<String>();
        list.add("/commonQuestion/listCommonQuestion.do");
        list.add("/commonQuestion/getCommonQuestion.do");
        
        return list;
    }
}
