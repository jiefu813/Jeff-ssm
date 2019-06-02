<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <%@ include file="../../common/base.jsp" %>
    <script src="${path}/static/js/sys/user.js"></script>
</head>
<body>
    <div class="easyui-layout" data-options="fit:true,border:false">
        <!-- 页面表格布局 -->
        <div data-options="region:'center',border:true" >
            <table id="grid" class="easyui-datagrid"
                data-options="
                    url : '${path}/user/dataGrid',
                    fit : true,
                    striped : true,
                    rownumbers : true,
                    pagination : true,
                    singleSelect : true, //设置为true时，只能单选，否则可多选
                    checkOnSelect: false, //设置为true时，点击行选中复选框
                    idField : 'id',
                    sortName : 'createTime',
                    sortOrder : 'asc',
                    pageSize : 10,
                    pageList : [ 10, 20, 50, 100 ],
                    toolbar: '#tb',
                    queryParams:$.serializeObject($('#searchForm')),
                    onLoadSuccess:function(row, data){loadSuccess_on(data)}, //数据加载成功触发,无数据也返回
                    method: 'post',
                    border:false
                    ">
                <thead>
                    <tr>
                        <th data-options="field:'loginName'" width="8%">登录名</th>
                        <th data-options="field:'sex',formatter:function(value,row,index){if(value=='MAN'){return '男';}else if(value=='WOMAN'){return '女';}else{return '保密';}}" width="5%">性别</th>
                        <th data-options="field:'status',formatter:function(value,row,index){if(value=='ENABLE'){return '正常';}else{return '停用';}}" width="5%">状态</th>
                        <th data-options="field:'name'" width="8%">真实姓名</th>
                        <th data-options="field:'nickName'" width="10%">昵称</th>
                        <th data-options="field:'phone'" width="10%">手机号</th>
                        <th data-options="field:'email'" width="10%">邮箱</th>
                        <th data-options="field:'birthday'" width="10%">生日</th>
                        <th data-options="field:'createTime'" formatter="opt_formatter_time" width="12%">创建时间</th>
                        <th data-options="field:'createName'" width="6%">创建人</th>
                        <th data-options="field:'action'" width="10%" formatter="opt_formatter">操作</th>
                    </tr>
                </thead>
            </table>
        </div>
        <!-- 页面表格操作菜单布局 -->
        <div id="tb" style="height:auto">
            <!-- 页面搜索布局 -->
            <div id="searchPanel" class="easyui-panel" title="${PageName}" style="width:100%;padding:5px;"  data-options="border:false,collapsible:true,collapsed:false,iconCls:'${PageIcon}'">
                    <form id="searchForm" method="post" action="dataload">
                        <div id="searchDiv" class="list_searchDiv">
                            登陆姓名：<input class="easyui-textbox" style="width:100px;" name="loginName">&nbsp;&nbsp;&nbsp;
                            创建时间：<input class="Wdate" style="height: 21px;width: 120px" name="createdateStart" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />&nbsp;至&nbsp;
                                   <input class="Wdate" style="height: 21px;width: 120px" name="createdateEnd" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                                   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="glyphicon-search" id="dataQuery"  onclick="search_on()">搜索</a>
                                   <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-clear" id="clearQuery" onclick="clean_on();">重置</a>
                        </div>
                    </form>
             </div>
             <!-- 页面工具栏操作按钮布局 -->
             <div id="toolbar" class="list_toolbar">
                <a id="collapseBtn" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'glyphicon-upload icon-blue',plain:true" onclick="collapse_on()">查询</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="add_on()">新增</a>
            </div>
        </div>

        <!-- 弹出框布局 -->
        <div id="openWindow" class="easyui-dialog" closed="true"  data-options="iconCls:'icon-save',modal:true,buttons:'#footBar'"></div>
        <div id="footBar" style="height:auto">
            <a href="javascript:void(0)" id="sbtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:false" onclick="save_on()">保存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:false"  onclick="close_on()">关闭</a>
        </div>
    </div>
</body>
</html>