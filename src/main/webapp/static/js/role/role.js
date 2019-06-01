//数据请求成功触发
function loadSuccess_on(result) {
    $.parser.parse($('.easyui-linkbutton').parent());//解析easyUI样式
    if(result){
        if (!result.success){
            $.messager.show({
                title: 'Error',
                msg: result.msg
            });
        }
    }
}

//formatter
function opt_formatter(value, row, index) {
    var str = '';
    /*str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:\'glyphicon-ok icon-green\'" onclick="authorization_on(\'{0}\');" >授权</a>', row.id);
    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';*/
    str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:\'glyphicon-pencil icon-blue\'" onclick="edit_on(\'{0}\');" >编辑</a>', row.id);
    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
    str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:\'glyphicon-trash icon-red\'" onclick="del_on(\'{0}\');" >删除</a>', row.id);
    return str;
}

//新增
function add_on() {
    var url = 'addPage';
    //如采用默认宽度和高度,参数设置为undefined
    var width = '420';
    var height = '220';
    $('#saveBtn').show();
    $.showOpenWindow($('#openWindow'), '新增页面', 'icon-add', url, width,height, true, false, false);
}

//编辑
function edit_on(pkid) {
    if (pkid) {
        //选中记录
        $('#grid').datagrid('getSelected', pkid);
        var url = 'editPage?id=' + pkid;
        //如采用默认宽度和高度,参数设置为undefined
        var width = '420';
        var height = '220';
        $('#saveBtn').show();
        $.showOpenWindow($('#openWindow'), '编辑页面', 'icon-edit', url, width,height, true, false, false);
    } else {
        $.messager.alert('提示', '编辑的记录为空或不存在！');
    }
}

//提交保存
function save_on() {
    var fm = $('#detailIframe')[0].contentWindow.$('#detailForm');
    fm.form('submit', {
        onSubmit : function() {
            progressLoad();
            var isValid = fm.form('validate');
            if (!isValid) {
                progressClose();
            }
            return isValid;
        },
        success : function(data) {
            progressClose();
            if (data=="success") {
                $.messager.show( {
                    title : '提示',
                    msg : "操作成功",
                    showType:'show'
                });
                $('#openWindow').dialog('close');
                $('#grid').datagrid('reload');
            } else {
                $.messager.show( {
                    title : '错误',
                    msg : "操作失败",
                    width:'300px',
                    height:'150px',
                    timeout:0,
                    showType:'show'
                });
            }
        }
    });
}

//删除
function del_on(pkid) {
    if (pkid) {
        $.messager.confirm('询问', '您是否要删除用户信息吗？', function(b) {
            if (b) {
                progressLoad();
                $.post('delete', {
                    id : pkid
                }, function(data) {
                    if (data=="success") {
                        $.messager.alert('提示', "删除成功", 'info');
                        $('#grid').datagrid('reload');
                    } else {
                        $.messager.alert('提示', "删除失败", 'info');
                    }
                    progressClose();
                }, 'text');
            }
        });
    } else {
        $.messager.alert('提示', '删除的记录为空或不存在！');
    }
}

//搜索折叠
function collapse_on() {
    var isCollapse = $('#searchPanel').panel('options').collapsed;
    if (isCollapse) {
        $('#collapseBtn').linkbutton({
            iconCls : 'glyphicon-upload icon-blue'
        });
        $('#searchPanel').panel('expand', true);
    } else {
        $('#collapseBtn').linkbutton({
            iconCls : 'glyphicon-download icon-blue'
        });
        $('#searchPanel').panel('collapse', true);
    }
}

//点击搜索
function search_on() {
    $('#grid').datagrid({
        queryParams : $.serializeObject($('#searchForm'))
    });
}

//清空
function clean_on() {
    $("#searchForm").form('clear');
    $('#grid').datagrid('reload', {});
}

//关闭窗口
function close_on() {
    $('#openWindow').dialog('close');
}