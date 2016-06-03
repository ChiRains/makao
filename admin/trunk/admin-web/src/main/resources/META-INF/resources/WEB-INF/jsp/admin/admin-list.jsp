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
                               href="#admin/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>    
                    
                    <div class="col-xs-6">
                        <div class="dataTables_length" style="float:right;">
                        <form id="query-form" action="#admin/list" onsubmit="listFormSearch(this); return false">
                            <input type="search" maxlength="40" class="form-control search-query"
                                           placeholder="姓名/账号" name="keyword" value="${keyword}">
                            <button title="查询" class="btn btn-sm btn-info"
                               href="#admin/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                查&nbsp;询
                            </button>    
                        </form>                       
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">                                             
                        <th>账号</th>                       
                        <th>姓名</th>
                        <th>是否启用</th>
                        <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${adminList}" var="admin" varStatus="current"> 
                            <tr>
                                                     
                            <td>${admin.account}</td>                         
                            <td>${admin.name}</td>                            
                            <td>
                                <input value="${admin.id}" type="checkbox" data-id="${admin.id}" class="ace ace-switch ace-switch-5 ajax_switch"
                                    checked="checked">
                                <span class="lbl middle"></span>
                            </td>
                            <td>
                                <div class="hidden-sm hidden-xs action-buttons">

                                    <a title="修改基本信息" class="green" 
                                       href="#admin/toEdit?id=${admin.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>

                                    <a title="重置密码" class="blue d_address resetPdw" 
                                       href="javascript:;" data-id="${admin.id}">
                                        <i class="ace-icon fa fa-cog bigger-130"></i>
                                    </a>								                                 
                                </div>
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
        
       	$(".resetPdw").on('click',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id')
            };
			BootstrapDialog.confirm('确定要重置密码吗?', function(result){
				if(result) {
					$.ajax({
							url:'/admin/resetPsw.do',
							type:'POST',
							data:data,
							dataType: 'json',
							cache: false,
							async: false,
							beforeSend: function(){
							
							},
							error: function(){
								BootstrapDialog.alert({
									title: '错误',
									message:'网络错误，请稍后再尝试！',
									type: BootstrapDialog.TYPE_DANGER
								});
							},
							success:function(rd){
								if(rd['status'] != 200){
									BootstrapDialog.alert({
										title: '错误',
										message:rd.message,
										type: BootstrapDialog.TYPE_DANGER
									});
								}else{
									BootstrapDialog.alert({
												type: BootstrapDialog.TYPE_SUCCESS
												,message:'密码已重置.'
												,closable: true
											});
								}
							}
						})
				}
			});			
        })     
        
        $(".ajax_switch").on('change',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id'),
                value:el[0].checked?'1':'0'
            };
            $.ajax({
                url:'/admin/enable.do',
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
    });
</script>
