<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<title>管理员管理后台</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="">
		<meta name="author" content="" />
		<%@include file="/WEB-INF/jsp/admin/css.inc.jsp" %>
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
					<a href="#" class="navbar-brand">
						<small>
							<i class="fa  fa-cloud"></i>
							QCloud Admin
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>						
					<div class="page-content-area">											
								<title>URL列表</title>								
								<!-- ajax layout which only needs content area -->						
								
								<div class="row">
								    <div class="col-xs-12">
								
								    
								
								        <!-- <div class="table-responsive"> -->
								
								        <!-- <div class="dataTables_borderWrap"> -->
								        <div>
								            <div class="dataTables_wrapper form-inline no-footer">
								                <div class="row">	
								                    <div class="col-xs-4">
								                	 <div class="dataTables_length">
								                            <a title="URL索引" class="btn btn-sm btn-info"
								                               href="/url/index.do?keyword=">
								                                <i class="ace-icon fa fa-undo align-bottom bigger-125"></i>
								                                URL索引
								                            </a>               
								                        </div>
								                	 </div>						                   
								                    <div class="col-xs-8">
								                        <div class="dataTables_length" style="float:right;">
								                        <form id="query-form" action="/url/list.do" onsubmit="listFormSearch(this); return false">
								                        	<span><font color="#ff9955">共有${total}个接口 ,未配置${notLinkTotal}个接口</font></span> 
								                            <input type="search" maxlength="40" class="form-control search-query"
								                                           placeholder="关键字" name="keyword" value="${keyword}">
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
								                        <th>序号</th>   			              
								                        <th>URL</th>								                      
								                    </tr>
								                    </thead>
								
								                    <tbody>
								                           <c:forEach items="${list}" var="url" varStatus="current"> 
								                            <tr>      
								                                <td>${current.index + 1}</td>
									                            <td>${url.url}</td>                           									                              								                          
									                        </tr>
														</c:forEach>
								                    </tbody>
								                </table>              
								            </div>
								        </div>
								    </div>
								</div>
						
						
						
					</div>
				</div>
			</div>
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

			});

		</script>
		<input type="hidden" name="now_user_company_id" id="now_user_company_id" value="" />
	</body>
</html>