<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>支付设置</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        支付设置
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            参数列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">   
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                     <tr role="row">                                             
                        <th>名称</th>                       
                        <th>是否启用</th>
                    </tr>
                    </thead>

                    <tbody>
						<tr>
                             <td>微信支付</td>                         
                            <td>
                                 <c:if test="${wxPay==1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch"
                                    checked="checked">
                            	</c:if>
                            	<c:if test="${wxPay!=1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch"
                                    >
                            	</c:if>
                                <span class="lbl middle"></span>
                            </td>
                        </tr>
                        <!----------------------->
                        <tr>
                             <td>支付宝支付</td>                         
                            <td>
                                <c:if test="${aliPay==1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch1"
                                    checked="checked">
                            	</c:if>
                            	<c:if test="${aliPay!=1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch1"
                                    >
                            	</c:if>
                                <span class="lbl middle"></span>
                            </td>
                        </tr>
                        <!--------------------------->
                        <tr>
                             <td>银联支付</td>                         
                            <td>
                            	<c:if test="${unionPay==1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch2"
                                    checked="checked">
                            	</c:if>
                            	<c:if test="${unionPay!=1}">
                            		<input value="" type="checkbox" data-id="" class="ace ace-switch ace-switch-5 ajax_switch2"
                                    >
                            	</c:if>
                                <span class="lbl middle"></span>
                            </td>
                        </tr>
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
            var postUrl=el[0].checked?'/admin/paySetting/wxEnable.do':'/admin/paySetting/wxDisable.do';
            var data = {
                value:el[0].checked?'1':'2'
            };
            $.ajax({
                url: postUrl,
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
        
        $(".ajax_switch1").on('change',function(){
            var el = $(this);
            var postUrl=el[0].checked?'/admin/paySetting/alipayEnable.do':'/admin/paySetting/alipayDisable.do';
            var data = {
                value:el[0].checked?'1':'2'
            };
            $.ajax({
                url: postUrl,
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
        
        $(".ajax_switch2").on('change',function(){
            var el = $(this);
            var postUrl=el[0].checked?'/admin/paySetting/unionEnable.do':'/admin/paySetting/unionDisable.do';
            var data = {
                value:el[0].checked?'1':'2'
            };
            $.ajax({
                url: postUrl,
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
            });
        });
        //表单验证
            $("#model-form1").validate({
                errorElement: 'div',
                errorClass: 'help-block col-xs-12 col-sm-reset inline',
                focusInvalid: false,
                rules: {
                    paySettingTime:{
                    	required: true,
                    	range: [1, 120],
                        digits: true
                    	
                    }
                },

                messages: {},

                highlight: function (e) {
                    $(e).closest('.form-group').removeClass('has-success').addClass('has-error');
                },

                success: function (e) {
                    $(e).closest('.form-group').removeClass('has-error').addClass('has-success');
                    $(e).remove();
                },

                errorPlacement: function (error, element) {
                    if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
                        var controls = element.closest('div[class*="col-"]');
                        if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
                        else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
                    }
                    else if (element.is('.select2')) {
                        error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
                    }
                    else if (element.is('.chosen-select')) {
                        error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
                    }
                    else error.insertAfter(element.parent());
                },

                submitHandler: function (form) {
                    postForm('model-form1');
                },
                invalidHandler: function (form) {
                }
            }); 
    });
</script>
