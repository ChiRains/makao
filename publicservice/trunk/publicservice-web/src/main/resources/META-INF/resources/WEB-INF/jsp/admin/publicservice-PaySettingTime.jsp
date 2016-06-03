<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>支付设置</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        支付设置
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            支付时间设置
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form1" class="form-horizontal"  role="form" action="/admin/paySetting/update.do" >             
            <!-- #section:elements.form -->
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="paySettingTime">支付有效时间 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-80" maxlength="5" id="paySettingTime" name="paySettingTime" placeholder="请输入支付有效时间" value="${paySettingTime}"/>分钟
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
             <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="refundTime">退换货时间 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<select class="width-80"  id="refundTime" name="refundTime">
							<c:forEach var="item" begin="1" end="15">
								<option <c:if test="${item eq refundTime}">selected="selected"</c:if> value="${item}" > ${item}</option>
							</c:forEach>
							
						</select>
						天
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="autoSignTime">自动签收时间 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<select class="width-80"  id="autoSignTime" name="autoSignTime">
							<c:forEach var="item" begin="1" end="15">
								<option <c:if test="${item eq autoSignTime}">selected="selected"</c:if> value="${item}" > ${item}</option>
							</c:forEach>
							
						</select>
						天
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
             <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="domain">系统域名 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-80" id="domain" name="domain" placeholder="系统域名" value="${domain}"/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                	<button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110">
                    </i>&nbsp;保&nbsp;存&nbsp;</button>
                    
                </div>
            </div>

        </form>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        jQuery(function ($) {
            $(window)
            .off('resize.chosen')
            .on('resize.chosen', function() {
                $('.chosen-select').each(function() {
                     var $this = $(this);
                     $this.next().css({'width': $this.parent().width()});
                })
            }).trigger('resize.chosen');
                   
             
            //表单验证
            $("#model-form1").validate({
                errorElement: 'div',
                errorClass: 'help-block col-xs-12 col-sm-reset inline',
                focusInvalid: false,
                rules: {
                    paySettingTime: {
                        required: true,
                    	range: [1, 120],
                        digits: true
                    },
                    refundTime: {
                        required: true,
                    	range: [1, 15],
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
    })
</script>
