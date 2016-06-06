<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>

<div class="page-header">
    <h1>
        配送管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            配送列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info" 
                            href="#admin/express/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>
                         <!--   <button title="批量删除" class="btn btn-sm btn-info" id="mult-del" api-path="">
                                <i class="ace-icon fa fa-trash-o align-bottom bigger-125"></i>
                                删&nbsp;除
                            </button> -->
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">
                        <!--<th class="center sorting_disabled">
                            <label class="position-relative">
                                <input id="select-all" type="checkbox" class="ace">
                                <span class="lbl"></span>
                            </label>
                        </th> -->
                        <th>配送方式</th>
                        <th>排序</th>
                        <th>是否启用</th>
                        <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                    	<c:forEach items="${result}" var="item" varStatus="current">
                         <tr>
                           <!--   <td class="center">
                              <label class="position-relative">
                                    <input type="checkbox" name="ids[]" value="2" class="ace select-item">
                                    <span class="lbl"></span>
                                </label>
                            </td> -->
                            <td>${item.name}</td>
                            <td>${item.sort}</td>
                            <td>
                            <!--	<c:if test="${item.enable==1}">
                            		<input value="1" type="checkbox" data-id="2" class="ace ace-switch ace-switch-5 ajax_switch" checked="checked">
                            	</c:if>
                            	<c:if test="${item.enable!=1}">
                            	 	<input value="0" type="checkbox" data-id="2" class="ace ace-switch ace-switch-5 ajax_switch" >
                            	</c:if>  -->
                            	<c:if test="${item.enable==1}">是</c:if>
                            	<c:if test="${item.enable!=1}">否</c:if>
                                <span class="lbl middle"></span>
                            </td>
                            <td>
                                <div class="hidden-sm hidden-xs action-buttons">

                                    <a title="修改" class="green" href="#admin/express/toEdit?id=${item.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>
                                  <!--  <a title="删除" class="red del-item" href="javascript:;" api-path="/admin/express/delete.do?id=${item.id}">
                                        <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                    </a>  -->
                                </div>

                                <div class="hidden-md hidden-lg">
                                    <div class="inline position-relative">
                                        <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                        </button>
                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                            <li>
                                                <a href="#Express/edit/id/2" class="tooltip-success" data-rel="tooltip" title="" data-original-title="Edit">
                                                <span class="green">
                                                <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                </span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:;" class="tooltip-error  del-item" data-rel="tooltip" title="" data-original-title="Delete" api-path="#Express/del/id/2">
                                                <span class="red">
                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                </span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </td>
                        </tr>
                       </c:forEach>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-xs-12">
                    <%@include file="../page.inc.jsp" %>
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
