<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>管理员管理后台</title>
		<link rel="icon" href="/qcloud-admin/assets/favicon.ico" type="image/icon" >
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="">
		<meta name="author" content="" />
		<%@include file="css.inc.jsp" %>
		<%--<%@include file="js.inc.jsp" %> --%>
			
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- text fonts -->
			<link rel="stylesheet" href="/qcloud-admin/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/qcloud-admin/assets/css/ace.min.css" />		
        <link href="/qcloud-admin/umeditor/themes/default/css/umeditor.min.css" type="text/css" rel="stylesheet">
	
        <link rel="stylesheet" href="/qcloud-admin/assets/css/bootstrap-dialog.min.css"/>

		<!--[if lte IE 9]>
		<link rel="stylesheet" href="/qcloud-admin/assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="/qcloud-admin/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="/qcloud-admin/assets/css/ace-rtl.min.css" />


		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="/qcloud-admin/assets/css/ace-ie.min.css" />
		<![endif]-->

		<link rel="stylesheet" href="/qcloud-admin/assets/css/public.css" />

		<!-- ace settings handler -->
		<script src="/qcloud-admin/assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="/qcloud-admin/assets/js/html5shiv.js"></script>
		<script src="/qcloud-admin/assets/js/respond.min.js"></script>
		<![endif]-->
		<style>
			/*.main-container:before{
				background-image:url(/qcloud-admin/assets/img/qcloud.jpg);
			}*/
			.table-responsive {
				width: 100%;
				margin-bottom: 15px;
				overflow-x: scroll;
				overflow-y: hidden;
				border: 1px solid #dddddd;
				-ms-overflow-style: -ms-autohiding-scrollbar;
				-webkit-overflow-scrolling: touch;
			}
			.table-responsive > .table {
				margin-bottom: 0;
			}
			.table-responsive > .table > thead > tr > th,
			.table-responsive > .table > tbody > tr > th,
			.table-responsive > .table > tfoot > tr > th,
			.table-responsive > .table > thead > tr > td,
			.table-responsive > .table > tbody > tr > td,
			.table-responsive > .table > tfoot > tr > td {
			white-space: nowrap;
			}
		</style>
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="/admin/index.do" class="navbar-brand">
						<small>
							<i class="fa  fa-cloud"></i>
							QCloud Admin
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">						
						<!-- #section:basics/navbar.user_menu -->						
						
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="/qcloud-admin/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎您</small>									
								</span>
								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">								
								<li>
									<a href="/admin/logout.do">
										<i class="ace-icon fa fa-power-off"></i>
										退出管理
									</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="ace-icon fa fa-pencil"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning">
							<i class="ace-icon fa fa-users"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				


				<ul class="nav nav-list">
					<c:forEach items="${catalogList}" var="catalog" varStatus="current"> 
						<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-caret-right"></i>
							<span class="menu-text"> ${catalog.catalog.name} </span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						<ul class="submenu">
							<c:forEach items="${catalog.menuList}" var="menu" varStatus="current"> 
							<li class="">
								<a data-url="${menu.url}" href="#${menu.url}">
									<i class="menu-icon fa fa-caret-right"></i>
									${menu.name}
								</a>
								<b class="arrow"></b>
							</li>
							</c:forEach>
						</ul>
						</li>
					</c:forEach>
				</ul>

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="javascript:;">管理后台</a>
						</li>
					</ul><!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<!--<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
								<i class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>-->
					<!-- /.nav-search -->

					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<!-- #section:settings.box -->
					<div class="ace-settings-container" id="ace-settings-container">
						<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
							<i class="ace-icon fa fa-cog bigger-150"></i>
						</div>

						<div class="ace-settings-box clearfix" id="ace-settings-box">
							<div class="pull-left width-50">
								<!-- #section:settings.skins -->
								<div class="ace-settings-item">
									<div class="pull-left">
										<select id="skin-colorpicker" class="hide">
											<option data-skin="no-skin" value="#438EB9">#438EB9</option>
											<option data-skin="skin-1" value="#222A2D">#222A2D</option>
											<option data-skin="skin-2" value="#C6487E">#C6487E</option>
											<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
										</select>
									</div>
									<span>&nbsp; Choose Skin</span>
								</div>

								<!-- /section:settings.skins -->

								<!-- #section:settings.navbar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
									<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
								</div>

								<!-- /section:settings.navbar -->

								<!-- #section:settings.sidebar -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
									<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
								</div>

								<!-- /section:settings.sidebar -->

								<!-- #section:settings.breadcrumbs -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
									<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
								</div>

								<!-- /section:settings.breadcrumbs -->

								<!-- #section:settings.rtl -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
									<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
								</div>

								<!-- /section:settings.rtl -->

								<!-- #section:settings.container -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
									<label class="lbl" for="ace-settings-add-container">
										Inside
										<b>.container</b>
									</label>
								</div>

								<!-- /section:settings.container -->
							</div><!-- /.pull-left -->

							<div class="pull-left width-50">
								<!-- #section:basics/sidebar.options -->
								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
									<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
									<label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
								</div>

								<div class="ace-settings-item">
									<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
									<label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
								</div>

								<!-- /section:basics/sidebar.options -->
							</div><!-- /.pull-left -->
						</div><!-- /.ace-settings-box -->
					</div><!-- /.ace-settings-container -->

					<!-- /section:settings.box -->
					<div class="page-content-area">
						<!-- ajax content goes here -->
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->



			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

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
			//css动态加载
			var cssLoadArr = new Array();
			function loadCss(link){
				if(null!=link){

				}
				for(lk in link){
					if(-1!==jQuery.inArray(link[lk], cssLoadArr)){
						console.log(link[lk]);
					}else{
						cssLoadArr.push(link[lk]);
						$('head').prepend('<link rel="stylesheet" href="'+link[lk]+'">');
					}
				}
				console.log(cssLoadArr);
			}
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
										window.location.href = "/admin/index.do?#" + rd.data.url;
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

			});

		</script>
		<input type="hidden" name="now_user_company_id" id="now_user_company_id" value="" />
	</body>
</html>
