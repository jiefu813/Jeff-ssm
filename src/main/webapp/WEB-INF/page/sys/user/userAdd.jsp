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
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <form id="detailForm" name="detailForm" action="${path }/user/add" method="post">
            <table id="userAddGrid" class="grid">
                <tr>
                    <td>
                    	<label class="form_label">登录名</label>
                    </td>
                    <td>
                        <input name="loginName"  class="easyui-textbox" data-options="required:true,width:170,height:28">
                    </td>
                    <td>
                        <label class="form_label">性别</label>
                    </td>
                    <td>
                        <select name="sex" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                            <option value="SECRECY">保密</option>
                            <option value="MAN">男</option>
                            <option value="WOMAN">女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                    	<label class="form_label">密码</label>
                    </td>
                    <td>
                        <input id="password" name="password" prompt="" data-options="width:170,height:28" class="easyui-passwordbox" validType="same['#password1']"/>
                    </td>
                    <td>
                    	<label class="form_label">确认密码</label>
                    </td>
                    <td>
                        <input id="password1" name="password1" prompt="" data-options="width:170,height:28" class="easyui-passwordbox" validType="same['#password']"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">用户状态</label>
                    </td>
                    <td>
                        <select name="status" class="easyui-combobox" data-options="width:170,height:28,editable:false,panelHeight:'auto'">
                            <option value="ENABLE">正常</option>
                            <option value="DISABLE">停用</option>
                        </select>
                    </td>
                    <td>
                        <label class="form_label">昵称</label>
                    </td>
                    <td>
                        <input name="nickName"  class="easyui-textbox" data-options="width:170,height:28">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form_label">真实姓名</label>
                    </td>
                    <td>
                        <input name="name"  class="easyui-textbox" data-options="width:170,height:28">
                    </td>
                    <td>
                        <label class="form_label">生日</label>
                    </td>
                    <td>
                        <input name="birthday" class="easyui-datebox" data-options="width:170,height:28"/>
                    </td>
                </tr>
                <tr>
                    <td><label class="form_label">手机号</label></td>
                    <td>
                        <input name="phone" class="easyui-numberbox" data-options="width:170,height:28"/>
                    </td>
                    <td>
                        <label class="form_label">邮箱</label>
                    </td>
                    <td>
                        <input name="email"  class="easyui-textbox" data-options="width:170,height:28">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>