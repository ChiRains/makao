<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>站内信模板管理</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        站内信模板管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            编辑
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form1" class="form-horizontal"  role="form" action="/admin/insideMessage/save.do">
            <!-- #section:elements.form -->
            
           <c:forEach items="${result}" var="item" varStatus="i">
	           	<div class="space-4"></div>
	            <div class="form-group">
	                <label class="col-sm-3 control-label no-padding-right" for="${item.code}"> ${item.name}</label>
	                <div class="col-sm-9">
						<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
							<input type="hidden" readonly  maxlength="200" id="${item.code}" name="smsTemplates[${i.index}].code" value="${item.code}"/>
							<input type="text" class="width-80" maxlength="200" id="${item.code}" name="smsTemplates[${i.index}].value" placeholder="${item.name}" value="${item.value}"/>
							
							<%--<button onclick="window.location='#admin/umsConfig/toTest?code=${item.code}'" class="btn btn-testing" type="button">
								<i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;测&nbsp;试&nbsp;
							</button> --%>
							<i class="ace-icon fa"></i>
						</span>
	                </div>
	            </div>
           </c:forEach>
            
            <div class="space-4"></div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;保&nbsp;存&nbsp;</button>
                    &nbsp; &nbsp; &nbsp;
                    <button onclick="window.location='#admin/umsConfig/getUmsConfig'" class="btn btn-testing" type="button"><i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;</button>
                </div>
            </div>

        </form>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div><!-- /.row -->

<!-- var btnUpload = $(".btn-testing");
            //绑定事件
            btnUpload.on('click', function () {
               BootstrapDialog.show({
	                    title: "测试发送短信",
	                    message: "请输入手机号码:<input value='' type='text' id='phoneNumber' name='phoneNumber'/><br/><input value='发送' class='btn' type='button' id='sendBtn' name='sendBtn'/><input value='取消' class='btn' type='button' name='calBtn'/>",
	                    onshow: function (dialog) {
	                        //$(document).off("click", ".select-product-dialog a,.search-button");
	                        $(document).on("click", "#sendBtn", function (e) {
	                            e.preventDefault();
	                            var obj = $(this);
	                            //console.log(obj);
	                           	var phoneNumber=$("#phoneNumber").val();
	                           	alert(phoneNumber);
	                        });
	                    }
	                });
               
            });   -->  
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
                    name: {
                        required: true
                    },
                    mobile: {
                        required: true
                    },
                    sort: {
                        required: true,
                        range: [0, 99999999],
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
