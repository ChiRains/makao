<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../taglib.inc.jsp" %>

<title>分类管理</title>
<style>
    .dd {
        /*max-width: 100%;*/
        min-width: 300px;
    }
    img{
    	cursor:pointer;
    }
</style>
<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        分类管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div>
<!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="row">
            <div class="col-xs-3">
                <div class="dataTables_length">
                    <a title="新增" class="btn btn-sm btn-info"
                       href="#admin/classify4Types/toAdd?type=${type}&beanId=${beanId}">
                        <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                        新&nbsp;增
                    </a>
                </div>
            </div>
            
            <div class="col-xs-6">
	            <div class="dataTables_length">
                	<a class="blue" title="修改" ><i class="ace-icon fa fa-pencil bigger-130"></i>修改</a>
			         &nbsp;&nbsp;<img title="置顶"  src="/qcloud-admin/assets/img/top.png" width="14"  height="15"/>置顶
			         &nbsp;&nbsp;<img title="向上"  src="/qcloud-admin/assets/img/upward.png" width="14"  height="15"/>向上
			         &nbsp;&nbsp;<img title="向下"  src="/qcloud-admin/assets/img/down.png" width="14"  height="15"/>向下
			         &nbsp;&nbsp;<a class="red" title="删除" ><i class="ace-icon fa fa-trash-o bigger-130"></i> 删除</a>
			         &nbsp;&nbsp;<input value=""   type="checkbox"  disabled="true"  class="ace ace-switch ace-switch-6 ajax_switch1" >
			        <span class="lbl middle">启用/禁用</span>
                </div>
            </div>
            
        </div>
        <!-- PAGE CONTENT BEGINS -->
        
        <div class="row">
            <div class="col-sm-12">
                <div class="dd" id="nestable">
                    <ol class="dd-list">
                        <c:forEach items="${qclassify}" var="levelOne" varStatus="current">
                            <li class="dd-item" data-id="${levelOne.id}">
                                <div class="dd-handle">
                                    <span class="">${levelOne.name}</span>
                                    <div class="pull-right action-buttons">
                                    	 <a class="blue" title="修改" href="#admin/classify4Type/toEdit?id=${levelOne.id}"><i class="ace-icon fa fa-pencil bigger-130"></i></a>
                                        &nbsp;&nbsp;<img title="置顶" api-path="/admin/classify4Type/top.do?id=${levelOne.id}" class="sortpng" src="/qcloud-admin/assets/img/top.png" width="14"  height="15"/> 
                                        &nbsp;&nbsp;<img title="向上" api-path="/admin/classify4Type/upward.do?id=${levelOne.id}" class="sortpng" src="/qcloud-admin/assets/img/upward.png" width="14"  height="15"/> 
                                        &nbsp;&nbsp;<img title="向下" api-path="/admin/classify4Type/down.do?id=${levelOne.id}" class="sortpng" src="/qcloud-admin/assets/img/down.png" width="14"  height="15"/> 
                                    	&nbsp;&nbsp;<a class="red del-item-new" api-path="/admin/classifyMerchandise/deleteMallClassify.do?id=${levelOne.id}" title="删除" ><i class="ace-icon fa fa-trash-o bigger-130"></i></a>
                                    	<input value="${levelOne.id}" <c:if test="${levelOne.enable==1}"> checked </c:if>  type="checkbox" data-id="${levelOne.id}" class="ace ace-switch ace-switch-6 ajax_switch" >
                                		<span class="lbl middle"></span>
                                           
                                    </div>
                                </div>
                                    <ol class="dd-list">
                                        <c:forEach items="${levelOne.childrenList}" var="levelTwo" varStatus="current">
                                            <li class="dd-item item-blue2" data-id="${levelTwo.id}">
                                                <div class="dd-handle">
                                                    <span class="">${levelOne.name}--${levelTwo.name}</span>
                                                    <div class="pull-right action-buttons">
		                                                    <a class="blue" title="修改" href="#admin/classify4Type/toEdit?id=${levelTwo.id}"><i class="ace-icon fa fa-pencil bigger-130"></i></a>
				                                        &nbsp;&nbsp;<img title="置顶" api-path="/admin/classify4Type/top.do?id=${levelTwo.id}" class="sortpng" src="/qcloud-admin/assets/img/top.png" width="14"  height="15"/> 
				                                        &nbsp;&nbsp;<img title="向上" api-path="/admin/classify4Type/upward.do?id=${levelTwo.id}" class="sortpng" src="/qcloud-admin/assets/img/upward.png" width="14"  height="15"/> 
				                                        &nbsp;&nbsp;<img title="向下" api-path="/admin/classify4Type/down.do?id=${levelTwo.id}" class="sortpng" src="/qcloud-admin/assets/img/down.png" width="14"  height="15"/> 
				                                     	&nbsp;&nbsp;<a class="red del-item-new" api-path="/admin/classifyMerchandise/deleteMallClassify.do?id=${levelTwo.id}" title="删除" ><i class="ace-icon fa fa-trash-o bigger-130"></i></a>
				                                     	<input value="${levelTwo.id}" 
				                                     	<c:if test="${levelTwo.enable==1}"> checked </c:if> <c:if test="${levelOne.enable!=1}"> disabled="true" </c:if> type="checkbox" data-id="${levelTwo.id}" class="ace ace-switch ace-switch-6 ajax_switch" >
		                                				<span class="lbl middle"></span>
		                                				
                                                    </div>
                                                </div>
                                                    <ol class="dd-list">
                                                        <c:forEach items="${levelTwo.childrenList}" var="levelThree" varStatus="current">
                                                            <li class="dd-item item-orange" data-id="${levelThree.id}">
                                                                <div class="dd-handle">
                                                                    <span class="">${levelOne.name}--${levelTwo.name}--${levelThree.name}</span>

                                                                    <div class="pull-right action-buttons">
                                                                    	<a class="blue" title="修改" href="#admin/classify4Type/toEdit?id=${levelThree.id}"><i class="ace-icon fa fa-pencil bigger-130"></i></a>
								                                        &nbsp;&nbsp;<img title="置顶" api-path="/admin/classify4Type/top.do?id=${levelThree.id}" class="sortpng" src="/qcloud-admin/assets/img/top.png" width="14"  height="15"/> 
								                                        &nbsp;&nbsp;<img title="向上" api-path="/admin/classify4Type/upward.do?id=${levelThree.id}" class="sortpng" src="/qcloud-admin/assets/img/upward.png" width="14"  height="15"/> 
								                                        &nbsp;&nbsp;<img title="向下" api-path="/admin/classify4Type/down.do?id=${levelThree.id}" class="sortpng" src="/qcloud-admin/assets/img/down.png" width="14"  height="15"/> 
                                                                    	&nbsp;&nbsp;<a class="red del-item-new" api-path="/admin/classifyMerchandise/deleteMallClassify.do?id=${levelThree.id}" title="删除" ><i class="ace-icon fa fa-trash-o bigger-130"></i></a>
										                            	<input value="${levelThree.id}" <c:if test="${levelOne.enable!=1 || levelTwo.enable!=1}">  disabled="true" </c:if> <c:if test="${levelThree.enable==1}"> checked </c:if>  type="checkbox" data-id="${levelThree.id}" class="ace ace-switch ace-switch-6 ajax_switch" >
			                                							<span class="lbl middle"></span>
                                                                    	
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </c:forEach>
                                                    </ol>
                                            </li>
                                        </c:forEach>
                                    </ol>
                            </li>
                        </c:forEach>
                    </ol>
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
        
        $('.sortpng').on('click', function () {
            var apiUrl = $(this).attr('api-path');
            $.get(apiUrl, {},
          	  function (data) {
                data = JSON.parse(data);
                if (parseInt(data["status"]) === 0) {
                
                } else {
                    location.reload();
                }
            });
        });
        
        $(".ajax_switch").on('change',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id'),
                value:el[0].checked?'1':'0'
            };
            var url=el[0].checked?"/admin/classify4Type/enable.do":"/admin/classify4Type/disable.do";
            $.ajax({
                url:url,
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
                    	 setTimeout(function () {
                            location.reload();
                        }, 1500);
                    }
                }
            })
        })  
    });
</script>