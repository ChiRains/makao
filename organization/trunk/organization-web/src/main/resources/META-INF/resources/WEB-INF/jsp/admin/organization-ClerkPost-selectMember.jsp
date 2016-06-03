<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<div class="row">
    <div class="col-xs-12">
        <!-- <div class="table-responsive"> -->
		<div class="text-left">
            <label>
            	<input type="text" placeholder="姓名 ..." class="nav-search-input" id="name" value="${query.name}" autocomplete="off">
            	<button type="submit" class="btn btn-purple search-clerk-trigger">
                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                    查询
                </button>
            </label>
		</div>
        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer" style="width:750px; height:500px; overflow:auto; overflow-x:hidden;">
            <form id="myForm">
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                	<input type="hidden" name="postId" value="${query.postId}"/>
					<thead>
						<tr>
							<th>姓名</th>
							<th>手机</th>
							<th>是否在职</th>
							<!-- 
							<th>操作</th>
							-->
							<th class="center">
							</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${clerkList}" var="item" varStatus="current"> 
							<tr>
								<td>${item.name}</td>
								<td>${item.mobile}</td>
								<td>
									${item.enable > 0 ? "是" : "否"}
								</td>
								<!-- 
								<td>
									<label><input type="radio" name="lastingType" value="1" checked/>长期</label>
									<label><input type="radio" name="temporaryType" value="2" />临时</label>
								</td>
								 -->
								<td class="center">
									<label>
										<input type="checkbox" class="ace select-clerkPost-trigger" id="clerkId_${item.id}" name="clerkId" value="${item.id}"
										 <c:forEach items="${result}" var="result" varStatus="current">
										 	<c:if test="${result.clerkId eq item.id}">
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
            </div>
        </div>
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
    });
</script>
