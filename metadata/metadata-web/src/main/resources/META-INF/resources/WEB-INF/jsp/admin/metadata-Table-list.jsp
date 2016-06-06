<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>元数据定义</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        表定义
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            表定义列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/table/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>
                     <div class="col-xs-6">
                        <div class="text-right">
                            <label>
                                <form action="#admin/table/list" onsubmit="listFormSearch(this); return false">
                                   <div class="dataTables_length">
                                   			<input type="search" class="form-control search-query" placeholder="名称" name="label" value="${query.label}">
                                   			<input type="search" class="form-control search-query" placeholder="表名" name="name" value="${query.name}">
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
                        <th>编号</th>           
                        <th>名称</th>           
                        <th>表名</th>           
                        <th>描述</th>
                        <th>属性管理</th>
                        <th class="sorting_disabled">操作</th>
                        <th class="sorting_disabled">快捷部署</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                <td>${item.id}</td>                         
                                <td>${item.label}</td>                         
                                <td>${item.name}</td>                         
                                <td>${item.remark}</td>
                                <td>
                                	<div class="hidden-sm hidden-xs action-buttons">
                                	<a href="#admin/field/list?tableId=${item.id}" class="btn btn-primary btn-xs">
                                     <i class="ace-icon fa fa-keyboard-o bigger-130"></i>属性</a>
                                    </div>
                                </td>
                                <td>
	                                <div class="hidden-sm hidden-xs action-buttons">
	                                     <a title="修改基本信息" class="green" 
	                                       href="#admin/table/toEdit?id=${item.id}">
	                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
	                                   	 </a>
		                                 <a title="删除" class="red del-item-new" href="javascript:;"
		                                   api-path="/admin/table/delete.do?id=${item.id}">
		                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
	                                     </a>
	                                </div>
                            	</td>
                            	<td>
                            		<button class="btn btn-sm btn-success btn-white btn-round"
                            		onclick="window.location.href='/admin/field/downloadFile.do?tableId=${item.id}'">
									  <i class="ace-icon fa fa-check bigger-110 green"></i>
									  初始化
									</button>
									
									<button class="btn btn-sm btn-success btn-white btn-round"
                            		onclick="window.location.href='/admin/table/initBackup.do?tableId=${item.id}'">
									  <i class="ace-icon fa fa-check bigger-110 green"></i>
									生成表单备份表
									</button>
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
         $('.del-item-new').on('click', function () {
            var delUrl = $(this).attr('api-path');
            BootstrapDialog.show({
                title: '确认删除？',
                message: '删除后将无法恢复！',
                buttons: [{
                    label: '确定',
                    cssClass: 'btn btn-primary',
                    action: function (dialogItself) {
                        $.get(delUrl, {},
                                function (data) {
                                    data = JSON.parse(data);
                                    if (parseInt(data["status"]) === 0) {
                                        dialogItself.setTitle('删除失败');
                                        dialogItself.setMessage(data["message"]);
                                        dialogItself.setType(BootstrapDialog.TYPE_WARNING);
                                    } else {
                                        dialogItself.setTitle('成功');
                                        dialogItself.setMessage("删除成功！");
                                        dialogItself.setType(BootstrapDialog.TYPE_SUCCESS);
                                        setTimeout(function () {
                                            dialogItself.close();
                                        }, 1000);
                                        setTimeout(function () {
                                            location.reload();
                                        }, 1500);
                                    }
                                });
                    }
                }, {
                    label: '取消',
                    action: function (dialogItself) {
                        dialogItself.close();
                    }
                }]
            });
        });
    });
</script>
