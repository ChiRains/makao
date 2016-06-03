<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<style>
.delClerk{
cursor:pointer;

}

</style>
<div class="row">
    <div class="col-xs-12">
        <!-- <div class="table-responsive"> -->
           <form id="myForm" action="#admin/clerk/selectAllClerk"  onsubmit="listFormSearch(this); return false">
		<div class="text-right">
            <label>
            	<input type="text" placeholder="姓名 ..." class="nav-search-input" id="name" name="name" value="${query.name}" autocomplete="off">
            	<button type="submit"  class="btn btn-purple search-clerk-trigger">
                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                    查询
                </button>
            </label>
		</div>
			</form>
        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer" style="width:600px; height:560px; overflow:auto; overflow-x:hidden;float: left;margin-right: 35px">
         
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>姓名</th>
							<th>手机</th>
							<!-- 
							<th>操作</th>
							-->
							<th class="center">
								<input type="checkbox" name="selectAll"/>全选
								<input type="checkbox" name="initAll"/>反选
								
							</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${clerkList}" var="item" varStatus="current"> 
							<tr>
								<td>${item.name}</td>
								<td>${item.mobile}</td>
								<!-- 
								<td>
									<label><input type="radio" name="lastingType" value="1" checked/>长期</label>
									<label><input type="radio" name="temporaryType" value="2" />临时</label>
								</td>
								 -->
								<td class="center">
										<input type="checkbox"  id="clerkId_${item.id}" name="clerkId" value="${item.id}"
										 	data-id="${item.id}" data-name="${item.name}" data-mobile="${item.mobile}"
										 	data-current="${current.index}"
										 <c:forEach items="${guList}" var="result" varStatus="current">
										 	<c:if test="${item.id eq result.userId}">
										 		checked />
										 	</c:if>
										 </c:forEach>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		
            </div>
            
            <div class="dataTables_wrapper form-inline no-footer" style="width:600px; height:560px; overflow:auto; overflow-x:hidden;">
            <form id="myForm2" action="/admin/usergroupUser/add.do">
            <input name="groupId" value="${groupId}" type="hidden"/>
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>姓名</th>
							<th>手机</th>
							<th class="center">
							操作
							</th>
						</tr>
					</thead>

					<tbody id="second">
						
					</tbody>
				</table>
				
			</form>
            </div>
            
        </div>
        <div style="text-align:center;"><input id="clerkbtn" type="button" value="确定"/></div>
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
    	$("input[name=clerkId]").each(function(){
			var id=$(this).attr("data-id");
    		var name=$(this).attr("data-name");
    		var mobile=$(this).attr("data-mobile");
    		var current=$(this).attr("data-current");
    		var str="<tr><td id='"+id+"'><input type='hidden' name='guList["+current+"].userId' value='"+id+"'/>  "+name+"</td><td>"+mobile+"</td><td style='text-align:center;'><a class='delClerk'>X</a></td></tr>";
   			if($(this).is(":checked")){
   				
    			$("#second").append(str);
    			$(this).prop("checked",true);
    		}else{
    			
    		}
    		$(".delClerk").bind('click',function(){
    			var id=$(this).parent().prev().prev().attr("id");
				$("input[name=clerkId]").each(function(){
					var dataId=$(this).attr("data-id");
					if(dataId==id){
						$(this).prop("checked",false);
					}
				});
				$(this).parent().parent().remove();
				$("input[name=selectAll]").prop("checked",false);
    		});
		});

    	$("#clerkbtn").click(function (){
    		$("#myForm2").submit();
    	});
    	
    	
    	//全选
    	$("input[name=selectAll]").click(function(){
    		if($(this).is(":checked")){
    			$("input[name=clerkId]").each(function(){
    				var id=$(this).attr("data-id");
		    		var name=$(this).attr("data-name");
		    		var mobile=$(this).attr("data-mobile");
		    		var current=$(this).attr("data-current");
		    		var str="<tr><td id='"+id+"'><input type='hidden' name='guList["+current+"].userId' value='"+id+"'/>  "+name+"</td><td>"+mobile+"</td><td style='text-align:center;'><a class='delClerk'>X</a></td></tr>";
		   			if($(this).is(":checked")){
		    		
		    		}else{
		    			$("#second").append(str);
		    			$(this).prop("checked",true);
		    		}
    			});
    			
    			$(".delClerk").bind('click',function(){
    				var id=$(this).parent().prev().prev().attr("id");
    				$("input[name=clerkId]").each(function(){
    					var dataId=$(this).attr("data-id");
    					if(dataId==id){
    						$(this).prop("checked",false);
    					}
    				});
					$(this).parent().parent().remove();
					$("input[name=selectAll]").prop("checked",false);
				});
    		}else{
    			$("input[name=clerkId]").prop("checked",false);
    			$("input[name=clerkId]").each(function(){
    				var id=$(this).attr("data-id");
		    		var name=$(this).attr("data-name");
		    		var mobile=$(this).attr("data-mobile");
		    		var current=$(this).attr("data-current");
		    		var str="<tr><td id='"+id+"'><input type='hidden' name='guList["+current+"].userId' value='"+id+"'/>  "+name+"</td><td>"+mobile+"</td><td style='text-align:center;'><a class='delClerk'>X</a></td></tr>";
		   			if($(this).is(":checked")){
		    			
		    		}else{
		    			$("#"+id).parent().remove();
		    		}
    			});
    		}
    	});
  		//单选
    	$("input[name=clerkId]").click(function(){
    		var flag=0;
    		$("input[name=clerkId]").each(function(){
    			if($(this).is(":checked")){
    				
    			}else{
    				flag++;
    			}
    		});
    		if(flag>0){
    			$("input[name=selectAll]").prop("checked",false);
    		}else{
    			$("input[name=selectAll]").prop("checked",true);
    		}
    	});
    	//反选
    	$("input[name=initAll]").click(function(){
    		var count=$("input[name=clerkId]").length;	
    		var isCheck=0;
    		$("input[name=clerkId]").each(function(){
    			var id=$(this).attr("data-id");
		    	var name=$(this).attr("data-name");
		    	var mobile=$(this).attr("data-mobile");
		    	var current=$(this).attr("data-current");
		    	var str="<tr><td id='"+id+"'><input type='hidden' name='guList["+current+"].userId' value='"+id+"'/>  "+name+"</td><td>"+mobile+"</td><td style='text-align:center;'><a class='delClerk'>X</a></td></tr>";
		   		if($(this).is(":checked")){
    				$("#"+id).parent().remove();
    			}else{
    				isCheck++;
    				$("#second").append(str);
    				
    			}
    			$(this).prop("checked",!this.checked); 
    			
    		});
    		$(".delClerk").bind('click',function(){
				var id=$(this).parent().prev().prev().attr("id");
				$("input[name=clerkId]").each(function(){
					var dataId=$(this).attr("data-id");
					if(dataId==id){
						$(this).prop("checked",false);
					}
				});
				$(this).parent().parent().remove();
				$("input[name=selectAll]").prop("checked",false);
			});
			if(isCheck==count){//全选按钮变成  选中状态
				$("input[name=selectAll]").prop("checked",true);
			}
			if(isCheck==0){//全选按钮变成  取消选中状态
				$("input[name=selectAll]").prop("checked",false);
			}
    	});
    	//动态添加td
    	$("input[name=clerkId]").click(function(){
    		var id=$(this).attr("data-id");
    		var name=$(this).attr("data-name");
    		var mobile=$(this).attr("data-mobile");
    		var current=$(this).attr("data-current");
    		var str="<tr><td id='"+id+"'><input type='hidden' name='guList["+current+"].userId' value='"+id+"'/>  "+name+"</td><td>"+mobile+"</td><td style='text-align:center;'><a class='delClerk'>X</a></td></tr>";
		    if($(this).is(":checked")){
    			$("#second").append(str);
    		}else{
    			$("#"+id).parent().remove();
    		}
    		$(".delClerk").bind('click',function(){
    			var id=$(this).parent().prev().prev().attr("id");
				$("input[name=clerkId]").each(function(){
					var dataId=$(this).attr("data-id");
					if(dataId==id){
						$(this).prop("checked",false);
					}
				});
				$(this).parent().parent().remove();
				$("input[name=selectAll]").prop("checked",false);
    		});
    	});
    	$("#myForm2").validate({
                errorElement: 'div',
                errorClass: 'help-block col-xs-12 col-sm-reset inline',
                focusInvalid: false,
                rules: {
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
                    postForm('myForm2');
                },
                invalidHandler: function (form) {
                
                }
            });
    });
</script>
