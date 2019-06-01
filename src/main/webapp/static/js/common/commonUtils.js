//格式化日期
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