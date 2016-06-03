<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
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
        活动任务管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            活动任务列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                        </div>
                    </div>
                    <div class="col-xs-6" style="text-align: right;">
                    <a href="#admin/process/list" class="btn btn-sm btn-info">&ensp;返&emsp;回&ensp;</a>
                	</div>
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
	                    <th>名称</th>           
	                    <th>显示名称</th>           
	                    <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
	                            <td>${item.name}</td>                         
	                            <td>${item.displayName}</td>                         
	                            <td>
	                                <div class="hidden-sm hidden-xs action-buttons">
	                                    <a class="btn btn-primary btn-xs add-element-trigger" data-name="${item.name}" data-processId="${query.processId}">
	                                    <i class="ace-icon fa fa-keyboard-o bigger-130"></i>元素权限</a>
	                                    <a class="btn btn-primary btn-xs add-member-trigger" data-name="${item.name}" data-processId="${query.processId}">
	                                    <i class="ace-icon fa fa-keyboard-o bigger-130"></i>执行人</a>
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
    var scripts = [null,"/qcloud-admin/assets/js/bootstrap.min.js","/qcloud-admin/assets/js/jquery.dataTables.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
     $(".add-element-trigger").on("click", function () {
     		var name = $(this).attr("data-name");
     		var processId = $(this).attr("data-processId");
            BootstrapDialog.show({
                title: name,
                message: $('<div></div>').load('/admin/taskFormAccess/selectElement.do?processId='+processId+'&taskName='+name),
                cssClass: "select-product-dialog",
                buttons: [{
                    label: '保存',
                    cssClass: 'btn btn-primary',
                    action: function (dialogItself) {
                        $.get("/admin/taskFormAccess/edit.do?"+$("#myForm").serialize(),
	                        function (data) {
	                        	dialogItself.close();
	                        	//location.reload();
	                        }
                        );
                    }
                }, {
                    label: '取消',
                    action: function (dialogItself) {
                        dialogItself.close();
                    }
                }],
                onshow: function (dialog) {
                	 
                }
            });
        });
        
     $(".add-member-trigger").on("click", function () {
     		// 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".search-member-trigger");
     		$(document).off('click',".select-member-trigger");
     		var name = $(this).attr("data-name");
     		var processId = $(this).attr("data-processId");
            BootstrapDialog.show({
                title: name,
                message: $('<div></div>').load('/admin/processExecutor/selectMember.do?processId='+processId+'&taskName='+name),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
	                $(document).on("click", ".search-member-trigger", function (e) {
	                	var param = $("#name").val();
                	 	var param1Array = $("#type_1").attr("class").split(" ");
                        var param2Array = $("#type_2").attr("class").split(" ");
                        var param3Array = $("#type_3").attr("class").split(" ");
                        var type;
                        if(param1Array[param1Array.length - 1] == 'active') {
                        	type = 1;
                        }
                        if(param2Array[param2Array.length - 1] == 'active') {
                        	type = 2;
                        }
                        if(param3Array[param3Array.length - 1] == 'active') {
                        	type = 3;
                        }
	                	dialog.getModalBody().html($('<div></div>').load('/admin/processExecutor/selectMember.do?processId='+processId+'&taskName='+name+'&name='+param+'&type='+type));
	                });
	                
	                $(document).on("click", ".select-member-trigger", function (e) {
	                	var param1Array = $("#type_1").attr("class").split(" ");
                        var param2Array = $("#type_2").attr("class").split(" ");
                        var param3Array = $("#type_3").attr("class").split(" ");
	                	var type;
                        if(param1Array[param1Array.length - 1] == 'active') {
                        	type = 1;
                        }
                        if(param2Array[param2Array.length - 1] == 'active') {
                        	type = 2;
                        }
                        if(param3Array[param3Array.length - 1] == 'active') {
                        	type = 3;
                        }
                		var memberId = $(this).attr("value");
	                	$.get("/admin/processExecutor/edit.do",{isSelected:$(this).get(0).checked, processId:processId, 
	                	taskName:name, memberId:memberId, type:type},
	                        function (data) {
	                        	
	                        }
                        );
	                });
                }
            });
        });
    });
</script>
