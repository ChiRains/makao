<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>映射管理</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        映射管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            映射
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form" class="form-horizontal"  role="form" action="/admin/formTableMapping/edit.do">
            <!-- #section:elements.form -->
			<input type="hidden" name="mainFormId" value="${formTableForm.mainFormId}">
            <div class="space-4"></div>
            <div class="form-group">
                <div class="col-sm-10">
                	<div class="form-group">
	                    <table class="table table-striped table-bordered table-hover kv-table">
	                        <thead>
	                        	<tr>
	                        		<td align="center">表单</td>
	                        		<td align="center">数据库表</td>
	                        	</tr>
		                        <tr>
		                            <th width="50%" style="text-align: center;">
		                            	${formDef.name}
		                            </th>
		                            <th width="50%" style="text-align: center;">
										<select class="chosen-select" id="tableId" name="tableId" data-placeholder="表名" size="10" onchange="changeTable();">
					                		  <c:forEach items="${tableList}" var="item" varStatus="current">
					                		  	 <option value="${item.id}"
					                		  	  <c:if test="${item.id eq formTableForm.tableId}">
						                		  	 selected
		                        				  </c:if>>${item.name}-[${item.label}]</option>
					                		  </c:forEach>
					                	</select>
										<i class="ace-icon fa"></i>
		                            </th>
		                        </tr>
	                        </thead>
	                        <tfoot>
	                        	<c:forEach items="${elementDeflist}" var="element" varStatus="current">
		                        <tr>
		                        	<input type="hidden" name="elementIds" value="${element.id}"/>
		                        	<td align="center">${element.name}</td>
		                        	<td align="center">
		                        		<select name="fieldIds" data-placeholder="选择">
					                		<option value="">请选择</option>
					                		  <c:forEach items="${fieldMap}" var="map" varStatus="current">
					                		  	 <option value="${map.key}"
					                		  	 <c:if test="${map.key eq elementFieldMappingMap[element.id]}">
					                		  	 selected
					                		  	 </c:if>>${map.value.name}-[${map.value.label}]</option>
					                		  </c:forEach>
					                	</select>
		                        	</td>
		                        </tr>
		                        </c:forEach>
	                        </tfoot>
	                    </table>
                    </div>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-4 col-md-9">
                    <button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;保&nbsp;存&nbsp;</button>
                    &nbsp; &nbsp; &nbsp;
                    <button class="btn" type="button" onclick="window.location.href='#admin/formDef/list'">
                    <i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;</button>
                </div>
            </div>

        </form>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    function changeTable() {
    	var mainFormId = '${formTableForm.mainFormId}';
    	var tableId = $("#tableId").val();
    	window.location.href="#admin/formTableMapping/toEdit?mainFormId="+mainFormId + "&tableId="+tableId;
    }
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        jQuery(function ($) {
        	$('.chosen-select').chosen({allow_single_deselect:true});
            $(window)
            .off('resize.chosen')
            .on('resize.chosen', function() {
                $('.chosen-select').each(function() {
                     var $this = $(this);
                     $this.next().css({'width': $this.parent().width()});
                })
            }).trigger('resize.chosen');
            
            var width = $('.chosen-choices input').parent().parent().parent().width();                       
            $('.chosen-choices input').css({'width':width});
            
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
