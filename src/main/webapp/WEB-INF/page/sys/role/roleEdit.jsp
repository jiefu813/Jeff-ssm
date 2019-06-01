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
        <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
            <form id="detailForm" name="detailForm" action="${path }/role/edit" method="post">
                <table id="roleEditGrid" class="grid">
                    <tr>
                        <td>
                            <label class="form_label">角色名称</label>
                        </td>
                        <td>
                            <input name="id" type="hidden" value="${role.id}">
                            <input name="name" class="easyui-textbox" data-options="required:true,width:170,height:28" value="${role.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="form_label">状态</label>
                        </td>
                        <td >
                            <select name="status" class="easyui-combobox" data-options="width:170,height:28,value :'${role.status}',editable:false,panelHeight:'auto'">
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
                            <input name="seq"  class="easyui-numberspinner" required="required" data-options="editable:true,min:0,width:170,height:28" value="${role.seq}">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>