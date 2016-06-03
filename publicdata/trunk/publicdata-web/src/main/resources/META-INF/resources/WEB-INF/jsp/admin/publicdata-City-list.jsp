<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>地级市管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
       地级市管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            地级市列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-4">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/city/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>    
                    <div class="col-xs-8">
                        <div class="text-right">
                            <label>
                                <form id="query-form" action="#admin/city/list" onsubmit="listFormSearch(this); return false">
                                    <div class="dataTables_length">            	                                      		                              
	                                   	<span class="input-group-btn">
	                                   	  	<select class="form-control" id="provinceId" name="provinceId">
										 		  <option value="-1" selected>请选择一个省份</option>
						                          <c:forEach items="${provinceList}" var="item" varStatus="current"> 
								                  	 <option value="${item.key}" ${item.message}>${item.value}</option>
								                  </c:forEach> 
								            </select> 
                                       		<input type="search" maxlength="6" class="form-control search-query" placeholder="名称" name="name" value="${query.name}">
	                                      	<button type="submit" class="btn btn-purple btn-sm">
                                                <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                               	 查询
                                            </button>
                                        </span>
                                     </div>
                                </form>
                            </label>
                        </div>
                    </div>                                             
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">                                                         
                                                <th>省</th>           
                                                <th>市</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>                                 
                                                        <td>${item.province}</td>                         
                                                        <td>${item.name}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/city/toEdit?id=${item.id}">
                                        <i class="ace-icon fa fa-pencil bigger-130"></i>
                                    </a>							                                 
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
         
    });
</script>
