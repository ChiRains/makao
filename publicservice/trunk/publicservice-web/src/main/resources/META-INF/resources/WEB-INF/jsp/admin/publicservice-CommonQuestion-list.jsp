<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>常见问题管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        常见问题管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            常见问题列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/commonQuestion/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">            
                                                <th style="width:85%">问题</th>           
                                                <%--<th style="width:50%">回答</th>           
                                                <th>排序</th>--%>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>                                 
                                                        <td>${item.title}</td>                         
                                                        <%--<td>
                                                        	${item.answer}
                                                        </td>                         
                                                        <td>${item.sort}</td>--%>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改常见问题" class="green" 
                                       href="#admin/commonQuestion/toEdit?id=${item.id}&queryStr=${queryStr}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>
                                    <a class="upward" title="向上" 
                                    	api-path="/admin/commonQuestion/upward.do?id=${item.id}&queryStr=${queryStr}">
                                    	<img title="向上" src="/qcloud-admin/assets/img/upward.png" width="14" height="17">
                                    </a>
                                    <a class="downward" title="向下" 
                                    	api-path="/admin/commonQuestion/downward.do?id=${item.id}&queryStr=${queryStr}">
                                    	<img title="向下" src="/qcloud-admin/assets/img/down.png" width="14" height="17">
                                    </a>
                                    &nbsp;&nbsp;&nbsp;
                                    <a title="删除常见问题" class="del-item" 
	                                    api-path="/admin/commonQuestion/delete.do?id=${item.id}">
	                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
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

        $(".upward").on("click", function() {
       		var url = $(this).attr('api-path');
            $.get(url, {}, function (data) {
            	data = JSON.parse(data);
                setTimeout(function () {
                	location.reload(true);	// 刷新本页面
                }, 10);
            });
        });
  
        $(".downward").on("click",function() {
       		var url = $(this).attr('api-path');
            $.get(url, {}, function (data) {
            	data = JSON.parse(data);
            	setTimeout(function () {
                	location.reload(true);	// 刷新本页面
                }, 10);
            });
        });
        
    });
</script>
