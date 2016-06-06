<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>问卷问题管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        问卷问题管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            问卷问题列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/question/toAdd?questionnaireId=${questionnaireId}">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>    
                    <div class="col-xs-6">
                    	<div class="dataTables_length">
                        	<a title="返回" class="btn btn-sm btn-back" style="float:right;"
                                  href="#admin/questionnaire/list">
                                  <i class="ace-icon fa fa-undo align-bottom bigger-125"></i>
                           		     返&nbsp;回
                            </a> 
                    	</div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                   		<tr role="row">     
	                            <th>问卷名称</th>           
	                            <th>题目名称</th>           
	                            <th>选项序号编码</th>           
	                            <th>类型</th> 
	                            <th>排序</th>            
	                            <th class="sorting_disabled">操作</th>
                    	</tr>
                    </thead>

                    <tbody>
                        <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                <td>${item.questionnaireName}</td>                         
                                <td>${item.name}</td>                         
                                <td>${item.serialNumber}</td> 
                                <td>${item.typeStr}</td>                         
                                <td>${item.sort}</td>                         
                                <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/question/toEdit?id=${item.id}&queryStr=${queryStr}&questionnaireId=${item.questionnaireId}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>
                                    <a title="查看回答" class="pink" 
                                       href="#admin/questionnaireAnswers/list?questionId=${item.id}"> 
                                        <i class="ace-icon fa fa-camera bigger-130"></i>
                                    </a>
                                    <a title="删除" class="red del-item-new"  
							           api-path="/admin/question/delete.do?id=${item.id}">
							           <i class="ace-icon fa fa-trash-o bigger-130"></i>
							        </a>	
                                    <c:if test="${item.type eq 3 or item.type eq 4}">
                                    	<a title="选项设置" class="blue" 
                                       		href="#admin/options/list?questionId=${item.id}&questionnaireId=${item.questionnaireId}">
                                        	<i class="ace-icon fa fa-tasks bigger-130"></i>
                                    	</a>
                                    </c:if>	
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
        $('.del-item-new').on('click', function () {
            var delUrl = $(this).attr('api-path');
            BootstrapDialog.show({
                title: '确认删除？',
                message: '删除后将无法恢复！',
                buttons: [{
                    id: 'btn-1', 
                    label: '确定',
                    cssClass: 'btn btn-primary',
                    action: function (dialogItself) {
                        $.get(delUrl, {},
                                function (data) {
                                    data = JSON.parse(data);
                                    if (parseInt(data["status"]) === 0) {
                                        dialogItself.setTitle('删除失败');
                                        dialogItself.setMessage(data["message"]);
                                        dialogItself.setType(BootstrapDialog.TYPE_DANGER);
                                        dialogItself.getButton('btn-1').remove();
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
