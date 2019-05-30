<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${path}/static/css/index/main.css">
    <!--EasyUI-->
    <link rel="stylesheet" type="text/css" href="${path}/static/js/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/js/plugins/easyui/themes/icon.css">
    <script type="text/javascript" src="${path}/static/js/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/plugins/easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${path}/static/js/common/jquery.easyui.extend.validatebox.js"></script>

</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;">
            <form id="detailForm" name="detailForm"  action="${path}/user/editPwd" method="post">
                <table class="grid">
                    <tr>
                        <th><label class="form_label">登录名：</label></th>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <th><label class="form_label">原密码：</label></th>
                        <td><input name="oldPwd" type="password" class="easyui-validatebox" data-options="required:true,width:170,height:28"></td>
                    </tr>
                    <tr>
                        <th><label class="form_label">新密码：</label></th>
                        <td><input name="pwd" type="password"    class="easyui-validatebox" data-options="required:true"></td>
                    </tr>
                    <tr>
                        <th><label class="form_label">重复密码：</label></th>
                        <td><input name="rePwd" type="password"  class="easyui-validatebox" data-options="required:true,validType:'eqPwd[\'#detailForm input[name=pwd]\']'"></td>
                    </tr>
                </table>
            </form>
    </div>
</div>
</body>
</html>