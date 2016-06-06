<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>
<div class="row">
    <div class="col-xs-12">
        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer" style="width:600px; height:500px; overflow:auto; overflow-x:hidden;">
            <form id="myForm">
                <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                	<input type="hidden" name="processId" value="${query.processId}"/>
                	<input type="hidden" name="taskName" value="${query.taskName}"/>
					<thead>
						<tr>
							<th>表单元素</th>
							<th class="center">
								<label>
									<input type="checkbox" class="ace" />
									<span class="lbl"></span>
								</label>
							</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${elementDefList}" var="item" varStatus="current"> 
							<tr>
								<td>
									<span class="label label-sm label-success">我是元素</span>
									${item.name}
								</td>
								<td class="center">
									<label>
										<input type="checkbox" class="ace" name="element" value="${item.formId}_${query.taskName}_${item.id}"
											<c:if test="${elementMap[item.id] > 0}">
											checked
										</c:if>/>
										<span class="lbl"></span>
									</label>
									
								</td>
							</tr>
						</c:forEach>
						<c:forEach items="${formDefList}" var="item" varStatus="current"> 
							<tr>
								<td>
									<span class="label label-sm label-warning">我是表单</span>
									${item.name}
								</td>
								<td class="center">
									<label>
										<input type="checkbox" class="ace" name="childrenForm" value="${item.mainFormId}_${item.id}_${query.taskName}"
										<c:if test="${elementMap[item.id] > 0}">
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
        jQuery(function($) {
			var oTable1 = $('#sample-table-2').dataTable( {
			"aoColumns": [
		      { "bSortable": false },
		      null, null,null, null, null,
			  { "bSortable": false }
			] } );
			
			
			$('table th input:checkbox').on('click' , function(){
				var that = this;
				$(this).closest('table').find('tr > td:last-child input:checkbox')
				.each(function(){
					this.checked = that.checked;
					$(this).closest('tr').toggleClass('selected');
				});
			});
			
		
			$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();
				
				var off2 = $source.offset();
				var w2 = $source.width();
				
				if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
				return 'left';
			}
		})
    });
</script>
