<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>发送消息</title>
<style>
.delClerk{
cursor:pointer;

}
</style>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form id="delivery-form" class="form-horizontal"  role="form" action="">
            <!-- #section:elements.form -->	      		           	    		
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="clerkId"> 接收人 </label>
                <div class="col-md-offset-3 col-md-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
		               <input type="hidden"  id="clerkId_send" name="clerkId_send" value="${clerkId}"/>
					   <input type="text" class="width-100" readonly  id="clerkName_send" name="clerkName_send" placeholder="接收人" value="${name}"/>
					</span>
				  <c:if test="${clerkId eq 0}"> 
				<a class="btn btn-primary select-clerk">
                       <i class="ace-icon fa fa-keyboard-o bigger-130"></i>接收人设置</a>
                 </c:if>
			      
                </div>
            </div>
                  		<div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="title"> 标题 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100"  id="title" name="title" placeholder="标题" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>                  		
           <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="content"> 内容 </label>
                <div class="col-sm-9">
                    <textarea style="height:300px;" class="col-xs-10 no-float" id="content" name="content" placeholder="内容"></textarea>
                </div>
            </div>
                  		
             <!--   <div class="space-4"></div>
                <div class="col-md-offset-3 col-md-9">
                    <button class="btn btn-info submit_message" type="submit"><i class="ace-icon fa fa-check bigger-110"></i>&nbsp;发&nbsp;送&nbsp;</button>
                    &nbsp; &nbsp; &nbsp;
                    <button id="back" class="btn" type="button"><i class="ace-icon fa fa-undo bigger-110"></i>&nbsp;返&nbsp;回&nbsp;</button>
            </div>-->

        </form>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
    
     $(".select-clerk").on("click", function () {
     		// 务必添加解绑事件，要不然会重复提交数据
     		$(document).off('click',"#clerkbtn");
     		  var id= document.getElementById("clerkId_send").value;  
            BootstrapDialog.show({
          
                title:"选择接收人",                          
                message: $('<div></div>').load('/admin/clerkMessage/toSelectClerk.do?clerkId_send='+id),
                cssClass: "select-product-dialog",
                onshow: function (dialog) { 
          
                //单选 
                $(document).on('click','input[name=clerkId]',function(){
			    		 var flag=0;
			    		 var id_array=new Array();
			    		 var name_array=new Array();
			    		 $("input[name=clerkId]").each(function(){
			    			if($(this).is(":checked")){
			    			var id=$(this).attr("data-id");
			    			var name=$(this).attr("data-name");
			    			  id_array.push(id);
			    			  name_array.push(name);
			    				
			    			}else{
			    				flag++;
			    			}
			    		});
			    		var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串
			    		var namestr=name_array.join(',');
			    		// console.log("idstr:" +idstr);
    	    			// console.log("namestr:" + namestr);
    	    			  $('#clerkId_send').val(idstr);
	    	       		  $('#clerkName_send').val(namestr);
			    		if(flag>0){
			    			$("input[name=selectAll]").prop("checked",false);
			    		}else{
			    			$("input[name=selectAll]").prop("checked",true);
			    		}
			    });
                //反选
               $(document).on('click','input[name=initAll]',function(){
    	             var id_array=new Array();
    		         var name_array=new Array();
    		         var isCheck=0;
    		   $("input[name=clerkId]").each(function(){
    			  var id=$(this).attr("data-id");
		    	  var name=$(this).attr("data-name");
		   		   if($(this).is(":checked")){
    			    	$("#"+id).parent().remove();
    			     }else{
    				   isCheck++;
    				   id_array.push(id);
    			       name_array.push(name);
    		    	}
    			$(this).prop("checked",!this.checked); 
    			var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串
    		    var namestr=name_array.join(',');
                       //  console.log("idstr:" +idstr);
    	    			// console.log("namestr:" + namestr);
    	    			  $('#clerkId_send').val(idstr);
	    	       		  $('#clerkName_send').val(namestr);
             
    	
    			});
                
              });  
                //全选
    	 $(document).on('click','input[name=selectAll]',function(){
    	     var id_array=new Array();
    		 var name_array=new Array();
    		if($(this).is(":checked")){
    		
    			$("input[name=clerkId]").each(function(){
    				var id=$(this).attr("data-id");
		    		var name=$(this).attr("data-name");
		    			id_array.push(id);
    			  name_array.push(name);
		   			if($(this).is(":checked")){
		    		
		    		}else{
		    			$(this).prop("checked",true);
		    		}
		    		
    			});
    		  var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串
    		  var namestr=name_array.join(',');
    		           // console.log("idstr:" +idstr);
    	    			// console.log("namestr:" + namestr);
    	    			  $('#clerkId_send').val(idstr);
	    	       		  $('#clerkName_send').val(namestr);
    		}
    	});
                 $(document).on('click','#clerkbtn',function(){
                  	
    		        	dialog.close();
    	             });
                	
                }
            });
        });
    
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
            $("#delivery-form").validate({
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
                    postForm('delivery-form');
                    //window.location.reload(true);
                },
                invalidHandler: function (form) {
                }
            });
        });
    })
</script>
