<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>目录管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
   目录管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
           目录列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            目录列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">  
               <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#catalog/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>  
                    
                    <div class="col-xs-6" style="text-align: right;">
                        <label>
                            <form id="query-form" action="#catalog/list" onsubmit="listFormSearch(this); return false">
                            	<div class="dataTables_length">
                               			<input type="search" maxlength="40" class="form-control search-query"
                                           placeholder="名称" name="name" value="${name}">
                                   		<button type="submit" class="btn btn-purple btn-sm">
                                            <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                            查询
                                        </button>                                        
                                 </div>
                            </form>
                        </label>
                    </div>                  
                </div>             
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">                                             
                        <th>名称</th>                       
                        <th>排序</th>                         
                        <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${catalogList}" var="catalog" varStatus="current"> 
                            <tr>
                                                     
                            <td>${catalog.name}</td>                         
                            <td>${catalog.order}</td>                                                    
                            <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="授权" class="green" 
                                       href="#menu/list?catalogId=${catalog.id}">
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
