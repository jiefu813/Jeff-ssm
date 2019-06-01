<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <%@ include file="../../common/base.jsp" %>
    <script src="${path}/static/js/role/role.js"></script>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true,border:false">
        <!-- 页面表格布局 -->
        <div data-options="region:'center',fit:true,border:false">
            <table id="grid"  class="easyui-datagrid"
                data-options="
                    url : '${path }/role/dataGrid',
                    fit:true,
                    striped : true,
                    rownumbers : true,
                    pagination : true,
                    singleSelect : true,
                    checkOnSelect: false,
                    idField : 'id',
                    pageSize : 10,
                    pageList : [ 10, 20, 50, 100],
                    toolbar: '#tb',
                    queryParams:$.serializeObject($('#searchForm')),
                    onLoadSuccess:function(row, data){loadSuccess_on(data)}, //数据加载成功触发,无数据也返回
                    method: 'post',
                    border:false">
                    <thead>
                        <tr>
                            <th data-options="field:'id',hidden:'true'" width="10%" >ID</th>
                            <th data-options="field:'name'" sortable="true" width="20%">角色名称</th>
                            <th data-options="field:'status',formatter:function(value,row,index){if(value=='ENABLE'){return '正常';}else{return '停用';}}" width="10%">状态</th>
                            <th data-options="field:'seq'" width="5%">排序</th>
                            <th data-options="field:'createTime'" formatter="opt_formatter_time" width="12%">创建时间</th>
                            <th data-options="field:'createName'" width="6%">创建人</th>
                            <th data-options="field:'action'"  formatter="opt_formatter"  width="10%">操作</th>
                        </tr>
                    </thead>
            </table>
        </div>
    </div>
	<!-- 页面表格操作菜单布局 -->  
	<div id="tb" style="height:auto">
		<!-- 页面搜索布局 -->
		<div id="searchPanel" class="easyui-panel" title="${PageName}" style="width:100%;padding:5px;"  data-options="border:false,collapsible:true,collapsed:false,iconCls:'${PageIcon}'">
		        <form id="searchForm" method="post" action="dataload">
					<div id="searchDiv" class="list_searchDiv">
						角色名称： <input class="easyui-textbox" style="width:100px;"  id="id" name="name">&nbsp;&nbsp;&nbsp;
						<a href="javascript:void(0)" class="easyui-linkbutton"   iconCls="glyphicon-search " id="dataQuery"  onclick="search_on()">搜索</a>
						<a href="javascript:void(0);" class="easyui-linkbutton"  iconCls="icon-clear"  id="clearQuery" onclick="clean_on();">重置</a>
					</div>
				</form>
	     </div>
      	 <!-- 页面工具栏操作按钮布局 -->
	     <div id="toolbar" class="list_toolbar">
	        	<a id="collapseBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'glyphicon-upload icon-blue',plain:true" onclick="collapse_on()">查询</a>
			<shiro:hasPermission name="/role/add">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add_on()">新增</a>
			</shiro:hasPermission>
		</div>
	</div>
    <!-- 弹出框布局 --> 
	<div id="openWindow" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#footBar'"></div>
	<div id="footBar" style="height:auto">
		<shiroExt:hasAnyPermissions name="/role/add,/role/edit">
			<a href="javascript:void(0)" id="sbtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:false" onclick="save_on()">保存</a>
		</shiroExt:hasAnyPermissions>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="close_on()">关闭</a>
	</div>
	<!-- 授权页面弹出框布局 --> 
	<div id="openGrantWindow" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#grantFootBar'"></div>
	<div id="grantFootBar" style="height:auto">
		<shiroExt:hasAnyPermissions name="/role/add,/role/edit">
			<a href="javascript:void(0)" id="sbtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:false" onclick="saveAuthorization_on()">保存</a>
		</shiroExt:hasAnyPermissions>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="close_onGrant()">关闭</a>
	</div>
</body>
</html>