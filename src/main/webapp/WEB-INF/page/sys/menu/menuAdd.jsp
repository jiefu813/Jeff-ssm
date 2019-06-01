<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <%@ include file="../../common/base.jsp" %>
    <script src="${path}/static/js/menu/menu.js"></script>
</head>
<body>
    <div style="padding: 3px;">
        <form id="detailForm" name="detailForm" action="${path}/menu/add" method="post">
            <table id="resourceAddGrid" class="grid">
                <tr>
                    <td>
                        <label class="form_label">菜单名称</label>
                    </td>
                    <td>
                        <input name="name"  class="easyui-textbox" data-options="required:true,width:170,height:28" >
                    </td>
                    <td>
                        <label class="form_label">菜单类型</label>
                    </td>
                    <td>
                        <select name="type" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                            <option value="MENU">菜单</option>
                            <option value="BUTTON">按钮</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">菜单状态</label>
                    </td>
                    <td>
                        <select name="status" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                        <option value="ENABLE">正常</option>
                        <option value="DISABLE">停用</option>
                        </select>
                    </td>
                    <td>
                        <label class="form_label">父菜单</label>
                    </td>
                    <td >
                        <select id="pid" name="parentId" class="easyui-combotree"
                        data-options="url:'${path }/menu/tree',
                        parentField:'pid',
                        width:170,height:28,
                        lines: true,
                        panelHeight:'300',
                        icons:[{iconCls:'icon-clear',handler:function(){$('#pid').combotree('clear');}}]">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">展开状态</label>
                    </td>
                    <td>
                        <select name="opened" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                        <option value="UNFOLD">展开</option>
                        <option value="FOLD">折叠</option>
                        </select>
                    </td>
                    <td>
                        <label class="form_label">排序</label>
                    </td>
                    <td>
                        <input name="seq" value="0"  class="easyui-numberspinner" data-options="required:true,width:170,height:28,editable:true,min:0">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">菜单图标</label>
                    </td>
                    <td >
                        <input id="icon" name="icon"  class="easyui-textbox" data-options="width:170,height:28,icons:[{iconCls:'icon-more',handler:function(e) {top.window.openIconDialog($(e.data.target));}}] "/>
                    </td>
                    <td>
                        <label class="form_label">菜单路径</label>
                    </td>
                    <td>
                        <input name="url" class="easyui-textbox" data-options="width:170,height:28" >
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>