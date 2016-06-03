<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>编辑管理员</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        管理里管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            编辑
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form" class="form-horizontal"  role="form" action="/admin/neighbourhood/edit.do">
            <!-- #section:elements.form -->
			<input type="hidden" name="id" value="${neighbourhood.id}">
			
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name"> 名称 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" maxlength="20" id="name" name="name" placeholder="名称" value="${neighbourhood.name}"/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
                  			<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="province"> 省份 </label>

                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<select class="form-control" id="province" name="province">
                            <option value="" selected>请选择一个省份</option>
                            <c:forEach items="${provinceList}" var="item" varStatus="current">
                                <option value="${item.key}" ${item.message}>${item.value}</option>
                            </c:forEach>
                        </select>
					</span>
                </div>
            </div>
           		 		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="city"> 城市 </label>

                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<select class="form-control" id="city" name="city">
                            <option value="" selected>请选择一个市</option>
                            <c:forEach items="${cityList}" var="item" varStatus="current">
                                <option value="${item.key}" ${item.message}>${item.value}</option>
                            </c:forEach>
                        </select>
					</span>
                </div>
            </div>
            			<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="district"> 区/县</label>

                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<select class="form-control" id="district" name="district">
                            <option value="" selected>请选择一个区/县</option>
                            <c:forEach items="${districtList}" var="item" varStatus="current">
                                <option value="${item.key}" ${item.message}>${item.value}</option>
                            </c:forEach>
                        </select>
					</span>
                </div>
            </div>
                  		<div class="space-4"></div>
       		<div class="form-group">
           		<label class="col-sm-3 control-label no-padding-right"> 经纬度 </label>
            	<div class="col-sm-9">
                	<span class="">
                    	<input type="text" readonly name="longitude" id="longitude" value="${neighbourhood.longitude}">
                	</span>
                	<span class="">
                    	<input type="text" readonly name="latitude" id="latitude" value="${neighbourhood.latitude}">
                	</span>
                	<span class="btn btn-sm btn-info" id="getPoint"><i
                        class="ace-icon glyphicon glyphicon-map-marker"></i></span>
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
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","http://api.map.baidu.com/api?v=2.0&ak=RsKB8DSnWTqfeICstegXWCRG&callback=init","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        jQuery(function ($) {
        var setPoint = function (lng, lat) {
                if (lng && lat) {
                    $("#longitude").val(parseFloat(lng));
                    $("#latitude").val(parseFloat(lat));
                }
            };

            var lng = ${store.longitude > 0 ?store.longitude:0};
            var lat = ${store.latitude > 0 ?store.latitude:0};

            $("#getPoint").on("click", function () {
                BootstrapDialog.show({
                    title: '坐标设置',
                    message: '<div>经纬度：<span><input type="text" readonly class="lng" value="' + lng + '"></span><span><input type="text" readonly class="lat" value="' + lat + '"></span></div>' +
                    '<div id="bmap" style="height: 300px;"></div>',
                    onshown: function (dialog) {
                        var map = new BMap.Map(bmap);
                        if (lng && lat) {
                            map.centerAndZoom(new BMap.Point(lng, lat), 13);
                        } else {
                            map.centerAndZoom("珠海", 13);
                        }
                        var menu = new BMap.ContextMenu();
                        var txtMenuItem = [
                            {
                                text: '放大',
                                callback: function () {
                                    map.zoomIn()
                                }
                            },
                            {
                                text: '缩小',
                                callback: function () {
                                    map.zoomOut()
                                }
                            }
                        ];
                        for (var i = 0; i < txtMenuItem.length; i++) {
                            menu.addItem(new BMap.MenuItem(txtMenuItem[i].text, txtMenuItem[i].callback, 100));
                        }
                        map.addContextMenu(menu);
                        map.addEventListener("click", function (e) {
                            dialog.getModalBody().find(".lng").val(e.point.lng).end().find(".lat").val(e.point.lat);
                        });
                    },
                    buttons: [{
                        label: '确定',
                        cssClass: 'btn-primary',
                        action: function (dialog) {
                            lng = dialog.getModalBody().find(".lng").val();
                            lat = dialog.getModalBody().find(".lat").val();
                            setPoint(lng, lat);
                            dialog.close();
                        }
                    }]
                });
            });
        	
        	$('#province').change(function () {
                var data = {
                    province: $('#province').val()
                };
                $.ajax({
                    url: '/city/queryByProvince.do',
                    type: 'POST',
                    data: data,
                    dataType: 'json',
                    cache: false,
                    async: false,
                    beforeSend: function () {

                    },
                    error: function () {
                        BootstrapDialog.alert({
                            title: '错误',
                            message: '网络错误，请稍后再尝试！',
                            type: BootstrapDialog.TYPE_DANGER
                        });
                    },
                    success: function (rd) {
                        if (rd['status'] != 200) {
                            BootstrapDialog.alert({
                                title: '错误',
                                message: rd.message,
                                type: BootstrapDialog.TYPE_DANGER
                            });
                        } else {
                            $("#city").empty();
                            $("#district").empty();
                            var option0 = $("<option>").val(-1).text("请选择一个市");
                            $("#city").append(option0);

                            var option1 = $("<option>").val(-1).text("请选择一个区");
                            $("#district").append(option1);

                            var obj = rd.data.cityList;
                            $.each(obj, function (n, value) {
                                var option = $("<option>").val(value.key).text(value.value);
                                $("#city").append(option);
                            });
                        }
                    }
                });
            });

            $('#city').change(function () {
                var data = {
                    city: $('#city').val()
                };
                $.ajax({
                    url: '/district/queryByCity.do',
                    type: 'POST',
                    data: data,
                    dataType: 'json',
                    cache: false,
                    async: false,
                    beforeSend: function () {

                    },
                    error: function () {
                        BootstrapDialog.alert({
                            title: '错误',
                            message: '网络错误，请稍后再尝试！',
                            type: BootstrapDialog.TYPE_DANGER
                        });
                    },
                    success: function (rd) {
                        if (rd['status'] != 200) {
                            BootstrapDialog.alert({
                                title: '错误',
                                message: rd.message,
                                type: BootstrapDialog.TYPE_DANGER
                            });
                        } else {
                            $("#district").empty();
                            var option0 = $("<option>").val(-1).text("请选择一个区");
                            $("#district").append(option0);
                            var obj = rd.data.districtList;
                            $.each(obj, function (n, value) {
                                var option = $("<option>").val(value.key).text(value.value);
                                $("#district").append(option);
                            });
                        }
                    }
                });
            });
            $(window)
            .off('resize.chosen')
            .on('resize.chosen', function() {
                $('.chosen-select').each(function() {
                     var $this = $(this);
                     $this.next().css({'width': $this.parent().width()});
                })
            }).trigger('resize.chosen');
                   
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
        });
    })
</script>
