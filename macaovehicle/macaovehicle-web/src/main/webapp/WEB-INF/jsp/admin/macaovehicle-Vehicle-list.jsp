<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../taglib.inc.jsp" %>

<title>管理员管理</title>

<!-- ajax layout which only needs content area -->
<div class="page-header">
    <h1>
        管理员管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            列表
        </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">
    <div class="col-xs-12">

        <div class="table-header">
            管理员列表
        </div>

        <!-- <div class="table-responsive"> -->

        <!-- <div class="dataTables_borderWrap"> -->
        <div>
            <div class="dataTables_wrapper form-inline no-footer">
                <div class="row">
                    <div class="col-xs-6">
                        <div class="dataTables_length">
                            <a title="新增" class="btn btn-sm btn-info"
                               href="#admin/vehicle/toAdd">
                                <i class="ace-icon fa fa-plus align-bottom bigger-125"></i>
                                新&nbsp;增
                            </a>                           
                        </div>
                    </div>                    
                </div>
                <table class="table table-striped table-bordered table-hover dataTable no-footer">
                    <thead>
                    <tr role="row">     
                                                <th>ID</th>           
                                                <th></th>           
                                                <th>车牌号</th>           
                                                <th>行驶证号码</th>           
                                                <th>行驶证拍照</th>           
                                                <th>车品牌</th>           
                                                <th>车辆规格型号</th>           
                                                <th>车型 1小车2货车</th>           
                                                <th>发证机关</th>           
                                                <th>购置时间</th>           
                                                <th>车主姓名</th>           
                                                <th>车主电话</th>           
                                                <th>车主地址</th>           
                                                <th>发动机号</th>           
                                                <th>车架号</th>           
                                                <th>方向盘 1左2右</th>           
                                                <th>启用年份</th>           
                                                <th>自重 KG</th>           
                                                <th>车身长 m</th>           
                                                <th>车高 m</th>           
                                                <th>车宽 m</th>           
                                                <th>颜色</th>           
                                                <th>燃料种类 1汽油2柴油</th>           
                                                <th>容量</th>           
                                                <th>吨位/座</th>           
                                                <th>备用轮胎个数</th>           
                                                <th>前轮胎个数</th>           
                                                <th>后轮胎个数</th>           
                                                <th>注册时间</th>           
                                                <th>车辆正面</th>           
                                                <th>车辆左侧45度（前）</th>           
                                                <th>车辆右侧45度（前）：</th>           
                                                <th>车辆左侧45度（后）：</th>           
                                                <th>车辆右侧45度（后）：</th>           
                                                <th class="sorting_disabled">操作</th>
                    </tr>
                    </thead>

                    <tbody>
                           <c:forEach items="${result}" var="item" varStatus="current"> 
                            <tr>            
                                                        <td>${id}</td>                         
                                                        <td>${carOwnerId}</td>                         
                                                        <td>${plateNumber}</td>                         
                                                        <td>${licenseNumber}</td>                         
                                                        <td>${licenseImage}</td>                         
                                                        <td>${brand}</td>                         
                                                        <td>${specification}</td>                         
                                                        <td>${models}</td>                         
                                                        <td>${authority}</td>                         
                                                        <td>${buyTime}</td>                         
                                                        <td>${ownerName}</td>                         
                                                        <td>${ownerPhone}</td>                         
                                                        <td>${ownerAddress}</td>                         
                                                        <td>${engineNumber}</td>                         
                                                        <td>${frameNumber}</td>                         
                                                        <td>${steeringWheel}</td>                         
                                                        <td>${startTime}</td>                         
                                                        <td>${weight}</td>                         
                                                        <td>${length}</td>                         
                                                        <td>${height}</td>                         
                                                        <td>${width}</td>                         
                                                        <td>${color}</td>                         
                                                        <td>${type}</td>                         
                                                        <td>${capacity}</td>                         
                                                        <td>${seat}</td>                         
                                                        <td>${backupWheel}</td>                         
                                                        <td>${faceWheel}</td>                         
                                                        <td>${backWheel}</td>                         
                                                        <td>${registTime}</td>                         
                                                        <td>${faceImage}</td>                         
                                                        <td>${leftfaceImage}</td>                         
                                                        <td>${rightfaceImage}</td>                         
                                                        <td>${leftbackImage}</td>                         
                                                        <td>${rightbackImage}</td>                         
                                                        <td>
                                <div class="hidden-sm hidden-xs action-buttons">
                                    <a title="修改基本信息" class="green" 
                                       href="#admin/vehicle/toEdit?id=${item.id}">
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
