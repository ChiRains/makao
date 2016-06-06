<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<div class="row">
		<div class="col-sm-12">
		  <div class="tabbable tabs-left">
		    <ul class="nav nav-tabs" id="myTab3">
			  <c:forEach items="${executorType}" var="executorType" varStatus="current">
			      <li <c:if test="${executorType.key eq query.type}">class="active"</c:if>>
			        <a data-toggle="tab" href="#type_${executorType.key}">
			          <i class="blue ace-icon fa fa-user bigger-110"></i>
			          <i class="ace-icon fa fa-rocket"></i>
			          ${executorType.name}
			        </a>
			      </li>
			  </c:forEach>
		    </ul>
		
			<div class="text-right">
                <label>
                	<input type="text" placeholder="Search ..." class="nav-search-input" id="name" value="${query.name}" autocomplete="off">
                	<button type="submit" class="btn btn-purple search-member-trigger">
                        <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                        查询
                    </button>
                </label>
    		</div>
		    <div class="tab-content" id="myDiv">
		    <c:forEach items="${executorType}" var="executorType" varStatus="current">
		    <!--  <div id="${executorType.name}" class="tab-pane in active"> -->
		    	<div id="type_${executorType.key}" class="tab-pane in <c:if test='${executorType.key eq query.type}'>active</c:if>">
			     <div class="dataTables_wrapper form-inline no-footer" style="width:500px; height:450px; overflow:auto; overflow-x:hidden;">
			            <form id="myFormData">
			                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
			                	<c:choose>
			                		<c:when test="${executorType.key eq 1}">
			                			<thead>
											<tr>
												<th>姓名</th>
												<th>电话</th>
												<th></th>
											</tr>
										</thead>
										
										<tbody>
											<c:forEach items="${clerkMap}" var="item" varStatus="current">
											<tr>
												<td>${item.value.name}</td>
												<td>${item.value.mobile}</td>
												<td class="center">
													<label>
														<input type="checkbox" class="ace select-member-trigger" name="memberIds" value="${item.key}"
														<c:forEach items="${clerkIdList}" var="processExecutor" varStatus="current">
															<c:if test="${processExecutor.memberId eq item.key && processExecutor.type eq executorType.key}">
																checked
															</c:if>
														</c:forEach>/>
														<span class="lbl"></span>
													</label>
												</td>
											</tr>
											</c:forEach>
										</tbody>
			                		</c:when>
			                		<c:when test="${executorType.key eq 2}">
			                			<thead>
											<tr>
												<th>分组</th>
												<th class="center">
												</th>
											</tr>
										</thead>
					
										<tbody>
											<c:forEach items="${departmentClerkList}" var="item" varStatus="current">
											<tr>
												<td>${item.name}</td>
												<td class="center">
													<label>
														<input type="checkbox" class="ace select-member-trigger" name="characterMemberIds" value="${item.id}"
														<c:forEach items="${clerkIdList}" var="processExecutor" varStatus="current">
															<c:if test="${processExecutor.memberId eq item.id && processExecutor.type eq executorType.key}">
																checked
															</c:if>
														</c:forEach>  /> 
														<span class="lbl"></span>
													</label>
												</td>
											</tr>
											</c:forEach>
										</tbody>
			                		</c:when>
			                		<c:otherwise>
			                			<thead>
											<tr>
												<th>接口名称</th>
												<th>接口方法</th>
												<th class="center">
													<label>
														<span class="lbl"></span>
													</label>
												</th>
											</tr>
										</thead>
					
										<tbody>
											<c:forEach items="${interfaceList}" var="item" varStatus="current">
											<tr>
												<td>${item.name}</td>
												<td>${item.method}</td>
												<td class="center">
													<label>
														<input type="checkbox" class="ace select-member-trigger" name="processExecutorInterfaceIds" value="${item.id}"
														<c:forEach items="${clerkIdList}" var="processExecutor" varStatus="current">
															<c:if test="${processExecutor.memberId eq item.id && processExecutor.type eq executorType.key}">
																checked
															</c:if>
														</c:forEach>/>
														<span class="lbl"></span>
													</label>
												</td>
											</tr>
											</c:forEach>
										</tbody>
			                		</c:otherwise>
			                	</c:choose>
							</table>
						</form>
			        </div>
		      	</div>
		    </c:forEach>
		    </div>
		  </div>
		</div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
        jQuery(function($) {
		});
    });
</script>
