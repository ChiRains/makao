<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<div class="row">
    <div class="col-xs-12">
        <!-- <div class="table-responsive"> -->
		<div class="text-right">
            <label>
            	<input type="text" placeholder="名称 ..." class="nav-search-input" id="name" value="${query.name}" autocomplete="off">
            	<button type="submit" class="btn btn-purple search-form-trigger">
                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                    查询
                </button>
            </label>
		</div>
        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer" style="width:600px; height:500px; overflow:auto; overflow-x:hidden;">
            <form id="myForm">
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>主表单</th>
							<th class="center">
							</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${formDefList}" var="item" varStatus="current"> 
							<tr>
								<td>${item.name}</td>
								<td class="center">
									<label>
										<input type="radio" class="ace select-form-trigger" name="mainFormId" value="${item.id}" data-processId="${query.processId}"
										 	<c:if test="${processForm.mainFormId eq item.id}">
										 		checked
										 	</c:if>/>
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
