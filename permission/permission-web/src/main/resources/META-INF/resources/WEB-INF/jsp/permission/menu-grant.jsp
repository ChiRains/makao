<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>授权</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        授权管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            给${account.code}授权
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
                    <div class="col-xs-12">
                        <div class="dataTables_length" style="float:right;">
                            <a title="返回" class="btn btn-sm btn-info"
                               href="#menu/list?catalogId=${id}">
                                <i class="ace-icon fa fa-undo align-bottom bigger-125"></i>
                                返&nbsp;回
                            </a>                           
                        </div>
                    </div>                    
                </div>     
            	
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">  
                        <th>角色</th>
                        <th>是否授权</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${vos}" var="vo" varStatus="current"> 
                            <tr>
                                                       
                            <td>${vo.roleName}</td>                            
                            <td>
                                <input value="${vo.rolePermissionId}" type="checkbox" 
                                 data-permissionId=${vo.permissionId} 
                                 data-roleId="${vo.roleId}" 
                                 data-rolePermissionId="${vo.rolePermissionId}" 
                                 class="ace ace-switch ace-switch-5 ajax_switch" ${vo.checked}>
                                <span class="lbl middle"></span>
                            </td>
                        </tr>
						</c:forEach>
                    </tbody>
                </table>

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
            var rolePermissionId=el.attr('data-rolePermissionId');
            var data = {
                roleId:el.attr('data-roleId'),
                permissionId:el.attr('data-permissionId'),
                rolePermissionId:el[0].checked?'0':rolePermissionId
            };
            $.ajax({
                url:'/permission/menuGrant.do',
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
                    }else{
	                    setTimeout(function(){
	                    	window.location.reload(true);
	                    },1500);
                    }
                }
            })
        })      
    });
</script>
