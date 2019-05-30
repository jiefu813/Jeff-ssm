<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<%@ include file="../common/base.jsp" %>
	<script src="${path}/static/js/menu/menu.js"></script>
</head>
<body>
<!-- 页面表格布局 -->
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false"  style="overflow: hidden;">
        <table id="grid" class="easyui-treegrid" 
        	data-options="
	        	url : '${path }/menu/treeGrid',
	            idField : 'id',
	            treeField : 'name',
	            rownumbers : true,
	            lines: true,
	            remoteSort: false,
	            fit : true,
	            fitColumns : true,
	            nowrap: true,
	            toolbar: '#tb',
	            onLoadSuccess:function(row, data){loadSuccess_on(data)},
	            border : false
        	">
        	<thead>
				<tr>
				    <th data-options="field:'name'" width="15%"  >菜单名称</th>
				    <th data-options="field:'type'" width="6%"  >菜单类型</th>
				    <th data-options="field:'url'"  width="18%"  >菜单路径</th>
				    <th data-options="field:'iconCls'" width="12%"  >菜单图标</th>
				    <th data-options="field:'seq'"     width="4%"  >排序</th>
	                <th data-options="field:'status'"  width="6%"  >菜单状态</th>
				    <th data-options="field:'opened'" width="6%"  >展开状态</th>
				    <th data-options="field:'createTime'" formatter="opt_formatter_time" width="12%">创建时间</th>
				    <th data-options="field:'createName'" width="6%" >创建人</th>
					<th data-options="field:'action'"  formatter="opt_formatter"  width="15%">操作</th>
				</tr>
		   </thead>
        </table>
    </div>
</div>
    <!-- 页面表格操作菜单布局 -->  
	<div id="tb" style="height:auto">
		<!-- 页面搜索布局 -->
		<div id="searchPanel" class="easyui-panel" title="${PageName}" style="width:100%;padding:0px;"  data-options="border:false,iconCls:'${PageIcon}'">    
	    </div>
	     <!-- 页面工具栏操作按钮布局 -->
	     <div id="toolbar" class="list_toolbar">
	        	<a onclick="add_on();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">新增</a>
		</div>
	</div>
	<!-- 弹出框布局 --> 
	<div id="openWindow" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#footBar'"></div>
	<div id="footBar" style="height:auto">
		<a href="javascript:void(0)" id="sbtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:false" onclick="save_on()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="close_on()">关闭</a>
	</div>
	<div id="openWindowView" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#footBarView'"></div>
	<div id="footBarView" style="height:auto">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="closeWindowView_on()">关闭</a>
	</div>
</body>
</html>