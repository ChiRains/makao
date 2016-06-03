package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.organization.model.Clerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.pirates.core.json.Json;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.HistoryRecords;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.UserType;
import com.qcloud.project.macaovehicle.model.query.HistoryRecordsQuery;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.service.HistoryRecordsService;
import com.qcloud.project.macaovehicle.web.form.HistoryRecordsForm;
import com.qcloud.project.macaovehicle.web.handler.HistoryRecordsHandler;
import com.qcloud.project.macaovehicle.web.vo.HistoryRecordsVO;

@Controller
@RequestMapping(value = HistoryRecordsController.DIR)
public class HistoryRecordsController {

    public static final String          DIR = "/historyRecords";

    @Autowired
    private HistoryRecordsService       historyRecordsService;

    @Autowired
    private HistoryRecordsHandler       historyRecordsHandler;

    @Autowired
    private CarOwnerService             carOwnerService;

    @Autowired
    private ClerkHelper                 clerkHelper;

    @Autowired
    private CarOwnerEnterprisersService enterprisersService;

    @Autowired
    private CarOwnerWorkersService      workersService;

    @Autowired
    private CarOwnerHousersService      housersService;

    @Autowired
    private CarOwnerTalentService       talentService;

    @Autowired
    private CarOwnerAcquisitionService  acquisitionService;

    /**
     * 添加修改字段历史记录
     * @param request
     * @return
     */
    @RequestMapping
    public FrontAjaxView add(HttpServletRequest request, HistoryRecordsForm historyRecordsForm, HistoryRecords historyRecords) {

        long carOwnerId = historyRecords.getCarOwnerId();
        AssertUtil.assertTrue(isChecked(historyRecords), "类型type非法.");
        AssertUtil.greatZero(carOwnerId, "车主id不能为空.");
        AssertUtil.greatZero(historyRecords.getType(), "类型type不能为空.");
        Clerk clerk = clerkHelper.getClerk(request);
        //
        CarOwner carOwner = carOwnerService.get(carOwnerId);
        AssertUtil.assertNotNull(carOwner, "车主不存在." + carOwnerId);
        CarOwnerEnterprisers enterprisers = enterprisersService.getByCarOwner(carOwnerId);
        CarOwnerWorkers workers = workersService.getByCarOwner(carOwnerId);
        CarOwnerHousers housers = housersService.getByCarOwner(carOwnerId);
        CarOwnerTalent talent = talentService.getByCarOwner(carOwnerId);
        CarOwnerAcquisition acquisition = acquisitionService.getByCarOwner(carOwnerId);
        addComparesRecords(historyRecordsForm, historyRecords, carOwner, clerk.getId());
        addComparesRecords(historyRecordsForm, historyRecords, enterprisers, clerk.getId());
        addComparesRecords(historyRecordsForm, historyRecords, workers, clerk.getId());
        addComparesRecords(historyRecordsForm, historyRecords, housers, clerk.getId());
        addComparesRecords(historyRecordsForm, historyRecords, talent, clerk.getId());
        addComparesRecords(historyRecordsForm, historyRecords, acquisition, clerk.getId());
        //
        FrontAjaxView view = new FrontAjaxView();
        view.setMessage("添加历史修改记录成功!");
        return view;
    }

    @RequestMapping
    public FrontPagingView list(HistoryRecordsQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<HistoryRecords> pages = historyRecordsService.page(query, start, PAGE_SIZE);
        List<HistoryRecordsVO> voList = historyRecordsHandler.toVOList(pages.getData());
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, PAGE_SIZE);
        view.addObject("result", voList);
        return view;
    }

    // 返回对比不同的字段以及值
    @SuppressWarnings("unchecked")
    private void addComparesRecords(HistoryRecordsForm historyRecordsForm, HistoryRecords historyRecords, Object obj, Long clerkId) {

        if (obj == null) return;
        Map<String, Object> jsonMap = Json.toMap(Json.toJson(obj));
        //
        Map<String, Object> map = Json.toMap(Json.toJson(historyRecordsForm));
        Iterator<Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            if (entry.getValue() != null) {
                Map<String, Object> childrenMap = (Map<String, Object>) entry.getValue();
                Iterator<Entry<String, Object>> childrenIt = childrenMap.entrySet().iterator();
                // 获取传过来的值
                while (childrenIt.hasNext()) {
                    Entry<String, Object> childrenEntry = childrenIt.next();
                    if (jsonMap.containsKey(childrenEntry.getKey())) {
                        // 旧数据不等于新数据
                        if (childrenEntry.getValue() != null) {
                            if (childrenEntry.getValue() instanceof Integer && (Integer) childrenEntry.getValue() == 0) {
                                continue;
                            }
                            if (childrenEntry.getValue() instanceof Double && (Double) childrenEntry.getValue() == 0) {
                                continue;
                            }
                            System.out.println(childrenEntry.getKey() + ":" + jsonMap.get(childrenEntry.getKey()));
                            System.out.println(childrenEntry.getKey() + ":" + childrenEntry.getValue());
                            if (!jsonMap.get(childrenEntry.getKey()).toString().equals(childrenEntry.getValue().toString())) {
                                HistoryRecords hr = new HistoryRecords();
                                hr.setCarOwnerId(historyRecords.getCarOwnerId());
                                hr.setUpdateParam(childrenEntry.getKey());
                                hr.setUpdateParamStr(historyRecords.getUpdateParamStr());
                                hr.setOldValue(jsonMap.get(childrenEntry.getKey()).toString());
                                hr.setNewValue(childrenEntry.getValue().toString());
                                hr.setUpdateTime(new Date());
                                hr.setClerkId(clerkId);
                                hr.setType(historyRecords.getType());
                                historyRecordsService.add(hr);
                            }
                        }
                    }
                }
            }
        }
    }

    // 验证传值是否正确
    private boolean isChecked(HistoryRecords historyRecords) {

        boolean isOK = false;
        for (UserType userType : UserType.values()) {
            if (historyRecords.getType() == userType.getKey()) {
                isOK = true;
            }
        }
        return isOK;
    }
}
