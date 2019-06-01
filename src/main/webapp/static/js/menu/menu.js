//数据请求成功触发
function loadSuccess_on(result) {
    $.parser.parse($('.easyui-linkbutton').parent());//解析easyUI样式
    if(result){
        if (!result.rows){
            $.messager.show({
                title: 'Error',
                msg: "获取数据失败"
            });
        }else{
            $.each(result, function (i, val) {
                if(i=='rows'){
                    var data=result[i];
                    for (var j=0;j<data.length;j++){
                        if(data[j].opened=='折叠'){
                            $('#grid').treegrid('collapse', data[j].id);
                        }
                    }
                }
            })
        }
    }
}

//formatter
function opt_formatter(value, row, index) {
    var str = '';
    str += '&nbsp;&nbsp;';
    /*str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:\'glyphicon-zoom-in icon-blue\',plain:true" onclick="view_on(\'{0}\')">查看</a>', row.id);*/
    str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:\'glyphicon-pencil icon-blue\'" onclick="edit_on(\'{0}\');" >编辑</a>', row.id);
    str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
    str += $.formatString('<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:\'glyphicon-trash icon-red\'" onclick="del_on(\'{0}\');" >删除</a>', row.id);
    return str;
}

//新增
function add_on() {
    var url = 'addPage';
    //如采用默认宽度和高度,参数设置为undefined
    var width=undefined;
    var height =undefined;
    $.showOpenWindow($('#openWindow'),'新增页面', 'icon-add', url, width, height, true,false, false);
}
//关闭窗口
function closeWindowView_on() {
    $('#openWindowView').dialog('close');
    search_on();
}

function view_on(pkid) {
    if (pkid) {
        //选中记录
        $('#grid').datagrid('getSelected', pkid);
        var url = '${path }/resource/viewPage?id=' + pkid;
        //如采用默认宽度和高度,参数设置为undefined
        var width = "700";
        var height = "520";
        $('#saveBtn').show();
        $.showOpenWindow($('#openWindowView'),'查看页面', 'glyphicon-zoom-in icon-blue', url, width, height, true, false, false);
    } else {
        $.messager.alert('提示', '查看的记录为空或不存在！');
    }
}

//编辑
function edit_on(pkid) {
    if (pkid) {
        //选中记录
        $('#grid').treegrid('select', pkid);
        var url = 'editPage?id=' + pkid;
        //如采用默认宽度和高度,参数设置为undefined
        var width=undefined;
        var height =undefined;
        $.showOpenWindow($('#openWindow'),'编辑页面', 'icon-edit', url, width, height, true,false, false);
    } else {
        $.messager.alert('提示', '编辑的记录为空或不存在！');
    }
}

//删除
function del_on(pkid) {
    if (pkid) {
        $.messager.confirm('询问', '您是否要删除该数据记录吗？', function(b) {
            if (b) {
                progressLoad();
                $.post('delete', {
                    id : pkid
                }, function(data) {
                    if (data=="success") {
                        $.messager.alert('提示', "删除成功", 'info');
                        $('#grid').treegrid('reload');    // reload the user data
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

function opt_formatter_time(value, row, index) {
    var str="";
    if(value){
        var date=new Date(value);
        var year = date.getFullYear();
        var month = (date.getMonth() + 1)< 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var d = date.getDate()< 10 ? "0" + date.getDate() : date.getDate();
        var hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
        var minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
        var second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
        str=year + "年" + month + "月" + d + "日 " + hour + ":" + minute + ":" + second;
    }
    return str;
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
                $('#grid').treegrid('reload');
                $('#openWindow').dialog('close');

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

//关闭窗口
function close_on() {
    $('#openWindow').dialog('close');
}