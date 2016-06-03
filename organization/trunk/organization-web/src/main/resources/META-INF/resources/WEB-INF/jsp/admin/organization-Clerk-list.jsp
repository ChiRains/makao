<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>成员管理</title>
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

</style>
<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        成员管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            成员列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-4">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/clerk/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a> 
                            <a class="btn btn-sm btn-info send-massage2" >
                                <i class="ace-icon fa fa-keyboard-o align-bottom bigger-125"></i>发送消息
                            </a>		                          
                        </div>
                    </div>
                    <div class="col-xs-8">
                        <div class="text-right">
                            <label>
                                <form id="query-form" action="#admin/clerk/list" onsubmit="listFormSearch(this); return false">
                                    <div class="dataTables_length">            	                                      		                              
	                                   	<span class="input-group-btn">	                                   	    
								            <input type="search" maxlength="6" class="form-control search-query" placeholder="名称" name="name" value="${query.name}">
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
                               
                        <th>姓名</th>           
                        <th>手机号</th> 
                        <th>工作邮箱</th>             
                        <th>状态(是否启用 )</th> 
                        <th>重置密码</th>          
                        <th class="sorting_disabled">操作</th>
                        <th class="sorting_disabled">###</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                       
                                <td>${item.name}</td>                         
                                <td>${item.mobile}</td> 
                                <td>${item.jobEmail}</td>                      
                                <td>
                                	<input value="${item.id}" type="checkbox" data-id="${item.id}" class="ace ace-switch ace-switch-5 ajax_switch"
                                	<c:if test="${item.enable > 0}">
                                		checked
                                    </c:if>>
                                	<span class="lbl middle"></span>
                                </td>
                                <td>
                                	<a class="btn btn-xs btn-primary reset-pwd" api-path="/admin/clerk/resetPwd.do?id=${item.id}">重置密码</a>
                                </td>                     
                                <td>
                                	<div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/clerk/toEdit?id=${item.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>
                                	</div>
                            	</td>
                            	<td>
                                    <a class="btn btn-primary send-massage"  data-id="${item.id}" data-name="${item.name}">
                                	<i class="ace-icon fa fa-keyboard-o"></i>发送消息</a>							                                 
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
    
       //发送消息
      $(".send-massage").on("click", function (){
     // 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".to-send-massage");
     		
     		 var url ="/admin/clerkMessage/send.do";
     		  var id=$(this).attr("data-id");
              var name=$(this).attr("data-name");
     		  
            BootstrapDialog.show({ 
                title:"发送消息",   
                message: $('<div></div>').load('/admin/clerkMessage/toSend.do?clerkId='+id+'&name='+name),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
                },
                buttons: [{
	                label: '发送',
	                cssClass: 'btn btn-primary',
	                action: function (dialog) {
	                	 $.get(url + "?" + $("#delivery-form").serialize(),
	                        function (data) {
	                   var title = document.getElementById("title").value;
     		           var content = document.getElementById("content").value;
     		           if(title==""||content=="") 
     		            { 
     		              BootstrapDialog.alert({
                            title: '提醒',
                            message:"标题或者内容不能为空！！",
                            type: BootstrapDialog.TYPE_DANGER,
                        });
     		            }else{
     		                  dialog.close();
	                          location.reload();
     		            }
	                        }
	                    );
                    }
                }]
            });
        });
      //发送消息2
      $(".send-massage2").on("click", function () {
     // 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',".to-send-massage");
     		var url ="/admin/clerkMessage/send.do";
     		
     		  var id=0;
              var name=null;
     		  
            BootstrapDialog.show({ 
                title:"发送消息",   
                message: $('<div></div>').load('/admin/clerkMessage/toSend.do?clerkId='+id+'&name='+name),
                cssClass: "select-product-dialog",
                onshow: function (dialog) {
                	
                },
                buttons: [{
	                label: '发送',
	                cssClass: 'btn btn-primary',
	                action: function (dialog) {
	                	 $.get(url + "?" + $("#delivery-form").serialize(),
	                        function (data) {
	                    var title = document.getElementById("title").value;
     		            var content = document.getElementById("content").value;
     		            var clerkId_send = document.getElementById("clerkId_send").value;
     		            if(title==""||content==""||clerkId_send==0) 
     		            { 
     		              BootstrapDialog.alert({
                            title: '提醒',
                            message:"接受人或标题或内容不能为空！！",
                            type: BootstrapDialog.TYPE_DANGER,
                        });
     		            }else{
     		                  dialog.close();
	                          location.reload();
     		            }
	                        }
	                    );
                    }
                }]
            });
        });
    
        //inline scripts related to this page
          $('.reset-pwd').on('click', function () {
            var delUrl = $(this).attr('api-path');
            BootstrapDialog.show({
                title: '确认重置密码？',
                message: '重置以后密码将会恢复默认，请尽快登陆修改！',
                buttons: [{
                    id: 'btn-1',
                    label: '确定',
                    cssClass: 'btn btn-primary',
                    action: function (dialogItself) {
                        $.get(delUrl, {},
                                function (data) {
                                    data = JSON.parse(data);
                                    if (parseInt(data["status"]) === 0) {
                                        dialogItself.setTitle('重置密码失败');
                                        dialogItself.setMessage(data["message"]);
                                        dialogItself.setType(BootstrapDialog.TYPE_DANGER);
                                        dialogItself.getButton('btn-1').remove();
                                    } else {
                                        dialogItself.setTitle('成功');
                                        dialogItself.setMessage("重置密码成功！");
                                        dialogItself.setType(BootstrapDialog.TYPE_SUCCESS);
                                        setTimeout(function () {
                                            dialogItself.close();
                                        }, 1000);
//                                        setTimeout(function () {
//                                            location.reload();
//                                        }, 1500);
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
        
        $(".ajax_switch").on('change',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id'),
                value:el[0].checked?'1':'0'
            };
            $.ajax({
                url:'/admin/clerk/enable.do',
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
        });
    });
</script>
