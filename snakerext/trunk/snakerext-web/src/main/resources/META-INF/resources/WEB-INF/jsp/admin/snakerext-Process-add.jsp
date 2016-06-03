<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>新增流程</title>
<link rel="stylesheet" href="/qcloud-admin/assets/css/colorbox.css"/>
<link rel="stylesheet" href="/qcloud-admin/assets/css/chosen.css" />

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        流程管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            新增
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
         <form class="form-horizontal" role="form" id="validation-form" action="/admin/process/add.do" method="post" enctype="multipart/form-data">
            <!-- #section:elements.form -->
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="version"> 创建人 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" id="creator" name="creator" placeholder="名字" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="type"> 类型 </label>
                <div class="col-sm-9">
					<span class="col-sm-5 no-padding block input-icon input-icon-right mr10">
						<input type="text" class="width-100" id="type" name="type" placeholder="类型" value=""/>
						<i class="ace-icon fa"></i>
					</span>
                </div>
            </div>
            
            <div class="space-4"></div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="file"> 文件 </label>
	            <div class="col-xs-12 col-sm-4">
	                <span class="block input-icon input-icon-right">
	                	<input  type="file" name="pack" id="pack"  />
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
    <!-- /.col -->
</div><!-- /.row -->

<script type="text/javascript">
    var scripts = [null, "/qcloud-admin/assets/js/jquery.colorbox-min.js","/qcloud-admin/assets/js/upload-img.js","/qcloud-admin/assets/js/chosen.jquery.min.js", null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
      jQuery(function($) {					
				var $form = $('#validation-form');
				var deal_pic = function(){
					//you can have multiple files, or a file input with "multiple" attribute
					var file_input = $form.find('input[type=file]');
					var upload_in_progress = false;

					file_input.ace_file_input({
						style : 'well',
						btn_choose : '请选择文件',
						btn_change: null,
						droppable: true,
						thumbnail: 'large',
						
						maxSize: 1048576*150,//bytes(5m)
						allowExt: ["snaker", "snakerform", "xml"],
               			//allowMime: ["application/xml"],

						before_remove: function() {
							if(upload_in_progress)
								return false;//if we are in the middle of uploading a file, don't allow resetting file input
							return true;
						},

						preview_error: function(filename , code) {
							//code = 1 means file load error
							//code = 2 image load error (possibly file is not an image)
							//code = 3 preview failed
						}
					})
					file_input.on('file.error.ace', function(ev, info) {
						if(info.error_count['ext'] || info.error_count['mime']) alert('只支持上传snaker、xml文件');
						if(info.error_count['size']) alert('文件上限为5M');
						
						//you can reset previous selection on error
						//ev.preventDefault();
						//file_input.ace_file_input('reset_input');
					});
				}
				
				

				
					deal_pic();

					$form.find('button[type=reset]').on('click',function(){	//点击重置恢复成空白
						$('#pack').parent().parent().append('<input  type="file" name="pack" id="pack"  />');
						$('#pack').parent().remove();
						deal_pic();
					});
				

				$('#validation-form').validate({
					errorElement: 'div',
					errorClass: 'help-block',
					focusInvalid: false,
					rules: {
						content: {
							required: true,
							//maxlength:50
						},
						version: {
							required: true,
							//minlength: 5
						},
						
					},
			
					messages: {					
						
					},
			
			
					highlight: function (e) {
		                $(e).closest('.form-group').removeClass('has-success').addClass('has-error');
		            },
		    
		            success: function (e) {
		                $(e).closest('.form-group').removeClass('has-error').addClass('has-success');
		                $(e).remove();
		            },



		            errorPlacement: function (error, element) {
		                if(element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
		                    var controls = element.closest('div[class*="col-"]');
		                    if(controls.find(':checkbox,:radio').length > 1) controls.append(error);
		                    else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
		                }
		                else {
		                    error.insertAfter(element.parents('div').eq(0));
		                    if(!error.html()){
		                        element.next('i.ace-icon').removeClass('fa-times-circle').addClass('fa-check-circle');
		                    }else{
		                        element.next('i.ace-icon').removeClass('fa-check-circle').addClass('fa-times-circle');
		                    }
		                }
		            },
			
					submitHandler: function (form) {
						form.submit();						
						/*postForm($(form).attr('id'));
                		return false;*/
					},
					invalidHandler: function (form) {
					}
				});


			});
    })
</script>
