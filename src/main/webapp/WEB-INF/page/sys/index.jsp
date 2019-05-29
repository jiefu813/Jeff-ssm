<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%--项目路径 --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理平台</title>
    <link rel="icon" type="image/x-icon" href="${path}/static/images/jie.png" />
    <link rel="stylesheet" type="text/css" href="${path}/static/css/index/main.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/css/index/style.css">
    <!--EasyUI-->
    <link rel="stylesheet" type="text/css" href="${path}/static/js/plugins/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/js/plugins/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/js/plugins/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/css/index/common.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/css/index/icon.css">
    <script type="text/javascript" src="${path}/static/js/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/js/plugins/easyui/jquery.easyui.min.js"></script>
    <%-- [扩展JS] --%>
    <script type="text/javascript" src="${path}/static/js/index/arrayToTree.js"></script>
    <script type="text/javascript" src="${path}/static/js/index/extJs.js"></script>
    <script type="text/javascript" src="${path}/static/js/index/main.js"></script>
</head>
<body>
    <div id="loading" class="loading">
        <img id="loadingImag" class="loadingImag"/>
    </div>
    <div id="mainLayout" class="easyui-layout" data-options="fit:true, border:false">
        <div data-options="region:'north',border:false, collapsedSize:0" style="height:50px;">
            <div class="head">
                <table>
                  <tr>
                    <td width="300px" align="left" style="font-size: 20px;">微信平台管理系统</td>
                    <td></td>
                    <td width="400px" align="right">
                        <table >
                            <tr>
                                <!-- 个人信息 -->
                                <td width="33%">
                                    <div class="myInfoDiv" data-options="border:false">
                                        <a id="myInfo" href="#" class="easyui-menubutton myInfo" data-options="menu:'#mm1'" onclick="showMenu();">
                                            <img align=absmiddle style="width: 18px;" alt="" src="${path}/static/images/jie.png">
                                            admin
                                        </a>
                                    </div>
                                    <div id="mm1" style="width: 100px;">
                                        <div data-options="iconCls:'glyphicon-pencil'"  onclick='editUserPwd()'>修改密码</div>
                                        <div class="menu-sep"></div>
                                        <div data-options="iconCls:'glyphicon-log-out'"	onclick="logout()">退出</div>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                  </tr>
                </table>
            </div>
        </div>
        <div id="west" class="scrollbar" data-options="region:'west',split:true, border:false, collapsedSize:0">
            <div class="west_menu">
                <div class="menu_head">&nbsp;&nbsp;菜单导航</div>
                <ul id="layout_west_tree" class="easyui-tree";></ul>
            </div>
        </div>
        <div data-options="region:'center', border:false">
            <div id="mainTabs" style="height:250px">
                <div title="首页" data-options="iconCls:'glyphicon-home',border:false">
                    <iframe src="" class="easyui-panel" data-options="fit:true,border:false" frameborder="0"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div id="tabsMenu">
        <div data-options="iconCls:'glyphicon-refresh'" type="refresh" style="font-size: 12px;">刷新</div>
        <div class="menu-sep"></div>
        <div data-options="iconCls:'glyphicon-remove'" type="close" style="font-size: 12px;">关闭</div>
        <div data-options="iconCls:''" type="closeOther">关闭其他</div>
        <div data-options="iconCls:''" type="closeAll">关闭所有</div>
    </div>
    <div id="tabTools" class="tabTools">
        <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-home"    onclick="toHome()"></a>
        <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-refresh" onclick="refreshTab()"></a>
        <a href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-remove"  onclick="closeTab()"></a>
        <a id="fullScreen" href="###" class="easyui-linkbutton" plain="true" iconCls="glyphicon-fullscreen" onclick="fullScreen()"></a>
    </div>
    <!--[if lte IE 7]>
    <div id="ie6-warning"><p>您正在使用 低版本浏览器，在本页面可能会导致部分功能无法使用。建议您升级到 <a href="http://www.microsoft.com/china/windows/internet-explorer/" target="_blank">Internet Explorer 8</a> 或以下浏览器：
    <a href="http://www.mozillaonline.com/" target="_blank">Firefox</a> / <a href="http://www.google.com/chrome/?hl=zh-CN" target="_blank">Chrome</a> / <a href="http://www.apple.com.cn/safari/" target="_blank">Safari</a> / <a href="http://www.operachina.com/" target="_blank">Opera</a></p></div>
    <![endif]-->
    <style>
    /*ie6提示*/
    #ie6-warning{width:100%;position:absolute;top:0;left:0;background:#fae692;padding:5px 0;font-size:12px}
    #ie6-warning p{width:960px;margin:0 auto;}
    </style>
</body>
</html>