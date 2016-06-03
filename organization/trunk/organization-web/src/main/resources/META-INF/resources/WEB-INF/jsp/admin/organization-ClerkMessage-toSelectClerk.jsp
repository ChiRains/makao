<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<div class="row">
    <div class="col-xs-12">
        <!-- <div class="table-responsive"> -->
		<div class="text-right">
            <label>
            
            </label>
		</div>
        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer" style="width:570px; height:570px; overflow:auto; overflow-x:hidden;">
            <form id="myForm">
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                	<input type="hidden" name="clerkId" value="${query.id}"/>
					<thead>
						<tr>
							<th>姓名</th>
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
								<td class="center">
									<label>
										<input type="checkbox" class="ace select-clerk-trigger" id="clerkId_${item.id}" name="clerkId" value="${item.id}"
										data-id="${item.id}" data-name="${item.name}" 
										 <c:forEach items="${result}" var="result" varStatus="current">
										 	<c:if test="${result.id eq item.id}">
										 		checked
										 	</c:if>
										 </c:forEach>/>
										<span class="lbl"></span>
									</label>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		 <div style="text-align:center;"><input id="clerkbtn" type="button" value="确定"/></div>
			
            </div>
        </div>
        
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
    
    	$("#myForm").validate({
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
                    postForm('myForm');
                },
                invalidHandler: function (form) {
                
                }
            });
    
    
    });
</script>
