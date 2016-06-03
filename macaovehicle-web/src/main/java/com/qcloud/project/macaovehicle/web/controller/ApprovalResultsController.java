package com.qcloud.project.macaovehicle.web.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.mvc.FrontPagingView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.pirates.util.NumberUtil;
import com.qcloud.pirates.util.RequestUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.ApprovalResults;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ApprovalResultState;
import com.qcloud.project.macaovehicle.model.query.ApprovalResultsQuery;
import com.qcloud.project.macaovehicle.service.ApprovalResultsService;
import com.qcloud.project.macaovehicle.web.handler.ApprovalResultsHandler;
import com.qcloud.project.macaovehicle.web.vo.ApprovalResultsVO;

@Controller
@RequestMapping(value = ApprovalResultsController.DIR)
public class ApprovalResultsController {

    //
    public static final String     DIR = "/approvalResults";

    //
    @Autowired
    private ApprovalResultsService approvalResultsService;

    //
    @Autowired
    private ApprovalResultsHandler approvalResultsHandler;

    //
    // @RequestMapping
    // public FrontAjaxView addResults(ApprovalResults approvalResults) {
    //
    // // AssertUtil.assertTrue(approvalResults.getFormInstanceId()>0, "表单实例Id不能为空");
    // // approvalResults.setTime(new Date());
    // // approvalResultsService.add(approvalResults);
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("添加审批结果成功");
    // return view;
    // }
    //
    @RequestMapping
    public FrontPagingView list(ApprovalResultsQuery query, Integer pageNum, Integer pageSize) {

        final int PAGE_SIZE = pageSize == null || pageSize <= 0 ? 10 : pageSize;
        pageNum = RequestUtil.getPageid(pageNum);
        int start = NumberUtil.getPageStart(pageNum, PAGE_SIZE);
        Page<ApprovalResults> pages = approvalResultsService.page(query, start, PAGE_SIZE);
        List<ApprovalResultsVO> voList = approvalResultsHandler.toVOList(pages.getData());
        FrontPagingView view = new FrontPagingView(pageNum, pageSize, PAGE_SIZE);
        view.addObject("result", voList);
        return view;
    }
    //
    // // 国检
    // @RequestMapping
    // public FrontAjaxView countryRecord(Long id) {
    //
    // AssertUtil.assertTrue(id > 0, "id不能为空");
    // ApprovalResults results = approvalResultsService.get(id);
    // AssertUtil.assertNotNull(results, "审批结果不存在." + id);
    // AssertUtil.assertTrue(results.getState() >= ApprovalResultState.APPLY_RECORD.getKey() && results.getState() != ApprovalResultState.RECORD_FAILED.getKey(), "状态不正确");
    // if (results.getState() == TypeEnum.ApprovalResultState.APPLY_RECORD.getKey()) {
    // results.setState(TypeEnum.STATE_CONSTANT + TypeEnum.RecordStateType.country.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // } else {
    // int num = results.getState() % 1000;
    // AssertUtil.assertTrue(num < TypeEnum.RecordStateType.border.getKey(), "状态不正确,不允许重复备案");
    // results.setState(results.getState() + TypeEnum.RecordStateType.country.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // }
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("操作成功,备案通过");
    // return view;
    // }
    //
    // // 边检
    // @RequestMapping
    // public FrontAjaxView borderRecord(Long id) {
    //
    // AssertUtil.assertTrue(id > 0, "id不能为空");
    // ApprovalResults results = approvalResultsService.get(id);
    // AssertUtil.assertNotNull(results, "审批结果不存在." + id);
    // AssertUtil.assertTrue(results.getState() >= TypeEnum.ApprovalResultState.APPLY_RECORD.getKey() && results.getState() != TypeEnum.ApprovalResultState.RECORD_FAILED.getKey(), "状态不正确");
    // if (results.getState() == TypeEnum.ApprovalResultState.APPLY_RECORD.getKey()) {
    // results.setState(TypeEnum.STATE_CONSTANT + TypeEnum.RecordStateType.border.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // } else {
    // int num = results.getState() % 100;
    // AssertUtil.assertTrue(num < TypeEnum.RecordStateType.border.getKey(), "状态不正确,不允许重复备案");
    // results.setState(results.getState() + TypeEnum.RecordStateType.border.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // }
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("操作成功,备案通过");
    // return view;
    // }
    //
    // // 海关检
    // @RequestMapping
    // public FrontAjaxView haikwanRecord(Long id) {
    //
    // AssertUtil.assertTrue(id > 0, "id不能为空");
    // ApprovalResults results = approvalResultsService.get(id);
    // AssertUtil.assertNotNull(results, "审批结果不存在." + id);
    // AssertUtil.assertTrue(results.getState() >= TypeEnum.ApprovalResultState.APPLY_RECORD.getKey() && results.getState() != TypeEnum.ApprovalResultState.RECORD_FAILED.getKey(), "状态不正确");
    // if (results.getState() == TypeEnum.ApprovalResultState.APPLY_RECORD.getKey()) {
    // results.setState(TypeEnum.STATE_CONSTANT + TypeEnum.RecordStateType.haikwan.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // } else {
    // int num = results.getState() % 10;
    // AssertUtil.assertTrue(num < TypeEnum.RecordStateType.haikwan.getKey(), "状态不正确,不允许重复备案");
    // results.setState(results.getState() + TypeEnum.RecordStateType.haikwan.getKey());
    // approvalResultsService.updateResultState(id, results.getState());
    // }
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("操作成功,备案通过");
    // return view;
    // }
    //
    // // 备案不通过
    // @RequestMapping
    // public FrontAjaxView notThrough(Long id){
    //
    // AssertUtil.assertTrue(id > 0, "id不能为空");
    // ApprovalResults results = approvalResultsService.get(id);
    // AssertUtil.assertNotNull(results, "审批结果不存在." + id);
    // //
    // int maxNum=TypeEnum.STATE_CONSTANT+TypeEnum.RecordStateType.country.getKey()+TypeEnum.RecordStateType.border.getKey()+TypeEnum.RecordStateType.haikwan.getKey();
    // int minNum=TypeEnum.STATE_CONSTANT;
    // if(results.getState()==ApprovalResultState.APPLY_RECORD.getKey() ||(results.getState()>=minNum&&results.getState()<=maxNum)){
    // approvalResultsService.updateResultState(id, ApprovalResultState.RECORD_FAILED.getKey());
    // }else{
    // throw new MacaovehicleException("操作失败,审批结果状态不正确");
    // }
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("操作成功,备案不通过");
    // return view;
    // }
    //
    // //3检同时通过
    // @RequestMapping
    // public FrontAjaxView bothThrough(Long id){
    //
    // AssertUtil.assertTrue(id > 0, "id不能为空");
    // ApprovalResults results = approvalResultsService.get(id);
    // AssertUtil.assertNotNull(results, "审批结果不存在." + id);
    // //
    // int maxNum=TypeEnum.STATE_CONSTANT+TypeEnum.RecordStateType.country.getKey()+TypeEnum.RecordStateType.border.getKey()+TypeEnum.RecordStateType.haikwan.getKey();
    // int minNum=TypeEnum.STATE_CONSTANT;
    // if(results.getState()==ApprovalResultState.APPLY_RECORD.getKey() ||(results.getState()>=minNum&&results.getState()<=maxNum)){
    // approvalResultsService.updateResultState(id, ApprovalResultState.RECORD_SUCCESS.getKey());
    // }else{
    // throw new MacaovehicleException("操作失败,审批结果状态不正确");
    // }
    // FrontAjaxView view = new FrontAjaxView();
    // view.setMessage("操作成功,备案通过");
    // return view;
    // }
}
