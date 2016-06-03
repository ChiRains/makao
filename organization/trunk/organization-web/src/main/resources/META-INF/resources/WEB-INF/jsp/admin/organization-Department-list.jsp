<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>部门管理</title>
<style>
    .select-product-dialog {
        top: 50px;
    }

    .select-product-dialog tr {
        word-break: break-all;
    }

    .select-product-dialog .modal-content {
        min-height: 600px;
        min-width: 800px;
    }

    /*.select-dialog .modal-body{*/
    /*padding: 0;*/
    /*}*/
</style>
<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        部门管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            部门列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-4">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/department/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>
                    <div class="col-xs-8">
                        <div class="text-right">
                            <label>
                                <form id="query-form" action="#admin/department/list" onsubmit="listFormSearch(this); return false">
                                    <div class="dataTables_length">            	                                      		                              
	                                   	<span class="input-group-btn">	                                   	    
								            <input type="search" maxlength="6" class="form-control search-query" placeholder="名称" name="displayName" value="${query.displayName}">
                                       		<button type="submit" class="btn btn-purple btn-sm">
                                                <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                                查询
                                            </button>
                                        </span>
                                    </div>
                                </form>
                            </label>
                        </div>
                    </div>                     
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                        <th>名称</th>
                        <th>经理</th>
                        <th>人员管理</th>
                        <th class="sorting_disabled">操作</th> 
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                <td>${item.displayName}</td>
                                <td>
                                	<a class="btn btn-primary btn-xs add-manager-trigger" data-id="${item.id}" data-name="经理设置-${item.displayName}">
                                	<i class="ace-icon fa fa-keyboard-o bigger-130"></i>经理设置</a>
                                	&nbsp;&nbsp;
                                	<c:if test="${item.manager ne -1}">
                                		<span class="label label-info arrowed arrowed-in-right">${item.managerName}</span>
                                	</c:if>
                                </td>
                                <td>
                            	 	<a class="btn btn-primary btn-xs add-member-trigger" data-id="${item.id}" data-name="人员管理-${item.displayName}">
                                    <i class="ace-icon fa fa-keyboard-o bigger-130"></i>人员管理</a>
                                </td>
                                <td>
                            	 	<a class="btn btn-primary btn-xs" href="#admin/department/toEdit?id=${item.id}"  data-name="修改">
                                    	<i class="ace-icon fa fa-keyboard-o bigger-130"></i>修改
                                    </a>
                                    <a class="btn btn-primary btn-xs del-item" api-path="/admin/department/delete.do?id=${item.id}"  data-name="修改">
                                    	<i class="ace-icon fa fa-keyboard-o bigger-130"></i>删除
                                    </a>
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
        $(".add-member-trigger").on("click", function () {
     		// 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".select-departmentClerk-trigger");
     		$(document).off('click',".search-clerk-trigger");
     		
     		var id = $(this).attr("data-id");
     		var name = $(this).attr("data-name");
            BootstrapDialog.show({                                
                title: name,
                message: $('<div></div>').load('/admin/departmentClerk/selectMember.do?departmentId='+id),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
                	$(document).on("click", ".select-departmentClerk-trigger", function (e) {
                		var $obj=$(this);
                		var clerkId = $(this).attr("value");
	                	$.post("/admin/departmentClerk/edit.do",
	                	{isSelected:$(this).get(0).checked, departmentId:id, clerkId:clerkId},
	                        function (data) {
	                        	var dataStr=JSON.parse(data);
	                        	if(dataStr.status==-1){
	                        	 	$obj.prop("checked",true);
                        		    BootstrapDialog.show({
                        		  	   message:dataStr.message
                        		    });
	                        	}
	                        }
                        );
	                });
                
                	$(document).on("click", ".search-clerk-trigger", function (e) {
                		var name = $("#name").val();
	                	dialog.getModalBody().html($('<div></div>').load('/admin/departmentClerk/selectMember.do?name='+name+'&departmentId='+id));
	                });
                }
            });
        });
        
         $(".add-manager-trigger").on("click", function () {
     		// 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".select-departmentClerk-trigger");
     		$(document).off('click',".search-clerk-trigger");
     		var id = $(this).attr("data-id");
     		var name = $(this).attr("data-name");
            BootstrapDialog.show({
                title: name,
                message: $('<div></div>').load('/admin/departmentClerk/selectManager.do?departmentId='+id),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
                	$(document).on("click", ".select-departmentClerk-trigger", function (e) {
                		console.log($(this).get(0).checked);
                		var clerkId = $(this).attr("value");
	                	$.post("/admin/departmentClerk/editManager.do",{isSelected:$(this).get(0).checked, departmentId:id, clerkId:clerkId},
	                        function (data) {
	                        	window.location.reload();
	                        }
                        );
	                });
                
                	$(document).on("click", ".search-clerk-trigger", function (e) {
                		var name = $("#name").val();
	                	dialog.getModalBody().html($('<div></div>').load('/admin/departmentClerk/selectManager.do?name='+name+'&departmentId='+id));
	                });
                }
            });
        });
    });
</script>
