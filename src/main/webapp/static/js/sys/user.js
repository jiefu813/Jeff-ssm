//数据请求成功触发
function loadSuccess_on(result) {
    $.parser.parse($('.easyui-linkbutton').parent());//解析easyUI样式
    if(result){
        if (!result.success){
            $.messager.show({    // show error message
                title: 'Error',
                msg: result.msg
            });
        }
    }
}

//新增
function add_on() {
    var url = 'addPage';
    //如采用默认宽度和高度,参数设置为undefined
    var width=undefined;
    var height =undefined;
    $('#saveBtn').show();
    $.showOpenWindow($('#openWindow'),'新增页面', 'icon-add', url, width, height, true,false, false);
}

//编辑
function edit_on(pkid) {
    if (pkid) {
        //选中记录
        $('#grid').datagrid('getSelected', pkid);
        var url = 'editPage?id=' + pkid;
        //如采用默认宽度和高度,参数设置为undefined
        var width=undefined;
        var height =undefined;
        $('#saveBtn').show();
        $.showOpenWindow($('#openWindow'),'编辑页面', 'icon-edit', url, width, height, true,false, false);
    } else {
        $.messager.alert('提示', '编辑的记录为空或不存在！');
    }
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
                    }else{
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
                $('#grid').datagrid('reload');
                $('#openWindow').dialog('close');

            }else if(data=="alreadyExists"){
                $.messager.show( {
                    title : '错误',
                    msg : "此登录名已存在",
                    width:'300px',
                    height:'150px',
                    timeout:0,
                    showType:'show'
                });
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

//搜索折叠
function collapse_on(){
    var isCollapse=$('#searchPanel').panel('options').collapsed;
    if(isCollapse){
        $('#collapseBtn').linkbutton({
            iconCls: 'glyphicon-upload icon-blue'
        });
        $('#searchPanel').panel('expand',true);
    }else{
        $('#collapseBtn').linkbutton({
            iconCls: 'glyphicon-download icon-blue'
        });
        $('#searchPanel').panel('collapse',true);
    }
}

//点击搜索
function search_on() {
    $('#grid').datagrid( {
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