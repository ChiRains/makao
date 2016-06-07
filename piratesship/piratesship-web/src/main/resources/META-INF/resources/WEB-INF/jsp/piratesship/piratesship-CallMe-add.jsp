<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>
<head>
	<title>约 约 约 GO ~</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="">
	<meta name="author" content="" />
	<link rel="stylesheet" href="/qcloud-admin/assets/css/font-awesome.min.css" type="text/css" />
	<link rel="stylesheet" href="/qcloud-admin/assets/css/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="/qcloud-admin/assets/css/bootstrap-datetimepicker.css" type="text/css" />
	<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
	<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
	<link rel="stylesheet" href="/qcloud-admin/assets/css/ace.min.css" />		
    <link rel="stylesheet" href="/qcloud-admin/assets/css/bootstrap-dialog.min.css"/>
	<link rel="stylesheet" href="/qcloud-admin/assets/css/public.css" />
	
	<script src="/qcloud-admin/assets/js/jquery.min.js"></script>
	<script src="/qcloud-admin/assets/js/jquery-ui.custom.min.js"></script>
	<script src="/qcloud-admin/assets/js/bootstrap.min.js"></script>
	<script src="/qcloud-admin/assets/js/bootstrap-paginator.js"></script>
	<script src="/qcloud-admin/assets/js/bootstrap-datetimepicker.js"></script>
	<script src="/qcloud-admin/assets/js/bootstrap-datetimepicker.zh-CN.js"></script>
	
	<script src="/qcloud-admin/assets/js/jquery.colorbox-min.js"></script>
	<script src="/qcloud-admin/assets/js/upload-img.js"></script>
	
</head>
	<div id="navbar" class="navbar navbar-default">
		<script type="text/javascript">
			try{ace.settings.check('navbar' , 'fixed')}catch(e){}
		</script>

		<div class="navbar-container" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
				<span class="sr-only">Toggle sidebar</span>

				<span class="icon-bar"></span>

				<span class="icon-bar"></span>

				<span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand">
					<small>
						<i class="fa  fa-cloud"></i>
						QCloud Admin
					</small>
				</a>
			</div>
		</div>
	</div>

	<div class="main-container" id="main-container">
				<div class="page-content-area">											
							
				<title>新增提问</title>
				<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
				<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />
				
				<!-- ajax layout which only needs content area -->
				<div class="page-header">
				    <h1>
				        @
				        <small>
				            <i class="ace-icon fa fa-angle-double-right"></i>
				            新增提问
				        </small>
				    </h1>
				</div><!-- /.page-header -->

				<div class="row">
				    <div class="col-xs-12">
				        <!-- PAGE CONTENT BEGINS -->
				        <form id="model-form" class="form-horizontal"  role="form" action="/callMe/add.do">
				            <!-- #section:elements.form -->
											      						                  		
				                  		<div class="space-4"></div>
				            <div class="form-group">
				                <label class="col-sm-3 control-label no-padding-right" for="fromSeaman"><strong> 发起人 </strong></label>
				                <div class="col-sm-9">
									<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
										<span style="color:red;">高富帅/白富美：</br></span>
										<c:forEach var="member" items="${memberList}">
											<input style="width:20px;height:20px;" type="checkbox" value="${member}" class="fromWho" name="">${member}
										</c:forEach>
										<input type="text" class="width-100" style="color:#1751DA;" maxlength="40" id="fromSeaman" name="fromSeaman" placeholder="发起人" value=""/>
										
										<i class="ace-icon fa"></i>
									</span>
				                </div>
				            </div>
				            
				                  		<div class="space-4"></div>
				            <div class="form-group">
				                <label class="col-sm-3 control-label no-padding-right" for="toSeaman"><strong> 找谁 </strong></label>
				                <div class="col-sm-9">
									<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
										<span style="color:red;">备胎：</br></span>
										<c:forEach var="member" items="${memberList}">
											<input style="width:20px;height:20px;" type="checkbox" value="${member}" class="toWho" name="">${member}
										</c:forEach>
										<input type="text" class="width-100" style="color:#1751DA;" maxlength="40" id="toSeaman" name="toSeaman" placeholder="找谁" value=""/>
										<i class="ace-icon fa"></i>
									</span>
				                </div>
				            </div>
				            				                 							            
				                  		<div class="space-4"></div>
				            <div class="form-group">
				                <label class="col-sm-3 control-label no-padding-right" for="subject"> <strong>约约约 </strong> </label>
				                <div class="col-sm-9">
									<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
										<input type="text" class="width-100" maxlength="50" id="subject" name="subject" placeholder="主题" value=""/>
										<i class="ace-icon fa"></i>
									</span>
				                </div>
				            </div>			
				            
				
				            <div class="space-4"></div>
				            <div class="clearfix form-actions">
				                <div class="col-md-offset-3 col-md-9">
				                    <button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;保&nbsp;存&nbsp;</button>
				                    &nbsp; &nbsp; &nbsp;
				                    <button id="back" class="btn" type="button"><i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;</button>
				                </div>
				            </div>
				
				        </form>
				        <!-- PAGE CONTENT ENDS -->
				    </div>
				</div>
			</div>
		</div>
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div><!-- /.main-container -->


	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery || document.write("<script src='/qcloud-admin/assets/js/jquery.min.js'>"+"<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
	<script type="text/javascript">
	 window.jQuery || document.write("<script src='/qcloud-admin/assets/js/jquery1x.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->
	<script type="text/javascript">
		if('ontouchstart' in document.documentElement) document.write("<script src='/qcloud-admin/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>
	<script src="/qcloud-admin/assets/js/bootstrap.min.js"></script>

	<!-- ace scripts -->
	<script src="/qcloud-admin/assets/js/ace-elements.min.js"></script>
	<script src="/qcloud-admin/assets/js/ace.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/qcloud-admin/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="/qcloud-admin/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" charset="utf-8" src="/qcloud-admin/umeditor/lang/zh-cn/zh-cn.js"></script>
    <script src="/qcloud-admin/assets/js/bootstrap-dialog.js"></script>
    <script src="/qcloud-admin/assets/js/jquery.validate.min.js"></script>

	<script type="text/javascript">
		
		//表单验证
        $("#model-form").validate({
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
                },
                aboutusSetting:{
                	required:true
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
                postForm('model-form');
            },
            invalidHandler: function (form) {
            }
        });
		
		
		function postForm(formId){
			var thForm = $("#"+formId);
			$.ajax({
				url: thForm.attr('action'),
				type: 'POST',
				data: thForm.serialize(),
				dataType: 'json',
				cache: false,
				async: false,
				beforeSend: function(){
				},
				error: function(rd){
					if(rd && rd.message){
						BootstrapDialog.alert({
							type: BootstrapDialog.TYPE_DANGER
							,message:rd.message
							,closable: true
						});						
					}else{
						BootstrapDialog.alert({
							type: BootstrapDialog.TYPE_DANGER
							,message:'保存失败，可能网络延时，请稍后再试！'
							,closable: true
						});
					}						
				},
				success: function(rd){						
					var btpDialog;
					if(200==rd.status){
						var myClosable = 1==rd.data.tored?false:true;
						if(1==rd.data.tored){
                            btpDialog = BootstrapDialog.show({
                                closable: false,
                                type: BootstrapDialog.TYPE_SUCCESS,
                                message: rd.message
                            });
							setTimeout(function(){
								btpDialog.close();
								if(rd.data.url){
									window.location.href = "/callMe/list.do";
								}else{
									history.back();
								}
							}, 1000);
						}else{
                            btpDialog = new BootstrapDialog.alert({
                                type: BootstrapDialog.TYPE_SUCCESS
                                ,message:rd.message
                                ,closable: myClosable
                            });
                        }
					}else{
						btpDialog = new BootstrapDialog.alert({
							type: BootstrapDialog.TYPE_DANGER
							,message:rd.message
							,closable: true
						});
					}
				}
			});
		}

        //初始化中文验证信息
        jQuery.extend(jQuery.validator.messages, {
            required: "必选字段",
            remote: "请修正该字段",
            email: "请输入正确格式的电子邮件",
            url: "请输入合法的网址",
            date: "请输入合法的日期",
            dateISO: "请输入合法的日期 (ISO).",
            number: "请输入合法的数字",
            digits: "只能输入整数",
            creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: jQuery.validator.format("请输入一个 长度最多是 {0} 的字符串"),
            minlength: jQuery.validator.format("请输入一个 长度最少是 {0} 的字符串"),
            rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串"),
            range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: jQuery.validator.format("请输入一个最大为{0} 的值"),
            min: jQuery.validator.format("请输入一个最小为{0} 的值")
        });

		var $overflow = '';
		//图片浏览初始化参数
		var colorbox_params = {
				rel: 'colorbox',
				reposition: true,
				scalePhotos: true,
				scrolling: false,
				previous: '<i class="ace-icon fa fa-arrow-left"></i>',
				next: '<i class="ace-icon fa fa-arrow-right"></i>',
				close: '&times;',
				current: '{current} of {total}',
				maxWidth: '100%',
				maxHeight: '100%',
				//photo:true,
				onOpen: function () {
					$overflow = document.body.style.overflow;
					document.body.style.overflow = 'hidden';
				},
				onClosed: function () {
					document.body.style.overflow = $overflow;
				},
				onComplete: function () {
					$.colorbox.resize();
				}
			};


		//list form search
		function listFormSearch(th){
            var obj = $(th);
            var serializedData = obj.serializeArray();
            var query_str = '';
            //空字段搜索处理
            $.each(serializedData, function(i,data){
                if($.trim(data['value'])){
                    query_str += (query_str == '') ? '?' + data['name'] + '=' + data['value'] : '&' + data['name'] + '=' + data['value'];
                }
            });
			window.location.href = obj.attr('action')+query_str;
			return false;
		}

		var ajax_get = function (url) {
            var result = {'status': 0, 'msg': '网络错误'};
            $.ajax({
                url: url,
                type: 'get',
                dataType: 'json',
                cache: false,
                async: false,
                error: function () {
                    result['msg'] = '网络错误';
                },
                success: function (rd) {
                    result = rd;
                }
            });
            return result;
        };

      
		

	
		
		//Load content via ajax
		jQuery(function($) {
			//-----返回按钮
			$(document).on("click", "#back", function(){
				history.back();
			});
			//-----end返回按钮

            //删除单条记录
            $(document).on('click', '.del-item', function(){
                var delUrl = $(this).attr('api-path');
                BootstrapDialog.show({
                    title: '确认删除？',
                    message: '删除后将无法恢复！',
                    buttons: [{
                        label: '确定',
                        cssClass: 'btn btn-primary',
                        action: function(dialogItself) {
                            dialogItself.close();
                            window.location.href=delUrl;
                        }
                    }, {
                        label: '取消',
                        action: function(dialogItself) {
                            dialogItself.close();
                        }
                    }]
                });
            });

            //选择全部
            $(document).on('change',"#select-all", function () {
                var selectObj = $(".select-item");
                var status = $(this)[0]['checked'];
                selectObj.each(function () {
                    $(this)[0]['checked'] = status;
                });
            });

            $(document).on('click','#mult-del',function(){
                var selectObj = $(".select-item:checked");
                if(selectObj.length >0){
					var delUrl = $(this).attr('api-path')+'?'+selectObj.serialize();
                    BootstrapDialog.show({
						title: '确认删除？',
						message: '删除后将无法恢复！',
						buttons: [{
							label: '确定',
							cssClass: 'btn btn-primary',
							action: function(dialogItself) {
								dialogItself.close();
								window.location.href=delUrl;
							}
						}, {
							label: '取消',
							action: function(dialogItself) {
								dialogItself.close();
							}
						}]
					});
                }else{
					BootstrapDialog.alert({
						type: BootstrapDialog.TYPE_DANGER
						,message:'请至少选中一条记录！'
						,closable: true
					});
                }
            });

            $(document).on('click','#mult-pass',function(){
                var selectObj = $(".select-item:checked");
                if(selectObj.length >0){
					var delUrl = $(this).attr('api-path')+'?'+selectObj.serialize();
                    BootstrapDialog.show({
						title: '确认审核通过？',
						message: '审核通过后将无法还原！',
						buttons: [{
							label: '确定',
							cssClass: 'btn btn-primary',
							action: function(dialogItself) {
								dialogItself.close();
								window.location.href=delUrl;
							}
						}, {
							label: '取消',
							action: function(dialogItself) {
								dialogItself.close();
							}
						}]
					});
                }else{
					BootstrapDialog.alert({
						type: BootstrapDialog.TYPE_DANGER
						,message:'请至少选中一条记录！'
						,closable: true
					});
                }
            });

            $(document).on('click','#mult-deny',function(){
                var selectObj = $(".select-item:checked");
                if(selectObj.length >0){
					var delUrl = $(this).attr('api-path')+'?'+selectObj.serialize();
                    BootstrapDialog.show({
						title: '确认审核不通过？',
						message: '审核不通过后将无法还原！',
						buttons: [{
							label: '确定',
							cssClass: 'btn btn-primary',
							action: function(dialogItself) {
								dialogItself.close();
								window.location.href=delUrl;
							}
						}, {
							label: '取消',
							action: function(dialogItself) {
								dialogItself.close();
							}
						}]
					});
                }else{
					BootstrapDialog.alert({
						type: BootstrapDialog.TYPE_DANGER
						,message:'请至少选中一条记录！'
						,closable: true
					});
                }
            });

			if('enable_ajax_content' in ace) {
				var options = {
				  content_url: function(url) {
					//this is for Ace demo only, you should change it
					//please refer to documentation for more info
					var ua = url.split('?');
					if(ua.length == 1){
						return "/" + url + ".do";	
					}else if(ua.length == 2){
						return "/" + ua[0] + ".do?" + ua[1];	
					}					
				  },
				  default_url: ''//default url
				};
				ace.enable_ajax_content($, options);
			}
			ace.data.set('now_user_company_id', '');
			$(document).ajaxStart(function(){
				if(ace.data.get('now_user_company_id')!=$('#now_user_company_id').val()){
					window.location.href = '';
					return false;
				}
				return true;
			});
			$(document).ajaxComplete(function(evt, request, settings){
				var loginUrl = '/admin/toLogin.do';
				if(-99==request.responseText){
					window.location.href = loginUrl;
				}else if('POST'==settings.type){
					var t = jQuery.parseJSON(request.responseText);
					if(-99==t.status){
						window.location.href = loginUrl;
					}
				}

				return true;
			 });
			
			$(".fromWho").click(function(){
				var name="";
				$(".fromWho").each(function(){
					if($(this).is(":checked")){
						name+=$(this).val()+"@  ";
					}
				});	
				$("#fromSeaman").val(name);			
			});
			
			$(".toWho").click(function(){
				var name="";
				$(".toWho").each(function(){
					if($(this).is(":checked")){
						name+="@"+$(this).val()+"  ";
					}
				});	
				$("#toSeaman").val(name);			
			});
		});
		
	</script>
