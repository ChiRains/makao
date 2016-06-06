<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>流程定义</title>
<style>
    .select-product-dialog {
        top: 50px;
    }

    .select-product-dialog tr {
        word-break: break-all;
    }

    .select-product-dialog .modal-content {
        min-height: 600px;
        min-width: 700px;
    }

    /*.select-dialog .modal-body{*/
    /*padding: 0;*/
    /*}*/
</style>
<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
       流程定义
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            流程列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/process/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>
                    <div class="col-xs-6">
                        <div class="text-right">
	                        <label>
	                            <form action="#admin/process/list" onsubmit="listFormSearch(this); return false">
	                               <div class="dataTables_length">
	                               			<input type="search" class="form-control search-query" placeholder="流程显示名称" name="displayName" value="${query.displayName}">
	                                   		<button type="submit" class="btn btn-purple btn-sm">
	                                            <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
	                                            查询
	                                        </button>                                        
	                                 </div>
	                            </form>
	                        </label>
                        </div>
                    </div>              
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">
                    	<th>序号</th>
	                    <th>流程名称</th>
	                    <th>流程显示名称</th>
	                    <th>版本</th>
	                    <th>创建时间</th>
	                    <th>创建人</th>
	                    <th>是否可用</th>
	                    <th>主表单</th>
	                    <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>
                            	<td>${current.index + 1}</td>                        
                                <td>${item.name}</td>
                                <td>${item.displayName}</td>
                                <td>${item.version}</td>
                                <td>${item.createTime}</td>
                                <td>${item.creator}</td>
                                <td>
                                	<input value="${item.id}" type="checkbox" data-id="${item.id}" class="ace ace-switch ace-switch-5 ajax_switch" disabled
                                	<c:if test="${item.state ne 0}">checked</c:if>/>
        							<span class="lbl middle"></span>
                                </td>
                                <td>${item.formDef.name}</td>
                                <td>
	                                <div class="hidden-sm hidden-xs action-buttons">
                                		<a class="btn btn-primary btn-xs add-processForm-trigger" data-id="${item.id}" data-name="主表单-${item.displayName}">
                                		<i class="ace-icon fa fa-keyboard-o bigger-130"></i>主表单</a>
                                		
	                                   <a href="#admin/taskFormAccess/list?processId=${item.id}" class="btn btn-primary btn-xs">
	                                     <i class="ace-icon fa fa-keyboard-o bigger-130"></i>活动</a>
	                                </div>
                                </td>
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
          $(".ajax_switch").on('change',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id'),
                value:el[0].checked?'1':'0'
            };
            $.ajax({
                url:'/admin/process/enable.do',
                type:'POST',
                data:data,
                dataType: 'json',
                cache: false,
                async: false,
                error: function(){
                    BootstrapDialog.alert({
                        title: '错误',
                        message:'网络错误，请稍后再尝试！',
                        type: BootstrapDialog.TYPE_DANGER,
                        callback: function(){setTimeout(function(){el[0].checked = !el[0].checked;},500)}
                    });
                },
                success:function(rd){
                    if(rd['status'] != 200){
                        BootstrapDialog.alert({
                            title: '错误',
                            message:rd.message,
                            type: BootstrapDialog.TYPE_DANGER,
                            callback: function(){setTimeout(function(){el[0].checked = !el[0].checked;},500)}
                        });
                    }
                }
            })
        })
        
         $(".add-processForm-trigger").on("click", function () {
     		// 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".select-form-trigger");
     		$(document).off('click',".search-form-trigger");
     		var id = $(this).attr("data-id");
     		var name = $(this).attr("data-name");
            BootstrapDialog.show({                                
                title: name,
                message: $('<div></div>').load('/admin/processForm/selectForm.do?processId='+id),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
                	$(document).on("click", ".select-form-trigger", function (e) {
                		var mainFormId = $(this).attr("value");
                		var processId = $(this).attr("data-processId");
	                	$.post("/admin/processForm/editForm.do",{mainFormId:mainFormId, processId:processId},
	                        function (data) {
	                        	window.location.reload();
	                        }
                        );
	                });
                
                	$(document).on("click", ".search-form-trigger", function (e) {
                		var queryName = $("#name").val();
	                	dialog.getModalBody().html($('<div></div>').load('/admin/processForm/selectForm.do?name='+queryName+'&processId='+id));
	                });
                }
            });
        });
    });
</script>
