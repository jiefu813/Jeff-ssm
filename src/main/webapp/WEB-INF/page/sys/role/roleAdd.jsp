<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <%@ include file="../../common/base.jsp" %>
    <script src="${path}/static/js/sys/role.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false" >
    <div data-options="region:'center',border:false" style="overflow: hidden;padding: 3px;" >
        <form id="detailForm" name="detailForm" action="${path }/role/add" method="post">
            <table id="roleAddGrid" class="grid">
                <tr>
                    <td>
                		<label class="form_label">角色名称</label>
                    </td>
                    <td>
                        <input name="name" class="easyui-textbox" data-options="required:true,width:170,height:28">
                    </td>
                </tr>
                <tr>
                    <td>
                		<label class="form_label">状态</label>
                    </td>
                    <td >
                        <select name="status" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                            <option value="ENABLE">正常</option>
                            <option value="DISABLE">停用</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">排序</label>
                    </td>
                    <td>
                        <input name="seq" value="0" class="easyui-numberspinner" data-options="required:true,editable:true,min:0,width:170,height:28">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>