function submitForm(){
    var loginName = $("input[name='logname']").val();;
    var password = $("input[name='logpass']").val();;
    if (!loginName) {
        $.messager.show( {
            title : '提示',
            msg : "用户名不能为空",
            width:'300px',
            height:'150px',
            timeout:3000,
            showType:'show'
        });
        return false;
    }else if(!password){
        $.messager.show( {
            title : '提示',
            msg : "密码不能为空",
            width:'300px',
            height:'150px',
            timeout:3000,
            showType:'show'
        });
        return false;
    }else {
        $.ajax({
            type: 'POST',
            url: 'login',
            data: { 'loginName': loginName, 'password':password},
            success: function(data){
                if (data=="success") {
                    window.location = 'index';
                }else{
                    $.messager.show( {
                        title : '提示',
                        msg : '用户名或密码错误',
                        width:'300px',
                        height:'150px',
                        timeout:3000,
                        showType:'show'
                    });
                }
            },
            error: function(xhr, type){
                $.messager.show( {
                    title : '提示',
                    msg : '登陆失败',
                    width:'300px',
                    height:'150px',
                    timeout:3000,
                    showType:'show'
                });
            }
        });
        return false;
    }
}

//回车登录
function enterLogin(){
    if (event.keyCode == 13){
        submitForm();
    }
}