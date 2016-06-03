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
                               href="#admin/approvalResults/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                    	<th>标识唯一号</th> 
                        <th>类型</th>           
                        <th>时间</th>           
                        <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                <td>${item.appointmentNumber}</td>                         
                                <td>
                                <c:if test="${item.type eq 1}">
                                	车卡id
                                </c:if>
                                <c:if test="${item.type eq 2}">
                                	司机卡id
                                </c:if>
                                </td>                         
                                <td><fmt:formatDate value="${item.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>                         
                                <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green"  target=_blank
                                    	<c:if test="${item.state eq 1}">
                                    		href="/test/sendCarCard.do?appointmentNumber=${item.appointmentNumber}"
                                    	</c:if>
                                    	<c:if test="${item.state eq 2}">
                                    		href="/test/sendDriverCard.do?appointmentNumber=${item.appointmentNumber}"
                                    	</c:if>
                                    	<c:if test="${item.state eq 3}">
                                    		href="/eport/ciqPost.do?formInstanceId=${item.formInstanceId}&appointmentNumber=${item.appointmentNumber}"
                                    	</c:if>
                                    	<c:if test="${item.state eq 4}">
                                    		href="/eport/customsPost.do?formInstanceId=${item.formInstanceId}&appointmentNumber=${item.appointmentNumber}"
                                    	</c:if>
                                    	>
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>发送接口
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
