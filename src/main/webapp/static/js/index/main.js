/**
 *
 * @requires jQuery
 *
 * 当页面加载完毕关闭加载进度
 * **/
$(window).load(function(){
    $("#loading").fadeOut();
});

var mainTabs;
var indexTabsMenu;
var layoutWestTree;
$(function() {
    $('#mainLayout').layout({fit : true});
    mainTabs = $('#mainTabs').tabs({
        fit : true,
        border : false,
        tools : "#tabTools",
        onContextMenu : function(e, title) {
            e.preventDefault();
            indexTabsMenu.menu('show', {
                left : e.pageX,
                top : e.pageY
            }).data('tabTitle', title);
        }
    });
    // 选项卡菜单
    indexTabsMenu = $('#tabsMenu').menu({
        onClick : function(item) {
            var curTabTitle = $(this).data('tabTitle');
            var type = $(item.target).attr('type');
            if (type === 'refresh') {
                refreshTab();
                return;
            }
            if (type === 'close') {
                var t = mainTabs.tabs('getTab', curTabTitle);
                if (t.panel('options').closable) {
                    mainTabs.tabs('close', curTabTitle);
                }
                return;
            }
            var allTabs = mainTabs.tabs('tabs');
            var closeTabsTitle = [];
            $.each(allTabs, function() {
                var opt = $(this).panel('options');
                if (opt.closable && opt.title != curTabTitle
                    && type === 'closeOther') {
                    closeTabsTitle.push(opt.title);
                } else if (opt.closable && type === 'closeAll') {
                    closeTabsTitle.push(opt.title);
                }
            });
            for ( var i = 0; i < closeTabsTitle.length; i++) {
                mainTabs.tabs('close', closeTabsTitle[i]);
            }
        }
    });

    layoutWestTree = $('#layout_west_tree').tree({
        url : 'menu/tree',
        parentField : 'pid',
        onClick : function(node) {
            var opts = {
                title : node.text,
                border : false,
                closable : true,
                fit : true,
                iconCls : node.iconCls
            };
            var url = node.url;
            if (url){
                encodeUrl=encodeURI(url+"?PageName="+node.text+"&PageIcon="+node.iconCls);
            	opts.content = '<iframe src="' + encodeUrl + '" frameborder="0" style="border:0;width:100%;height:99.5%;"></iframe>';
            	addTab(opts);
            }
        }
    });
});

function addTab(opts) {
    var t = $('#mainTabs');
    if (t.tabs('exists', opts.title)) {
        t.tabs('select', opts.title);
    } else {
        t.tabs('add', opts);
    }
}

function refreshTab() {
    var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
    var tab = mainTabs.tabs('getTab', index);
    var options = tab.panel('options');
    if (options.content) {
        mainTabs.tabs('update', {
            tab: tab,
            options: {
                content: options.content
            }
        });
    } else {
        tab.panel('refresh', options.href);
    }
}

function logout(){
    $.messager.confirm('提示','确定要退出?',function(r){
        if (r){
            progressLoad();
            $.post('/logout', function(result) {
                result = $.parseJSON(result);
                if(result.success){
                    progressClose();
                    window.location.href = '/';
                }
            }, 'text');
        }
    });
}

function editUserPwd() {
    var t = parent.$.modalDialog({
        title : '修改密码',
        width : 300,
        height : 217,
        href : '/user/editPwdPage',
        buttons : [ {
            text : '确定',
            handler : function() {
//                var f = parent.$.modalDialog.handler.find('#detailForm');
//                f.submit();
            	var fm = parent.$.modalDialog.handler.find('#detailForm');
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
            			var result = $.parseJSON(data);
            			if (result.success) {
                            $.messager.alert('提示', result.msg, 'info');
            				/*$.messager.show( {
            					title : '提示',
            					msg : result.msg,
            					showType:'show'
            				});*/
            				// reload the list data
            				$('#grid').datagrid('reload');
            				t.dialog('close');
            				
            			} else {
                            $.messager.alert('提示', result.msg, 'error');
            				/*$.messager.show( {
            						title : '错误',
            						msg : result.msg,
            						width:'300px',
            						height:'150px',
            						timeout:0,
            						showType:'show'
            				});*/
            			}
            		}
            	});
            }
        } ]
    });
}

/**
 * 主页
 */
function toHome() {
    mainTabs.tabs('select', 0);
}

/**
 * 关闭
 */
function closeTab() {
    var index = mainTabs.tabs('getTabIndex', mainTabs.tabs('getSelected'));
    var tab = mainTabs.tabs('getTab', index);
    if (tab.panel('options').closable) {
        mainTabs.tabs('close', index);
    }
}

/**
 * 全屏
 */
function fullScreen() {
    if($("#fullScreen").find(".glyphicon-screenshot").length > 0) {
        $("#mainLayout").layout('expand', 'west').layout('expand', 'north');
        $("#fullScreen").find(".l-btn-icon").addClass("glyphicon-fullscreen").removeClass("glyphicon-screenshot");
    }else {
        $("#mainLayout").layout('collapse', 'north').layout('collapse', 'west');
        $("#fullScreen").find(".l-btn-icon").addClass("glyphicon-screenshot").removeClass("glyphicon-fullscreen");
        $(".layout-expand").hide();
    }
}

function showMenu() {
	if($("#mm1").css('display')=='none'){
        $("#mm1").css("display","");
    }else{
        $("#mm1").css("display","none");
    }
}
