<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>
<title>新增管理员</title>


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="model-form" class="form-horizontal" role="form" action="/admin/express/edit.do" >

            <!-- /section:elements.form -->
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name"> 配送方式名称 </label>

                <div class="col-sm-9">
                    <span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
                     	<input type="hidden" class="width-100" maxlength="100" id="id" name="id" value="${express.id}">
                        <input type="text" class="width-100" maxlength="100" id="name" name="name" value="${express.name}">
                        <i class="ace-icon fa"></i>
                    </span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="code"> 快递公司编码 </label>

                <div class="col-sm-2">
                    <span class="col-sm-12 no-padding block input-icon input-icon-right mr10">
                        <input type="text" class="width-100" maxlength="20" id="code" placeholder="用于快递100查询物流" name="code" value="${express.code}">
                        <i class="ace-icon fa"></i>
                    </span>
                </div>
                <label class="control-label"><a href="https://code.google.com/p/kuaidi-api/wiki/Open_API_API_URL" target="_blank">快递公司及参数说明</a></label>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="desc"> 描述 </label>

                <div class="col-sm-9">
                    <span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
                        <textarea class="width-100" maxlength="255" id="desc" name="desc">${express.desc}</textarea>
                    </span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="image"> 图片 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="hidden"  id="logo" name="logo" value="${express.logoUid}"/>
						<button type="button" mult="false" sid="logo" vid="pic-pic-view"   class="btn btn-sm btn-purple btn-upload-pic"  upfrom="0"  ><i class="ace-icon fa fa-upload"></i> 上 传</button>
						<ul sid="pic" id="pic-pic-view" class="ace-thumbnails clearfix">	
							<img src="${express.logo}" />
						</ul>
					</span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name"> 重量设置 </label>

                <div class="col-sm-9">
                    <span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
                       首重重量&nbsp;&nbsp;&nbsp;<input type="text" class="input-mini" style="width: 80px;" name="firstWeight" value="${express.firstWeight}">&nbsp;&nbsp;克&nbsp;<br><br>
                       首重费用&nbsp;&nbsp;&nbsp;<input type="text" class="input-mini" style="width: 80px;" name="firstPrice" value="${express.firstPrice}">&nbsp;&nbsp;元<br><br>
                       续重重量&nbsp;&nbsp;&nbsp;<input type="text" class="input-mini" style="width: 80px;" name="continuedWeight" value="${express.continuedWeight}">&nbsp;&nbsp;克&nbsp;<br><br>
                       续重费用&nbsp;&nbsp;&nbsp;<input type="text" class="input-mini" style="width: 80px;" name="continuedPrice" value="${express.continuedPrice}">&nbsp;&nbsp;元
                <div class="space-6"></div>
                    </span>
                </div>
            </div>
            
          
            
         <!--   <div id="areas_show">
            	<div class="space-4"></div>
	            <div class="form-group">
	                <label for="version" class="col-xs-12 col-sm-3 control-label no-padding-right">
	                    支持的配送地区
	                </label>
	                <div class="col-sm-9">
	                    <span class="col-sm-8 no-padding block input-icon input-icon-right mr10">
	                        <table id="sample-table-1" class="table table-striped table-bordered table-hover ">
	                            <thead>
	                                <tr>
	                                    <th>首重费用</th>
	                                    <th>续重费用</th>
	                                    <th>特殊地区</th>
	                                    <th></th>
	                                </tr>
	                            </thead>
	
	                            <tbody class="city-tbody">
	                            	<c:forEach items="${expressDistrict}" var="item" varStatus="current">
									<tr>
	                                    <td><input type="text" class="input-mini" value="${item.firstPrice}" name="list[${current.index+1}].firstWeight">
	                                    	<input type="hidden" class="input-mini" value="${item.id}" name="list[${current.index+1}].id">
	                                    </td>
	                                    <td><input type="text" class="input-mini" value="${item.continuedPrice}" name="list[${current.index+1}].continuedWeight"></td>
	                                    <td>
	                                      <select class="tag-input-style province"  name="list[${current.index+1}].province">
	                                      	<option value="-1">请选择省份</option>
	                                      	<c:forEach items="${province}" var="province" varStatus="cu">
	                                      		<option <c:if test="${item.province==province}"> selected="selected" </c:if> value="${province}">${province} </option>
	                                      	</c:forEach>
                                    	  </select>
                                    	  <select class="tag-input-style city"  name="list[${current.index+1}].city">
                                    	  </select>
                                    	  <input type="hidden" class="hcity" value="${item.city}"/>
	                                    </td>
	                                    <td><a href="javascript:;" class="del-guige">X</a></td>
	                                </tr>
	                                </c:forEach>
	                            </tbody>
	                            <tfoot>                     
	                                <tr>                            
	                                    <td colspan="4">
	                                        <button type="button" class="btn-link add-row">增加</button>
	                                    </td>                       
	                                </tr>                   
	                            </tfoot>
	                        </table>
	                    </span>
                	</div>    
	            </div>
	            
	        </div> -->

            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="enable"> 是否启用 </label>

                <div class="col-sm-9">
                    <input id="enable" type="checkbox" value="1" class="ace ace-switch ace-switch-5" name="enable" checked="checked">
                    <span class="lbl middle"></span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="sort"> 排序号 </label>

                <div class="col-sm-9">
                    <span class="col-sm-2 no-padding block input-icon input-icon-right mr10">
                        <input type="text" class="width-100" id="sort" name="sort" value="${express.sort}">
                        <i class="ace-icon fa"></i>
                    </span>
                </div>
            </div>

            <div class="space-4"></div>

            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;保&nbsp;存&nbsp;
                    </button>
                    &nbsp; &nbsp; &nbsp;
                    <button id="back" class="btn" type="button"><i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;
                    </button>
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
        jQuery(function ($) {
        	var pArray=$(".province");
        	var cArray=$(".city");
        	var hcity =$(".hcity");
        	var rows=pArray.length;//当前tr数量
	        init();
	        function init(){
	       		setTimeout(3000);	
	        	for(var i=0;i<pArray.length;i++){
	        		var obj=$(pArray[i]);
	        		var obj2=$(cArray[i]);
	        		var name=obj.val();
	        		var h=$(hcity[i]).val();
	        		cityOption="";
	        	 	$.ajax({
	        	 		async :false,
			        	type:"GET",
			        	data :{provinceName:name},
			        	url: "/admin/express/cityList.do",
			        	dataType:"json",
			        	success:function(data){
			        		$.each(data.data.cityList,function(j,c){
			        			if(h==c){
			        				cityOption+="<option selected='selected' value='"+c+"'>"+c+"</option>"
			        			}else{
			        				cityOption+="<option value='"+c+"'>"+c+"</option>"
			        			}
			        		});
			        		$(obj2).html(cityOption);
			        		setTimeout(function(){
			        			
			        		},3000);
						}
					});
	        	}
	        }
            $(window)
            .off('resize.chosen')
            .on('resize.chosen', function() {
                $('.chosen-select').each(function() {
                     var $this = $(this);
                     $this.next().css({'width': $this.parent().width()});
                })
            }).trigger('resize.chosen');
            
            $("#enable").click(function(){
            	if($(this).attr("checked")){
            		$(this).removeAttr("checked");
            		$(this).val("0");
            	}else{
            		$(this).val("1");
            		$(this).attr("checked","true");
            	}
            });
            
             //初始化图片浏览
            $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
            $("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange'></i>");
                   
            var btnUpload = $(".btn-upload-pic");
            delEvent(getButtonSetting(btnUpload));
            //绑定事件
            btnUpload.on('click', function () {
                var bs = getButtonSetting($(this));
                uploadDialog(bs);
            });
            //增加一行
	        $('.add-row').on('click',function(){
	        	rows++;
	        	var str="<tr><td><input type='text' class='input-mini' name='list["+rows+"].firstWeight'>"+
	        	"<input type='hidden' class='input-mini' value='0' name='list["+rows+"].id'>"+
	        	"</td>"+
	        	"<td><input type='text' class='input-mini' name='list["+rows+"].continuedWeight''></td>"+
	        	"<td><select class='tag-input-style province' name='list["+rows+"].province'>"+provinceOption+"</select>  "+
	        	"<select class='tag-input-style city' name='list["+rows+"].city'><option> 请选择城市 </option></select>  </td>"+
	        	"<td><a href='javascript:;' class='del-guige'>X</a></td>";
	        	$(".city-tbody").append(str);
	        	$(".province").change(function(){
					 var obj=$(this);  
					 var name=obj.val();
					 cityOption="";
					 $.ajax({
						type:"GET",
						data :{provinceName:name},
						url: "/admin/express/cityList.do",
						dataType:"json",
						success:function(data){
							$.each(data.data.cityList,function(i,c){
								cityOption+="<option value='"+c+"'>"+c+"</option>"
							});
							obj.next().html(cityOption);
						}
					});
					
				});
	        	
	        });
            //删除
            $(document).on('click','.del-guige',function(){
	            $(this).parent().parent().remove();
	        });    
	        
	       
	        var provinceOption="<option value=''>请选择省份</option>";
	        var cityOption="";
	        $.ajax({
	        	type:"GET",
	        	url: "/admin/express/provinceList.do",
	        	dataType:"json",
	        	success:function(data){
	        		$.each(data.data.provinceList,function(i,p){
	        			provinceOption+="<option value='"+p+"'>"+p+"</option>"
	        		});
	        		//$("#initProvince").html(provinceOption);
	        	}
	        });
	        
	        $(".province").change(function(){
	        	 var obj=$(this);  
	        	 var name=obj.val();
	        	 cityOption="";
	        	 $.ajax({
		        	type:"GET",
		        	data :{provinceName:name},
		        	url: "/admin/express/cityList.do",
		        	dataType:"json",
		        	success:function(data){
		        		$.each(data.data.cityList,function(i,c){
		        			cityOption+="<option value='"+c+"'>"+c+"</option>"
		        		});
		        		obj.next().html(cityOption);
		        	}
		        });
	        });
	        
	      
	        
            //表单验证
            $("#model-form").validate({
                errorElement: 'div',
                errorClass: 'help-block col-xs-12 col-sm-reset inline',
                focusInvalid: false,
                rules: {
                    name: {
                        required: true
                    },
                    firstWeight: {
                        required: true,
                        range: [0, 99999999],
                    },
					firstPrice: {
                        required: true,
                        range: [0, 99999999],
                    },
                    continuedWeight: {
                        required: true,
                        range: [0, 99999999],
                    },
                    continuedPrice: {
                        required: true,
                        range: [0, 99999999],
                    },
                    sort: {
                        required: true,
                        range: [0, 99999999],
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
