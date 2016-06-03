<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>


<div class="row">
    <div class="col-xs-12">

        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">
                        <th>快递名称</th>
                        <th>首重重量</th>
                        <th>首重费用</th>
                        <th>续重重量</th>
                        <th>续重费用</th>
                        <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                    	<c:forEach items="${result}" var="item" varStatus="current">
                         <tr>
                            <td>${item.name}</td>
                            <td>${item.firstWeight}</td>
                            <td>${item.firstPrice}</td>
                            <td>${item.continuedWeight}</td>
                            <td>${item.continuedPrice}</td>
                           	<td>
	                        	<div class="hidden-sm hidden-xs action-buttons">
	                                <a title="选择" class="green add-btn"  href=""
	                                data-id="${item.id}" data-name="${item.name}" 
	                                data-firstWeight="${item.firstWeight}" data-firstPrice="${item.firstPrice}"
	                                data-continuedWeight="${item.continuedWeight}" data-continuedPrice="${item.continuedPrice}"
	                                data-code="${item.code}" data-desc="${item.desc}"
	                                data-logo="${item.logo}" data-logoUid="${item.logoUid}"  >
	                                    <i class="ace-icon glyphicon glyphicon-ok bigger-130"></i>
	                                </a>
	                            </div>
                        	</td>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="dataTables_paginate paging_simple_numbers">
                            <div class="dataTables_paginate paging_simple_numbers"><ul class="pagination">     <li class="paginate_button disabled"><a href="javascript:;">共2条</a></li></ul></div>                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
        $(".ajax_switch").on('change',function(){
            var el = $(this);
            var data = {
                id:el.attr('data-id'),
                value:el[0].checked?'on':'off'
            };
            $.ajax({
                url:'/admin/express/list.do',
                type:'POST',
                data:data,
                dataType: 'json',
                cache: false,
                async: false,
                error: function(){
                    BootstrapDialog.alert({
                        title: '错误',
                        message:'网络错误，请稍后再尝试！',
                        type: BootstrapDialog.TYPE_DANGER,
                        callback: function(){setTimeout(function(){el[0].checked = !el[0].checked;},500)}
                    });
                },
                success:function(rd){
                    if(rd['status'] == 0){
                        BootstrapDialog.alert({
                            title: '错误',
                            message:'请稍后再尝试！',
                            type: BootstrapDialog.TYPE_DANGER,
                            callback: function(){setTimeout(function(){el[0].checked = !el[0].checked;},500)}
                        });
                    }
                }
            })
        })
    });
</script></div>

<!-- page specific plugin scripts -->
<script type="text/javascript">
    var scripts = [null, null];
    ace.load_ajax_scripts(scripts, function () {
        //inline scripts related to this page
         
    });
</script>
