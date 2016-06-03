<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        管理员管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            管理员列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/tasking/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                                                <th>ID</th>           
                                                <th>处理人ID</th>           
                                                <th>流程申请ID</th>           
                                                <th>任务名称</th>           
                                                <th>流程类型</th>           
                                                <th>申请时间</th>           
                                                <th>接收时间</th>           
                                                <th>表单实例ID</th>           
                                                <th>表单实例ID</th>           
                                                <th>流程实例ID</th>           
                                                <th>流程实例ID</th>           
                                                <th>流程任务ID</th>           
                                                <th>PC页面</th>           
                                                <th>表单编号</th>           
                                                <th>申请类型</th>           
                                                <th>职员姓名</th>           
                                                <th>身份证号</th>           
                                                <th>公司名称</th>           
                                                <th>公司代码</th>           
                                                <th>车牌号</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                        <td>${id}</td>                         
                                                        <td>${clerkId}</td>                         
                                                        <td>${creator}</td>                         
                                                        <td>${name}</td>                         
                                                        <td>${type}</td>                         
                                                        <td>${applyTime}</td>                         
                                                        <td>${receiveTime}</td>                         
                                                        <td>${formId}</td>                         
                                                        <td>${formInstanceId}</td>                         
                                                        <td>${processId}</td>                         
                                                        <td>${processInstId}</td>                         
                                                        <td>${workitemId}</td>                         
                                                        <td>${pcPageUrl}</td>                         
                                                        <td>${code}</td>                         
                                                        <td>${applyType}</td>                         
                                                        <td>${clerkName}</td>                         
                                                        <td>${idCard}</td>                         
                                                        <td>${companyName}</td>                         
                                                        <td>${companyCode}</td>                         
                                                        <td>${plateNumber}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/tasking/toEdit?id=${item.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>							                                 
                                </div>
                            </td>
                        </tr>
						</c:forEach>
                    </tbody>
                </table>    
                <div class="row">
                    <div class="col-xs-12">                  
                       	<%@include file="../page.inc.jsp" %>
                    </div>
                </div>          
            </div>
        </div>
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
         
    });
</script>
