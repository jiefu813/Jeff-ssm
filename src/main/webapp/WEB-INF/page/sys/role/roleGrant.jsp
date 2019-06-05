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
<div id="roleGrantLayout" class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'west'" title="系统菜单" style="width: 350px; padding: 1px;">
        <div class="well well-small">
            <form id="detailForm" name="detailForm" action="${path }/role/grant" method="post">
                <input name="id" type="hidden"  value="${id}" readonly="readonly">
                <ul id="menuTree" class="easyui-tree"
                data-options="url:'${path }/menu/allTree?id=${id}',
		                parentField:'pid',
		                checkbox:true,
		                cascadeCheck:true,
		                onClick:function(node) {}
		                ">
		         </ul>
                <input id="resourceIds" name="resourceIds" type="hidden" />
            </form>
        </div>
    </div>
    <div data-options="region:'center'" title="" style="overflow: hidden; padding: 10px;">
        <div>
            <button class="btn btn-success" onclick="checkAll_on();">全选</button>
            <br /> <br />
            <button class="btn btn-warning" onclick="checkInverse_on();">反选</button>
            <br /> <br />
            <button class="btn btn-inverse" onclick="uncheckAll_on();">取消</button>
        </div>
    </div>
</div>
</body>
</html>